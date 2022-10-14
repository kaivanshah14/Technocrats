package com.technocrats.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import com.technocrats.model.Customer;

public class CustomerApplication {

	public static void main(String[] args) throws Exception {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to Customer Application by Team Technocrats");
		System.out.println("----------------------------------------------------");

		System.out.print("Enter bill month: "); // 01/02/2021
		String month = sc.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		LocalDate date = LocalDate.parse(month, formatter);

		JDBCConnection.createCustomerList(customerList);

		// 3.a. List of all Customers
		JDBCConnection.listallCustomers(customerList);

		// 3.b. bill for all the customers for particular month
		JDBCConnection.listallCustomersforAMonth(customerList, date);

		// 3.c. bill for the particular customer for particular month
		JDBCConnection.billforAMonth(customerList, date);

		// 3.d. total bill generated from all the customers in the particular month
		JDBCConnection.getBillforAllCustomers(customerList, date);

		// 3.e. displayed the customer list with their bills for a month, in descending
		// order of the bill.
		JDBCConnection.displayCustomerListforAMonth(customerList, date);

		// 3.f. Admin should be able to modify the customer data.
		JDBCConnection.modifyCustomerasAdmin(customerList);

//		while(true) {
//			System.out.print("Enter 0 to add a customer and 1 to exit: ");
//			if(sc.nextInt()==0) {
//				System.out.println();
//				System.out.println("Enter customer details:");
//				System.out.println("------------");
//				System.out.print("Enter customer ID: ");
//				int customerId = sc.nextInt();
//				System.out.print("Enter customer Name: ");
//				String customerName = sc.next();
//				System.out.print("Enter customer Area Code: ");
//				String customerAreaCode = sc.next();
//				System.out.print("Enter customer Type: ");
//				String customerType = sc.next();
//				System.out.print("Enter bill month: ");
//				String month = sc.next();
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
//				LocalDate date = LocalDate.parse(month, formatter);
//				System.out.print("Enter customer Number of Units Consumed: ");
//				int numberofUnitsConsumed = sc.nextInt();
//				try {
//					if(numberofUnitsConsumed>0) {
//						System.out.println();
//						customerList.add(new Customer(customerId, customerName, customerAreaCode, customerType, date, numberofUnitsConsumed));
////						customerList.get(i).calculateTotalBill();
//						System.out.println("New customer added with following details:");
//						System.out.println(customerList.get(i));
//						System.out.print("------------");
//						i++;
//						System.out.println();
//						System.out.println();
//					}
//					else {
//						throw new CustomerException();
//					}
//				}
//				catch(Exception e) {
//					System.out.print(e);
//					System.out.println();
//					System.out.println();
//				}
//			}
//			else {
//				System.out.print("You entered '1' now exiting program");
//				break;
//			}
//		}
//		System.out.println();
//		System.out.println();
////		System.out.println("List of customers entered:");
//		if(customerList.isEmpty()) System.out.println("No customers added");
//		else {
//			Collections.sort(customerList, (c1,c2)->{
//				try {
//					return (int) (c2.getTotalBill()-c1.getTotalBill());
//				} catch (CustomerException e) {
//					e.printStackTrace();
//				}
//				return 0;
//			});
//			for(Customer customer:customerList) {
//				System.out.println(customer);
//			}
//		}
//		
//		System.out.println("-----------------------------------------");
//		System.out.println();
//		
//		System.out.println("Serializing Customer Data....");
//		try {
//			// custList1 = customerList
//			// serialize customerList
//			// deserialize customerList
//			// custList2 = customerList
//			// custList1 ! = custList2
//			Serialize.serialize(customerList);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Customer Data serialized, now attempting deserialization");
//		System.out.println("Deserializing Customer Data....");
//		try {
//			@SuppressWarnings("unchecked")
//			ArrayList<Customer> ls2 = (ArrayList<Customer>)Serialize.deserialize();
//			
//			for(Customer customer: ls2)
//				System.out.println(customer);
//		} catch (IOException | ClassNotFoundException e) {	
//			e.printStackTrace();
//		}
//		
//		System.out.println("-----------------------------------------");
//		System.out.println();
//		System.out.println("Searching Customers with Area Code A1");
//		System.out.println(CustomerService.searchByAreaCode(customerList, "A1"));
//		
//		System.out.println("-----------------------------------------");
//		System.out.println();
//		System.out.println("Customer List with Same Area Codes:");
//		 AreaCodeMap a = new AreaCodeMap();
//		HashMap<String, List<Customer>> mp = a.getAreaCode(customerList);
//		for(Entry<String, List<Customer>> entry: mp.entrySet()) {
//			System.out.println("AreaCode: "+entry.getKey()+",Customers= "+entry.getValue());
//		}

		sc.close();
	}

}
