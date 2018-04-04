/**
 * 
 */
package cl.magno.concentrador.model.flow.execution;
 

import cl.magno.stream.core.model.flow.FlujoAbstract;
import cl.magno.stream.utils.Constants;

/**
 * @author SEBASTIAN VEGA - KUVASZ SOLUTIONS
 * FECHA CREACION : 26-09-2013
 * DESCRIPCION DE CLASE: 
 * MODIFICACIONES : 
 */
public class EstadoPendiente extends EstadoEjecucionFlujo { 
	private static final long serialVersionUID = -3471023040122288601L;

	public EstadoPendiente() {
		this.setIcon(Constants.ICON_ESTADO_PENDIENTE);
		this.setNombre(Constants.ESTADO_PENDIENTE);
	}

	@Override
	public void restartExecution(FlujoAbstract flujoAbstract) { 
	}
}
