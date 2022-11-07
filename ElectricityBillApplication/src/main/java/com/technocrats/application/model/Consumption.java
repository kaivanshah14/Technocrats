package com.technocrats.application.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ForeignKey;

@Entity
public class Consumption {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billId;
	private int numberofUnitsConsumed;
	private double totalBill;
	private String month;
	@JoinColumn(name="customer.customerId")
	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Consumption() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		Consumption c = (Consumption) obj;
		return this.billId == c.billId;
	}

	public int getBillId() {
		return billId;
	}

	public int getNumberofUnitsConsumed() {
		return numberofUnitsConsumed;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public String getMonth() {
		return month;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public void setNumberofUnitsConsumed(int numberofUnitsConsumed) {
		this.numberofUnitsConsumed = numberofUnitsConsumed;
	}

	public void setTotalBill(double totalBill) throws CustomerException {
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
		this.totalBill = totalBill;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Consumption(int billId, int numberofUnitsConsumed, String month) throws CustomerException {
		super();
		this.billId = billId;
		this.numberofUnitsConsumed = numberofUnitsConsumed;
		this.setTotalBill(numberofUnitsConsumed);
		this.month = month;
	}

	@Override
	public String toString() {
		return "Consumption [billId=" + billId + ", numberofUnitsConsumed=" + numberofUnitsConsumed + ", totalBill="
				+ totalBill + ", month=" + month + "]";
	}
}
