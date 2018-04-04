/**
 * 
 */
package cl.magno.concentrador.streamdata.core.notify.type;

import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @author jmaldonado
 *
 */
public class CommandStartSending extends CommandNotification {

	private transient static final Logger LOGGER = Logger.getLogger(CommandStartSending.class);
	
	@Override
	public void execute(Map<String, Object> map) {
		LOGGER.info("execute ...");
		
	}

}
