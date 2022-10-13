package com.technocrats.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.technocrats.exceptions.CustomerException;
import com.technocrats.model.Customer;

class CustomerTest {

	Customer c = new Customer();
	
	@Test
	@DisplayName("Test case for Customer ID")
	void getCustomerId() {
		c.setCustomerId(1);
		assertEquals(1, c.getCustomerId());
	}
	
	@Test
	@DisplayName("Test case for Customer Name")
	void getCustomerNameTest() {
		c.setCustomerName("Ram");
		assertEquals("Ram", c.getCustomerName());
	}
	
	@Test
	@DisplayName("Test case for Customer Area Code")
	void getCustomerAreaCodeTest() {
		c.setCustomerAreaCode("A1");
		assertEquals("A1", c.getCustomerAreaCode());
	}
	
	@Test
	@DisplayName("Test case for number of units consumed")
	void getNumberofUnitsConsumedTest() {
		c.setNumberofUnitsConsumed(100);
		assertEquals(100, c.getNumberofUnitsConsumed());
	}
	
	@Test
	@DisplayName("Test case for Total bill")
	void getTotalBillTest() throws CustomerException {
		final double DELTA2 = 1e-15;
		c.setNumberofUnitsConsumed(100);
		assertEquals(50, c.getTotalBill(),DELTA2);
	}
	
	@Test
	@DisplayName("Test case for toString() method")
	void toStringTest() {
		Customer c2 = new Customer(1,"Ram","A1",100);
		String s ="Customer [customerId=1, customerName=Ram, customerAreaCode=A1, numberofUnitsConsumed=100]";
		assertEquals(s,c2.toString());
	}
	
	@Test
	@DisplayName("Test case for Equals method")
	void equalsTest() {
		Customer c3 = new Customer(1,"Ram","A1",100);
		Customer c2 = new Customer(1,"Ram","A1",100);
		assertTrue(c3.equals(c2));
	}

}
