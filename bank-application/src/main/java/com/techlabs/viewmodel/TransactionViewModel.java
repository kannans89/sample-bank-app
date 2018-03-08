package com.techlabs.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class TransactionViewModel 
{
	private static final String WITHDRAW="WITHDRAW";
	private static final String DEPOSITE="DEPOSITE";
	private String transChoice;
	private boolean postBack=false;
	private double amount;
	private List<String> transList;
	
	public TransactionViewModel() {
		transList=new ArrayList<String>();
		transList.add(WITHDRAW);
		transList.add(DEPOSITE);
	}
	
	public String getTransChoice() {
		return transChoice;
	}
	public void setTransChoice(String transChoice) {
		this.transChoice = transChoice;
	}

	public List<String> getTransList() {
		return transList;
	}
	public void setTransList(List<String> transList) {
		this.transList = transList;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public boolean isPostBack() {
		return postBack;
	}

	public void setPostBack(boolean postBack) {
		this.postBack = postBack;
		System.out.println(postBack);
	}
}
