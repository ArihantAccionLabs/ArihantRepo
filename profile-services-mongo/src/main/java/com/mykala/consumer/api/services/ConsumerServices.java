package com.mykala.consumer.api.services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mykala.consumer.api.model.ConsumerProfile;
import com.mykala.consumer.api.repository.ConsumerRepository;
import com.mykala.consumer.api.repository.SequenceRepository;
import com.mykala.consumer.api.util.S3ImageSaving;


@Service
public class ConsumerServices{

	private static final String CONSUMER_SEQ_KEY = "consumer";

	@Autowired
	ConsumerRepository consumerRepository;
	
	@Autowired
	private SequenceRepository sequenceRepository;
	
	public String saveConsumer(ConsumerProfile consumerProfile) throws Exception {
		Gson gson = new Gson();
		ConsumerProfile filePath = null;
		consumerProfile.setCustomerId(sequenceRepository.getNextSequence(CONSUMER_SEQ_KEY));
		/*if(consumerProfile.getCustomerProfileImage()!=null) {
			
			filePath=S3ImageSaving.saveImage(consumerProfile.getCustomerProfileImage(),consumerProfile.getUserId()+"_"+consumerProfile.getFirstName());
			consumerProfile.setCustomerProfileImage(filePath);
		}*/
		filePath=consumerRepository.save(consumerProfile);
			
	     return gson.toJson(filePath);
	     
	}

	public ConsumerProfile getConumerById(int id) {
		
		return consumerRepository.findByCustomerId(id);
	}
		public ConsumerProfile getConumerByEmail(String email) {
		
		return consumerRepository.findByEmail(email);
	}
		
}
