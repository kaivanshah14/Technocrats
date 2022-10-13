package com.technocrats.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class SQLConnector {
	public static Connection getConnection() throws Exception {
		Properties p = new Properties();
		p.setProperty("url", "jdbc:mysql://localhost:3306/eba");
		p.setProperty("user", "root");
		p.setProperty("password", "root");
		Connection con = DriverManager.getConnection(p.get("url").toString(), p);
		System.out.println("Connection Established");
		return con;
	}
}

