package com.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiles.model.Contact;

@Controller
public class HomeController {
	@RequestMapping("/contact.htm")
	public String addContact(ModelMap model){
		System.out.println("contact added successfully");
		Contact c = new Contact();
		model.addAttribute("obj",c);
		return "contact";
	}
	@RequestMapping("/addContact.htm")
	public String addUser(ModelMap model){
		System.out.println("contact added successfully");
		Contact c = new Contact();
		model.addAttribute("obj",c);
		return "index";
	}

}
