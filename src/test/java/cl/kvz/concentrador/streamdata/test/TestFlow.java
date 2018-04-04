/**
 * Kuvasz Solutions - Equipo de Consultoria
 * Santiago de Chile, Merced 838 Piso 15 oficina 153
 * http://www.kvz.cl
 */
package cl.kvz.concentrador.streamdata.test;

import java.util.ArrayList;
import java.util.List;

import cl.magno.concentrador.model.Muestreador;
import cl.magno.concentrador.model.execution.extract.ExecutionReadFileCSV;
import cl.magno.concentrador.model.execution.sender.ExecutionWriteFileCSV;
import cl.magno.concentrador.model.mapping.Columna;
import cl.magno.concentrador.model.mapping.Mapeo;
import cl.magno.concentrador.model.mapping.MapeoColumna;
import cl.magno.concentrador.model.mapping.Objeto;
import cl.magno.stream.core.model.datasource.DataSourceDirectory;
import cl.magno.stream.core.model.flow.Flow;

/**
 * 
 * @author Juan Francisco Maldonado León
 * @since 30-06-2016 11:34:38
 */
public class TestFlow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DataSourceDirectory dsIn = new DataSourceDirectory("0", "", "", "/Users/jmaldonado/archivos/");

		List<Columna> cols = new ArrayList<Columna>();
		cols.add(new Columna(1, "Nombre"));
		cols.add(new Columna(2, "Rubro"));
		
		Objeto objectIn = new Objeto(0, "", "", cols);
		Objeto objectOut = new Objeto(0, "", "", cols);
		
		
		List<MapeoColumna> mapingFields = new ArrayList<MapeoColumna>();
		mapingFields.add(new MapeoColumna(0, cols.get(0), cols.get(0), "", 1));
		mapingFields.add(new MapeoColumna(0, cols.get(1), cols.get(1), "", 2));
		
		
		Mapeo mapeo = new Mapeo();
		mapeo.setObjetoEntrada(objectIn);
		mapeo.setObjetoEntrada(objectOut);
		mapeo.setMapeoColumnas(mapingFields);
		
		
		ExecutionReadFileCSV readFile = new ExecutionReadFileCSV();
		readFile.setDatasource(dsIn);
		readFile.setNameFile("9801.csv");
		
		ExecutionWriteFileCSV writeFile = new ExecutionWriteFileCSV();
		writeFile.setDatasource(dsIn);
		writeFile.setNameFile("9801-w.csv");
		
		
		Muestreador muestreador = new Muestreador();
		muestreador.setMapeo(mapeo);
		muestreador.setEjecucionEntrada( readFile );
		muestreador.setEjecucionSalida( writeFile );
		
		
		Flow flujo = new Flow();
		flujo.setMuestreador(muestreador);
		
	}

}
