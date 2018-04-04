/**
 * Kuvasz Solutions - Equipo de Consultoria
 * Santiago de Chile, Merced 838 Piso 15 oficina 153
 * http://www.kvz.cl
 */
package cl.magno.concentrador.streamdata.core.phase.sender;

import java.util.Map;
import java.util.concurrent.ExecutorService;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.log4j.Logger;

import cl.magno.concentrador.streamdata.core.jms.QueueSender;
import cl.magno.stream.core.model.flow.Flow;
import cl.magno.stream.utils.Constants;

import com.google.gson.Gson;

/**
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 01-07-2016 13:07:42
 */
public class SenderListener implements MessageListener, ExceptionListener{

	private transient static final Logger LOGGER = Logger.getLogger(SenderListener.class);
	private Flow flujo;
	private QueueSender sender;
	private Gson gsrv = new Gson();
	private int idListener;
	private ExecutorService executor;
	
	
	
	
	
	
	/**
	 * @param flujo
	 * @param sender
	 * @param gsrv
	 * @param idListener
	 * @param executor
	 */
	public SenderListener(Flow flujo, QueueSender sender, Gson gsrv,
			int idListener, ExecutorService executor) {
		this.flujo = flujo;
		this.sender = sender;
		this.gsrv = gsrv;
		this.idListener = idListener;
		this.executor = executor;
	}
	
	

	public void onException(JMSException arg0) {
		LOGGER.info( flujo.getUuidExecution() + " Ocurrio un error al recibir el mensaje, Listener : " + idListener + arg0 );
	}

	@SuppressWarnings("unchecked")
	public void onMessage(Message msg) {
		String core = null;
		String source = null;
		try {
			core = ((MapMessage) msg).getString( Constants.PROP_TARGET );
			source = ((MapMessage) msg).getString( Constants.PROP_SOURCE );
			Map<String, Object> m = gsrv.fromJson(core, Map.class);
//			Map<String, Object> s = gsrv.fromJson(source, Map.class);
			
			executor.execute( new SenderPhase(m, flujo, msg.getJMSMessageID() ) );
		} catch (Exception ex) {
			
			LOGGER.error("&" + flujo.getUuidExecution() + " Listener " + this.idListener+ " Error " + ex.getMessage(), ex);
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
	 * @return the sender
	 */
	public QueueSender getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(QueueSender sender) {
		this.sender = sender;
	}

	/**
	 * @return the gsrv
	 */
	public Gson getGsrv() {
		return gsrv;
	}

	/**
	 * @param gsrv the gsrv to set
	 */
	public void setGsrv(Gson gsrv) {
		this.gsrv = gsrv;
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
	 * @return the executor
	 */
	public ExecutorService getExecutor() {
		return executor;
	}

	/**
	 * @param executor the executor to set
	 */
	public void setExecutor(ExecutorService executor) {
		this.executor = executor;
	}

}
