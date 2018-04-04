/**
 * 
 */
package cl.magno.stream.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;

/**
 * @author Juan Francisco Maldonado León - 
 * email juan.maldonado.leon@gmail.com
 *
 */
public class GenericDAO<T> {
	
	private MongoOperations connection;
	
	
	/**
	 * @param object
	 */
	public void save( T object ){
		this.getConnection().save(object);
	}
	
	/**
	 * @param object
	 */
	public void remove( T object ){
		this.getConnection().remove(object);
	}
	
	
	/**
	 * @param object
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll( T object ){
		return (List<T>) this.getConnection().findAll( object.getClass() );
	}
	
	
	/**
	 * @param object
	 * @param oid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T findById( T object, String oid ){
		return (T) this.getConnection().findById(oid, object.getClass() );
	}
	
	
	

	/**
	 * @return the connection
	 */
	public MongoOperations getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(MongoOperations connection) {
		this.connection = connection;
	}

}
