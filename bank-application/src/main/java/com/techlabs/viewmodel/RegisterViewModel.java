package com.techlabs.viewmodel;

import java.io.File;
import java.io.FileInputStream;

public class RegisterViewModel {

	private boolean postBack=false;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private Long mobile=(long) 0;
	private String address;
	private Long aadharNo=(long) 0;
	private String panNo;
	private File userImage; 
	private String userImageFileName;
	private String userImageContentType;  
	private byte[] byteImage;
	private String captchaAnswer;
	
	public String getCaptchaAnswer() {
		return captchaAnswer;
	}

	public void setCaptchaAnswer(String captchaAnswer) {
		this.captchaAnswer = captchaAnswer;
	}

	public RegisterViewModel() {
		System.out.println("Register view model Constructor");
		System.out.println("postBack:"+postBack);
	}
	
	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}
	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		System.out.println("setuserImage called..");
		this.userImage = userImage;
		byteImage=new byte[(int)userImage.length()];
		 try {
	            FileInputStream fileInputStream = new FileInputStream(userImage);
	            fileInputStream.read(byteImage);
	            fileInputStream.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	public boolean isPostBack() {
		return postBack;
	}
	public void setPostBack(boolean postBack) {
		this.postBack = postBack;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	
	public String getUserImageFileName() {
		return userImageFileName;
	}
	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	} 
	public byte[] getByteImage() {
		return byteImage;
	}

	public void setByteImage(byte[] byteImage) {
		this.byteImage = byteImage;
	}
}
