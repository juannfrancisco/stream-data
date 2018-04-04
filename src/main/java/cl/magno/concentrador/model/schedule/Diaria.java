package cl.magno.concentrador.model.schedule;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

/**
 * 
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 30-06-2016 11:27:50
 */
public class Diaria extends Planificacion
{
	private static final long serialVersionUID = 9056088039575568143L;
	private transient static final Logger LOGGER = Logger.getLogger(Diaria.class);
	private SimpleDateFormat fecha= new SimpleDateFormat("yyyy-MM-dd");
	

	
}
