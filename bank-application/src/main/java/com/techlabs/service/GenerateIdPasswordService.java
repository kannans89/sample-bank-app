package com.techlabs.service;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;
@Service("generateIdPasswordService")
public class GenerateIdPasswordService 
{
	public GenerateIdPasswordService() {
		System.out.println("Generate Idpassword service");
	}
	public String generatePassword()
	{
		int length=5;
		String passwordString="01BC@DE23$MN45TWX6$7UV89A@FG5H125IJ$KL68O9@8P0QR5S54YZ6ab7cd7@8$ef6g6hij6kl6m5no@6p6q5rs5t1@uv2w3x9yz";
		SecureRandom random=new SecureRandom();
		StringBuilder builder=new StringBuilder(length);
		for(int i=0;i<length;i++)
			builder.append(passwordString.charAt(random.nextInt(passwordString.length())));
		return builder.toString();
	}
	public String generateUserId()
	{
		int length=8;
		StringBuilder builder=new StringBuilder(length);
		builder.append("SSS");
		builder.append(generatePassword());
		return builder.toString();
	}
}
