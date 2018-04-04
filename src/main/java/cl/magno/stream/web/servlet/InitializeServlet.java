package cl.magno.stream.web.servlet;

import java.net.InetAddress;
import java.util.UUID;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import cl.magno.concentrador.streamdata.core.app.Application;
import cl.magno.concentrador.streamdata.core.notify.NotifyManager;


/**
 * @author Juan Francisco Maldonado Leon - jmaldonado@kvz.cl
 */
public class InitializeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private transient static final Logger LOGGER = Logger.getLogger(InitializeServlet.class); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitializeServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
			LOGGER.info("Inicializando Applicacion");
			InetAddress IP=InetAddress.getLocalHost();
			
			Application.getInstance().setId( "app-" + UUID.randomUUID().toString() );
			Application.getInstance().setInfo( config.getServletContext().getServerInfo() );
			Application.getInstance().setIp( IP.getHostAddress() );
			LOGGER.info( Application.getInstance().toString() );
			
			
			NotifyManager.initialize();
			
			
			
			
		} catch (Exception e) {
			LOGGER.error( "Ocurrio un error al inicializar la aplicación", e );
		}
	}
	
	
	@Override
	public void destroy() {
		super.destroy();
		LOGGER.info("------------------------------------------------------------------------------------");
		LOGGER.info( "La aplicacion ha sido removida del servidor" );
		try {
			if( null != Application.getInstance().getNotifyQueue() ){
				 Application.getInstance().getNotifyQueue().stop();
				 LOGGER.info( "deteniendo listener de notificaciones....... OK" );
			}
			
			LOGGER.info("------------------------------------------------------------------------------------");
		} catch (Exception e) {
			LOGGER.error("Ocurrio un error al detener la lectura de mensajes",e );
		}
	}

}
