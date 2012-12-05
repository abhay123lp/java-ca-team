package dao.sql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ConnectionToolKit {
	public static Connection getConnection(String file) 
			throws SQLException,FileNotFoundException,ClassNotFoundException{
		Connection connection;
		ConnecterBean cb;
		//Drivers
		try {
			File configFile = new File(file);
			InputSource ins = new InputSource(new FileInputStream(configFile));
			cb = SAXParseConnecter.xmlOpera(ins);
			Class.forName(cb.getDriver());
			connection = DriverManager.getConnection(cb.getDatabase(),cb.getUsername(),cb.getPassword());
		} 
		catch (SQLException e) {
			throw e;
		}
		catch (FileNotFoundException e){
			throw e;
		}
		catch (ClassNotFoundException e){
			throw e;
		}
		return connection;
	}
}

//Tool class for get the bean from file
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