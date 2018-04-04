/**
 * 
 */
package cl.magno.concentrador.streamdata.core.notify.type;

import java.util.Map;

/**
 * @author Juan Francisco Maldonado Leon - jmaldonado@kvz.cl
 * 
 *
 */
public abstract class CommandNotification {
	
	
	/**
	 * 
	 */
	public abstract void execute( Map<String, Object> map);

}
