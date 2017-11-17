package com.test.boot.envir.models;

import java.io.Serializable;


import org.springframework.data.annotation.Id;

public class Customer  implements Serializable{


	@Id
	private long custID;
	private String orgName;
	private String accOwner;
	private String feildComment;
	private long status;
	private String billingCity;
	private String billingPin;
	private String billingCountry;
	private String billingState;
	
	
	public Customer() {
		super();
	}

	public Customer(long custID, String orgName, String accOwner, String feildComment, long status, String billingCity,
			String billingPin, String billingCountry, String billingState) {
		super();
		this.custID = custID;
		this.orgName = orgName;
		this.accOwner = accOwner;
		this.feildComment = feildComment;
		this.status = status;
		this.billingCity = billingCity;
		this.billingPin = billingPin;
		this.billingCountry = billingCountry;
		this.billingState = billingState;
	}
	
	public Customer(String orgName, String accOwner, String feildComment, long status, String billingCity,
			String billingPin, String billingCountry, String billingState){
		super();
		this.orgName = orgName;
		this.accOwner = accOwner;
		this.feildComment = feildComment;
		this.status = status;
		this.billingCity = billingCity;
		this.billingPin = billingPin;
		this.billingCountry = billingCountry;
		this.billingState = billingState;
	}

	

	public long getCustID() {
		return custID;
	}

	public void setCustID(long custID) {
		this.custID = custID;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getAccOwner() {
		return accOwner;
	}

	public void setAccOwner(String accOwner) {
		this.accOwner = accOwner;
	}

	public String getFeildComment() {
		return feildComment;
	}

	public void setFeildComment(String feildComment) {
		this.feildComment = feildComment;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingPin() {
		return billingPin;
	}

	public void setBillingPin(String billingPin) {
		this.billingPin = billingPin;
	}

	public String getBillingCountry() {
		return billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}
	
	
}
