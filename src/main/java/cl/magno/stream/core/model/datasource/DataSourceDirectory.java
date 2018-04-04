/**
 * Magno Labs - Desarrollo de Software 2016 
 * Santiago de Chile, Merced 838 Piso 15 oficina 153
 * http://www.magno.cl
 */
package cl.magno.stream.core.model.datasource;

/**
 * 
 * @author Juan Francisco Maldonado León
 * @since 30-06-2016 11:38:26
 */
public class DataSourceDirectory extends DataSourceObject
{
	private static final long serialVersionUID = 2061942138570892215L;
	private String path;
	
	/**
	 * 
	 */
	public DataSourceDirectory(){
		this.path = null;
	}
	
	/**
	 * @param oid
	 * @param discriminator
	 * @param name
	 * @param description
	 */
	public DataSourceDirectory(String oid, String name,
			String description, String path) {
		super(oid, name, description);
		this.path = path;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
}