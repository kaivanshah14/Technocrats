package com.technocrats.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLConnector {
	public static Connection getConnection() {
		Properties p = new Properties();
		p.setProperty("url", "jdbc:mysql://localhost:3306/eba");
		p.setProperty("user", "root");
		p.setProperty("password", "root");
		Connection con=null;
		try {
			con = DriverManager.getConnection(p.get("url").toString(), p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection Established");
		return con;
	}
}

