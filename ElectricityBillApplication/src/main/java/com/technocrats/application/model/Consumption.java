package com.technocrats.application.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Consumption {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billId;
	private int numberofUnitsConsumed;
	private double totalBill;
	private LocalDateTime month;

	public Consumption() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		Consumption c = (Consumption) obj;
		return this.billId == c.billId;
	}

	@Override
	public String toString() {
		return "Consumption [billId=" + billId + ", numberofUnitsConsumed=" + numberofUnitsConsumed + ", totalBill="
				+ totalBill + ", month=" + month + "]";
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

	public LocalDateTime getMonth() {
		return month;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public void setNumberofUnitsConsumed(int numberofUnitsConsumed) {
		this.numberofUnitsConsumed = numberofUnitsConsumed;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public void setMonth(LocalDateTime month) {
		this.month = month;
	}

	public Consumption(int billId, int numberofUnitsConsumed, double totalBill, LocalDateTime month) {
		super();
		this.billId = billId;
		this.numberofUnitsConsumed = numberofUnitsConsumed;
		this.totalBill = totalBill;
		this.month = month;
	}
}
