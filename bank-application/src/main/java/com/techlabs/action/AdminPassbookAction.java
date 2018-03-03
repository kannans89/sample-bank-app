package com.techlabs.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.entity.BankTransaction;
import com.techlabs.services.AdminServices;

public class AdminPassbookAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private List<BankTransaction> adminPassbookTrans;
	
	@Autowired
	   private AdminServices adminServices;
	private String userId;
		
		
		@Override
		public String execute() throws Exception {
			System.out.println("###########################");
			adminPassbookTrans=adminServices.getUserTransactions(userId);
			System.out.println(adminPassbookTrans.size());
			return SUCCESS;
		}
	
	public List<BankTransaction> getAdminPassbookTrans() {
		return adminPassbookTrans;
	}
	public void setAdminPassbookTrans(List<BankTransaction> adminPassbookTrans) {
		this.adminPassbookTrans = adminPassbookTrans;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
