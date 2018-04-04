/**
 * 
 */
package cl.magno.concentrador.streamdata.core.app;

import cl.magno.concentrador.streamdata.core.jms.QueueReceiver;

/**
 * @author Juan Francisco Maldonado León - juan.maldonado.leon@gmail.com
 *
 */
public class Application {
	
	public static Application _instance = null;
	private String id;
	private String info;
	private String ip;
	private QueueReceiver notifyQueue;
	
	
	
	/**
	 * 
	 */
	private Application(){
		
	}	
	
	
	/**
	 * 
	 * @return
	 */
	public static Application getInstance(){
		if( null == _instance  ){
			_instance = new Application();
			
		}
		return _instance;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}


	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}


	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	

	/**
	 * @return the notifyQueue
	 */
	public QueueReceiver getNotifyQueue() {
		return notifyQueue;
	}


	/**
	 * @param notifyQueue the notifyQueue to set
	 */
	public void setNotifyQueue(QueueReceiver notifyQueue) {
		this.notifyQueue = notifyQueue;
	}


	@Override
	public String toString() {
		
		return  "\n ------------------------------------------ "+
				"\n | Aplication Info  "+
				"\n ------------------------------------------ "+
				"\n Id : "+ this.getId() + 
				"\n IP : "+ this.getIp() +
				"\n Info : "+ this.getInfo()+
				"\n -------------------------------------- ";
	}
	
	

}
