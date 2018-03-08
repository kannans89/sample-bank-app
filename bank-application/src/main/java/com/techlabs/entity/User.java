package com.techlabs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User {
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String role;
	@JoinColumn
	@OneToOne
	private Account account;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String role, Account account) {
		this.role = role;
		this.account = account;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
