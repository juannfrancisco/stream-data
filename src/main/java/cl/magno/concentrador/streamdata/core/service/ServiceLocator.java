/**
 * Magno Labs - Desarrollo de Software 
 * Santiago de Chile, Merced 838 Piso 15 oficina 153
 * http://www.magno.cl
 */
package cl.magno.concentrador.streamdata.core.service;

import java.io.Serializable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Magno Labs
 * 
 * @author Juan Francisco Maldonado León
 * @since 29-06-2016 18:35:08
 */
public class ServiceLocator implements Serializable {
	
	private static final long serialVersionUID = 6419515074354952981L;
	private static ServiceLocator instance = null;
	private ApplicationContext context = null;
	private static final String APP_CONTEX_NAME = "stream-data-config.xml";

	/**
	 * 
	 */
	private ServiceLocator() {
		this.setContext(new ClassPathXmlApplicationContext(
				new String[] { ServiceLocator.APP_CONTEX_NAME }));
	}

	
	
	public static ServiceLocator getInstance() {
		return ServiceLocator.instance != null ? ServiceLocator.instance
				: ServiceLocator.init();
	}

	private static ServiceLocator init() {
		ServiceLocator.instance = new ServiceLocator();
		return ServiceLocator.instance;
	}

	private ApplicationContext getContext() {
		return context;
	}

	private void setContext(ApplicationContext context) {
		this.context = context;
	}

	public Object getBean(String idBean) {
		return this.getContext().getBean(idBean);
	}
}