package com.springproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springproject.entities.Customer;

public interface UserRepository extends JpaRepository<Customer, Integer>{

	@Query("select u from Customer u where u.email = :email")
	public Customer  getUserByUserEmail(@Param("email") String email);
	
	public Customer findById(int id);
}
