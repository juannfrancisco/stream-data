/**
 * 
 */
package cl.magno.concentrador.model.execution;

import java.io.Serializable;

import org.apache.log4j.Logger;

import cl.magno.concentrador.model.Muestreador;

/**
 * 
 * @author Juan Francisco Maldonado León
 * @since 30-06-2016 12:11:45
 */
public abstract class Execution implements Serializable {
	
	private static final long serialVersionUID = 4246006365422943056L;
	private transient static final Logger LOGGER = Logger.getLogger( Execution.class );
	private String nombre;
	private String descripcion;
	private boolean isStopped = false;
	
	private int recordsProcessedSuccess;
	private int recordsProcessedError;

	
	
	/**
	 * 
	 */
	public Execution() {
		this.nombre = "";
		this.descripcion = "";
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
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
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the isStopped
	 */
	public boolean isStopped() {
		return isStopped;
	}

	/**
	 * @param isStopped
	 *            the isStopped to set
	 */
	public void setStopped(boolean isStopped) {
		this.isStopped = isStopped;
	}

	/**
	 * 
	 * @param muestreador
	 */
	public void stop(Muestreador muestreador) {
		this.setStopped(true);
		LOGGER.info("SE DETENDRA SERVICIO " + this.getNombre() );
	}

	@Override
	public boolean equals(Object obj) {
		return this.getNombre().equals(((Execution) obj).getNombre());
	}
	
	
	/**
	 * @return the recordsProcessedSuccess
	 */
	public int getRecordsProcessedSuccess() {
		return recordsProcessedSuccess;
	}

	/**
	 * @param recordsProcessedSuccess the recordsProcessedSuccess to set
	 */
	public void setRecordsProcessedSuccess(int recordsProcessedSuccess) {
		this.recordsProcessedSuccess = recordsProcessedSuccess;
	}

	/**
	 * @return the recordsProcessedError
	 */
	public int getRecordsProcessedError() {
		return recordsProcessedError;
	}

	/**
	 * @param recordsProcessedError the recordsProcessedError to set
	 */
	public void setRecordsProcessedError(int recordsProcessedError) {
		this.recordsProcessedError = recordsProcessedError;
	}
	
	
	public synchronized void incRecordsProcessedError(){
		recordsProcessedError++;
	}
	
	
	public synchronized void incRecordsProcessedSuccess(){
		recordsProcessedSuccess++;
	}
	
	
	 @Override
	public String toString() {
		return "\n NOMBRE : " + this.getNombre()  + 
			   "\n Descripcion : " + this.getDescripcion() + 
			   "\n Registros OK : " + this.getRecordsProcessedSuccess() + 
			   "\n Registros NOK : " + this.getRecordsProcessedError();
	}

}