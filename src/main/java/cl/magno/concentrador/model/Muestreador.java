package cl.magno.concentrador.model;

import java.io.Serializable;

import cl.magno.concentrador.model.execution.ExecutionInput;
import cl.magno.concentrador.model.execution.ExecutionOutput;
import cl.magno.concentrador.model.mapping.Mapeo;


/**
 * Kuvasz Solutions - Factoria de Desarrollo de software
 * Concentrador de Datos
 * 
 * @author Juan Francisco Maldonado León - jmaldonado@kvz.cl
 * @since 02-10-2013
 */
public class Muestreador implements Serializable {
	private static final long serialVersionUID = -1915067124003341283L;
//	private transient static final Logger LOGGER = Logger.getLogger(Muestreador.class);
	private int oid;
	private String nombre;
	private String descripcion;
	private Mapeo mapeo = new Mapeo();
	private String muestreadorEntrada;
	private String muestreadorSalida;
	private ExecutionInput ejecucionEntrada;
	private ExecutionOutput ejecucionSalida;
	
	
	
	
	
	/**
	 * @return the oid
	 */
	public int getOid() {
		return oid;
	}
	/**
	 * @param oid the oid to set
	 */
	public void setOid(int oid) {
		this.oid = oid;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the mapeo
	 */
	public Mapeo getMapeo() {
		return mapeo;
	}
	/**
	 * @param mapeo the mapeo to set
	 */
	public void setMapeo(Mapeo mapeo) {
		this.mapeo = mapeo;
	}
	/**
	 * @return the muestreadorEntrada
	 */
	public String getMuestreadorEntrada() {
		return muestreadorEntrada;
	}
	/**
	 * @param muestreadorEntrada the muestreadorEntrada to set
	 */
	public void setMuestreadorEntrada(String muestreadorEntrada) {
		this.muestreadorEntrada = muestreadorEntrada;
	}
	/**
	 * @return the muestreadorSalida
	 */
	public String getMuestreadorSalida() {
		return muestreadorSalida;
	}
	/**
	 * @param muestreadorSalida the muestreadorSalida to set
	 */
	public void setMuestreadorSalida(String muestreadorSalida) {
		this.muestreadorSalida = muestreadorSalida;
	}

	/**
	 * @return the ejecucionEntrada
	 */
	public ExecutionInput getEjecucionEntrada() {
		return ejecucionEntrada;
	}
	/**
	 * @param ejecucionEntrada the ejecucionEntrada to set
	 */
	public void setEjecucionEntrada(ExecutionInput ejecucionEntrada) {
		this.ejecucionEntrada = ejecucionEntrada;
	}
	/**
	 * @return the ejecucionSalida
	 */
	public ExecutionOutput getEjecucionSalida() {
		return ejecucionSalida;
	}
	/**
	 * @param ejecucionSalida the ejecucionSalida to set
	 */
	public void setEjecucionSalida(ExecutionOutput ejecucionSalida) {
		this.ejecucionSalida = ejecucionSalida;
	}
}