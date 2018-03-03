package com.techlabs.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.entity.Account;
import com.techlabs.services.BankServices;
import com.techlabs.vm.TransactionVM;

//@Component
public class TransactionAction extends ActionSupport implements SessionAware, ModelDriven<TransactionVM> {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private TransactionVM transactionVM;

	@Autowired
	private BankServices services;

	@Override
	public String execute() throws Exception {
		if (transactionVM.isPostBack()) {
			
			transactionVM.setAccount((Account) session.get("user"));
			if (!services.transactionOperation(transactionVM.getAmount(), transactionVM.getType(), transactionVM.getAccount())) {
				transactionVM.setErrorMsg("withdrawl fail");
			} else {
				transactionVM.setMsg("transaction success......");
			}
			return SUCCESS;
		}
		return "show";
	}

	@Override
	public TransactionVM getModel() {
		transactionVM = new TransactionVM();
		return transactionVM;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	@Override
	public void validate() {
		if (transactionVM.getAmount() < 0 || transactionVM.getAmount() > 50000) {
			addFieldError("amount", "AMOUNT NOT VALID");
		}
	}

}
