package com.ait.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.ContactEntity;

public interface IContactRepository extends JpaRepository<ContactEntity, Serializable>{

}
