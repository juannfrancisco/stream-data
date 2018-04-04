/**
 * Magno Labs - Desarrollo de Software 2016 
 * Santiago de Chile, Merced 838 Piso 15 oficina 153
 * http://www.magno.cl
 */
package cl.magno.stream.core.model.datasource;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Magno Labs - 2016
 * @author Juan Francisco Maldonado León - juan.maldonado.leon@gmail.com
 *
 */
@Document(collection = "datasources")
public abstract class DataSourceObject implements Serializable {

	private static final long serialVersionUID = -1338728312185789080L;
	@Id
	private String oid;
	private String name;
	private String description;
	
	
	/**
	 * 
	 */
	public DataSourceObject(){
		this.oid = "";
		this.name = null;
		this.description = null;
	}
	
	
	
	/**
	 * @param oid
	 * @param discriminator
	 * @param name
	 * @param description
	 */
	public DataSourceObject(String oid, String name,
			String description) {
		super();
		this.oid = oid;
		this.name = name;
		this.description = description;
	}
	/**
	 * @return the oid
	 */
	public String getOid() {
		return oid;
	}
	/**
	 * @param oid the oid to set
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}