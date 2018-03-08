package com.techlabs.viewmodel;

import java.util.Set;
import com.techlabs.entity.BankTransaction;

public class PassbookViewModel 
{
	private boolean postBack=false;
	private Set<BankTransaction> bankTransactions;
	
	public boolean isPostBack() {
		return postBack;
	}
	public void setPostBack(boolean postBack) {
		this.postBack = postBack;
	}
	public Set<BankTransaction> getBankTransactions() {
		return bankTransactions;
	}
	public void setBankTransactions(Set<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}
}
