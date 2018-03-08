package com.techlabs.viewmodel;

import com.techlabs.entity.Account;

public class ProfileViewModel {

	private Account account;
	private String base64EncodedImage;

	public String getBase64EncodedImage() {
		return base64EncodedImage;
	}

	public void setBase64EncodedImage(String base64EncodedImage) {
		this.base64EncodedImage = base64EncodedImage;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
		System.out.println(account.getAccountNo());
	}
}
