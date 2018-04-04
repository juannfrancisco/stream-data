package cl.magno.concentrador.streamdata.core.phase.mapping;

import gnu.trove.map.hash.THashMap;

import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;

import org.apache.log4j.Logger;

import cl.magno.concentrador.model.TrxObject;
import cl.magno.concentrador.model.mapping.MapeoColumna;
import cl.magno.concentrador.streamdata.core.jms.QueueSender;
import cl.magno.concentrador.streamdata.core.util.OGNLUtils;
import cl.magno.stream.core.model.flow.Flow;
import cl.magno.stream.utils.Constants;

import com.google.gson.Gson;


/**
 * Kuvasz Solutions - Factoria de Desarrollo de software
 * Concentrador de Datos
 * 
 * @author Richard Gutierrez rgutierrez@kvz.cl
 * @since 02-10-2013 
 */
public class MappingPhase extends Thread {
	
	private transient static final Logger LOGGER = Logger.getLogger(MappingPhase.class);
	private Map<String, String>  source;
	private Flow flujo;
	private QueueSender sender;
	private Gson gson;


	
	/**
	 * 
	 * @param source
	 * @param flujo
	 * @param sender
	 * @param gsrv
	 */
	public MappingPhase(Map<String, String> source, Flow flujo, QueueSender sender, Gson gsrv) {
		this.source = source;
		this.flujo = flujo;
		this.sender = sender;
		this.gson = gsrv;
	}

	@Override
	public void run() {
		try {
			String jsonTarget = source.get(Constants.PROP_TARGET);
			TrxObject object = new TrxObject();
			
			@SuppressWarnings("unchecked")
			Map<String, Object> registro = gson.fromJson(jsonTarget, Map.class);
			object.setCore(registro);
			
			Map<String, Object> tMsg = new THashMap<String, Object>();
			
			for( MapeoColumna mapeo :  this.flujo.getMuestreador().getMapeo().getMapeoColumnas() ){
				String value = (String)registro.get( mapeo.getColumnaEntrada().getNombre() );
				String ongl = mapeo.getOgnl();
				String newValue = (String)apply(value, ongl, object);
				tMsg.put( mapeo.getColumnaSalida().getNombre() , newValue);
			}
			tMsg.put("target", gson.toJson( tMsg ));
			sender.setCorrelationId( flujo.getUuidExecution() );
			sender.sendMesageSync(tMsg);
			flujo.incAsyncNroRegsMapping();
			
		} catch (Exception ex) {
			flujo.incAsyncNroRegsMapping();
			LOGGER.error(flujo.getUuidExecution() + " Error Enviando Mensaje a jmsMapping: " + ex.getMessage() + "." + source, ex );
		}
	}
	
	
	
	
	/**
	 * Aplica funcion OGNL.
	 * @param valueCol
	 * @param ognlExpression
	 * @param source
	 * @return
	 */
	public synchronized Object apply( String valueCol, String ognlExpression, TrxObject source ) 
	{
		try 
		{
			valueCol = null ==valueCol?"":valueCol;
		    if( !ognlExpression.trim().isEmpty() ){
		    	
		    	Map<String,Object> map = new HashMap<String,Object>(); 
		    	
		    	if( ognlExpression.contains( "$Columna" ) )
		    		map.put( "$Columna", valueCol==null?"":valueCol );
		    	
		    	if( ognlExpression.contains( "$ObjetoEntrada" ) )
		    		map.put( "$ObjetoEntrada", source );
		    	
		    	if( ognlExpression.contains( "$Utils" ) ) 
		    		map.put( "$Utils", new OGNLUtils() ); 
		    	
		    	if( ognlExpression.contains( "$Map" ) )
		    		map.put( "$Map", valueCol ); 
		    	
		    	Object expr = Ognl.parseExpression(ognlExpression);
		    	Object value = Ognl.getValue( expr , map ); 
			    return value;
		    }
		    else
		    	return valueCol;
		}
		catch ( OgnlException e) 
		{
			LOGGER.error( "Error al parser la expresion ognl:  "+ ognlExpression , e);
		}
		return valueCol;
	}
}