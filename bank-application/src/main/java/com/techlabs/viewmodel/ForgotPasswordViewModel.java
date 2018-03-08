package com.techlabs.viewmodel;

public class ForgotPasswordViewModel 
{
	private String accountNo;
	private String email;
	private boolean postBack;
	
	public ForgotPasswordViewModel() {
		System.out.println("forgot password view model");
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isPostBack() {
		return postBack;
	}

	public void setPostBack(boolean postBack) {
		this.postBack = postBack;
	}
}
