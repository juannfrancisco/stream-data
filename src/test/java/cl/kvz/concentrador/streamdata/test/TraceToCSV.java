/**
 * 
 */
package cl.kvz.concentrador.streamdata.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author jmaldonado
 *
 */
public class TraceToCSV {
	
	
	/**
	 * 
	 * @param args
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		File fXmlFile = new File("/Users/jmaldonado/Desarrollo/clientes/bancofalabella/simuladores/ciclo2/monitor_fraude_2.xml");
//		File fXmlFile = new File("/Users/jmaldonado/trace_con_concentrador_01.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		
		NodeList nList = doc.getElementsByTagName("Events");
		
		FileWriter fileWriter = new FileWriter("/Users/jmaldonado/Desarrollo/clientes/bancofalabella/simuladores/ciclo2/trace.csv", false);
//		FileWriter fileWriter = new FileWriter("/Users/jmaldonado/trace_con_concentrador_01.csv", false);
		
		fileWriter.append("id;name;LoginName;ApplicationName;ClientProcessID;SPID;TextData;TextData1;Duration;CPU;Reads;Writes;StartTime;EndTime;\n");

		System.out.println("----------------------------");

			
		Node nNode = nList.item(0);
		NodeList nEvents  = nNode.getChildNodes();
		for (int i = 0; i < nEvents.getLength(); i++) {
			StringBuilder line = new StringBuilder();
			Node n = nEvents.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element event = (Element) n;
				line.append( event.getAttribute("id") + ";");
				line.append( event.getAttribute("name")+ ";");
				
				NodeList columns  = n.getChildNodes();
				Test obj = new Test();
				for (int ix = 0; ix < columns.getLength(); ix++) {
					Node nColumn = columns.item(ix);
					if( null != nColumn.getAttributes()  ){
						String attr = nColumn.getAttributes().getNamedItem("name").getNodeValue();
						
						if( attr.equals("LoginName") )
							obj.setLoginName( nColumn.getTextContent() );
						
						if( attr.equals("StartTime") )
							obj.setStartTime( nColumn.getTextContent() );
						
						if( attr.equals("EndTime") )
							obj.setEndTime( nColumn.getTextContent() );
						
						if( attr.equals("ApplicationName") )
							obj.setApplicationName( nColumn.getTextContent() );
						
						if( attr.equals("SPID") )
							obj.setSPID( nColumn.getTextContent() );
						
						if( attr.equals("Reads") )
							obj.setReads( nColumn.getTextContent() );
						
						if( attr.equals("CPU") )
							obj.setCPU( nColumn.getTextContent() );
						
						if( attr.equals("ClientProcessID") )
							obj.setClientProcessID( nColumn.getTextContent() );
						
						if( attr.equals("Duration") )
							obj.setDuration( nColumn.getTextContent() );
						
						if( attr.equals("Writes") )
							obj.setWrites( nColumn.getTextContent() );
						
						if( attr.equals("ClientProcessID") )
							obj.setClientProcessID( nColumn.getTextContent() );
						
						if( attr.equals("TextData") )
							obj.setTextData( nColumn.getTextContent() );
						
					}
				}
				line.append( obj.toString() );
				
			}
			if( line.length() >0 ){
			fileWriter.write( line.toString() + "\n" );
			fileWriter.flush();
			}
		}
		fileWriter.close();
	}

}
