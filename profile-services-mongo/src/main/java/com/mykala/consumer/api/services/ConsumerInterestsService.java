package com.mykala.consumer.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mykala.consumer.api.model.ConsumerInterestResponse;
import com.mykala.consumer.api.model.ConsumerInterests;
import com.mykala.consumer.api.repository.ConsumerInterestsRepository;

@Service
public class ConsumerInterestsService {
	@Autowired
	private ConsumerInterestsRepository consumerInterestsRepository;
	
	public List<ConsumerInterests> getListOfConsumerInterests() {
		// TODO Auto-generated method stub
		return (List<ConsumerInterests>) consumerInterestsRepository.findAll();
	}


	

}
