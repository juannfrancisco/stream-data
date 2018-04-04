package cl.magno.concentrador.model.flow.state;

import java.io.Serializable;

import org.apache.log4j.Logger;

import cl.magno.stream.core.model.flow.FlujoAbstract;

/**
 * @author JUAN MALDONADO LEON
 * KUVASZ SOLUTIONS 2012
 */
public class FlujoIniciado extends EstadoFlujo implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7019972404732069416L;
	private static final Logger LOGGER = Logger.getLogger(FlujoIniciado.class);
	/**
	 * 
	 */
	public FlujoIniciado()
	{
		this.setNombre( "Iniciado" );
		this.setIcon( "flStop.png" );
	}

	@Override
	public void executeFlujo(FlujoAbstract flujo) 
	{
//		try 
//		{
////			AdminProcess.stopFlujo(flujo);
//			flujo.stopFlujo();
//			flujo.setEstado( new FlujoDetenido() );
//		} 
//		catch ( Exception e) 
//		{
//			LOGGER.error( "OCURRIO UN ERROR AL DETENER EL FLUJO", e );
//		}
	}
	

	@Override
	public void deleteFlujo(FlujoAbstract flujo) 
	{
//		try 
//		{
////			AdminProcess.stopFlujo(flujo);
//			flujo.stopFlujo();
//		}
//		catch (SchedulerException e) 
//		{
//			LOGGER.error( "[ELIMINAR] - No se ha podido detener el flujo " + flujo.getNombre() , e );
//		}
	}

	@Override
	public void restartFlujo(FlujoAbstract flujo) 
	{
		throw new UnsupportedOperationException( "Ya se encuentra en ejecuci�n." );
	}

	@Override
	public void startFlujo(FlujoAbstract flujo) 
	{
		
	}
}
