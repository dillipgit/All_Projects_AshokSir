package com.ait.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.bind.Contact;
import com.ait.entity.ContactEntity;
import com.ait.exception.PhoneBookExceptionHandling;
import com.ait.repository.IContactRepository;

@Service
public class ContactServiceImpl implements IContactService {

	@Autowired
	private IContactRepository repo;

	@Override
	public Boolean saveContact(Contact contact) {
		Boolean isSave = false;
		try {

			ContactEntity entity = new ContactEntity();
			BeanUtils.copyProperties(contact, entity);
			repo.save(entity);
			isSave = true;
		} catch (Exception e) {
			throw new PhoneBookExceptionHandling();
		}

		return isSave;
	}

	@Override
	public List<Contact> getAllContacts() {

		List<Contact> listContact = null;
		try {
			List<ContactEntity> findAll = repo.findAll();

			listContact = findAll.stream().map(entity -> {
				Contact contact = new Contact();
				BeanUtils.copyProperties(entity, contact);
				return contact;
			}).collect(Collectors.toList());

		}

		catch (Exception e) {
			throw new PhoneBookExceptionHandling();
		}
		return listContact;

	}

	@Override
	public Contact getContactById(Integer id) {
		Contact c = null;
		try {
			
			Optional<ContactEntity> findById = repo.findById(id);
			if (findById.isPresent()) {
				ContactEntity entity = findById.get();
				c = new Contact();
				BeanUtils.copyProperties(entity, c);
				
			}
		}
		catch (Exception e) {
          throw new PhoneBookExceptionHandling();
		}
		
		return c;
	}

	@Override
	public Boolean deleteContactById(Integer id) {
		Boolean isdelete=false;
		try {
			repo.deleteById(id);
			isdelete = true;
		}
		catch (Exception e) {
			throw new PhoneBookExceptionHandling();
		}
		return isdelete;
	}

}
