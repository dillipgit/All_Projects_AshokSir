package com.ait.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.bind.Contact;
import com.ait.entity.ContactEntity;
import com.ait.repository.IContactRepository;

@Service
public class ContactServiceImpl implements IContactService{
	
	@Autowired
	private IContactRepository repo;

	@Override
	public Boolean saveContact(Contact contact) {
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(contact, entity);
		repo.save(entity);
		return entity.getContactId() != null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactEntity> findAll = repo.findAll();
		
		return findAll.stream().map(entity->{
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());
	
	}

	@Override
	public Contact getContactById(Integer id) {
		Optional<ContactEntity> findById = repo.findById(id);
		if(findById.isPresent()) {
			ContactEntity entity = findById.get();
			Contact c = new Contact();
			BeanUtils.copyProperties(entity,c);
			return c;
		}
		return null;
	}

	@Override
	public Boolean deleteContactById(Integer id) {
		repo.deleteById(id);
		return true;
	}

	 
}
