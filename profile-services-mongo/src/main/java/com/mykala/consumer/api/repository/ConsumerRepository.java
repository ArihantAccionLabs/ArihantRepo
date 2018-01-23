package com.mykala.consumer.api.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mykala.consumer.api.model.ConsumerProfile;

@Repository
public interface ConsumerRepository extends  MongoRepository<ConsumerProfile,Integer>{
	
	ConsumerProfile findByCustomerId(int consumerId);
	ConsumerProfile findByEmail(String email);
	
	
}
