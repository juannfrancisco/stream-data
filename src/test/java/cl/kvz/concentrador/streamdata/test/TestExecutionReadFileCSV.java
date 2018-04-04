/**
 * Kuvasz Solutions - Equipo de Consultoria
 * Santiago de Chile, Merced 838 Piso 15 oficina 153
 * http://www.kvz.cl
 */
package cl.kvz.concentrador.streamdata.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import cl.magno.concentrador.model.Muestreador;
import cl.magno.concentrador.model.execution.extract.ExecutionReadFileCSV;
import cl.magno.concentrador.model.execution.sender.ExecutionWriteFileCSV;
import cl.magno.concentrador.model.mapping.Columna;
import cl.magno.concentrador.model.mapping.Mapeo;
import cl.magno.concentrador.model.mapping.MapeoColumna;
import cl.magno.concentrador.model.mapping.Objeto;
import cl.magno.concentrador.streamdata.core.phase.extract.ExtractPhase;
import cl.magno.concentrador.streamdata.core.service.ServiceLocator;
import cl.magno.concentrador.streamdata.core.util.AppConfig;
import cl.magno.stream.core.model.datasource.DataSourceDirectory;
import cl.magno.stream.core.model.flow.Flow;
import cl.magno.stream.exceptions.FlowException;
import cl.magno.stream.utils.Constants;

/**
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 30-06-2016 15:36:03
 */
public class TestExecutionReadFileCSV extends TestCase {
	
	
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public TestExecutionReadFileCSV(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(TestExecutionReadFileCSV.class);
	}
	
	
	
	public void testReadFile() throws FlowException{
		
		AppConfig conf = (AppConfig)ServiceLocator.getInstance().getBean(Constants.BEAN_CONFIG);
		DataSourceDirectory dsIn = new DataSourceDirectory("0", "", "", "/Users/jmaldonado/archivos/");

		List<Columna> cols = new ArrayList<Columna>();
		cols.add(new Columna(1, "Nombre"));
		cols.add(new Columna(2, "Rubro"));
		
		Objeto objectIn = new Objeto(0, "", "", cols);
		Objeto objectOut = new Objeto(0, "", "", cols);
		
		List<MapeoColumna> mapingFields = new ArrayList<MapeoColumna>();
		mapingFields.add(new MapeoColumna(0, cols.get(0), cols.get(0), "$Columna + \"- Hola\"", 1));
		mapingFields.add(new MapeoColumna(0, cols.get(1), cols.get(1), "", 2));
		
		Mapeo mapeo = new Mapeo();
		mapeo.setObjetoEntrada(objectIn);
		mapeo.setObjetoSalida(objectOut);
		mapeo.setMapeoColumnas(mapingFields);
		
		ExecutionReadFileCSV readFile = new ExecutionReadFileCSV();
		readFile.setDatasource(dsIn);
		readFile.setNameFile("9801.csv");
		readFile.setDelimiter(';');
		
		ExecutionWriteFileCSV writeFile = new ExecutionWriteFileCSV();
		writeFile.setDatasource(dsIn);
		writeFile.setNameFile("9801-w.csv");
		writeFile.setDelimiter(';');
		writeFile.setWriteHeader(true);
		
		Muestreador muestreador = new Muestreador();
		muestreador.setMapeo(mapeo);
		muestreador.setEjecucionEntrada( readFile );
		muestreador.setEjecucionSalida( writeFile );
		
		Flow flujo = new Flow();
		flujo.setUuidExecution( UUID.randomUUID().toString() );
		flujo.setMuestreador(muestreador);
		
		ExecutorService exc = Executors.newFixedThreadPool(1);
		ExtractPhase extract = new ExtractPhase(flujo, 4 );
		exc.execute(extract);
		exc.shutdown();
			
		
	}

}
