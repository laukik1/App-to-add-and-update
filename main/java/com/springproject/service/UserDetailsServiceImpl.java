package com.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springproject.config.CustomUserDetails;
import com.springproject.dao.UserRepository;
import com.springproject.entities.Customer;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Customer customer = userRepository.getUserByUserEmail(username);
		
		if(customer==null)
		{
			throw new UsernameNotFoundException("could not found user !");
		}
		
		CustomUserDetails customUserDetails = new CustomUserDetails(customer);
		return customUserDetails;
	}

}
