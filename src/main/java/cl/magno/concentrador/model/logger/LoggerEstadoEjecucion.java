/**
 * 
 */
package cl.magno.concentrador.model.logger;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;

import cl.magno.stream.utils.TimeUtil;

/**
 * 
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 30-06-2016 11:25:35
 */
public class LoggerEstadoEjecucion implements Serializable {
	private static final long serialVersionUID = -7573789891468363921L;
	private String mensaje;
	private Date date;
	private Object object;
	@SuppressWarnings("unused")
	private String dateFormat;
	private Throwable throwable;

	/**
	 * 
	 */
	public LoggerEstadoEjecucion() {
		this.setMensaje("");
		this.setDate(new Date());
	}

	/**
	 * 
	 */
	public LoggerEstadoEjecucion(String mensaje) {
		this.setMensaje(mensaje);
		this.setDate(new Date());
	}

	/**
	 * @param mensaje
	 * @param date
	 */
	public LoggerEstadoEjecucion(String mensaje, Date date) {
		this.setMensaje(mensaje);
		this.setDate(date);
	}

	/**
	 * @param mensaje
	 * @param date
	 */
	public LoggerEstadoEjecucion(String mensaje, Date date, Throwable throwable) {
		this.setMensaje(mensaje);
		this.setDate(date);
		this.setThrowable(throwable);
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * @param object
	 *            the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * @return the dateFormat
	 */
	public String getDateFormat() {

		try {
			return TimeUtil.formatDateTime(this.getDate());
		} catch (Exception e) {
			return "";
		}

	}

	/**
	 * @param dateFormat
	 *            the dateFormat to set
	 */
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	/**
	 * @return the throwable
	 */
	public Throwable getThrowable() {
		return throwable;
	}

	/**
	 * @param throwable
	 *            the throwable to set
	 */
	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	/**
	 * @param message
	 * @return
	 */
	public static LoggerEstadoEjecucion info(String message) {
		LoggerEstadoEjecucion logger = new LoggerEstadoEjecucion(" [ > ] "
				+ message, new Date());
		return logger;
	}

	/**
	 * @param message
	 * @return
	 */
	public static LoggerEstadoEjecucion info(String message, Logger LOGGER) {
		LoggerEstadoEjecucion logger = new LoggerEstadoEjecucion(" [ > ] "
				+ message, new Date());
		LOGGER.info(message);
		return logger;
	}

	/**
	 * @param message
	 * @return
	 */
	public static LoggerEstadoEjecucion error(String message, Logger LOGGER,
			Throwable throwable) {
		LoggerEstadoEjecucion logger = new LoggerEstadoEjecucion(" [ ! ] "
				+ message + getStackTrace(throwable), new Date());
		LOGGER.error(message, throwable);
		return logger;
	}

	/**
	 * @param throwable
	 * @return
	 */
	public static String getStackTrace(Throwable throwable) {
		StringBuilder builder = new StringBuilder();
		builder.append("<div class='error-stack' >");
		builder.append(throwable.toString() + "<br/>");
		for (int i = 0; i < throwable.getStackTrace().length; i++)
			builder.append(throwable.getStackTrace()[i].toString() + "<br/>");
		builder.append("<div>");
		return builder.toString();
	}

}
