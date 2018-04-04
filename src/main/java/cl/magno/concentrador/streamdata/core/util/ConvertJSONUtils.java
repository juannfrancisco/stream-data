/**
 * Kuvasz Solutions - Equipo de Consultoria
 * Santiago de Chile, Merced 838 Piso 15 oficina 153
 * http://www.kvz.cl
 */
package cl.magno.concentrador.streamdata.core.util;

import java.util.Map;

import com.google.gson.Gson;

/**
 * Kuvasz Solutions
 * 
 * @author Juan Francisco Maldonado León
 * @since 29-06-2016 19:05:27
 */
@Deprecated
public final class ConvertJSONUtils {

	private ConvertJSONUtils() {
	}

	public static String mapToJson(Map<String, Object> datos ) {
		Gson gs = new Gson();
		return gs.toJson(datos);
	}

}
