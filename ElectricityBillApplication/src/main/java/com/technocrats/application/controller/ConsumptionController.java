package com.technocrats.application.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.technocrats.application.model.Consumption;
import com.technocrats.application.model.Customer;
import com.technocrats.application.model.CustomerException;
import com.technocrats.application.service.ConsumptionService;

@RestController
@RequestMapping("/api/v1/")
public class ConsumptionController {
	@Autowired
	private ConsumptionService consumptionService;
	
	@GetMapping("/bill")
	public List<Consumption> getAllBills(@RequestParam(required = false) Optional<String> month) {
		return consumptionService.getAllBills(month);
	}
	
	@GetMapping("/bill/{billId}")
	public ResponseEntity<Consumption> getBillbyId(@PathVariable int billId) {
		return consumptionService.getBillbyId(billId);
	}
	
	@GetMapping("/bill/customer/{customerId}")
	public List<Consumption> getBillbyCustomerId(@PathVariable int customerId) {
		return consumptionService.getBillbyCustomerId(customerId);
	}
	
	@PostMapping("/bill")
	public Consumption addBill(@RequestBody Consumption consumption) throws CustomerException {
		return consumptionService.addBill(consumption);
	}
	
	@PutMapping("/bill/{billId}")
	public Consumption updateBill(@PathVariable int billId, @RequestBody Consumption consumption) throws CustomerException {
		return consumptionService.updateBill(billId, consumption);
	}
	
	@DeleteMapping("/bill/{billId}")
	public void deleteBill(@PathVariable int billId) {
		consumptionService.deleteBill(billId);
	}
}
