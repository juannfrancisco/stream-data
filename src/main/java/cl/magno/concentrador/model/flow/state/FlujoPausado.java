package cl.magno.concentrador.model.flow.state;

import java.io.Serializable;

import org.apache.log4j.Logger;

import cl.magno.stream.core.model.flow.FlujoAbstract;

/**
 * @author JUAN MALDONADO LEON
 * KUVASZ SOLUTIONS 2012
 */
public class FlujoPausado extends EstadoFlujo implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7019972404732069416L;
	private static final Logger LOGGER = Logger.getLogger(FlujoPausado.class);
	
	/**
	 * 
	 */
	public FlujoPausado()
	{
		this.setNombre( "Pausado" );
		this.setIcon( "flPaused.png" );
	}

	@Override
	public void executeFlujo(FlujoAbstract flujo) 
	{
//		try 
//		{
//			AdminProcess.stopFlujo(flujo);
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
//			AdminProcess.stopFlujo(flujo);
//			flujo.stopFlujo();
//		}
//		catch (SchedulerException e) 
//		{
//			LOGGER.error( "[ELIMINAR] - No se ha podido detener el flujo " + flujo.getNombre() , e );
//		}
	}

	@Override
	public void restartFlujo( FlujoAbstract flujo ) 
	{
		
	}

	@Override
	public void startFlujo(FlujoAbstract flujo) 
	{		
//		try 
//		{
//			AdminProcess.stopFlujo( flujo );
//			flujo.stopFlujo();
//			AdminProcess.executeTask(flujo);
//			flujo.setEstado( new FlujoIniciado() );				
//		}
//		catch (  Exception e ) 
//		{
//			LOGGER.error( "[ELIMINAR] - No se ha podido detener el flujo " + flujo.getNombre() , e );
//		}		
	}
}
