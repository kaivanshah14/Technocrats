package com.technocrats.application;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.technocrats.model.Customer;
import com.technocrats.service.SQLConnector;

public class JDBCConnection {
	public static void jdbcCon(ArrayList<Customer> customerList) throws Exception {
		Connection con = SQLConnector.getConnection();

		CallableStatement cs = con.prepareCall("{call insertCustomerData(?,?,?,?)}");
		// Insert into table Customer
		for (Customer c : customerList) {
			cs.setLong(1, c.getCustomerId());
			cs.setString(2, c.getCustomerName());
			cs.setString(3, c.getCustomerType());
			cs.setString(4, c.getCustomerAreaCode());
			cs.addBatch();
		}
		cs.executeBatch();

		System.out.println("Displaying Customer from DB");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from customer");
		while (rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
		}
	}
}
