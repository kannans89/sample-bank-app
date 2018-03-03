package com.techlabs.vm;

import java.util.List;

import com.techlabs.entity.Account;

public class PassbookVM {
	private Account account;
	@SuppressWarnings("rawtypes")
	
	private List transactions;
	private String fileName;
	private boolean postBack;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@SuppressWarnings("rawtypes")
	public List getTransactions() {
		return transactions;
	}
	@SuppressWarnings("rawtypes")
	public void setTransactions(List transactions) {
		this.transactions = transactions;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public boolean isPostBack() {
		return postBack;
	}
	public void setPostBack(boolean postBack) {
		this.postBack = postBack;
	}

	
	
}
