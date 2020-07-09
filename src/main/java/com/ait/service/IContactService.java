package com.ait.service;

import java.util.List;

import com.ait.bind.Contact;

public interface IContactService {

	public Boolean  saveContact(Contact contact);
	public List<Contact>  getAllContacts();
	public Contact   getContactById(Integer id);
	public Boolean   deleteContactById(Integer id);
}
