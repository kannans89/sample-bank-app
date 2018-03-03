package com.techlabs.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	private String userId;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Account account;
	
	private int NumberOfFailAttemps;
	@Enumerated(EnumType.STRING)
	private Status status;
	

	public User() {
		System.out.println("User-constr");
	}

	public User( Role role, String password, Account account,int n,Status status) {
		super();
		
		UUID uuid = UUID.randomUUID();
		this.userId = uuid.toString().replace("-", "");
		this.role = role;
		this.password=password;
		this.account=account;
		
		this.NumberOfFailAttemps=n;
		this.status=status;
	
		System.out.println("User-para_constr");
	}

	public String getUserId() {
		return userId;
	}

	public Role getRole() {
		return role;
	}

	
	public void setRole(Role role) {
		this.role = role;
		System.out.println("User-setRole");
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNumberOfFailAttemps() {
		return NumberOfFailAttemps;
	}

	public void setNumberOfFailAttemps(int numberOfFailAttemps) {
		NumberOfFailAttemps = numberOfFailAttemps;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}



}
