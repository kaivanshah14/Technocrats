package com.technocrats.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.technocrats.application.exception.ResourceNotFoundException;
import com.technocrats.application.model.Customer;
import com.technocrats.application.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public ResponseEntity<Customer> getCustomer(int id) {
		Customer c = customerRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Customer not exist with id :" + id));
		return ResponseEntity.ok(c);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer updateCustomer(Customer customer) {
		Customer c = customerRepository.findById(customer.getCustomerId())
				.orElseThrow(()->new ResourceNotFoundException("Customer not exist with id :" + customer.getCustomerId()));
		
		c.setCustomerName(customer.getCustomerName());
		c.setCustomerAreaCode(customer.getCustomerAreaCode());
		c.setCustomerType(customer.getCustomerType());
		
		return customerRepository.save(c);
	}

	public void deleteCustomer(int id) {
		Customer c = customerRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Customer not exist with id :" + id));
		customerRepository.delete(c);
	}

}
