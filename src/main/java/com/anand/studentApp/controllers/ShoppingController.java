package com.anand.studentApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShoppingController {
	
	@RequestMapping(value = "/shoppinghome", method = RequestMethod.GET)
	public String shoppingHome(){
		return "shoppinghome";
		
	}

}
