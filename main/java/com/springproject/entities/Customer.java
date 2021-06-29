package com.springproject.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity 
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message="name field is required")
	@Size(min= 2, max=20, message = "min 2 & max 20 characters" )
	private String name;
	
	@Email
	private String email;	
	
	@Column(length=500)
	private String description;
	
	private String gender;
	
	private String password;
	
	@AssertTrue
	private boolean checkbox;
	
	private String role;
	
	private String imageUrl;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Address address;
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Product> products = new ArrayList<>();
	

//	public Customer(int id, String name, String email, String address, String description, String gender,
//			String password, boolean check) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.address = address;
//		this.description = description;
//		this.gender = gender;
//		this.password = password;
//		this.check = check;
//	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isCheckbox() {
		return checkbox;
	}

	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", description=" + description
				+ ", gender=" + gender + ", password=" + password + ", checkbox=" + checkbox + ", role=" + role
				+ ", imageUrl=" + imageUrl + ", address=" + address + ", products=" + products + "]";
	}
	
	
}