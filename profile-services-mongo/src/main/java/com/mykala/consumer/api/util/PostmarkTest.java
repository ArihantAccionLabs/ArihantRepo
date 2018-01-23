package com.mykala.consumer.api.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/*import com.postmark.java.NameValuePair;
import com.postmark.java.PostmarkClient;
import com.postmark.java.PostmarkMessage;
import com.postmark.java.PostmarkResponse;*/

public class PostmarkTest {

	
	public static void main(String[] args) {

		try {
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> postForEntity = 
					restTemplate.getForEntity("http://localhost:7090/login/user/token/"+1, String.class);
			
			System.out.println(":: response :: "+postForEntity.getBody());
			
			/*List<NameValuePair> headers = new ArrayList<NameValuePair>();

			headers.add(new NameValuePair("HEADER", "test"));

			String content = new Scanner(new File("E:\\project_stuff\\Kala\\templates\\index.html")).useDelimiter("\\Z").next().replace("Ryan", "Arihant");
			System.out.println(content);

			PostmarkMessage message = new PostmarkMessage("support@mykala.com",
			        "arihant.jain@accionlabs.com",
			        "arihant.jain@accionlabs.com",
			        null,
			        "Test Mail From Arihant",
			        content,
			        true,
			        null,
			        headers);

			
			PostmarkClient client = new PostmarkClient("f8fc3b11-683c-4b1e-a166-056b31ef6067");

		
			       
			
		PostmarkResponse response=client.sendMessage(message);*/
	
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	}
