package cl.magno.concentrador.streamdata.core.jms;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;

/**
 * 
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 29-06-2016 19:48:04
 */
public class SendMsgProcess implements Runnable {
	
	private JmsTemplate jmsTemplate = null;
	private String correlationId = null;
	private Map<String, String> msg = null;

	
	/**
	 * 
	 * @param msg
	 * @param jms
	 * @param correlationId
	 */
	public SendMsgProcess(Map<String, String> msg, JmsTemplate jms, String correlationId) {
		this.jmsTemplate = jms;
		this.correlationId = correlationId;
		this.msg = msg;
	}

	
	
	public void run() {
		jmsTemplate.convertAndSend(msg, new MessagePostProcessor() {

			public Message postProcessMessage(Message msg) throws JMSException {
				msg.setJMSCorrelationID(correlationId);
				return msg;
			}
		});

	}

}
