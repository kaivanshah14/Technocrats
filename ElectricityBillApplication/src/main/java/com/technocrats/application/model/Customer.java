package com.technocrats.application.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	private int customerId;
	private String customerName;
	private String customerAreaCode;
	private String customerType;
	
//    @OneToMany(targetEntity = Consumption.class, cascade = CascadeType.ALL)
//    @JoinColumn(name="customerId", referencedColumnName = "customerId")
//    private List<Consumption> bill;
	
	public Customer() {
		super();
	}
//	public List<Consumption> getBill() {
//		return bill;
//	}
//	public void setBill(List<Consumption> bill) {
//		this.bill = bill;
//	}
	public Customer(int customerId, String customerName, String customerAreaCode, String customerType) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAreaCode = customerAreaCode;
		this.customerType = customerType;
	}
	public int getCustomerId() {
		return customerId;
	}
	@Override
	public boolean equals(Object obj) {
		Customer c = (Customer) obj;
		return this.customerId == c.customerId;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAreaCode="
				+ customerAreaCode + ", customerType=" + customerType + "]";
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getCustomerAreaCode() {
		return customerAreaCode;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setCustomerAreaCode(String customerAreaCode) {
		this.customerAreaCode = customerAreaCode;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
}
