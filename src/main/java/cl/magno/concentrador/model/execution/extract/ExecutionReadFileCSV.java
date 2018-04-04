/**
 * Kuvasz Solutions - Equipo de Consultoria
 * Santiago de Chile, Merced 838 Piso 15 oficina 153
 * http://www.kvz.cl
 */
package cl.magno.concentrador.model.execution.extract;

import gnu.trove.map.hash.THashMap;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import cl.magno.concentrador.model.execution.CallbackExecution;
import cl.magno.concentrador.model.execution.ExecutionInput;
import cl.magno.concentrador.model.mapping.Columna;
import cl.magno.stream.core.model.datasource.DataSourceDirectory;
import cl.magno.stream.core.model.flow.Flow;
import cl.magno.stream.exceptions.FlowException;
import cl.magno.stream.utils.Constants;

import com.csvreader.CsvReader;
import com.google.gson.Gson;

/**
 * El archivo CSV debe poseer una cabecera.
 * 
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 30-06-2016 12:54:51
 */
public class ExecutionReadFileCSV extends ExecutionInput {
	
	private static final long serialVersionUID = -6804137894831148383L;
	private static final Logger LOGGER = Logger.getLogger(ExecutionReadFileCSV .class);
	private String nameFile;
	private char delimiter;
	private DataSourceDirectory datasource;

	
	/**
	 * 
	 */
	public ExecutionReadFileCSV() {
		System.out.println("...");
		this.nameFile = null;
		this.delimiter =';';
	}
	
	
	
	@Override
	public void extract(Flow flujo, CallbackExecution callback)
			throws FlowException {
		
		try {
			Gson gs = new Gson();
			File file = new File( datasource.getPath()+ this.getNameFile() );
			CsvReader reader = new CsvReader(new FileReader(file));
			reader.setDelimiter( this.getDelimiter() );
			reader.readHeaders();
			reader.setHeaders(reader.getHeaders());
//			String flow = gs.toJson(flujo);
			
			while (reader.readRecord() ) {
				Map<String, Object> datos = new THashMap<String, Object>();
				for( Columna columna : flujo.getMuestreador().getMapeo().getObjetoEntrada().getColumnas() ){ 
					datos.put( columna.getNombre()  , reader.get( columna.getNombre()  ) );
				} 
				Map<String, String> reg = new HashMap<String, String>();
				reg.put(Constants.PROP_TARGET, gs.toJson(datos));
//				reg.put("flow", flow );
				callback.onPushObject( reg );
				this.incRecordsProcessedSuccess();
			}
		} catch (Exception e) {
			LOGGER.error("", e);
			this.incRecordsProcessedError();
		}
	}

	
	/**
	 * @return the nameFile
	 */
	public String getNameFile() {
		return nameFile;
	}

	/**
	 * @param nameFile the nameFile to set
	 */
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}


	/**
	 * @return the datasource
	 */
	public DataSourceDirectory getDatasource() {
		return datasource;
	}


	/**
	 * @param datasource the datasource to set
	 */
	public void setDatasource(DataSourceDirectory datasource) {
		this.datasource = datasource;
	}


	/**
	 * @return the delimiter
	 */
	public char getDelimiter() {
		return delimiter;
	}


	/**
	 * @param delimiter the delimiter to set
	 */
	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + 
				"\n ARCHIVO : " + this.getNameFile();
	}
}