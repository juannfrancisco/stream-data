package cl.magno.stream.core.model.flow;

import java.io.Serializable;

import cl.magno.concentrador.model.flow.execution.EstadoEjecucionFlujo;
import cl.magno.concentrador.model.flow.state.EstadoFlujo;
import cl.magno.concentrador.model.schedule.Planificacion;


public abstract class FlujoAbstract implements Serializable ,Cloneable
{
	private static final long serialVersionUID = 6880905887414218157L;

	private String uuidExecution;
	private int oid;
	private String nombre;
	private String descripcion;
	private Planificacion planificacion;
	private EstadoFlujo estado;
	private EstadoEjecucionFlujo estadoEjecucion;
	
	
	public FlujoAbstract(){
		
	}
	
	
	
	/**
	 * @param uuidExecution
	 * @param oid
	 * @param nombre
	 * @param descripcion
	 * @param planificacion
	 * @param estado
	 * @param estadoEjecucion
	 */
	public FlujoAbstract(String uuidExecution, int oid, String nombre,
			String descripcion, Planificacion planificacion,
			EstadoFlujo estado, EstadoEjecucionFlujo estadoEjecucion) {
		this.uuidExecution = uuidExecution;
		this.oid = oid;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.planificacion = planificacion;
		this.estado = estado;
		this.estadoEjecucion = estadoEjecucion;
	}
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
	 * @return the planificacion
	 */
	public Planificacion getPlanificacion() {
		return planificacion;
	}
	/**
	 * @param planificacion the planificacion to set
	 */
	public void setPlanificacion(Planificacion planificacion) {
		this.planificacion = planificacion;
	}
	/**
	 * @return the estado
	 */
	public EstadoFlujo getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoFlujo estado) {
		this.estado = estado;
	}
	/**
	 * @return the estadoEjecucion
	 */
	public EstadoEjecucionFlujo getEstadoEjecucion() {
		return estadoEjecucion;
	}
	/**
	 * @param estadoEjecucion the estadoEjecucion to set
	 */
	public void setEstadoEjecucion(EstadoEjecucionFlujo estadoEjecucion) {
		this.estadoEjecucion = estadoEjecucion;
	}
	/**
	 * @return the uuidExecution
	 */
	public String getUuidExecution() {
		return uuidExecution;
	}
	/**
	 * @param uuidExecution the uuidExecution to set
	 */
	public void setUuidExecution(String uuidExecution) {
		this.uuidExecution = uuidExecution;
	}
	
	
}
