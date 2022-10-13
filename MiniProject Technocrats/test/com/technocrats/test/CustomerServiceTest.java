package com.technocrats.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.Ignore;

//import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.technocrats.exceptions.CustomerException;
import com.technocrats.model.Customer;
import com.technocrats.service.CustomerService;

class CustomerServiceTest {
	private static final double DELTA = 1e-15;

	@Test
	@DisplayName("Test case for Calculating Total Bill")
	void calculateTotalBilltest() throws CustomerException {
		CustomerService cs = new CustomerService();
		assertEquals(0, cs.calculateTotalBill(0),DELTA);
		assertEquals(65, cs.calculateTotalBill(120),DELTA);
		assertEquals(107.5, cs.calculateTotalBill(170),DELTA);
		Exception exception = assertThrows(CustomerException.class, () -> { 
	           cs.calculateTotalBill(-1);
		});

		assertEquals("Number of units cannot be less than 0 | Entered customer details are invalid!", exception.getMessage());

	}
	
	@Test
//	@Ignore
	@DisplayName("Test for Search by Area Code")
	void searchByAreaCodeTest() {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Customer c1 = new Customer(1, "Kajal", "A1", 85);
		Customer c2 = new Customer(2, "Gauri", "A2", 160);
		customerList.add(c1);
		customerList.add(c2);
		
		ArrayList<Customer> ls = new ArrayList<Customer>();
		for(Customer customer:customerList) {
			if(customer.getCustomerAreaCode().equals("A2"))
				ls.add(customer);
		}
		
		CustomerService cs = new CustomerService();
		assertNotEquals(ls,CustomerService.searchByAreaCode(customerList, "A1"));
		assertEquals(ls,CustomerService.searchByAreaCode(customerList, "A2"));
	}

}
