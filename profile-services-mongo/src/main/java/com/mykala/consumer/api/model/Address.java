package com.mykala.consumer.api.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "address")
public class Address {
	

	  @Id
	  private String  addID;
	  private String addressLineOne;
	  
	  private String addressLineTwo;
	  
	  private String city;	
	  
	  private String state;
	  
	  private String zipcode;
	  
	  private String addressType;

	  
	  
	public Address() {
		super();
	}

	public Address(String addID, String addressLineOne, String addressLineTwo, String city, String state, String zipcode,
			String addressType) {
		super();
		this.addID = addID;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.addressType = addressType;
	}

	public Address(String addressLineOne, String addressLineTwo, String city, String state, String zipcode,
			String addressType) {
		super();
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.addressType = addressType;
	}

	
	


	public String getAddID() {
		return addID;
	}

	public void setAddID(String addID) {
		this.addID = addID;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}


	
}
