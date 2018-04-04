package cl.magno.stream.web.servlet;

import gnu.trove.map.hash.THashMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import cl.magno.concentrador.model.Muestreador;
import cl.magno.concentrador.model.execution.extract.ExecutionReadFileCSV;
import cl.magno.concentrador.model.execution.sender.ExecutionWriteFileCSV;
import cl.magno.concentrador.model.mapping.Columna;
import cl.magno.concentrador.model.mapping.Mapeo;
import cl.magno.concentrador.model.mapping.MapeoColumna;
import cl.magno.concentrador.model.mapping.Objeto;
import cl.magno.concentrador.streamdata.core.notify.NotifyManager;
import cl.magno.concentrador.streamdata.core.notify.TYPE_NOTIFY;
import cl.magno.concentrador.streamdata.core.phase.extract.ExtractPhase;
import cl.magno.concentrador.streamdata.core.service.ServiceLocator;
import cl.magno.concentrador.streamdata.core.util.AppConfig;
import cl.magno.stream.core.model.datasource.DataSourceDirectory;
import cl.magno.stream.core.model.flow.Flow;
import cl.magno.stream.utils.Constants;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private transient static final Logger LOGGER = Logger.getLogger(TestServlet.class);

    /**
     * Default constructor. 
     */
    public TestServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		NotifyManager.sendNotification("xxx", new Flujo());
		
		
		AppConfig conf = (AppConfig)ServiceLocator.getInstance().getBean(Constants.BEAN_CONFIG);
		int maxThread = Integer.parseInt( conf.getData().get("asyncMaxThreadsMapping") );
//		
		DataSourceDirectory dsIn = new DataSourceDirectory("DIRECTORY", "", "", "/Users/jmaldonado/archivos/");
//
		List<Columna> cols = new ArrayList<Columna>();
		cols.add(new Columna(1, "Nombre"));
		cols.add(new Columna(2, "Rubro"));
		
		Objeto objectIn = new Objeto(0, "", "", cols);
		Objeto objectOut = new Objeto(0, "", "", cols);
//		
//		
		List<MapeoColumna> mapingFields = new ArrayList<MapeoColumna>();
		mapingFields.add(new MapeoColumna(0, cols.get(0), cols.get(0), "$Columna + \"- Hola\"", 1));
		mapingFields.add(new MapeoColumna(0, cols.get(1), cols.get(1), "", 2));
//		
//		
		Mapeo mapeo = new Mapeo();
		mapeo.setObjetoEntrada(objectIn);
		mapeo.setObjetoSalida(objectOut);
		mapeo.setMapeoColumnas(mapingFields);
//		
//		
		ExecutionReadFileCSV readFile = new ExecutionReadFileCSV();
		readFile.setDatasource(dsIn);
		readFile.setNameFile("9801.csv");
		readFile.setDelimiter(';');
//		
		ExecutionWriteFileCSV writeFile = new ExecutionWriteFileCSV();
		writeFile.setDatasource(dsIn);
		writeFile.setNameFile("9801-w.csv");
		writeFile.setDelimiter(';');
		writeFile.setWriteHeader(true);
//		
//		
//		
		Muestreador muestreador = new Muestreador();
		muestreador.setMapeo(mapeo);
		muestreador.setEjecucionEntrada( readFile );
		muestreador.setEjecucionSalida( writeFile );
//		
//		
		Flow flujo = new Flow();
		flujo.setUuidExecution( UUID.randomUUID().toString() );
		flujo.setMuestreador(muestreador);
//		
//		
		ExecutorService exc = Executors.newFixedThreadPool(1);
		ExtractPhase extract = new ExtractPhase(flujo, 4);
		extract.setMaxThread(maxThread);
		exc.execute(extract);
		exc.shutdown();
		
		
		Gson gson = new Gson();
		
		Map<String, Object> data = new THashMap<String, Object>();
		data.put(Constants.NOTIFY_COMMAND, gson.toJson(flujo) );
		data.put(Constants.NOTIFY_DATA_FLOW, gson.toJson(flujo) );
		
		NotifyManager.sendNotification(TYPE_NOTIFY.START_MAPPING, data );
		
		
//		
//		
//		
//		ExecutorService ex = Executors.newFixedThreadPool(1);
//		MappingStage mapping = new MappingStage(flujo);
//		mapping.setnThreadsMapping(maxThread);
//		ex.execute(mapping);
//		ex.shutdown();
//		
//		
//		ExecutorService exSender = Executors.newFixedThreadPool(1);
//		SenderStage sender = new SenderStage();
//		sender.setnThreadsMapping(maxThread);
//		sender.setFlujo(flujo);
//		exSender.execute(sender);
//		exSender.shutdown();
		
		
	}

}
