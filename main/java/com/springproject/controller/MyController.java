package com.springproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@RequestMapping("/welcm")
	public String welcm()
	{
		String text = "this is private page";
		text+="not allowed to unauthorized users";
		return text;
	}
}
