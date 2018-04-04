/**
 * 
 */
package cl.magno.concentrador.streamdata.core.phase.extract;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;

import cl.magno.concentrador.model.execution.CallbackExecution;
import cl.magno.concentrador.streamdata.core.jms.QueueSender;
import cl.magno.concentrador.streamdata.core.service.ServiceLocator;
import cl.magno.stream.core.model.flow.Flow;
import cl.magno.stream.utils.Constants;

/**
 * @author Juan Francisco Maldonado - juan.maldonado.leon@kvz.cl
 * @since 29-06-2016
 */
public class ExtractPhase implements Runnable {

	private static final Logger LOGGER = Logger.getLogger(ExtractPhase.class);
	private Flow flujo;
	private int maxThread;
	
	/**
	 * 
	 * @param correlationID
	 */
	public ExtractPhase(Flow flujo,int maxThread ) {
		super();
		this.flujo = flujo;
		this.maxThread = maxThread;
	}

	
	/**
	 * 
	 */
	public void run() {
		
		LOGGER.info( this.getFlujo().getUuidExecution()  + "INICIO de la etapa de extraccion" );

		JmsTemplate template = null;
		
		try {
			template = (JmsTemplate) ServiceLocator.getInstance().getBean( Constants.BEAN_EXTRACT_TEMPLATE );
			final QueueSender sender  = new QueueSender(template, this.getFlujo().getUuidExecution() );
			sender.prepareAsync( maxThread );
			
			this.getFlujo().getMuestreador().getEjecucionEntrada().extract(this.getFlujo(), new CallbackExecution() {
				
				public void onPushObject(Map<String, String> object) {
					sender.sendMesageAsync(object);
					flujo.incAsyncNroRegsIng();
				}
			});
			this.getFlujo().setAsyncFinalizaEntrada(true);
			LOGGER.info( this.getFlujo().getUuidExecution()  + " FIN de la etapa de extraccion  " + this.getFlujo().getMuestreador().getEjecucionEntrada() );
			sender.close();
		} catch (Exception e) {
			LOGGER.error("Ocurrio un error el fase de extracción", e);
		}
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
	 * @return the maxThread
	 */
	public int getMaxThread() {
		return maxThread;
	}

	/**
	 * @param maxThread the maxThread to set
	 */
	public void setMaxThread(int maxThread) {
		this.maxThread = maxThread;
	}
}