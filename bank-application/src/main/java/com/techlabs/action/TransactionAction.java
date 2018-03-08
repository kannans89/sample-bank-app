package com.techlabs.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.service.TransactionService;
import com.techlabs.viewmodel.TransactionViewModel;

@SuppressWarnings("serial")
public class TransactionAction extends ActionSupport implements ModelDriven<TransactionViewModel>,SessionAware
{
	@Autowired
	private TransactionService transactionService;
	private TransactionViewModel transactionVM;
	@SuppressWarnings("unused")
	private Map<String,Object> session;
	
	@Override
	public TransactionViewModel getModel() {
		transactionVM=new TransactionViewModel();
		return transactionVM;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	@Override
	public String execute() {
		System.out.println("Transaction Ececute method: "+transactionVM.isPostBack());
		if(!transactionVM.isPostBack()) {
			System.out.println("get call transaction");
			return Action.NONE;  
		}
		else {
			System.out.println("post : "+transactionVM.getAmount()+transactionVM.getTransChoice());
			if(transactionVM.getTransChoice().equals("WITHDRAW")) {
				System.out.println("do withdraw");
				if(transactionService.checkBalance(transactionVM.getAmount())) {
					transactionService.withdraw(transactionVM.getAmount());
					addActionMessage("You have successfully Withdraw "+transactionVM.getAmount()+" RS");
				}
				else
					addActionError("Withdraw fail...!!! Not sufficient balance");
			}
			else{
				System.out.println("do deposit");
				transactionService.deposit(transactionVM.getAmount());
				addActionMessage("You have successfully Deposited "+transactionVM.getAmount()+" RS");
			}
			return Action.SUCCESS;  
		}
	}
	
	@Override
	public void validate() {  
		if(transactionVM.isPostBack()) {
			System.out.println("validate here");
			if(transactionVM.getAmount()<=100)
				addFieldError("amount","Please Enter Valid Amount"); 
			if(transactionVM.getTransChoice()==null)
				addFieldError("transChoice","Please select transaction type"); 
		}
	}
}
