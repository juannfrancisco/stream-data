/**
 * Kuvasz Solutions - Equipo de Consultoria
 * Santiago de Chile, Merced 838 Piso 15 oficina 153
 * http://www.kvz.cl
 */
package cl.magno.concentrador.model.execution;

/**
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 01-07-2016 14:00:14
 */
public interface CallbackExecutionSender {

	public void onSendSuccess();
	public void onSendError();

}