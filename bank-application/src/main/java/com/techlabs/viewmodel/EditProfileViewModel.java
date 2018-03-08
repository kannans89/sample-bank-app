package com.techlabs.viewmodel;

import com.techlabs.entity.Account;

public class EditProfileViewModel
{
	private boolean postBack;
	private Account account;
	
	public boolean isPostBack() {
		return postBack;
	}
	public void setPostBack(boolean postBack) {
		this.postBack = postBack;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
