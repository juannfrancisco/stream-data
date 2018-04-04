package cl.magno.stream.utils;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

/**
 * Contiene metodos necesarios para calculos de fecha
 */
public class TimeUtil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3248121048545758299L;
	public static final String DATE_FORMAT = "dd-MM-yyyy";
	public static final String DATE_FORMAT_2 = "yyyy-MM-dd";
	public static final String DATE_FORMAT_3 = "dd/MM/yyyy";
	public static final String DATE_FORMAT_4 = "dd/MM/yy";
	public static final String DATE_FORMAT_TS = "yyyy/MM/dd hh:mm:ss";
	public static final String DATE_FORMAT_5 = "yyyy-MM-dd hh:mm:ss";
	public static final String DATE_FORMAT_6 = "yyyyMMdd";
	private static final Logger LOGGER = Logger.getLogger(TimeUtil.class);

	/**
	 * La diferencia en horas entre una fecha y otra
	 * 
	 * @return date1 - date2 en horas
	 */
	public static long getDiferenceInHours(Date date1, Date date2) {

		long secs;
		secs = date1.before(date2) ? ((long) ((date2.getTime() - date1
				.getTime()) / 1000)) : (long) ((date1.getTime() - date2
				.getTime()) / 1000);

		long mins = secs / 60;
		long hours = mins / 60;
		return hours;
	}

	/**
	 * La diferencia en horas entre una fecha y otra
	 * 
	 * @return date1 - date2 en d�as
	 */
	public static long getDiferenceInDays(Date date1, Date date2) {

		return (getDiferenceInHours(date1, date2) / 24) + 1;
	}

	/**
	 * La diferencia en a�os entre la fecha y otra
	 * 
	 * @return date1 - date2, en a�os
	 */
	public static long getDiferenceInYears(Date date1, Date date2) 
	{
		double round = ( getDiferenceInDays(date1, date2)) /365;
		return Math.round(round);
	}

	/**
	 * La diferencia en meses entre la fecha y otra
	 * 
	 * @return date1 - date2, en meses
	 */
	public static long getDiferenceInMonths(Date date1, Date date2) 
	{
		double round = ( getDiferenceInDays(date1, date2)) /30;
		return Math.round( round );
	}

	/**
	 * 
	 * Dada una fecha de nacimiento de una persona retorna la edad de la misma
	 * 
	 * @param date1
	 * @return int
	 */
	public static int getAge(Date date1) {

		int age = 0;
		Calendar birthdate = Calendar.getInstance();
		birthdate.setTime(date1);
		Calendar now = Calendar.getInstance();
		age = now.get(Calendar.YEAR) - birthdate.get(Calendar.YEAR);
		birthdate.add(Calendar.YEAR, age);
		if (now.before(birthdate)) {
			age--;
		}
		return age;
	}

	/**
	 * Retorna el dia de la fecha
	 * 
	 * @param fecha
	 *            la fecha de la que se quiere recuperar el dia
	 * @return el dia de la fecha
	 */
	public static int getDia(Date fecha) {
		Calendar c = Calendar.getInstance();
		c.setTime(fecha);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Retorna el mes de la fecha
	 * 
	 * @param fecha
	 *            la fecha de la que se quiere recuperar el mes
	 * @return el mes de la fecha
	 */
	public static int getMes(Date fecha) {
		Calendar c = Calendar.getInstance();
		c.setTime(fecha);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * Retorna el a�o de la fecha
	 * 
	 * @param fecha
	 *            la fecha de la que se quiere recuperar el a�o
	 * @return el a�o de la fecha
	 */
	public static int getAno(Date fecha) {
		Calendar c = Calendar.getInstance();
		c.setTime(fecha);
		return c.get(Calendar.YEAR);
	}

	/**
	 * Transforma un String a un Date
	 * 
	 * @param dateStr
	 *            el string a transformar
	 * @return el Date correspondiente a la string ingresado por parametro
	 * @throws ParseException
	 */
	public static Date toDate(String dateStr) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat();
		return formatter.parse(dateStr);
	}

	/**
	 * Si una fecha es 01/01/1900 retorna el valor nulo en caso contrario
	 * retorna el mismo valor
	 * 
	 * @param date
	 *            la fecha que hay que verificar
	 * @return Si una fecha es 01/01/1900 retorna el valor nulo en caso
	 *         contrario retorna el mismo valor
	 */
	public static Date verificarFecha(Date date) {
		int year = 1900;
		int month = 1;
		int day = 1;
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		if (c.get(Calendar.DAY_OF_MONTH) == day
				&& c.get(Calendar.MONTH) + 1 == month
				&& c.get(Calendar.YEAR) == year) {
			return null;
		}
		return date;
	}

	/**
	 * Formatea y parsea una fecha Date a String
	 * 
	 * @param date
	 * @return String
	 */
	public static String formatDate(Date date) 
	{
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(date);
		SimpleDateFormat SDF = new SimpleDateFormat(DATE_FORMAT);
		SDF.format(c.getTime());
		return SDF.format(c.getTime());
	}
	
	/**
	 * @param date
	 * @return
	 */
	public static String formatDateTime(Date date) 
	{
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(date);
		SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		DATE_TIME_FORMAT.format(c.getTime());
		return DATE_TIME_FORMAT.format(c.getTime());
	}

	/**
	 * Formatea y parsea una fecha Date a String
	 * 
	 * @param date
	 * @return String
	 */
	public static String formatDate2( Date date ) 
	{
		if (date != null) 
		{
			Calendar c = GregorianCalendar.getInstance();
			c.setTime(date);
			SimpleDateFormat SDF_2 = new SimpleDateFormat( DATE_FORMAT_2 );
			SDF_2.format(c.getTime());
			return SDF_2.format(c.getTime());
		} 
		else
			return "";
	}

	/**
	 * Formatea y parsea una fecha Date a String
	 * 
	 * @param date
	 * @return String
	 */
	public static String formateaDateToString(Date date) {
		if (date != null) {
			Calendar c = GregorianCalendar.getInstance();
			c.setTime(date);
			SimpleDateFormat SDF_2 = new SimpleDateFormat( DATE_FORMAT_2 );
			SDF_2.format(c.getTime());
			return SDF_2.format(c.getTime());
		} else
			return "";
	}

	/**
	 * Formatea una fecha string
	 * 
	 * @param strfch
	 * @return String
	 */
	public static String formatString(String strfch) 
	{
		Date date = null;
		try 
		{
			SimpleDateFormat SDF = new SimpleDateFormat(DATE_FORMAT);
			date = SDF.parse(strfch);
			return SDF.format(date);
		} catch (ParseException e) {
			return "";
		}

	}

	/**
	 * Transforma un String a un Date
	 * 
	 * @param dateStr
	 *            el string a transformar
	 * @return el Date correspondiente a la string ingresado por parametro
	 * @throws ParseException
	 */
	public static Date toDateFormatWrapper(String dateStr)
			throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(TimeUtil.DATE_FORMAT);
		return formatter.parse(dateStr);
	}

	/**
	 * Transforma un String a Date
	 * 
	 * @param dateStr
	 * @param format
	 * @return Date
	 * @throws ParseException
	 */
	public static Date toDateFormatWrapper(String dateStr, String format)
			throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.parse(dateStr);
	}

	/**
	 * Transforma un String a un Date
	 * 
	 * @param dateStr
	 *            el string a transformar
	 * @return el Date correspondiente a la string ingresado por parametro
	 * @throws ParseException
	 */
	public static Date toDateFormat(String dateStr) throws ParseException {
		String pformat = "yyyy-mm-dd";
		Date date = null;
		SimpleDateFormat df = new SimpleDateFormat(pformat);
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			LOGGER.error("Error al transformar el formato de un String a Date",
					e);
			throw new ParseException(
					"Error al transformar el formato de un String a Date. "
							+ e.getMessage(), e.getErrorOffset());
		}
		return date;
	}

	/**
	 * Obtiene el mes anterior
	 * 
	 * @param fecha
	 * @return
	 */
	public static String getFechaMesAnterior(Date fecha) {

		Calendar fch = Calendar.getInstance();
		fch.setTime(fecha);

		fch.add(Calendar.MONTH, -1);

		Date fechaNueva = fch.getTime();

		String var = TimeUtil.formatDate2(fechaNueva);

		return var;
	}

	/**
	 * Parsea a Date una fecha String
	 * 
	 * @param dateStr
	 * @return Date
	 */
	public static Date toFormatDate(String dateStr)
	{
		try 
		{
			SimpleDateFormat SDF_3 = new SimpleDateFormat( DATE_FORMAT_3 );
			return SDF_3.parse(dateStr);
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	public static String getNombreMES(int mes) {
		try {
			switch (mes) {
			case 1:
				return "Enero";
			case 2:
				return "Febrero";
			case 3:
				return "Marzo";
			case 4:
				return "Abril";
			case 5:
				return "Mayo";
			case 6:
				return "Junio";
			case 7:
				return "Julio";
			case 8:
				return "Agosto";
			case 9:
				return "Septiembre";
			case 10:
				return "Octubre";
			case 11:
				return "Noviembre";
			case 12:
				return "Diciembre";
			default:
				return "";
			}
		} catch (Exception e) {
			return "";
		}
	}

	public static boolean compararFecha(String d1, Date d2) throws Exception {

		boolean resultado = false;
		
		Calendar fch1 = Calendar.getInstance();
		Calendar fch2 = Calendar.getInstance();
		fch1.setTime(toDateFormat(d1));// Fecha Enlace
		fch2.setTime(d2);// Fecha Conexion

		try {
			if (fch2.before(fch1)) {
				resultado = true;
			}
			return resultado;
		} catch (Exception e) {
			throw new Exception("Error al comparar las fechas", e);
		}

	}

	public static Date parseTs(Timestamp t) {
		try {
			Date d = new Date(t.getTime());

			return d;
		} catch (Exception e) {
			return null;
		}

	}

	public static String parseTsString(Timestamp t) {
		try {
			Date d = new Date(t.getTime());
			return formateaDateToString(d);
		} catch (Exception e) {
			return null;
		}

	}

	public static Timestamp parseTimestamp(String fecha) {
		Timestamp timest;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			Date date = sdf.parse(fecha);
			timest = new Timestamp(date.getTime());

			return timest;
		} catch (Exception e) {

			return null;
		}

	}

	public static Timestamp parseTimestamp(Date fecha) {
		try {

			Timestamp timest = new Timestamp(fecha.getTime());

			return timest;
		} catch (Exception e) {
			return null;
		}

	}

	public static Date toDateSdf2(String dateStr) throws ParseException {
		try 
		{
			SimpleDateFormat SDF_2 = new SimpleDateFormat( DATE_FORMAT_2 );
			return SDF_2.parse(dateStr);
		} 
		catch (Exception e) 
		{
			LOGGER.error("Error al formatear fecha " + dateStr + " a Date" + e.getMessage() );
			return null;
		}

	}

	public static Date toDateSdf4(String dateStr) throws ParseException 
	{
		try 
		{
			SimpleDateFormat SDF_4 = new SimpleDateFormat( DATE_FORMAT_4 );
			return SDF_4.parse(dateStr);
		} catch (Exception e) {
			LOGGER.error("Error al formatear fecha " + dateStr + " a Date"
					+ e.getMessage());
			return null;
		}

	}

	/**
	 * Formatea y parsea una fecha Date a String
	 * 
	 * @param date
	 * @return String
	 */
	public static String formateaDateToStringTs(Date date) 
	{
		if (date != null) 
		{
			Calendar c = GregorianCalendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, 0);
			SimpleDateFormat SDF_2 = new SimpleDateFormat( DATE_FORMAT_2 );
			SDF_2.format(c.getTime());
			return SDF_2.format(c.getTime());
		} 
		else
			return "";
	}
	
	/**
	 * @param format
	 * @param date
	 * @return
	 */
	public static String formateaDateToString( String format,  Date date) 
	{
		if (date != null) 
		{
			SimpleDateFormat sdf = new SimpleDateFormat( format );
			Calendar c = GregorianCalendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE,0);
			sdf.format(c.getTime());
			return sdf.format(c.getTime());
		} else
			return "";
	}

	public static Date toDateFull(String dateStr) throws ParseException 
	{
		try 
		{
			SimpleDateFormat SDF_5 = new SimpleDateFormat( DATE_FORMAT_5 );
			return SDF_5.parse(dateStr);
		} catch (Exception e) {
			LOGGER.error("Error al formatear fecha " + dateStr + " a Date"
					+ e.getMessage());
			return null;
		}

	}

	public static String obtenerDiaTexto(int in) {
//		int dia = 0;

		try {

			
//			Calendar c = Calendar.getInstance();
//			
//			dia = c.get(Calendar.DAY_OF_WEEK);

			switch (in) {
			case 1:
				return "DOMINGO";
			case 2:
				return "LUNES";
			case 3:
				return "MARTES";
			case 4:
				return "MIERCOLES";
			case 5:
				return "JUEVES";
			case 6:
				return "VIERNES";
			case 7:
				return "SABADO";
			default:
				return "";
			}
		} catch (Exception e) {
			return "";
		}
	}
	
	
	
	
	public static boolean isToday( Date fecha )
	{
		Date fechaActual = new Date();
	    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	    int mesActual = Integer.parseInt(formato.format( fechaActual ).split("/")[1] );
	    int diaAcual = Integer.parseInt(formato.format( fechaActual ).split("/")[0] );
	    int anioAcual = Integer.parseInt(formato.format( fechaActual ).split("/")[2] );
	    
	    int mesFecha = Integer.parseInt(formato.format( fecha ).split("/")[1] );
	    int diaFecha = Integer.parseInt(formato.format( fecha ).split("/")[0] );
	    int anioFecha = Integer.parseInt(formato.format( fecha ).split("/")[2] );
	    
	    return ((mesActual == mesFecha) && ( diaAcual == diaFecha ) && (anioAcual == anioFecha ) )? true:false; 
	}
	
}
