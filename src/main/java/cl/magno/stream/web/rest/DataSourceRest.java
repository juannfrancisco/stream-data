/**
 * 
 */
package cl.magno.stream.web.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cl.magno.stream.core.model.datasource.DataSourceObject;

/**
 * @author jmaldonado
 *
 */
@Path( "datasources" )
public class DataSourceRest {

	
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public List<DataSourceObject> listAll(){
		//return DataSingleton.getInstance().getMatches();
		//return getFacade().getAll();
		return null;
	}
	
}
