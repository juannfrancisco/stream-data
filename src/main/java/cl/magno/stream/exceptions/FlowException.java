/**
 * 
 */
package cl.magno.stream.exceptions;

import cl.magno.concentrador.model.execution.Execution;

/**
 * @author Juan Francisco Maldonado León - juan.maldonado.leon@gmail.com
 */
public class FlowException extends Exception 
{
	private static final long serialVersionUID = 6561813636010997558L;
	private Execution ejecucion;
	
	/**
	 * 
	 */
	public FlowException()
	{
		super( "Error en ejecucion" );
	}
	
	
	/**
	 * @param mensaje
	 */
	public FlowException( String mensaje )
	{
		super( mensaje );
	}
	
	
	
	/**
	 * @param mensaje
	 */
	public FlowException( String mensaje, Throwable cause )
	{
		super( mensaje , cause );
	}


	/**
	 * @return the ejecucion
	 */
	public Execution getEjecucion() 
	{
		return ejecucion;
	}


	/**
	 * @param ejecucion the ejecucion to set
	 */
	public void setEjecucion(Execution ejecucion) 
	{
		this.ejecucion = ejecucion;
	}
}
