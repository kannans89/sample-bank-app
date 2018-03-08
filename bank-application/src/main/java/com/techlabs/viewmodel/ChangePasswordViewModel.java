package com.techlabs.viewmodel;

public class ChangePasswordViewModel 
{
	private boolean postBack=false;
	private String userId;
	private String password;
	private String newPassword;
	private String confirmNewPassword;
	
	public boolean isPostBack() {
		return postBack;
	}
	public void setPostBack(boolean postBack) {
		this.postBack = postBack;
	}
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
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}
	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}
}
