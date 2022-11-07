package com.technocrats.application.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.technocrats.application.model.Consumption;
import com.technocrats.application.model.Customer;

@Repository
public interface ConsumptionRepository extends JpaRepository<Consumption, Integer> {

	@Query(value="SELECT * FROM consumption WHERE customer_id=:cid",nativeQuery=true)
	public List<Consumption> findByCustomerId(@Param("cid") int cid);

	@Query(value="SELECT * FROM consumption WHERE month=:m",nativeQuery=true)
	public List<Consumption> findbyMonth(@Param("m") Optional<String> month);

}
