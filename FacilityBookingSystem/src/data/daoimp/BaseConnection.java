package data.daoimp;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;


public class BaseConnection {
	protected Connection conn;
	public BaseConnection(){
		ConnecterBean cb = null;
		try {
			InputSource ins = new InputSource(this.getClass().getResourceAsStream("../../config.xml"));
			cb = SAXParseConnecter.xmlOpera(ins);
			Class.forName(cb.getDriver());
			conn = DriverManager.getConnection(cb.getDatabase(),cb.getUsername(),cb.getPassword());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void finalize() throws Throwable {
		conn.close();
		super.finalize();
	}
}

class SAXParseConnecter {
	public static ConnecterBean xmlOpera(InputSource instream){
		SAXParserFactory saxparseFac = SAXParserFactory.newInstance();
		try {
			SAXParser saxPar =saxparseFac.newSAXParser();
			XMLContentHandlerForBean xmlHandler = new XMLContentHandlerForBean();
			saxPar.parse(instream,xmlHandler);
			return xmlHandler.getConnecterBean();
		} 
		catch (Exception e) {
			return null;
		}
	}
}

class XMLContentHandlerForBean extends DefaultHandler{
		private ConnecterBean bean;
		private String preTag;
		@Override
		public void startDocument() throws SAXException {
			;
		}
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) 
				throws SAXException {
			if("ConneterBean".equals(qName)){
				bean = new ConnecterBean();
			}
			preTag = qName;
		}
		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			if(bean != null){
				if("driver".equals(preTag)) bean.setDriver(new String(ch,start,length));
				else if("database".equals(preTag)) bean.setDatabase(new String(ch,start,length));
				else if("username".equals(preTag)) bean.setUsername(new String(ch,start,length));
				else if("password".equals(preTag)) bean.setPassword(new String(ch,start,length));
			}
		}
		@Override
		public void endElement(String uri, String localName, String qName)throws SAXException {
			preTag = null;
		}	
		public ConnecterBean getConnecterBean(){
			return bean;
		}		
}

class ConnecterBean {
	private String driver;
	private String username;
	private String password;
	private String database;
	public ConnecterBean(){
		this.driver = "";
		this.username = "";
		this.password = "";
		this.database = "";
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	
}
