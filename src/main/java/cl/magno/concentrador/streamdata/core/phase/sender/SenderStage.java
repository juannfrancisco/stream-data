/**
 * Kuvasz Solutions - Equipo de Consultoria
 * Santiago de Chile, Merced 838 Piso 15 oficina 153
 * http://www.kvz.cl
 */
package cl.magno.concentrador.streamdata.core.phase.sender;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;

import com.google.gson.Gson;

import cl.magno.concentrador.streamdata.core.jms.QueueReceiver;
import cl.magno.concentrador.streamdata.core.service.ServiceLocator;
import cl.magno.stream.core.model.flow.Flow;
import cl.magno.stream.utils.Constants;

/**
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 01-07-2016 13:07:17
 */
public class SenderStage extends Thread {
	
	private transient static final Logger LOGGER = Logger.getLogger(SenderStage.class);
	private Flow flujo;
	private int idListener;
	private int nThreadsMapping;
	
	
	@Override
	public void run() {
		QueueReceiver receiver = null;
		try {
			JmsTemplate jms = (JmsTemplate) ServiceLocator.getInstance().getBean( Constants.BEAN_MAPPING_TEMPLATE );
			
			flujo.getMuestreador().getEjecucionSalida().initialize( flujo );
			
			
			ExecutorService exlistener = Executors.newFixedThreadPool(nThreadsMapping);
			SenderListener listener = new SenderListener(flujo, null, new Gson(), this.idListener, exlistener);

			receiver = new QueueReceiver(jms, String.valueOf( flujo.getUuidExecution() ));
			receiver.start(listener);
			
			LOGGER.info( flujo.getUuidExecution() + " Listener #" + this.idListener + " Iniciado. ");
			while (true) {
//				LOGGER.info("Registros Leidos :"+flujo.getAsyncNroRegsIng());
//				LOGGER.info("Registros Procesados OK:"+flujo.getAsyncNroRegsSalida());
//				LOGGER.info("Registros Procesados ER:"+flujo.getAsyncNroRegsErrSalida());
				
				if ( (flujo.isAsyncFinalizaMapping() &&  flujo.getAsyncNroRegsMapping() == (flujo.getAsyncNroRegsErrIng() + flujo.getAsyncNroRegsErrSalida() ) ) ) {
					
					flujo.getMuestreador().getEjecucionSalida().finalize(flujo);
					LOGGER.info( flujo.getUuidExecution()+ " Listener "+ this.idListener+ " completado o en estado inactivo, finalizando.. ");
					receiver.stop();
					exlistener.shutdown();
					break;
				}
			}
			exlistener.awaitTermination(3, TimeUnit.HOURS);
			LOGGER.info( "FINALIZA SENDER STAGE" );
		} catch (Exception e) {
			try {
				receiver.stop();
			} catch (Exception ex) {
			}
			LOGGER.error("Ocurrio un error",e);
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
	 * @return the idListener
	 */
	public int getIdListener() {
		return idListener;
	}
	/**
	 * @param idListener the idListener to set
	 */
	public void setIdListener(int idListener) {
		this.idListener = idListener;
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
