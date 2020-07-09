package com.ait.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CONTACT_DETAILS")
public class ContactEntity {
	@Id
	@Column(name = "CONTACT_ID")
	@SequenceGenerator(name = "SEQUENCE_ID"
	                                             ,sequenceName = "CONTACT_ID_SEQ"
	                                             ,allocationSize = 1)
	@GeneratedValue(generator = "SEQUENCE_ID"
	                                       ,strategy = GenerationType.SEQUENCE)
	private  Integer   contactId;
	
	@Column(name = "CONTACT_NAME")
	private  String     contactName;
	
	@Column(name = "CONTACT_EMAIL")
	private  String     contactEmail;
	
	@Column(name = "CONTACT_NUMBER")
	private  Long       contactNumber;
	
	@Column(name = "CREATED_DATE",updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private  Date       createDate;
	
	@Column(name = "UPDATED_DATE",insertable = false)
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private  Date       updateDate;
}
