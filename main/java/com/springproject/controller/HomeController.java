package com.springproject.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.springproject.dao.UserRepository;
import com.springproject.entities.Customer;
import com.springproject.helper.Message;
import com.springproject.service.CustomerService;

@Controller
public class HomeController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping("/")
	public String home(Model model)
	{
		return "index";
	}
	
	@RequestMapping("/register")	
	public String signup(Model model)
	{
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "register";
	}
	

	
	@PostMapping(value="do_register")	
	public String register(@Valid @ModelAttribute("customer") Customer customer, BindingResult result1, 
			@RequestParam(value ="checkbox", defaultValue = "false") boolean checkbox, 
			HttpSession session, Model model)
	{
		try {
			
			if(!checkbox) {
				throw new Exception("You have not checked checkbox");
			}
			
			if(result1.hasErrors())
			{
				System.out.println("ERROR"+result1.toString());
				model.addAttribute("customer", customer);
				return "register";
			}
			
			customer.setRole("ROLE_USER");
			customer.setPassword(passwordEncoder.encode(customer.getPassword()));
			
			System.out.println(checkbox);
			System.out.println(customer);
			
			
			Customer result = this.userRepository.save(customer);
			
			model.addAttribute("customer", new Customer());
			
			session.setAttribute("message", new Message("Successfully", 
					"alert-success"));
			return "register";
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			model.addAttribute("customer", customer);
			session.setAttribute("message", new Message("Something went wrong"+e.getMessage(), 
					"alert-danger"));
			return "register";
		}
		
		
	}
	
	@GetMapping("/signin")
	public String customLogin(Model model)
	
	{
		model.addAttribute("title", "Login Page");
		return "login";
		
	}
	
	
	@GetMapping("/contact")
	public String getCustomers(Model m)
	{
		List<Customer> list = customerService.getAllCustomers();
		m.addAttribute("customer", list);
		return "contact";
	}
	
	@GetMapping("/update/{id}")
	public String getCustomer(@PathVariable("id") int id, Model model)
	{
		Customer customer = customerService.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "update";
	}
	
	@PostMapping("/update_cust")
	public RedirectView contact(@ModelAttribute("customer") Customer customer, 
			HttpServletRequest request)
	{
		this.userRepository.save(customer);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/contact");
		return redirectView;
	}
	
	@RequestMapping("/delete/{custId}")
	public RedirectView deleteCustomer(@PathVariable("custId") int custId, HttpServletRequest request)
	{
		this.customerService.deleteCustomer(custId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/contact");
		return redirectView;
			
	}
	

}
