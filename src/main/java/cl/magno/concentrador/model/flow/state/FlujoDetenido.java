package cl.magno.concentrador.model.flow.state;

import java.io.Serializable;

import org.apache.log4j.Logger;

import cl.magno.stream.core.model.flow.FlujoAbstract;

/**
 * @author JUAN MALDONADO LEON.-
 * KUVASZ SOLUTIONS 2012
 */
public class FlujoDetenido extends EstadoFlujo implements Serializable 
{
	private static final Logger LOGGER = Logger.getLogger(FlujoDetenido.class);
	private static final long serialVersionUID = 6039202613956022023L;

	/**
	 * 
	 */
	public FlujoDetenido()
	{
		this.setNombre( "Detenido" );
		this.setIcon( "flPlay.png" );
	}

	@Override
	public void executeFlujo(FlujoAbstract flujo) 
	{
//		try 
//		{
////			AdminProcess.executeTask(flujo);
//			flujo.setEstado( new FlujoIniciado() );
//		}
//		catch (Exception e) 
//		{
//			LOGGER.error( "Error al iniciar el flujo", e );
//		}	
	}

	
	public void deleteFlujo(FlujoAbstract flujo) 
	{
		//Solo se detiene el flujo si su estado es Iniciado.	
	}

	@Override
	public void restartFlujo( FlujoAbstract flujo )
	{
		throw new UnsupportedOperationException( "El flujo esta detenido, no se puede reiniciar la ejecuci�n" );
	}

	@Override
	public void startFlujo(FlujoAbstract flujo) 
	{
//		try 
//		{
////			AdminProcess.executeTask(flujo);
//			flujo.setEstado( new FlujoIniciado() );
//		}
//		catch (Exception e) 
//		{
//			LOGGER.error( "Error al iniciar el flujo", e );
//		}	

	}
}
