package com.mykala.consumer.api.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.postmark.java.NameValuePair;
import com.postmark.java.PostmarkClient;
import com.postmark.java.PostmarkMessage;
import com.postmark.java.PostmarkResponse;

public class EmailNotification {

	public static void emailVerificationMail(String userName, String emailID, String token) {

		try {

			List<NameValuePair> headers = new ArrayList<NameValuePair>();

			headers.add(new NameValuePair("HEADER", "Email Verification"));
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream(ProfileConstant.FORGOT_PASSWORD_FILE_PATH );
			BufferedReader br = null;
			StringBuilder sb = new StringBuilder();
			String line;
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			String content =sb.toString().replace("Ryan", userName);

			content = content.replace("@@@", "?token=" + token);

			System.out.println(content);

			PostmarkMessage message = new PostmarkMessage(ProfileConstant.FROM_ADDRESS, emailID, emailID, null,
					"Verify your EMail", content, true, null, headers);

			PostmarkClient client = new PostmarkClient(ProfileConstant.POSTMARK_SERVER_TOKEN);

			PostmarkResponse response = client.sendMessage(message);
			System.out.println(":: response :: " + response.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void forgotPasswordMail(String resetLink, String emailID) {
		try {

			List<NameValuePair> headers = new ArrayList<NameValuePair>();

			headers.add(new NameValuePair("HEADER", "Forgot Password"));
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream(ProfileConstant.FORGOT_PASSWORD_FILE_PATH );
			BufferedReader br = null;
			StringBuilder sb = new StringBuilder();
			String line;
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			String content = sb.toString().replace("@@@@@", resetLink);

			System.out.println(content);

			PostmarkMessage message = new PostmarkMessage(ProfileConstant.FROM_ADDRESS, emailID, emailID, null,
					"reset your password", content, true, null, headers);

			PostmarkClient client = new PostmarkClient(ProfileConstant.POSTMARK_SERVER_TOKEN);

			PostmarkResponse response = client.sendMessage(message);
			System.out.println(":: response :: " + response.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
