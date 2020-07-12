package com.ait.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContactServiceExceptionHandler {
	
	@ExceptionHandler(value = PhoneBookExceptionHandling.class)
	public String exception(Model model) {
		return "error";
	}

}
