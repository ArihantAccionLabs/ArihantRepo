package com.mykala.consumer.api.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mykala.consumer.api.repository.CascadeSave;


@Document(collection = "consumer")
public class ConsumerProfile {


   	@Id
	private int customerId;

	private int userId;


	private String userName;

	private String firstName;

	private String lastName;

	@DBRef
	@CascadeSave
	private List<Address> address;

	
	private String consumerImagePath;
	
	private String phoneNumber;
	
	private String phoneNo;
	
	
	private String email;
	
	private String gender;
	
	private Date dateOfBirth;
	
	private Date createdAt;
	
	private int  customerAccountStatus;
	
	@DBRef
	@CascadeSave
	private Set<ConsumerInterests> consumerInterests;
	
	
	public ConsumerProfile() {
		super();
	}


	public int getCustomerId() {
		return customerId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	


	


	public List<Address> getAddress() {
		return address;
	}


	public void setAddress(List<Address> address) {
		this.address = address;
	}


	public String getConsumerImagePath() {
		return consumerImagePath;
	}


	public void setConsumerImagePath(String consumerImagePath) {
		this.consumerImagePath = consumerImagePath;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public int getCustomerAccountStatus() {
		return customerAccountStatus;
	}


	public void setCustomerAccountStatus(int customerAccountStatus) {
		this.customerAccountStatus = customerAccountStatus;
	}


	public Set<ConsumerInterests> getConsumerInterests() {
		return consumerInterests;
	}


	public void setConsumerInterests(Set<ConsumerInterests> consumerInterests) {
		this.consumerInterests = consumerInterests;
	}


	


	
	
	
}
