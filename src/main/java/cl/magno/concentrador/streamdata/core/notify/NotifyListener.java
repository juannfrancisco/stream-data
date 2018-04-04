/**
 * Kuvasz Solutions - Equipo de Consultoria
 * Santiago de Chile, Merced 838 Piso 15 oficina 153
 * http://www.kvz.cl
 */
package cl.magno.concentrador.streamdata.core.notify;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.log4j.Logger;

import cl.magno.concentrador.streamdata.core.app.Application;
import cl.magno.stream.utils.Constants;

/**
 * @author Juan Francisco Maldonado León - juan.maldonado.leon@gmail.com
 * @since 02-07-2016 23:52:49
 */
public class NotifyListener implements MessageListener {

	private transient static final Logger LOGGER = Logger.getLogger(NotifyListener.class);
	
	/**
	 * 
	 */
	public void onMessage(Message message) {
		
		try {
			LOGGER.debug( "[ "+Application.getInstance().getId() +  " ]- Recibiendo notificacion..." + message);
			String type = ((MapMessage) message).getString( Constants.NOTIFY_COMMAND );
			TYPE_NOTIFY.valueOf(type).execute(null);;
			
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		
		
	}
	
	
	
	
	
	

}
