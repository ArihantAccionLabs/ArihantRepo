package com.mykala.consumer.api.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@SuppressWarnings("serial")
@Document(collection="consumer_interests")
public class ConsumerInterests implements Serializable{
	

	@Id
    private String id;
 
	private String interestsImageName;
	private String interestsImagePath;
	
	public String getInterestsImageName() {
		return interestsImageName;
	}
	public void setInterestsImageName(String interestsImageName) {
		this.interestsImageName = interestsImageName;
	}
	public String getInterestsImagePath() {
		return interestsImagePath;
	}
	public void setInterestsImagePath(String interestsImagePath) {
		this.interestsImagePath = interestsImagePath;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
