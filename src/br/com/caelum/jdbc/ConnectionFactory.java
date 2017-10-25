package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	public Connection getconnection() {
		
		Properties properties = new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "root");
		properties.setProperty("useSSL", "false");
		properties.setProperty("autoReconnect", "true");
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/fj21", properties);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
