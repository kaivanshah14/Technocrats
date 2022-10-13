package com.technocrats.service;

import java.util.ArrayList;

import com.technocrats.exceptions.CustomerException;
import com.technocrats.model.Customer;

@SuppressWarnings("serial")
public class CustomerService extends Customer {
	private double totalBill;

	public double calculateTotalBill(int numberofUnitsConsumed) throws CustomerException {
		if (numberofUnitsConsumed < 0) {
			throw new CustomerException();
		}
		else if (numberofUnitsConsumed >= 0 && numberofUnitsConsumed <= 100) {
			totalBill = numberofUnitsConsumed * 0.5;
		} else if (100 < numberofUnitsConsumed && numberofUnitsConsumed <= 150) {
			totalBill = 100 * 0.5 + (numberofUnitsConsumed - 100) * 0.75;
		} else {
			totalBill = 100 * 0.5 + 50 * 0.75 + (numberofUnitsConsumed - 150) * 1;
		}
		return totalBill;
	}

	public static ArrayList<Customer> searchByAreaCode(ArrayList<Customer> arr, String customerAreaCode) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		for (Customer c : arr) {
			if (c.getCustomerAreaCode().equals(customerAreaCode)) {
				customerList.add(c);
			}
		}
		return customerList;
	}
}
