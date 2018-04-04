/**
 * 
 */
package cl.magno.concentrador.model.flow.execution;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cl.magno.concentrador.model.logger.LoggerEstadoEjecucion;
import cl.magno.stream.core.model.flow.FlujoAbstract;

/**
 * @author SEBASTIAN VEGA - KUVASZ SOLUTIONS
 * FECHA CREACION : 26-09-2013
 * DESCRIPCION DE CLASE: 
 * MODIFICACIONES : 
 */
public abstract class EstadoEjecucionFlujo implements Serializable
{ 
	private static final long serialVersionUID = -5181459386717584951L;
	private String nombre;
	private String icon;
	private List<LoggerEstadoEjecucion> logger; 
	
	public EstadoEjecucionFlujo()
	{
		this.setNombre("");
		this.setIcon("");
		this.setLogger( new ArrayList<LoggerEstadoEjecucion>() );
	}
	
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * @return the logger
	 */
	public List<LoggerEstadoEjecucion> getLogger() {
		return logger;
	}
	/**
	 * @param logger the logger to set
	 */
	public void setLogger(List<LoggerEstadoEjecucion> logger) 
	{
		this.logger = logger;
	}
	
	
	
	
	public abstract void restartExecution( FlujoAbstract flujoAbstract );
}
