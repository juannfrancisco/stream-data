/**
 * 
 */
package cl.magno.concentrador.model.flow.execution;

 
import org.apache.log4j.Logger;

import cl.magno.stream.core.model.flow.FlujoAbstract;
import cl.magno.stream.utils.Constants;

/**
 * @author JUAN MALDONADO LEON .-
 * KUVASZ SOLUTIONS - Concentrador - 01-10-2013
 * DESCRIPCION : 
 * CAMBIOS 
 * ----------------------------------------------------------------------
 * DESCRIPCION 	: 
 * USUARIO 		: 
 * FECHA 		: 
 * ----------------------------------------------------------------------
 */
public class EstadoEjecucionConError extends EstadoEjecucionFlujo 
{ 
	private static final long serialVersionUID = -1418593379675596548L;
	private transient static final Logger LOGGER = Logger.getLogger( EstadoEjecucionConError.class );
	 
	public EstadoEjecucionConError() 
	{		
		this.setIcon( Constants.ICON_ESTADO_EJECUCION_ERROR );
		this.setNombre( Constants.ESTADO_EJECUCION_ERROR );
	}

	@Override
	public void restartExecution( FlujoAbstract flujoAbstract ) 
	{
//		final FlujoAbstract flujo =  flujoAbstract;
//		LOGGER.info( "Reiniciando el flujo " + flujo.getNombre() + "..." );
//		flujo.addLog( new LoggerEstadoEjecucion( " [ > ] - Reiniciando el Flujo " + this.getNombre() , new Date() ) );
//		flujo.setPaused( false );
	}

}
