package com.technocrats.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technocrats.application.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
}
