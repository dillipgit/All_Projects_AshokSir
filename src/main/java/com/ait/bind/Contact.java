package com.ait.bind;

import java.util.Date;

import lombok.Data;

@Data
public class Contact {
	
	private  Integer   contactId;
	private  String     contactName;
	private  String     contactEmail;
	private  Long       contactNumber;
	private  Date       createDate;
	private  Date       updateDate;

}
