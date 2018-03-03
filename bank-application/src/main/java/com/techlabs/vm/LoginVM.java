package com.techlabs.vm;

public class LoginVM {

	private String userId;
	private String password;

	private boolean loginPostBack;
	private String loginErrorMsg;
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
	public boolean isLoginPostBack() {
		return loginPostBack;
	}
	public void setLoginPostBack(boolean loginPostBack) {
		this.loginPostBack = loginPostBack;
	}
	public String getLoginErrorMsg() {
		return loginErrorMsg;
	}
	public void setLoginErrorMsg(String loginErrorMsg) {
		this.loginErrorMsg = loginErrorMsg;
	}
	
	
}
