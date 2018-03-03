package com.techlabs.vm;

import com.techlabs.entity.Account;
import com.techlabs.entity.TransactionType;
import com.techlabs.services.BankServices;

public class TransactionVM {
	private boolean postBack;
	private double amount;
	private TransactionType type;
	private BankServices services;
	private String msg;
	private String errorMsg;
	private Account account;
	
	public boolean isPostBack() {
		return postBack;
	}
	public void setPostBack(boolean postBack) {
		this.postBack = postBack;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TransactionType getType() {
		return type;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}
	public BankServices getServices() {
		return services;
	}
	public void setServices(BankServices services) {
		this.services = services;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
