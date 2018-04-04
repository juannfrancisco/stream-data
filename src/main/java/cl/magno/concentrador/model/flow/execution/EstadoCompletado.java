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
public class EstadoCompletado extends EstadoEjecucionFlujo{
   
	private static final long serialVersionUID = 8002076406146794870L;

	public EstadoCompletado() 
	{
		this.setIcon(Constants.ICON_ESTADO_COMPLETADO);
		this.setNombre(Constants.ESTADO_COMPLETADO);
	}

	@Override
	public void restartExecution(FlujoAbstract flujoAbstract) 
	{
		
	}

	
}
