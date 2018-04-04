/**
 * Kuvasz Solutions - Equipo de Consultoria
 * Santiago de Chile, Merced 838 Piso 15 oficina 153
 * http://www.kvz.cl
 */
package cl.magno.concentrador.streamdata.core.util;

import java.util.Map;

/**
 * Kuvasz Solutions
 * 
 * @author Juan Francisco Maldonado León
 * @since 29-06-2016 20:13:32
 */
public class AppConfig {

	private Map<String, String> data;

	/**
	 * 
	 */
	public AppConfig() {
	}

	/**
	 * @param data
	 */
	public AppConfig(Map<String, String> data) {
		super();
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public Map<String, String> getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Map<String, String> data) {
		this.data = data;
	}

}
