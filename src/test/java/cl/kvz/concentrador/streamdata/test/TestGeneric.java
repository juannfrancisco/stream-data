/**
 * 
 */
package cl.kvz.concentrador.streamdata.test;

import cl.magno.concentrador.streamdata.core.service.ServiceLocator;
import cl.magno.stream.core.model.datasource.DataSourceDirectory;
import cl.magno.stream.dao.GenericDAO;

/**
 * @author jmaldonado
 *
 */
public class TestGeneric {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenericDAO<DataSourceDirectory> dao = (GenericDAO<DataSourceDirectory>) ServiceLocator.getInstance().getBean("generic");
		System.out.println( dao.getAll(new DataSourceDirectory() ).size() );

	}

}
