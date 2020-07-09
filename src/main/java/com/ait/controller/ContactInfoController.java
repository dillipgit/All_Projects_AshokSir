package com.ait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ait.bind.Contact;
import com.ait.service.IContactService;

@Controller
public class ContactInfoController {

	@Autowired
	private IContactService service;

	@GetMapping(value = { "/", "login" })
	public String loadForm(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "contactInfo";

	}

	@PostMapping("/save")
	public String handleSubmitBtn(@ModelAttribute Contact contact,
			                                             Model model,
			                                             RedirectAttributes attribute) {
		
     	Boolean isAvailable = service.saveContact(contact);
		if (isAvailable) {
			attribute.addFlashAttribute("successMsg","Contact Save Successfully..");
		} else {
			attribute.addFlashAttribute("errosMessage","Save Faild");
			
		}
		return "redirect:/login";

	}
	
	@GetMapping("/all")
	public String retriveAllContacts(Model model) {
		List<Contact> allContacts = service.getAllContacts();
		model.addAttribute("allContacts", allContacts);
		
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
	    // return "viewContacts";
		 return "contactInfo";
		
	}

}
