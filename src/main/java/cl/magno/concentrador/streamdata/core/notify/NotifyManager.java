/**
 * 
 */
package cl.magno.concentrador.streamdata.core.notify;

import gnu.trove.map.hash.THashMap;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;

import cl.magno.concentrador.streamdata.core.app.Application;
import cl.magno.concentrador.streamdata.core.jms.QueueReceiver;
import cl.magno.concentrador.streamdata.core.jms.QueueSender;
import cl.magno.concentrador.streamdata.core.service.ServiceLocator;
import cl.magno.stream.utils.Constants;

/**
 * @author Juan Francisco Maldonado León
 * @since 03-07-2016 4:29:23
 */
public class NotifyManager {
	
	private transient static final Logger LOGGER = Logger.getLogger(NotifyManager.class);

	/**
	 * 
	 */
	public static void initialize(){
		
		try {
			
			Thread thread = new Thread( new Runnable() {
				public void run() {
					
					try {
						JmsTemplate jms = (JmsTemplate) ServiceLocator.getInstance().getBean( Constants.BEAN_NOTIFY_TEMPLATE );
						QueueReceiver receiver = new QueueReceiver(jms, Constants.CORRELETION_ID_QUEUE_NOTIFY );
						
						NotifyListener listener = new NotifyListener();
						Application.getInstance().setNotifyQueue(receiver);
						receiver.start(listener);
					} catch (Exception e) {
						LOGGER.error( "Ocurrio un error al inicializar el listener de notificaciones", e );
					}
					
				}
			} );
			thread.start();
		} catch (Exception e) {
			LOGGER.error( "Ocurrio un error al inicializar el listener de notificaciones", e );
		}
	}
	
	
	/**
	 * 
	 */
	public static void sendNotification( TYPE_NOTIFY type, Map<String, Object> data ){
		JmsTemplate template = null;
		try {
			template = (JmsTemplate) ServiceLocator.getInstance().getBean( Constants.BEAN_NOTIFY_TEMPLATE );
			final QueueSender sender  = new QueueSender(template, Constants.CORRELETION_ID_QUEUE_NOTIFY  );
			sender.prepareAsync( 1 );
			LOGGER.info("Enviando data " +  data );
			sender.sendMesageSync(data);
			sender.close();
			
		} catch (Exception e) {
			LOGGER.error("Ocurrio un error el fase de extracción", e);
		}
	}


}
