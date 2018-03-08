package com.techlabs.viewmodel;

public class LoginViewModel 
{
	private boolean postBack=false;
	private String userId;
	private String password;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isPostBack() {
		return postBack;
	}

	public void setPostBack(boolean postBack) {
		this.postBack = postBack;
	}

}
