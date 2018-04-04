/**
 * Kuvasz Solutions - Equipo de Consultoria
 * Santiago de Chile, Merced 838 Piso 15 oficina 153
 * http://www.kvz.cl
 */
package cl.magno.concentrador.streamdata.core.phase.sender;

import java.util.Map;

import org.apache.log4j.Logger;

import cl.magno.concentrador.model.execution.CallbackExecutionSender;
import cl.magno.stream.core.model.flow.Flow;

/**
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 01-07-2016 13:08:06
 */
public class SenderPhase extends Thread {
	
	private transient static final Logger LOGGER = Logger.getLogger(SenderPhase.class);
	private Map<String, Object> data;
	private Flow flujo;
	private String identificador;
	
	
	
	
	
	
	/**
	 * @param data
	 * @param flujo
	 */
	public SenderPhase(Map<String, Object> data, Flow flujo, String identificador) {
		this.setName( "SenderPhase-"+ flujo.getUuidExecution() + identificador );
		this.data = data;
		this.flujo = flujo;
	}

	
	@Override
	public void run() {
		try {
			
			
			flujo.getMuestreador().getEjecucionSalida().sendData(data, flujo, new CallbackExecutionSender() {
				
				public void onSendSuccess() {
					flujo.incAsyncNroRegsSalida();
				}
				public void onSendError() {
					flujo.incAsyncNroRegsErrSalida();
				}
			});
			
		} catch (Exception ex) {
			LOGGER.error("Ex." + ex.getMessage());
			flujo.incAsyncNroRegsErrSalida();
		}
	}
	
	
	/**
	 * @return the data
	 */
	public Map<String, Object> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	/**
	 * @return the flujo
	 */
	public Flow getFlujo() {
		return flujo;
	}
	/**
	 * @param flujo the flujo to set
	 */
	public void setFlujo(Flow flujo) {
		this.flujo = flujo;
	}

	/**
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
}
