package com.techlabs.services;

import org.springframework.stereotype.Service;

@Service
public class PasswordGenrator {
	
	public PasswordGenrator() {
		System.out.println("PasswordGenrator-constr");
	}

	public String createPassword() {	
		System.out.println("password is created");
		return Long.toHexString(Double.doubleToLongBits(Math.random()));
	}
}
