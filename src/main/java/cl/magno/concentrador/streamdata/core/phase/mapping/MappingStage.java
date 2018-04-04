package cl.magno.concentrador.streamdata.core.phase.mapping;

import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;

import cl.magno.concentrador.streamdata.core.jms.QueueReceiver;
import cl.magno.concentrador.streamdata.core.service.ServiceLocator;
import cl.magno.stream.core.model.flow.Flow;
import cl.magno.stream.utils.Constants;

/**
 * Kuvasz Solutions - Factoria de Desarrollo de software
 * Concentrador de Datos
 * 
 * Clase encargada de generar Los listeners que obtendran los mensajes
 * de la queue "queueExtractCtdr" 
 * 
 * @author Richard Gutierrez rgutierrez@kvz.cl
 * @since 02-10-2013 
 */
public class MappingStage extends Thread {
	
	private Flow flujo;
	private int nThreadsMapping;
	private transient static final Logger LOGGER = Logger.getLogger(MappingStage.class);

	
	/**
	 * 
	 * @param flujo
	 */
	public MappingStage(Flow flujo) {
		this.flujo = flujo;
	}
	

	@Override
	public void run() {
		
		JmsTemplate jms = (JmsTemplate) ServiceLocator.getInstance().getBean( Constants.BEAN_EXTRACT_TEMPLATE );
		QueueReceiver receiver = new QueueReceiver(jms, this.getFlujo().getUuidExecution() );
		MappingListener listener = new MappingListener(flujo);
		listener.setExecutor(Executors.newFixedThreadPool(nThreadsMapping));

		try {
			receiver.start(listener);
			listener.setUltimaEjecucion(System.currentTimeMillis());
			while (true) {
				if ( flujo.isAsyncFinalizaEntrada()  && flujo.getAsyncNroRegsIng() == flujo.getAsyncNroRegsMapping() ){//&& System.currentTimeMillis() - listener.getUltimaEjecucion() > 30000 ) {
					flujo.setAsyncFinalizaMapping(true);
					LOGGER.info( flujo.getUuidExecution() + " Finaliza el listener Mapping . Registros procesados :"+ flujo.getAsyncNroRegsMapping() );
					break;
				}
			}
			receiver.stop();
			listener.getExecutor().shutdown();
			
		} catch (Exception e) {
			LOGGER.error( flujo.getUuidExecution() + " Error Iniciando Listener", e);
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
	 * @return the nThreadsMapping
	 */
	public int getnThreadsMapping() {
		return nThreadsMapping;
	}


	/**
	 * @param nThreadsMapping the nThreadsMapping to set
	 */
	public void setnThreadsMapping(int nThreadsMapping) {
		this.nThreadsMapping = nThreadsMapping;
	}
}
