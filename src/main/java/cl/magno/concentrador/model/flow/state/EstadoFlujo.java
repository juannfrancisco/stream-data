package cl.magno.concentrador.model.flow.state;

import cl.magno.stream.core.model.flow.FlujoAbstract;


/**
 * 
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 30-06-2016 11:21:43
 */
public abstract class EstadoFlujo 
{
	private String icon;
	private String nombre;
	

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
	
	
	public abstract void executeFlujo( FlujoAbstract flujo );
	
	public abstract void startFlujo( FlujoAbstract flujo );
	
	public abstract void deleteFlujo( FlujoAbstract  flujo );
	
	public abstract void restartFlujo( FlujoAbstract  flujo );
}
