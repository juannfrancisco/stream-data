/**
 * Magno Labs - Desarrollo de Software 
 * Santiago de Chile, Merced 838 Piso 15 oficina 153
 * http://www.magno.cl
 */
package cl.kvz.concentrador.streamdata.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import cl.magno.concentrador.streamdata.core.notify.NotifyManager;
import cl.magno.stream.exceptions.FlowException;

/**
 * 
 * @author Juan Francisco Maldonado León
 * @since 30-06-2016 15:36:03
 */
public class TestTopicNotification extends TestCase {
	
	
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public TestTopicNotification(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(TestTopicNotification.class);
	}
	
	
	
	public void testReadFile() throws FlowException{
		NotifyManager manager = new NotifyManager();
		manager.initialize();
	}

}
