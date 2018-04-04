/**
 * Kuvasz Solutions - Consultoria
 */
package cl.magno.concentrador.streamdata.core.jms;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;

/**
 * Kuvasz Solutions - Consultoria
 * 
 * @author Juan Francisco Maldonado - jmaldonado@kvz.cl
 * @since 29-06-2016
 */
public class QueueSender {
	
	private String correlationId;
	private JmsTemplate jmsTemplate;
	private ExecutorService executor;
	
	
	
	/**
	 * 
	 * @param jmsTemplate
	 * @param correlationId
	 */
	public QueueSender(JmsTemplate jmsTemplate, String correlationId) {  
		this.jmsTemplate = jmsTemplate;
		this.correlationId = correlationId; 
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
	/**
	 * @return the jmsTemplate
	 */
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	/**
	 * @param jmsTemplate the jmsTemplate to set
	 */
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	/**
	 * @return the correlationId
	 */
	public String getCorrelationId() {
		return correlationId;
	}
	/**
	 * @param correlationId the correlationId to set
	 */
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	
	/**
	 * 
	 * @param poolThreadAsync
	 */
	public void prepareAsync(int poolThreadAsync) {
		this.executor = Executors.newFixedThreadPool(poolThreadAsync);
	}
	
	/**
	 * 
	 */
	public void close() {
		if ( null != this.executor && !this.executor.isShutdown() ) 
			this.executor.shutdown();
	}
	
	
	/**
	 * 
	 * @param m
	 */
	public void sendMesageAsync(Map<String, String> m) {   
		SendMsgProcess smp = new SendMsgProcess(m, jmsTemplate, correlationId);
		this.executor.execute(smp); 
	}
	
	
	/**
	 * 
	 * @param m
	 */
	public void sendMesageSync(Map<String, Object> m) {    
		
		jmsTemplate.convertAndSend(m, new MessagePostProcessor() {
			
			public Message postProcessMessage(Message msg) throws JMSException {
				msg.setJMSCorrelationID(correlationId);   
				return msg;
			}
		});
		
	}
	
	
}
