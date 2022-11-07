package com.technocrats.application.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.technocrats.application.exception.ResourceNotFoundException;
import com.technocrats.application.model.Consumption;
import com.technocrats.application.model.Customer;
import com.technocrats.application.model.CustomerException;
import com.technocrats.application.repository.ConsumptionRepository;
import com.technocrats.application.repository.CustomerRepository;

@Service
public class ConsumptionService {

	@Autowired
	private ConsumptionRepository consumptionRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	public List<Consumption> getAllBills(@RequestParam(required=false) Optional<String> month) {
		if(month.isPresent())
			return consumptionRepository.findbyMonth(month);
		else return consumptionRepository.findAll();
	}

	public ResponseEntity<Consumption> getBillbyId(int id) {
		Consumption c = consumptionRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Bill not exist with id :" + id));
		return ResponseEntity.ok(c);
	}

	public Consumption addBill(Consumption consumption) throws CustomerException {
		consumption.setTotalBill(consumption.getNumberofUnitsConsumed());
		return consumptionRepository.save(consumption);
	}

	public Consumption updateBill(int billId, Consumption consumption) throws CustomerException {
		Consumption c = consumptionRepository.findById(billId)
				.orElseThrow(()->new ResourceNotFoundException("Bill not exist with id :" + consumption.getBillId()));
		c.setCustomerId(consumption.getCustomerId());
		c.setMonth(consumption.getMonth());
		c.setNumberofUnitsConsumed(consumption.getNumberofUnitsConsumed());
		c.setTotalBill(consumption.getNumberofUnitsConsumed());
		consumptionRepository.saveAndFlush(c);
		return c;
	}

	public void deleteBill(int id) {
		Consumption c = consumptionRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Bill not exist with id :" + id));
		consumptionRepository.delete(c);
	}

	public List<Consumption> getBillbyCustomerId(int cid) {
		return consumptionRepository.findByCustomerId(cid);
	}
	
	
}
