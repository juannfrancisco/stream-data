package cl.magno.concentrador.model.schedule;

import java.io.Serializable;

/**
 * 
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 30-06-2016 11:15:00
 */
public abstract class Planificacion implements Serializable 
{
	private static final long serialVersionUID = -918438166801983214L;
	private int oid;
	private String name;
	private String description;
	private String schedule;

	private String fechaInicio;
	private String horaInicio;
	private String intervaloEjecucion;
	private String fechaTermino;
	private int diaEjecucion;
	private String diaEjecucionTexto; 
	private boolean indefinida;
	private boolean cantVeces;
	private boolean ejecucionInmediata;
	
	
	
}
