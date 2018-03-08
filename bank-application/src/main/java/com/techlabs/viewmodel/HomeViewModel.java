package com.techlabs.viewmodel;

import com.techlabs.entity.Account;

public class HomeViewModel 
{
	private String base64EncodedImage;
	private Account account;
	
	public HomeViewModel() {
		System.out.println("Home view model");
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getBase64EncodedImage() {
		return base64EncodedImage;
	}

	public void setBase64EncodedImage(String base64EncodedImage) {
		this.base64EncodedImage = base64EncodedImage;
	}
}
