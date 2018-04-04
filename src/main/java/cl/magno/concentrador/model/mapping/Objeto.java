package cl.magno.concentrador.model.mapping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 30-06-2016 10:47:48
 */
public class Objeto implements Serializable 
{
	private static final long serialVersionUID = -8129530196907461773L;
	private int oid;
	private String nombre;
	private String descripcion;
	private List<Columna> columnas;
	
	/**
	 * 
	 */
	public Objeto()
	{
		this.nombre = "" ;
		this.descripcion = "" ;
		this.columnas = new ArrayList<Columna>();
	}
	
	
	
	
	

	/**
	 * @param oid
	 * @param nombre
	 * @param descripcion
	 * @param columnas
	 */
	public Objeto(int oid, String nombre, String descripcion,
			List<Columna> columnas) {
		this.oid = oid;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.columnas = columnas;
	}






	public int getOid() 
	{
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Columna> getColumnas() {
		return columnas;
	}

	public void setColumnas(List<Columna> columnas) {
		this.columnas = columnas;
	}

}
