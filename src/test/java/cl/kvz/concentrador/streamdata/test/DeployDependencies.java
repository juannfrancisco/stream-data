/**
 * Kuvasz Solutions - Equipo de Consultoria
 * Santiago de Chile, Merced 838 Piso 15 oficina 153
 * http://www.kvz.cl
 */
package cl.kvz.concentrador.streamdata.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Juan Francisco Maldonado León
 * @since 29-06-2016 19:56:17
 */
public class DeployDependencies {
	
	static String dUrl = "http://localhost:8081/repository/internal/";
	static String dRepositoryId = "archiva.internal";
//	static final String HOME_M2 = "/Users/jmaldonado/.m2/repository/"; 
	static final String DELIMITER_FILE = "/";
	
	
	
	/**
	 * Param 1 = archivo que contienen la lista de dependencias. 
	 * Param 2 = directorio que contiene las librerias.
	 * Param 3 = Nombre del Repositorio Remoto. (-DrepositoryId) 
	 * 			 *** El nombre del repositorio debe estar configurado en archivo .m2/settings.xml
	 * Param 4 = URL del Repositorio remoto. (-Durl)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		BufferedReader br = null;
		try {
			String fileDependencies = args[0];
			String dirLibs = args[1];
			dRepositoryId = null == args[2] ? dRepositoryId:args[2];
			dUrl = null ==args[3]? dUrl : args[3];
			String sCurrentLine;

			br = new BufferedReader(new FileReader( fileDependencies ));
			int numeroLinea = 0;
			
		    File file = new File("deploy_deps.sh");
		    FileWriter writer = new FileWriter(file);

			while ((sCurrentLine = br.readLine()) != null) {
				if( numeroLinea > 1 && !sCurrentLine.trim().isEmpty() )
				{
					String[] data =  sCurrentLine.split(":");
					if( data[0].trim().startsWith( "cl" ) || data[0].trim().startsWith( "net.tech" ) ) {
						String artifactId = data[1].trim();
						String groupId = data[0].trim();
						String version = data[3].trim();
						String type = data[2].trim();
//						System.out.println( executeCommand ( getCommandPOMGenerate(artifactId, groupId, version, type, dirLibs) ) );
						writer.write(getCommandPOMGenerate(artifactId, groupId, version, type, dirLibs) + "\n");
					}
				}
				numeroLinea++;
			}
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
	
	/**
	 * 
	 * @param command
	 * @return
	 */
	public static String executeCommand( final String command) {

		System.out.println( "Ejecutando commando " + command );
		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			output.append("Error al ejecutar el commando: "+ command + e.getMessage() );
		}

		return output.toString();

	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static String getCommandPOMGenerate(String artifactId, String groupId, String version, String type, String dirLibs){
		
		final String NAME_ARTIFACT = artifactId + "-" + version;
		
		StringBuilder builder = new StringBuilder();
		builder.append("mvn deploy:deploy-file");
		builder.append(" -DgroupId="+ groupId );
		builder.append(" -DartifactId="+ artifactId );
		builder.append(" -Dpackaging="+ type);
		builder.append(" -Dversion="+version);
		builder.append(" -Dfile="+ dirLibs + NAME_ARTIFACT + "." + type );
		builder.append(" -DgeneratePom=true ");
		builder.append(" -DrepositoryId="+ dRepositoryId );
		builder.append(" -Durl="+ dUrl );
		
		return builder.toString();
	}
	
	
	
	
	
//	/**
//	 * 
//	 * @return
//	 */
//	public static String getCommandPOMGenerate(String artifactId, String groupId, String version, String type, String dirLibs){
//		
//		final String NAME_ARTIFACT = artifactId + "-" + version;
//		final String FOLDER_ARTIFACT = groupId.trim().replaceAll("\\.", DELIMITER_FILE ) + DELIMITER_FILE + artifactId + DELIMITER_FILE + version + DELIMITER_FILE;
//		
//		StringBuilder builder = new StringBuilder();
//		builder.append("mvn deploy:deploy-file");
//		builder.append(" -DgroupId="+ groupId );
//		builder.append(" -DartifactId="+ artifactId );
//		builder.append(" -Dpackaging="+ type);
//		builder.append(" -Dversion="+version);
//		builder.append(" -Dfile="+ dirLibs + FOLDER_ARTIFACT + NAME_ARTIFACT + "." + type );
//		builder.append(" -DgeneratePom=true ");
//		builder.append(" -DrepositoryId="+ dRepositoryId );
//		builder.append(" -Durl="+ dUrl );
//		
//		return builder.toString();
//	}
	
	
}
