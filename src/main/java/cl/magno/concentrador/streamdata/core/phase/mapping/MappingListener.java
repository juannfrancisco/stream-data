package cl.magno.concentrador.streamdata.core.phase.mapping;

import gnu.trove.map.hash.THashMap;

import java.util.Map;
import java.util.concurrent.ExecutorService;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;

import cl.magno.concentrador.streamdata.core.jms.QueueSender;
import cl.magno.concentrador.streamdata.core.service.ServiceLocator;
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
public class MappingListener implements MessageListener {
	
	private transient static final Logger LOGGER = Logger.getLogger(MappingListener.class);
	private Flow flujo;
	private QueueSender sender;
	private Gson gsrv = new Gson();
	private long ultimaEjecucion;
	private ExecutorService executor;

	
	/**
	 * 
	 * @param flujo
	 */
	public MappingListener(Flow flujo) {
		this.flujo = flujo;
		JmsTemplate jms = (JmsTemplate) ServiceLocator.getInstance().getBean( Constants.BEAN_MAPPING_TEMPLATE );
		sender = new QueueSender(jms, String.valueOf(this.flujo.getUuidExecution()));
	}

	
	/**
	 * 
	 */
	public void onMessage(Message msg) {
		try {
			processMsg(msg);
			ultimaEjecucion = System.currentTimeMillis();
		} catch (Exception e) {
			LOGGER.error( flujo.getUuidExecution() + " Error en procesar mapping. ",e);
		}
	}

	
	/**
	 * 
	 * @param msg
	 * @throws Exception
	 */
	private void processMsg(Message msg) throws Exception {

		MapMessage mmsg = (MapMessage) msg;
		Map<String, String> src = new THashMap<String, String>();
		src.put( Constants.PROP_TARGET , mmsg.getString(Constants.PROP_TARGET));
		src.put( Constants.PROP_FLOW , mmsg.getString(Constants.PROP_FLOW));
		

		Thread mapping = new MappingPhase(src, flujo, sender, this.gsrv);
		this.executor.execute(mapping);
	}

	public long getUltimaEjecucion() {
		return ultimaEjecucion;
	}

	public void setUltimaEjecucion(long ultimaEjecucion) {
		this.ultimaEjecucion = ultimaEjecucion;
	}

	public ExecutorService getExecutor() {
		return executor;
	}

	public void setExecutor(ExecutorService executor) {
		this.executor = executor;
	}
	
	public QueueSender getSender() {
		return sender;
	}

	public void setSender(QueueSender sender) {
		this.sender = sender;
	}
}
