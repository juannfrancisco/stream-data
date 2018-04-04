/**
 * Kuvasz Solutions - Equipo de Consultoria
 * Santiago de Chile, Merced 838 Piso 15 oficina 153
 * http://www.kvz.cl
 */
package cl.magno.concentrador.model.execution;

import java.util.Map;

/**
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 30-06-2016 12:52:46
 */
public interface CallbackExecution {
	
	/**
	 * 
	 * @return
	 */
	public void onPushObject( Map<String, String> object );
	
}
