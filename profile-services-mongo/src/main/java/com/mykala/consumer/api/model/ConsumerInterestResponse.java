package com.mykala.consumer.api.model;

public class ConsumerInterestResponse {
private int consumerId;
private int totalRecordsSelected;
private String message;
public int getConsumerId() {
	return consumerId;
}
public void setConsumerId(int consumerId) {
	this.consumerId = consumerId;
}
public int getTotalRecordsSelected() {
	return totalRecordsSelected;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public void setTotalRecordsSelected(int totalRecordsSelected) {
	this.totalRecordsSelected = totalRecordsSelected;
}
public ConsumerInterestResponse(int consumerId, int totalRecordsSelected, String message) {
	super();
	this.consumerId = consumerId;
	this.totalRecordsSelected = totalRecordsSelected;
	this.message = message;
}
public ConsumerInterestResponse() {
	super();
	// TODO Auto-generated constructor stub
}


}
