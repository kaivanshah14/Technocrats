package com.technocrats.application;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.technocrats.model.Customer;
import com.technocrats.service.CustomerService;
import com.technocrats.service.SQLConnector;

public class JDBCConnection {
	static Connection con = SQLConnector.getConnection();

	// create a customer list from DB
	public static void createCustomerList(ArrayList<Customer> customerList) throws Exception {
		CustomerService c = new CustomerService();

		Statement s = con.createStatement();
		s.executeQuery("select billid, units_consumed from consumption");
		ResultSet rs = s.getResultSet();
		while (rs.next()) {
			int billid = rs.getInt(1);
			int units = rs.getInt(2);
			double totalBill = c.calculateTotalBill(units);
			CallableStatement cs = con.prepareCall("{call updateTotalBill(?,?)}");
			cs.setLong(1, billid);
			cs.setDouble(2, totalBill);
			cs.execute();
		}

		Statement s2 = con.createStatement();
		s2.executeQuery(
				"select id, name, customertype, areaCode, bill_month, units_consumed, totalbill from customer c inner join consumption cs on c.id = cs.customer_id");
		ResultSet rs2 = s2.getResultSet();
		while (rs2.next()) {
			Customer c2 = new Customer(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4),
					rs2.getDate(5).toLocalDate(), rs2.getInt(6), rs2.getDouble(7));
			customerList.add(c2);
		}

		System.out.println("\n------------\n");
	}

	// 3.a. List of all Customers
	public static void listallCustomers(ArrayList<Customer> customerList) throws Exception {
		System.out.println("Displaying Customer from DB");
		CallableStatement cs3 = con.prepareCall("{call allCustomerDetails()}");
		cs3.execute();
		ResultSet rs3 = cs3.getResultSet();
		while (rs3.next()) {
			System.out.println(
					rs3.getString(1) + " " + rs3.getString(2) + " " + rs3.getString(3) + " " + rs3.getString(4));
		}

		System.out.println("\n------------\n");
	}

	// 3.b. bill for all the customers for particular month
	public static void listallCustomersforAMonth(ArrayList<Customer> customerList, LocalDate date) throws Exception {
		System.out.println("List of all the Customers for the month of " + date.getMonth());
		CallableStatement cs4 = con.prepareCall("{call BillforAllforMonth(?)}");
		cs4.setString(1, date.toString());
		cs4.executeQuery();
		ResultSet rs4 = cs4.getResultSet();
		while (rs4.next()) {
			System.out.println(rs4.getString(1) + " " + rs4.getDouble(2));
		}

		System.out.println("\n------------\n");
	}

	
	// 3.c. bill for the particular customer for particular month
	public static void billforAMonth(ArrayList<Customer> customerList, LocalDate date) throws Exception {
		System.out.println("List of Customer " + customerList.get(1).getCustomerName() + " for the month of "
				+ customerList.get(1).getMonth());
		CallableStatement cs5 = con.prepareCall("{call BillWithNameAndMonth(?,?)}");
		cs5.setString(1, customerList.get(1).getCustomerName());
		cs5.setString(2, customerList.get(1).getMonth().toString());
		cs5.executeQuery();
		ResultSet rs5 = cs5.getResultSet();
		while (rs5.next()) {
			System.out.println(rs5.getString(1) + " " + rs5.getDouble(2));
		}

		System.out.println("\n------------\n");

	}
	
	// 3.d. total bill generated from all the customers in the particular month
	public static void getBillforAllCustomers(ArrayList<Customer> customerList, LocalDate date) throws Exception {
		CallableStatement cs6 = con.prepareCall("{call totalBillGenerated(?,?)}");
		cs6.setString(1, date.toString());
		cs6.registerOutParameter(2, java.sql.Types.VARCHAR);
		cs6.executeQuery();
		ResultSet rs6 = cs6.getResultSet();
		while (rs6.next()) {
			System.out.println(rs6.getDouble(1));
		}

		System.out.println("\n------------\n");
	}

	// 3.e. displayed the customer list with their bills for a month, in descending
	// order of the bill.
	public static void displayCustomerListforAMonth(ArrayList<Customer> customerList, LocalDate date) throws SQLException {
		CallableStatement cs7 = con.prepareCall("{call CustomerBillForAMonth(?)}");
		cs7.setString(1, date.toString());
		cs7.executeQuery();
		ResultSet rs7 = cs7.getResultSet();
		while (rs7.next()) {
			System.out
					.println(rs7.getInt(1) + "  " + rs7.getString(2) + "  " + rs7.getString(3) + "  " + rs7.getString(4)
							+ "  " + rs7.getDate(5).toLocalDate() + "  " + rs7.getInt(6) + "  " + rs7.getDouble(7));
		}

		System.out.println("\n------------\n");
	}

	// 3.f. Admin should be able to modify the customer data.
	public static void modifyCustomerasAdmin(ArrayList<Customer> customerList) throws Exception {
		CallableStatement cs8 = con.prepareCall("{call modify_customer(?,?,?,?)}");
		cs8.setLong(1, 7);
		cs8.setString(2, "Siddharta");
		cs8.setString(3, "domestic");
		cs8.setString(4, "A5");
		cs8.executeQuery();
		
		JDBCConnection.listallCustomers(customerList);
	}
}

