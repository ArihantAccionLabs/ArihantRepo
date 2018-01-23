package com.mykala.consumer.api.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mykala.consumer.api.model.ConsumerProfile;
import com.mykala.consumer.api.services.ConsumerServices;
import com.mykala.consumer.api.util.EmailNotification;

@RestController
@RequestMapping("/user")
public class ForgotPasswordController {

	@Autowired
	private ConsumerServices consumerServices;

	@PostMapping("/forgotPassword")
	public ResponseEntity<String> forgotPassword(@RequestBody Object reqObject)
			throws Exception {

		String response = null;
		try {
			Map map=(Map) reqObject;
			Properties configProp = new Properties();
			InputStream in=ForgotPasswordController.class.getClassLoader()
					.getResourceAsStream("application.properties");
			configProp.load(in);

			ConsumerProfile consumer=consumerServices.getConumerByEmail((String)map.get("email"));
			if(consumer==null) {
				return new ResponseEntity<String>("Email Id is not registerd", HttpStatus.OK);
			}
			else {
				EmailNotification.forgotPasswordMail((String)map.get("resetLink"),(String)map.get("email"));
				
			}
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
}
