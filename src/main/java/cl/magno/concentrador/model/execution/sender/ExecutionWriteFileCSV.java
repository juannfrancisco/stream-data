/**
 * Kuvasz Solutions - Equipo de Consultoria
 * Santiago de Chile, Merced 838 Piso 15 oficina 153
 * http://www.kvz.cl
 */
package cl.magno.concentrador.model.execution.sender;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.data.annotation.Transient;

import cl.magno.concentrador.model.execution.CallbackExecutionSender;
import cl.magno.concentrador.model.execution.ExecutionOutput;
import cl.magno.concentrador.model.mapping.Columna;
import cl.magno.stream.core.model.datasource.DataSourceDirectory;
import cl.magno.stream.core.model.flow.Flow;
import cl.magno.stream.exceptions.FlowException;

/**
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 30-06-2016 13:03:05
 */
public class ExecutionWriteFileCSV extends ExecutionOutput {

	private transient static final Logger LOGGER = Logger.getLogger(ExecutionWriteFileCSV.class);
	private static final long serialVersionUID = -1903369856253596416L;
	private String nameFile;
	private boolean writeHeader;
	private char delimiter;
	private DataSourceDirectory datasource;
	
	//---
	@Transient
	private transient FileWriter fileWriter;

	
	public ExecutionWriteFileCSV(){
		
	}
			
	
	/**
	 * @param nameFile
	 * @param datasource
	 */
	public ExecutionWriteFileCSV(String nameFile, DataSourceDirectory datasource) {
		this.nameFile = nameFile;
		this.datasource = datasource;
	}

	@Override
	public void initialize( Flow flujo) {
		try {
			LOGGER.info("Initialize Send Stage - Write FILE CSV");
			fileWriter = new FileWriter(datasource.getPath() + this.nameFile, true);
			if( writeHeader ){
				StringBuilder header = new StringBuilder();
				for( Columna col : flujo.getMuestreador().getMapeo().getObjetoSalida().getColumnas() ){
					header.append( col.getNombre() + delimiter );
				}
				fileWriter.write( header.toString()+ "\n" ); 
				fileWriter.flush();
			}
				
		} catch (IOException e) {
			LOGGER.error("Error al inicializar la ejecucion..", e);
		}
	}

	@Override
	public void sendData(Map<String, Object> data, Flow flujo,
			CallbackExecutionSender callback) throws FlowException {
		try {
			StringBuilder line = new StringBuilder();
			for( Columna col : flujo.getMuestreador().getMapeo().getObjetoSalida().getColumnas() ){
				line.append( data.get(col.getNombre()).toString() );
				line.append(delimiter);
			}
			fileWriter.write( line.toString() + "\n" );
			fileWriter.flush();
			callback.onSendSuccess();
			this.incRecordsProcessedSuccess();
			
		} catch (Exception e) {
			LOGGER.error( "error", e );
			callback.onSendError();
			this.incRecordsProcessedError();
		}
	}
	
	@Override
	public void finalize( Flow flujo ){
		try {
			LOGGER.info("Finalized Send Stage - Write FILE CSV");
			fileWriter.close();
		} catch (Exception e) {
			LOGGER.error("Error al finalizar ", e);
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
	 * @return the fileWriter
	 */
	public FileWriter getFileWriter() {
		return fileWriter;
	}

	/**
	 * @param fileWriter the fileWriter to set
	 */
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	/**
	 * @return the writeHeader
	 */
	public boolean isWriteHeader() {
		return writeHeader;
	}

	/**
	 * @param writeHeader the writeHeader to set
	 */
	public void setWriteHeader(boolean writeHeader) {
		this.writeHeader = writeHeader;
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

	
}
