package com.mykala.consumer.api.controller;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mykala.consumer.api.model.ConsumerInterestResponse;
import com.mykala.consumer.api.model.ConsumerProfile;
import com.mykala.consumer.api.services.ConsumerInterestsService;
import com.mykala.consumer.api.services.ConsumerServices;
import com.mykala.consumer.api.util.EmailNotification;

@RestController
@RequestMapping("/profile")
public class ProfileCreationController {

	@Autowired
	private ConsumerServices consumerServices;

	@Autowired
	private ConsumerInterestsService consumerInterestsService;

	@PostMapping("/userDetail")
	public ResponseEntity<String> saveUsers(@RequestBody ConsumerProfile consumerProfile) throws Exception {

		String response = null;
		try {
			Properties configProp = new Properties();
			InputStream in=ForgotPasswordController.class.getClassLoader()
					.getResourceAsStream("application.properties");
			configProp.load(in);
			
			response = consumerServices.saveConsumer(consumerProfile);
			/*EmailNotification.emailVerificationMail(consumerProfile.getFirstName(), consumerProfile.getEmail(),
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> postForEntity = restTemplate
					.getForEntity(configProp.getProperty("save.user.url")
							+ consumerProfile.getUserId(), String.class);
					postForEntity.getBody());*/
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@GetMapping("validateToken/{token}")
	public ResponseEntity<String> validateToken(@PathVariable("token") String token) throws Exception {
		Properties configProp = new Properties();
		InputStream in=ForgotPasswordController.class.getClassLoader()
				.getResourceAsStream("application.properties");
		configProp.load(in);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> postForEntity = restTemplate.getForEntity(
				configProp.getProperty("validate.user.url") + token, String.class);
		return new ResponseEntity<String>(postForEntity.getBody(), HttpStatus.OK);

	}

	@GetMapping("getUser/{id}")
	public ResponseEntity<String> getUser(@PathVariable("id") int id) throws Exception {

		Properties configProp = new Properties();
		InputStream in=ForgotPasswordController.class.getClassLoader()
				.getResourceAsStream("application.properties");
		configProp.load(in);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> postForEntity = restTemplate.getForEntity(
				configProp.getProperty("save.user.url")+ 1, String.class);
		
		System.out.println(":: response :: " + postForEntity.getBody());
		return new ResponseEntity<String>(postForEntity.getBody(), HttpStatus.OK);
	}
/*	@PostMapping("addConsumerCatalogs")
	public ConsumerInterestResponse addListOfCatalogs(@RequestBody ConsumerPreferences consumerPreferences) {
		return consumerInterestsService.addListOfCatalogs(consumerPreferences);

	}

	@GetMapping("getCatalogs/{id}")
	public ConsumerPreferences getConsumerInterestsById(@PathVariable("id") int id) {
		return consumerInterestsService.getConsumerInterestsById(id);

	}
	@PostMapping("getCatalogs/{id}")
	public ConsumerPreferences UpdateConsumerInterests(@PathVariable("id") int id,@RequestBody ConsumerPreferences consumerPreferences){
		consumerInterestsService.UpdateConsumerInterests(id,consumerPreferences);
		return null;
		
	}*/


}
