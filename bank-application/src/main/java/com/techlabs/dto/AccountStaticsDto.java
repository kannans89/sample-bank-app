package com.techlabs.dto;

public class AccountStaticsDto 
{
	private int noOfActiveAccounts;
	private int noOfDeactiveAccounts;
	private int noOfOpenedAccounts;
	private int noOfTransactions;
	private double totalAmountDeposited;
	private double totalAmountWithdrawal;
	private String reachUserId;
	
//	public StaticsDto(int noOfActiveAccounts, int noOfDeactiveAccounts,
//			int noOfOpenedAccounts, int noOfTransactions,
//			double totalAmountdeposited, double totalAmountWithdrawal,
//			String reachUserId) {
//		super();
//		this.noOfActiveAccounts = noOfActiveAccounts;
//		this.noOfDeactiveAccounts = noOfDeactiveAccounts;
//		this.noOfOpenedAccounts = noOfOpenedAccounts;
//		this.noOfTransactions = noOfTransactions;
//		this.totalAmountdeposited = totalAmountdeposited;
//		this.totalAmountWithdrawal = totalAmountWithdrawal;
//		this.reachUserId = reachUserId;
//	}
	
	public int getNoOfActiveAccounts() {
		return noOfActiveAccounts;
	}
	public void setNoOfActiveAccounts(int noOfActiveAccounts) {
		this.noOfActiveAccounts = noOfActiveAccounts;
	}
	public int getNoOfDeactiveAccounts() {
		return noOfDeactiveAccounts;
	}
	public void setNoOfDeactiveAccounts(int noOfDeactiveAccounts) {
		this.noOfDeactiveAccounts = noOfDeactiveAccounts;
	}
	public int getNoOfOpenedAccounts() {
		return noOfOpenedAccounts;
	}
	public void setNoOfOpenedAccounts(int noOfOpenedAccounts) {
		this.noOfOpenedAccounts = noOfOpenedAccounts;
	}
	public int getNoOfTransactions() {
		return noOfTransactions;
	}
	public void setNoOfTransactions(int noOfTransactions) {
		this.noOfTransactions = noOfTransactions;
	}
	public double getTotalAmountDeposited() {
		return totalAmountDeposited;
	}
	public void setTotalAmountDeposited(double totalAmountDeposited) {
		this.totalAmountDeposited = totalAmountDeposited;
	}
	public double getTotalAmountWithdrawal() {
		return totalAmountWithdrawal;
	}
	public void setTotalAmountWithdrawal(double totalAmountWithdrawal) {
		this.totalAmountWithdrawal = totalAmountWithdrawal;
	}
	public String getReachUserId() {
		return reachUserId;
	}
	public void setReachUserId(String reachUserId) {
		this.reachUserId = reachUserId;
	}
}
