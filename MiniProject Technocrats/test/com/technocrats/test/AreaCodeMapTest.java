package com.technocrats.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.technocrats.model.Customer;
import com.technocrats.service.AreaCodeMap;

class AreaCodeMapTest {
	AreaCodeMap a = new AreaCodeMap();
	@Test
//	@Ignore
	@DisplayName("Test case for checking SAME area code")
	void TestforSameAreaCode() {
		HashMap<String, List<Customer>> mp = new HashMap<>();
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Customer c1 = new Customer(1, "Kajal", "A1", 85);
		Customer c2 = new Customer(2, "Gauri", "A2", 160);
		customerList.add(c1);
		customerList.add(c2);
		
		ArrayList<Customer> customerList2 = new ArrayList<Customer>();
		Customer c3 = new Customer(1, "Kajal", "A1", 85);
		Customer c4 = new Customer(2, "Gauri", "A2", 160);
		customerList2.add(c3);
		customerList2.add(c4);
		mp.put("A1", customerList);
		assertEquals("Test case failed", customerList2, customerList);
	}
	
	@Test
	@DisplayName("Test case for checking DIFFERENT area code")
	void TestforDifferentAreaCode() {
		HashMap<String, List<Customer>> mp = new HashMap<>();
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Customer c1 = new Customer(1, "Kajal", "A1", 85);
		Customer c2 = new Customer(2, "Gauri", "A2", 160);
		customerList.add(c1);
		customerList.add(c2);
		
		for(Customer customer:customerList) {
			ArrayList<Customer> ls = new ArrayList<Customer>();
			ls.add(customer);
			mp.put(customer.getCustomerAreaCode(), ls);
		}
		assertEquals("Test case failed", mp, a.getAreaCode(customerList));
	}

}
