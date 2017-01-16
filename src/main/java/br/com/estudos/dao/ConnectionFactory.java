package br.com.estudos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import br.com.estudos.utils.Propriedades;

public class ConnectionFactory {

	public static Connection getConnection() throws Exception {
		
		Properties prop = Propriedades.getProp();
		String driver = prop.getProperty("banco.driver");
		String url = prop.getProperty("banco.host");
		String user = prop.getProperty("banco.user");
		String passwd = prop.getProperty("banco.password");
		
		Class.forName(driver);
		
		Connection result = DriverManager.getConnection(url,user,passwd);
		
		return result;
	}
	
}
