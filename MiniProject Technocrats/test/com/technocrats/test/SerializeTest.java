package com.technocrats.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Executable;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import com.technocrats.model.Customer;
import com.technocrats.service.Serialize;

import org.junit.Assert;
//import org.junit.Test;



class SerializeTest {

	@Test
	@DisplayName("Test case for Serialization")
	void serializeTest() throws IOException, ClassNotFoundException {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Customer c1 = new Customer(1, "Kajal", "A1", 85);
		Customer c2 = new Customer(2, "Gauri", "A2", 160);
		customerList.add(c1);
		customerList.add(c2);
		Serialize s = new Serialize();
		Serialize.serialize(customerList);

//		assertDoesNotThrow(Serialize.serialize(customerList), "Customer List got serialized successfully");
		assertEquals(customerList, Serialize.deserialize());
	}
	
	@Test
	@DisplayName("Test case for Serialization of Lists")
	void serializeTest2() throws IOException, ClassNotFoundException {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		ArrayList<Customer> customerList2 = new ArrayList<Customer>(customerList);
		Customer c1 = new Customer(1, "Kajal", "A1", 85);
		Customer c2 = new Customer(2, "Gauri", "A2", 160);
		customerList.add(c1);
		customerList.add(c2);
//		Serialize s = new Serialize();
		
		Serialize.serialize(customerList);
		customerList2 = (ArrayList<Customer>) Serialize.deserialize();
//		assertDoesNotThrow(Serialize.serialize(customerList), "Customer List got serialized successfully");
		assertEquals(customerList, customerList2);
	}

}
