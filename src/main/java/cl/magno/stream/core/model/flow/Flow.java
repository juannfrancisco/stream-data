package cl.magno.stream.core.model.flow;

import cl.magno.concentrador.model.Muestreador;
import cl.magno.concentrador.model.flow.execution.EstadoEjecucionFlujo;
import cl.magno.concentrador.model.flow.state.EstadoFlujo;
import cl.magno.concentrador.model.schedule.Planificacion;



/**
 * 
 * @author Juan Francisco Maldonado Leon - juan.maldonado.leon@gmail.com
 *
 */
public class Flow extends FlujoAbstract {
	
	private static final long serialVersionUID = 9205632215151133414L;
	private Muestreador muestreador = new Muestreador();
	private boolean isAsync = false;
	private String asynSelect;
	
	private boolean asyncFinalizaEntrada = false;
	private boolean asyncFinalizaMapping = false;
	
	private int asyncNroRegsIng = 0;
	private int asyncNroRegsMapping = 0;
	private int asyncNroRegsSalida = 0;
	private int asyncNroRegsErrIng = 0;
	private int asyncNroRegsErrSalida = 0;

	
	public Flow(){
		
	}
	

	/**
	 * @param uuidExecution
	 * @param oid
	 * @param nombre
	 * @param descripcion
	 * @param planificacion
	 * @param estado
	 * @param estadoEjecucion
	 * @param muestreador
	 * @param isAsync
	 * @param asynSelect
	 * @param asyncFinalizaEntrada
	 * @param asyncNroRegsIng
	 * @param asyncNroRegsSalida
	 * @param asyncNroRegsErrIng
	 * @param asyncNroRegsErrSalida
	 */
	public Flow(String uuidExecution, int oid, String nombre,
			String descripcion, Planificacion planificacion,
			EstadoFlujo estado, EstadoEjecucionFlujo estadoEjecucion,
			Muestreador muestreador, boolean isAsync, String asynSelect,
			boolean asyncFinalizaEntrada, int asyncNroRegsIng,
			int asyncNroRegsSalida, int asyncNroRegsErrIng,
			int asyncNroRegsErrSalida) {
		super(uuidExecution, oid, nombre, descripcion, planificacion, estado,
				estadoEjecucion);
		this.muestreador = muestreador;
		this.isAsync = isAsync;
		this.asynSelect = asynSelect;
		this.asyncFinalizaEntrada = asyncFinalizaEntrada;
		this.asyncNroRegsIng = asyncNroRegsIng;
		this.asyncNroRegsSalida = asyncNroRegsSalida;
		this.asyncNroRegsErrIng = asyncNroRegsErrIng;
		this.asyncNroRegsErrSalida = asyncNroRegsErrSalida;
	}







	/**
	 * @return the muestreador
	 */
	public Muestreador getMuestreador() {
		return muestreador;
	}
	/**
	 * @param muestreador the muestreador to set
	 */
	public void setMuestreador(Muestreador muestreador) {
		this.muestreador = muestreador;
	}
	/**
	 * @return the isAsync
	 */
	public boolean isAsync() {
		return isAsync;
	}
	/**
	 * @param isAsync the isAsync to set
	 */
	public void setAsync(boolean isAsync) {
		this.isAsync = isAsync;
	}
	/**
	 * @return the asynSelect
	 */
	public String getAsynSelect() {
		return asynSelect;
	}
	/**
	 * @param asynSelect the asynSelect to set
	 */
	public synchronized void setAsynSelect(String asynSelect) {
		this.asynSelect = asynSelect;
	}
	/**
	 * @return the asyncFinalizaEntrada
	 */
	public synchronized boolean isAsyncFinalizaEntrada() {
		return asyncFinalizaEntrada;
	}
	/**
	 * @param asyncFinalizaEntrada the asyncFinalizaEntrada to set
	 */
	public synchronized void setAsyncFinalizaEntrada(boolean asyncFinalizaEntrada) {
		this.asyncFinalizaEntrada = asyncFinalizaEntrada;
	}
	/**
	 * @return the asyncNroRegsIng
	 */
	public int getAsyncNroRegsIng() {
		return asyncNroRegsIng;
	}
	/**
	 * @param asyncNroRegsIng the asyncNroRegsIng to set
	 */
	public void setAsyncNroRegsIng(int asyncNroRegsIng) {
		this.asyncNroRegsIng = asyncNroRegsIng;
	}
	/**
	 * @return the asyncNroRegsSalida
	 */
	public int getAsyncNroRegsSalida() {
		return asyncNroRegsSalida;
	}
	/**
	 * @param asyncNroRegsSalida the asyncNroRegsSalida to set
	 */
	public void setAsyncNroRegsSalida(int asyncNroRegsSalida) {
		this.asyncNroRegsSalida = asyncNroRegsSalida;
	}
	/**
	 * @return the asyncNroRegsErrIng
	 */
	public int getAsyncNroRegsErrIng() {
		return asyncNroRegsErrIng;
	}
	/**
	 * @param asyncNroRegsErrIng the asyncNroRegsErrIng to set
	 */
	public void setAsyncNroRegsErrIng(int asyncNroRegsErrIng) {
		this.asyncNroRegsErrIng = asyncNroRegsErrIng;
	}
	/**
	 * @return the asyncNroRegsErrSalida
	 */
	public int getAsyncNroRegsErrSalida() {
		return asyncNroRegsErrSalida;
	}
	/**
	 * @param asyncNroRegsErrSalida the asyncNroRegsErrSalida to set
	 */
	public void setAsyncNroRegsErrSalida(int asyncNroRegsErrSalida) {
		this.asyncNroRegsErrSalida = asyncNroRegsErrSalida;
	}
	
	/**
	 * @return the asyncNroRegsMapping
	 */
	public int getAsyncNroRegsMapping() {
		return asyncNroRegsMapping;
	}


	/**
	 * @param asyncNroRegsMapping the asyncNroRegsMapping to set
	 */
	public void setAsyncNroRegsMapping(int asyncNroRegsMapping) {
		this.asyncNroRegsMapping = asyncNroRegsMapping;
	}
	
	/**
	 * @return the asyncFinalizaMapping
	 */
	public boolean isAsyncFinalizaMapping() {
		return asyncFinalizaMapping;
	}


	/**
	 * @param asyncFinalizaMapping the asyncFinalizaMapping to set
	 */
	public synchronized void setAsyncFinalizaMapping(boolean asyncFinalizaMapping) {
		this.asyncFinalizaMapping = asyncFinalizaMapping;
	}
	
	
	/**
	 * 
	 */
	public synchronized void incAsyncNroRegsSalida() {
		this.asyncNroRegsSalida++;
	}
	
	/**
	 * 
	 */
	public synchronized void incAsyncNroRegsMapping() {
		this.asyncNroRegsSalida++;
	}

	/**
	 * 
	 */
	public synchronized void incAsyncNroRegsIng() {
		this.asyncNroRegsIng++;
	}

	
	/**
	 * 
	 */
	public synchronized void decAsyncNroRegsIng() {
		this.asyncNroRegsIng--;
	}

	/**
	 * 
	 */
	public synchronized void incAsyncNroRegsErrSalida() {
		this.asyncNroRegsErrSalida++;
	}


	

	
}
