package com.mykala.consumer.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mykala.consumer.api.model.ConsumerInterests;


@Repository
public interface ConsumerInterestsRepository extends CrudRepository<ConsumerInterests, Integer>{
	
}
