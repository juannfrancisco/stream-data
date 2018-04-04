package cl.magno.concentrador.streamdata.core.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;

/**
 * 
 * @author Juan Francisco Maldonado León
 * @since 30-06-2016 16:01:20
 */
public class QueueReceiver {
	private String correlation;
	private JmsTemplate jms;
	private Connection connection;

	/**
	 * @param jms
	 * @param correlation
	 */
	public QueueReceiver(JmsTemplate jms, String correlation) {
		this.jms = jms;
		this.correlation = correlation;
	}

	/**
	 * Metodo Sincronico para recepcion de mensajes JMS.
	 */
	public Object receive() {
		jms.setReceiveTimeout(5000);
		return jms.receiveSelected("JMSCorrelationID='" + this.correlation + "'");
	}

	/**
	 * Metodo asincronico para recepcion de mensajes JMS.
	 */
	public void start(MessageListener lsnr) throws Exception {
		Queue queue = null;
		ConnectionFactory factory = null;
		Session session = null;

		factory = jms.getConnectionFactory();
		connection = factory.createConnection();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue) jms.getDefaultDestination();
		MessageConsumer queueReceiver = session.createConsumer(queue, "JMSCorrelationID='" + correlation + "'");
		queueReceiver.setMessageListener(lsnr);
		connection.start();
	}

	public void stop() throws JMSException {
		if (connection != null)
			connection.close();
	}

}
