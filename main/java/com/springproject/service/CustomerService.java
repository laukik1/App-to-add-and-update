package com.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.dao.UserRepository;
import com.springproject.entities.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Customer> getAllCustomers()
	{
		List<Customer> list = this.userRepository.findAll();
		return list;
	}
	
	
	public Customer getCustomerById(int id)
	{
		Customer customer = null;
		try {
			customer = this.userRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return customer;
	}
	
	public void deleteCustomer(int cid)
	{
		userRepository.deleteById(cid);
	}
	
	public void updateCustomer(Customer customer, int custId)
	{
		customer.setId(custId);
		userRepository.save(customer);
	}

}
