package cl.magno.concentrador.model.mapping;

import java.io.Serializable;

/**
 * 
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 30-06-2016 10:45:22
 */
public class Columna implements Serializable 
{
	private static final long serialVersionUID = -366993519173998369L;
	private int oid;
	private String nombre;

	/**
	 * 
	 */
	public Columna() 
	{
		super();
		this.setNombre("");
	}

	/**
	 * @param oid
	 * @param nombre
	 * @param activo
	 */
	public Columna(int oid, String nombre) 
	{
		super();
		this.setOid(oid) ;
		this.setNombre(nombre) ;
	}

	/**
	 * @return the oid
	 */
	public int getOid() {
		return oid;
	}

	/**
	 * @param oid the oid to set
	 */
	public void setOid(int oid) {
		this.oid = oid;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}
