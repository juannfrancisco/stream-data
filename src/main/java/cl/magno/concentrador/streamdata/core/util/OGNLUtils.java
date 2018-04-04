/**
 * 
 */
package cl.magno.concentrador.streamdata.core.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;

import cl.magno.concentrador.model.TrxObject;


import cl.magno.stream.utils.TimeUtil;

//import cl.gf.notificaciones.delivery.crypto.impl.HashUtils;
//import cl.gf.notificaciones.delivery.crypto.impl.StartEncryptor;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author JUAN MALDONADO LEON - KUVASZ SOLUTIONS.
 * 
 */
public class OGNLUtils implements Serializable
{
	private static final long serialVersionUID = 8861761203316859804L;
	private transient static final Logger LOGGER = Logger.getLogger( OGNLUtils.class );
	private static Gson gsrv;
	private static DecimalFormatSymbols dfs;
	
	static {
		dfs = new DecimalFormatSymbols();
		gsrv = new Gson();
		dfs.setDecimalSeparator('.');
	}
	
	
	public static String getArrayData( String data, String separator, int ncampo) {
		try {
			String[] campo = data.split(separator);
			return campo[ncampo];
		}catch(Exception ex) {
			return "";
		} 
	}
	
	/**
	 * @param name
	 * @return
	 */
	public static String getAttributeString( TrxObject target,  String name )
	{
		try
		{
			if (target.getStrCore() != null ) {
				return gsrv.fromJson(target.getStrCore(),Map.class).get(name).toString();
			}
			Object result = target.getCore().get( name );
			return String.valueOf( result );
		}
		catch (Exception e)
		{
			LOGGER.error( "ERROR AL CONVERTIR EL ATRIBUTO " + name + " A STRING", e );
			return "";
		}
	}
	
	/**
	 * @param numero
	 * @return
	 */
	public static String formatoDecimal( String numero )
	{
		String numeroNuevo = (numero == null || numero.length()==0)  ?  "0" : numero ;
		numeroNuevo = (numero != null && numero.contains(",")) ? numero.replace(',', '.') : numeroNuevo;
		String cadena="";		
		BigDecimal big = new BigDecimal(numeroNuevo);
		big = big.setScale(2, RoundingMode.HALF_UP);
		DecimalFormat formateador = new DecimalFormat("####.##");
		Double d= big.doubleValue();
		cadena= formateador.format ( d.doubleValue() ).replace(".", "");
		cadena= quitaEspacios(cadena);
		return cadena;
	}
	
	public static String formatoDecimal( String numero, String separador, int round )
	{ 
		String numeroNuevo = (numero == null || numero.length()==0)  ?  "0" : numero ;
		numeroNuevo = numero != null && numero.contains(",") ? numero.replace(',', '.') : numeroNuevo;
		String cadena="";		
		BigDecimal big = new BigDecimal(numeroNuevo);
		big = big.setScale(round, RoundingMode.HALF_UP);
		DecimalFormat formateador = new DecimalFormat("############.####");
		Double d= big.doubleValue();
		cadena= formateador.format ( d.doubleValue() ).replace(".", "");
		cadena= quitaEspacios(cadena);
		return cadena;
	}	
	
	public static void main( String[] args ) 
	{  
		
		System.err.println(  formatFecha( fechaActual("yyyyMMdd") ,"yyyyMMdd") );
	}
	/**
	 * @param texto
	 * @return
	 */
	public static String quitaEspacios(String texto) 
	{
		java.util.StringTokenizer tokens = new java.util.StringTokenizer(texto);
	    StringBuilder buff = new StringBuilder();
	    while (tokens.hasMoreTokens()) 
	    {
	    	buff.append(" ").append(tokens.nextToken());
	    }
	    return buff.toString().trim();
	}
	
	
	/** 
	 * @param nuevo
	 * @param cuantos
	 * @return
	 */
	public static String completarEspaciosIzquierda( String nuevo, int cuantos, String caracter )
	{ 
		StringBuilder resp = new StringBuilder(); 
		resp.append(nuevo== null ? "": nuevo);
		while( resp.length() < cuantos )
		{
			resp = resp.insert(0, caracter);
		}
		return resp.toString();
	}
	
	/**
	 * 
	 * @param nuevo
	 * @param cuantos
	 * @return
	 */
	public static String completarEspaciosDerecha( String nuevo, int cuantos, String caracter )
	{
		String respuesta = nuevo== null ? "": nuevo;
		
		while( respuesta.length() < cuantos )
		{
			respuesta = respuesta.concat( caracter );
		}
		return respuesta;
	}
	
//	
//	/**
//	 * Generacion de ID inico para RUT de usuario.
//	 * @param valor
//	 * @return
//	 */
//	public static String encriptarValor( String valor )
//	{
//		String resultado = "";
//		try 
//		{
//			resultado = HashUtils.hashCode(valor);
//		}
//		catch (Exception e) 
//		{
//			LOGGER.error( "Error al encriptar valor, retornando valor normalizado : " + valor );
//			resultado = valor;
//		}
//		return resultado;
//	}
//	
	
//	/**
//	 * @param valor
//	 * @return
//	 */
//	public static String encriptarValorConCertificado( String campo, String valor, String llave, Map<String, Object> map )
//	{
//		String resultado = ""; 
//		try 
//		{
//			VariablesDeEntorno variables = (VariablesDeEntorno)ServiceLocator.getInstance().getBean(Constants.BEAN_VARIABLES);
//			StartEncryptor enc = new StartEncryptor( variables.getPathCertificado() );
//			resultado = enc.encryptString( valor );
//			String keyEnc = enc.getSecretKeyEnc();
//			map.put(campo, resultado );
//			map.put(llave, keyEnc);
//		}
//		catch (Exception e) 
//		{
//			LOGGER.error( "Error al encriptar valor, retornando valor normalizado : " + valor );
//			resultado = valor;
//		}
//		return resultado;
//	}
//	
//	
//	/**
//	 * @param campos Nombre de los campos que se van a encriptar
//	 * @param entrada Valores de tipo String que se van a encriptar
//	 * @param llave Nombre del campo de la llave
//	 * @param map Mapa con los valores.
//	 * @return
//	 */
//	public static List<String> encriptarValorConCertificado( List<String> campos, List<String> entrada, String llave, Map<String, Object> map )
//	{
//		List<String> resultado = new ArrayList<String>(); 
//		try 
//		{
//			VariablesDeEntorno variables = (VariablesDeEntorno)ServiceLocator.getInstance().getBean(Constants.BEAN_VARIABLES);
//			StartEncryptor enc = new StartEncryptor( variables.getPathCertificado() );
//			resultado = enc.encryptStringList(entrada);
//			String keyEnc = enc.getSecretKeyEnc();
//			map.put( llave, keyEnc );
//			for( int i = 0; i < campos.size(); i++ )
//			{
//				map.put( campos.get(i) , resultado.get(i) );
//			}
//		}
//		catch (Exception e) 
//		{
//			LOGGER.error( "Error al encriptar valor, retornando valor normalizado " );
//		}
//		return resultado;
//	}
	
	/**
	 * DESCRIPCION : OBTIENE LA FECHA ACTUAL CON EL FORMATO ENVIADO COMO PARAMETRO
	 * @author SEBASTIAN VEGA - KUVASZ SOLUTIONS
	 * @return
	 */
	public static String fechaActual( String format )
	{
		return TimeUtil.formateaDateToString( format, new Date() );
		
	}
	
	/**
	 * @param format
	 * @return
	 */
	public static String cambiarFormatoFecha(String fecha, String formatoOrigen, String formatDestino )
	{
		SimpleDateFormat sdf = new SimpleDateFormat( formatoOrigen );
		Date date = null; 
		try {
			date = sdf.parse(fecha);
			
		} catch (ParseException e) {
			 date = new Date();
		}
		
		return TimeUtil.formateaDateToString( formatDestino, date );
		
	}
	
	
	public static String formatFecha( String strfch, String format )
	{
		SimpleDateFormat sdf = new SimpleDateFormat( format );
		Date date = null;
		try {
			date = sdf.parse(strfch);
			return sdf.format(date);
		} catch (ParseException e) {
			return "";
		}
	}
	
	/**
	 * DESCRIPCION : CONVIERTE EL OBJETO DE ENTRADA A JSON (STRING)
	 * @param target
	 * @return
	 */ 
	public static String objectToJson( TrxObject target )
	{ 
		if (target.getStrCore()!=null) {
			return target.getStrCore();
		}
		return gsrv.toJson( target.getStrCore() ); 		
		
	}
	
	/**
	 * DESCRIPCION : CONVIERTE EL STRING DE ENTRADA A JSON (OBJETO)
	 * @param jsonString
	 * @return
	 */
	public static JsonObject stringToJson( String jsonString )
	{
		JsonParser jsonParser = new JsonParser();
		JsonObject jo = (JsonObject)jsonParser.parse(jsonString);
		return jo;
	}
	
	/**
	 * @param number
	 * @param format
	 * @return
	 */
	public static String formatNumber( String number, String format)
	{
		double d = Double.parseDouble( number );
	    DecimalFormat df = new DecimalFormat( format );//"0000000000000000000.000"
	    df.setDecimalFormatSymbols(dfs); 
	    return df.format(d).replace(".", "");
	}
	
	public static String formatNumber( String number, String format, String decimal )
	{
		BigDecimal d = new BigDecimal(number);
		//Double d = Double.parseDouble( number );
	    DecimalFormat df = new DecimalFormat( format );//"0000000000000000000.000" - ######.####
	    df.setDecimalFormatSymbols(dfs); 
	    return df.format(d).replace(".", decimal);
	}
	
}