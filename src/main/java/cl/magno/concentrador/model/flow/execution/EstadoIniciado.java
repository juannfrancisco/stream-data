/**
 * 
 */
package cl.magno.concentrador.model.flow.execution;

import java.io.Serializable;

import cl.magno.stream.core.model.flow.FlujoAbstract;
import cl.magno.stream.utils.Constants;

/**
 * @author SEBASTIAN VEGA - KUVASZ SOLUTIONS
 * FECHA CREACION : 26-09-2013
 * DESCRIPCION DE CLASE: 
 * MODIFICACIONES : 
 */
public class EstadoIniciado extends EstadoEjecucionFlujo implements Serializable
{  
	private static final long serialVersionUID = 4528345535564750278L;

	public EstadoIniciado()
	{
		this.setIcon(Constants.ICON_ESTADO_INICIADO);
		this.setNombre(Constants.ESTADO_INICIADO );
	}

	@Override
	public void restartExecution(FlujoAbstract flujoAbstract) {
		// TODO Auto-generated method stub
		
	}

}
