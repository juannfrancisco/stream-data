package cl.magno.concentrador.model.mapping;

import java.io.Serializable;

/**
 * 
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 30-06-2016 10:46:22
 */
public class MapeoColumna implements Serializable 
{
	private static final long serialVersionUID = 1586213629287455334L;
	private int oid;
	private Columna columnaEntrada;
	private Columna columnaSalida;
	private String ognl;
	private int indice;

	/**
	 * 
	 */
	public MapeoColumna() 
	{
		super();
		this.oid=1;
		this.columnaEntrada = new Columna();
		this.columnaSalida = new Columna();
		this.ognl = "" ;
		this.indice = 1 ;
	}

	/**
	 * @param oid
	 * @param columnaEntrada
	 * @param columnaSalida
	 * @param ognl
	 * @param indice
	 * @param activo
	 */
	public MapeoColumna(int oid, Columna columnaEntrada, Columna columnaSalida, String ognl, int indice) 
	{
		super();
		this.oid = oid;
		this.columnaEntrada = columnaEntrada;
		this.columnaSalida = columnaSalida;
		this.ognl = ognl;
		this.indice = indice;
	}

	/**
	 * @return
	 */
	public int getOid() 
	{
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Columna getColumnaEntrada() {
		return columnaEntrada;
	}

	public void setColumnaEntrada(Columna columnaEntrada) {
		this.columnaEntrada = columnaEntrada;
	}

	public Columna getColumnaSalida() {
		return columnaSalida;
	}

	public void setColumnaSalida(Columna columnaSalida) {
		this.columnaSalida = columnaSalida;
	}

	public String getOgnl() {
		return ognl;
	}

	public void setOgnl(String ognl) {
		this.ognl = ognl;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

}
