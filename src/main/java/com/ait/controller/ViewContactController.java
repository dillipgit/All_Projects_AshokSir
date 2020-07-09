package com.ait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ait.bind.Contact;
import com.ait.service.IContactService;

@Controller
public class ViewContactController {
	
	@Autowired
	private IContactService service;
	
	@GetMapping("/edit")
	public String editContact(@RequestParam("cid") Integer conId,Model model) {
		
		Contact contactById = service.getContactById(conId);
		model.addAttribute("contact", contactById);
		return "contactInfo";
		
	}
	
	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("cid")Integer contactId) {
		Boolean isDeleted = service.deleteContactById(contactId);
		if(isDeleted) {
			return "redirect:/all";
		}
		return null;
		
	}

}
