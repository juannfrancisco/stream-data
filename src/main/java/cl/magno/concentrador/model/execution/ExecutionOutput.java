package cl.magno.concentrador.model.execution;

import java.util.Map;

import cl.magno.stream.core.model.flow.Flow;
import cl.magno.stream.exceptions.FlowException;

/**
 * 
 *
 */
public abstract class ExecutionOutput extends Execution 
{	
	private static final long serialVersionUID = 3527088544375488844L;

	
	public ExecutionOutput(){
		
	}
		
	public abstract void initialize( Flow flujo );
	public abstract void sendData( Map<String, Object> data, Flow flujo, CallbackExecutionSender callback) throws FlowException;
	public abstract void finalize( Flow flujo );

}
