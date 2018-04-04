package cl.magno.concentrador.model.mapping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Mapeo implements Serializable 
{
	private static final long serialVersionUID = 9026231359495014228L;
	private int oId;
	private String nombre;
	private String descripcion;
	private Objeto objetoEntrada;
	private Objeto objetoSalida;
	private List<MapeoColumna>mapeoColumnas;
	private boolean mensajeMotor;
	
	/**
	 * 
	 */
	public Mapeo()
	{
		this.nombre = "";
		this.descripcion = "" ;
		this.objetoEntrada = new Objeto();
		this.objetoSalida = new Objeto();
		this.mapeoColumnas = new ArrayList<MapeoColumna>();
		this.mensajeMotor = false ;
	}
	
	/**
	 * @param oId
	 * @param nombre
	 * @param descripcion
	 * @param objetoEntrada
	 * @param objetoSalida
	 * @param mapeoColumnas
	 * @param mensajeMotor
	 */
	public Mapeo(int oId, String nombre, String descripcion,	Objeto objetoEntrada, Objeto objetoSalida,List<MapeoColumna> mapeoColumnas, boolean mensajeMotor) 
	{
		super();
		this.oId = oId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.objetoEntrada = objetoEntrada;
		this.objetoSalida = objetoSalida;
		this.mapeoColumnas = mapeoColumnas;
		this.mensajeMotor = mensajeMotor;
	}





	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
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

	public Objeto getObjetoEntrada() {
		return objetoEntrada;
	}

	public void setObjetoEntrada(Objeto objetoEntrada) {
		this.objetoEntrada = objetoEntrada;
	}

	public Objeto getObjetoSalida() {
		return objetoSalida;
	}

	public void setObjetoSalida(Objeto objetoSalida) {
		this.objetoSalida = objetoSalida;
	}

	public List<MapeoColumna> getMapeoColumnas() {
		return mapeoColumnas;
	}

	public void setMapeoColumnas(List<MapeoColumna> mapeoColumnas) {
		this.mapeoColumnas = mapeoColumnas;
	}

	/**
	 * @return the mensajeMotor
	 */
	public boolean isMensajeMotor() {
		return mensajeMotor;
	}

	/**
	 * @param mensajeMotor the mensajeMotor to set
	 */
	public void setMensajeMotor(boolean mensajeMotor) {
		this.mensajeMotor = mensajeMotor;
	}

}
