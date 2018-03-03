package com.techlabs.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderBy;

@Entity
public class LoginDetails {

	@Id
	private int loginId;
	@OrderBy("desc")
	private Date date;
	@OrderBy("desc")
	private Time time;
	private boolean loginStatus;

	private String userId;

	public LoginDetails() {

	}

	public LoginDetails(Date date, Time time, String userId, boolean loginStatus) {
		super();
		this.date = date;
		this.time = time;
		this.loginStatus = loginStatus;
		this.userId = userId;
		System.out.println("in loginDetails");
	}

	public int getLoginId() {
		return loginId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}

}
