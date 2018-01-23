package com.mykala.consumer.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.mykala.consumer.api.model.SequenceID;

@Repository
public class SequenceRepository {


	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	  public int getNextSequence(String key) {
	 
		  Query query = new Query(Criteria.where("_id").is(key));

			// increase sequence id by 1
			Update update = new Update();
			update.inc("seq", 1);

			// return new increased id
			FindAndModifyOptions options = new FindAndModifyOptions();
			options.returnNew(true);

			// this is the magic happened.
			SequenceID seqId = mongoTemplate.findAndModify(query, update, options, SequenceID.class);

			return seqId.getSeq();
	  }
}
