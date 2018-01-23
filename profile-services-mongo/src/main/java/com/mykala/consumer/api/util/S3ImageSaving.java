package com.mykala.consumer.api.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.imageio.ImageIO;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

import sun.misc.BASE64Decoder;

public class S3ImageSaving {
	
	public  static String saveImage(String img,String userID) throws IOException {
		
		Properties configProp = new Properties();
		InputStream in=S3ImageSaving.class.getClassLoader()
				.getResourceAsStream("AwsCredentials.properties");
		configProp.load(in);
		
		  String keyName = userID.replace(".", "_")+".png";
		  
		  String amazonFileUploadLocationOriginal=ProfileConstant.EXISTING_BUCKET_NAME;
		  

		  
		AWSCredentials awsCredentials=new BasicAWSCredentials(configProp.getProperty("accessKey"),configProp.getProperty("secretKey"));
		
		  AmazonS3 s3Client = new AmazonS3Client(awsCredentials);
		  s3Client.setEndpoint(ProfileConstant.S3CLIENT_ENDPOINT_URL);
		  
		  String[] parts = img.split(",");
		  String imageString = parts[1];
		  
		  BufferedImage image = null;
		  byte[] imageByte;
		  
		  BASE64Decoder decoder = new BASE64Decoder();
			imageByte = decoder.decodeBuffer(imageString);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			image = ImageIO.read(bis);
			bis.close();
		  ByteArrayOutputStream os = new ByteArrayOutputStream();
		  ImageIO.write(image,"png", os); 
		  InputStream fis = new ByteArrayInputStream(os.toByteArray());
			
		  ObjectMetadata objectMetadata = new ObjectMetadata();
		  PutObjectRequest putObjectRequest = new PutObjectRequest(amazonFileUploadLocationOriginal, keyName, fis, objectMetadata);
		  PutObjectResult result = s3Client.putObject(putObjectRequest);
		  
		  return amazonFileUploadLocationOriginal+"/"+keyName;
		 
	}
	
	

}
