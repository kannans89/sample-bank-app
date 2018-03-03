package com.techlabs.action;

import java.util.List;

import com.techlabs.entity.Account;
import com.techlabs.entity.Role;
import com.techlabs.entity.Status;

public class AdminHomeVM {

	private String userId;
	private Status status;
	private String password;
	private Role role;
	private Account account;
	private List transactions;

	public AdminHomeVM() {
	}

	public AdminHomeVM(String userId, Status status, String password, Role role, Account account, List transactions) {
		this.userId = userId;
		this.status = status;
		this.password = password;
		this.role = role;
		this.account = account;
		this.setTransactions(transactions);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List getTransactions() {
		return transactions;
	}

	public void setTransactions(List transactions) {
		this.transactions = transactions;
	}

}
