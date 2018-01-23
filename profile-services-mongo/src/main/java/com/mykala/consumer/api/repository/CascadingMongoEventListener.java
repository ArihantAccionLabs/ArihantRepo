package com.mykala.consumer.api.repository;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mapping.model.MappingException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;


@Component
public class CascadingMongoEventListener extends  AbstractMongoEventListener<Object> {
	@Autowired
	private MongoOperations mongoOperations;

	
	@Override
	  public void onBeforeConvert(BeforeConvertEvent<Object> event) {
		Object source = event.getSource(); 
	      ReflectionUtils.doWithFields(source.getClass(), new ReflectionUtils.FieldCallback() {
	 
	          public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
	              ReflectionUtils.makeAccessible(field);
	 
	              if (field.isAnnotationPresent(DBRef.class) && field.isAnnotationPresent(CascadeSave.class)) {
	                  final Object fieldValue = field.get(source);
	                  if (Collection.class.isAssignableFrom(field.getType())) {
							Collection<Object> models = (Collection<Object>) fieldValue;
							for (Object model : models) {
								
								System.out.println("Cascading save model - "+model);
								mongoOperations.save(model);
							}
						}else if(!(Collection.class.isAssignableFrom(field.getType()))) {
							 
							  DbRefFieldCallback callback = new DbRefFieldCallback();
							    ReflectionUtils.doWithFields(fieldValue.getClass(), callback);

							    if (!callback.isIdFound()) {
							    
							   throw new MappingException("Cannot perform cascade save on child object without id set");
							    	                  }
							      mongoOperations.save(fieldValue);
						}
	                  
	              }
	          }
	      });
	  }
	
	  private static class DbRefFieldCallback implements ReflectionUtils.FieldCallback {
	      private boolean idFound;
	      public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
	          ReflectionUtils.makeAccessible(field);
	          if (field.isAnnotationPresent(Id.class)) {
	              idFound = true;
	          }
	      }
	      public boolean isIdFound() {
	          return idFound;
	      }
	  }


}
