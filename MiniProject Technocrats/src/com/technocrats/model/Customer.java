package com.technocrats.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.technocrats.exceptions.CustomerException;
import com.technocrats.service.CustomerService;

@SuppressWarnings("serial")
public class Customer implements Serializable {
	private int customerId;
	private String customerName;
	private String customerAreaCode;
	private int numberofUnitsConsumed;
	private double totalBill;
	private String customerType;
	private LocalDate month;

	public String getCustomerType() {
		return customerType;
	}

	public LocalDate getMonth() {
		return month;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public void setMonth(LocalDate month) {
		this.month = month;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAreaCode() {
		return customerAreaCode;
	}

	public void setCustomerAreaCode(String customerAreaCode) {
		this.customerAreaCode = customerAreaCode;
	}

	public int getNumberofUnitsConsumed() {
		return numberofUnitsConsumed;
	}

	public void setNumberofUnitsConsumed(int numberofUnitsConsumed) {
		this.numberofUnitsConsumed = numberofUnitsConsumed;
	}

	public double getTotalBill() throws CustomerException {
		CustomerService c = new CustomerService();
		totalBill = c.calculateTotalBill(numberofUnitsConsumed);
		return totalBill;
	}

//	public void setTotalBill(double totalBill) {
//		this.totalBill = totalBill;
//	}

	public Customer() {

	}

//	public Customer(int customerId, String customerName, String customerAreaCode, int numberofUnitsConsumed) {
//		super();
//		this.customerId = customerId;
//		this.customerName = customerName;
//		this.customerAreaCode = customerAreaCode;
//		this.numberofUnitsConsumed = numberofUnitsConsumed;
//	}

	public Customer(int customerId, String customerName, String customerAreaCode, String customerType, LocalDate month,
			int numberofUnitsConsumed) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAreaCode = customerAreaCode;
		this.numberofUnitsConsumed = numberofUnitsConsumed;
		this.customerType = customerType;
		this.month = month;
	}
	
	

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAreaCode="
				+ customerAreaCode + ", numberofUnitsConsumed=" + numberofUnitsConsumed + ", customerType="
				+ customerType + ", Bill month=" + month + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Customer c = (Customer) obj;
		return c.getCustomerId() == this.getCustomerId();
	}

}
