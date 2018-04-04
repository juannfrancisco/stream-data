package cl.magno.concentrador.model.execution;

import cl.magno.stream.core.model.flow.Flow;
import cl.magno.stream.exceptions.FlowException;

/**
 * 
 * @author Juan Francisco Maldonado León
 * @since 30-06-2016 12:51:59
 */
public abstract class ExecutionInput extends Execution 
{
	private static final long serialVersionUID = 1277279384875175905L;
	public abstract void extract( Flow flujo, CallbackExecution callback )throws FlowException;
}
