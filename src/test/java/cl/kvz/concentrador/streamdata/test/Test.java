/**
 * 
 */
package cl.kvz.concentrador.streamdata.test;

/**
 * @author jmaldonado
 *
 */
public class Test {

	private String LoginName ="";
	private String EndTime="";
	private String ApplicationName="";
	private String SPID="";
	private String StartTime="";
	private String Reads="";
	private String CPU="";
	private String ClientProcessID="";
	private String Duration="";
	private String Writes="";
	private String TextData="";
	
	
	
	
	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return LoginName;
	}
	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return EndTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	/**
	 * @return the applicationName
	 */
	public String getApplicationName() {
		return ApplicationName;
	}
	/**
	 * @param applicationName the applicationName to set
	 */
	public void setApplicationName(String applicationName) {
		ApplicationName = applicationName;
	}
	/**
	 * @return the sPID
	 */
	public String getSPID() {
		return SPID;
	}
	/**
	 * @param sPID the sPID to set
	 */
	public void setSPID(String sPID) {
		SPID = sPID;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return StartTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	/**
	 * @return the reads
	 */
	public String getReads() {
		return Reads;
	}
	/**
	 * @param reads the reads to set
	 */
	public void setReads(String reads) {
		Reads = reads;
	}
	/**
	 * @return the cPU
	 */
	public String getCPU() {
		return CPU;
	}
	/**
	 * @param cPU the cPU to set
	 */
	public void setCPU(String cPU) {
		CPU = cPU;
	}
	/**
	 * @return the clientProcessID
	 */
	public String getClientProcessID() {
		return ClientProcessID;
	}
	/**
	 * @param clientProcessID the clientProcessID to set
	 */
	public void setClientProcessID(String clientProcessID) {
		ClientProcessID = clientProcessID;
	}
	/**
	 * @return the duration
	 */
	public String getDuration() {
		return Duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		Duration = duration;
	}
	/**
	 * @return the writes
	 */
	public String getWrites() {
		return Writes;
	}
	/**
	 * @param writes the writes to set
	 */
	public void setWrites(String writes) {
		Writes = writes;
	}
	/**
	 * @return the textData
	 */
	public String getTextData() {
		return TextData;
	}
	/**
	 * @param textData the textData to set
	 */
	public void setTextData(String textData) {
		TextData = textData;
	}
	
	@Override
	public String toString() {
		final String SPLIT = ";"; 
		
		String a = ( this.getTextData().replace("\n", "").replace("\r", "") );
		
		return  this.getLoginName() + SPLIT + 
				this.getApplicationName() + SPLIT +
				this.getClientProcessID() + SPLIT +
				this.getSPID() + SPLIT +
				a+ SPLIT +
				( a.length() > 10 ? a.substring(0, 10)+"..."+SPLIT : a + SPLIT) +
				
				this.getDuration() + SPLIT +
				this.getCPU() + SPLIT +
				this.getReads() + SPLIT +
				this.getWrites() + SPLIT +
				this.getStartTime() + SPLIT +
				this.getEndTime() + SPLIT;
	}
	
	
}
