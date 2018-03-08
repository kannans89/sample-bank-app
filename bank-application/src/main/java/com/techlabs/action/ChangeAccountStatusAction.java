package com.techlabs.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.techlabs.dto.AccountDto;
import com.techlabs.service.ChangeAccountStatusService;
import com.techlabs.service.GetAccountsService;

public class ChangeAccountStatusAction 
{
	@Autowired
	private ChangeAccountStatusService changeAccountStatusService;
	@Autowired
	private GetAccountsService getAccountsService;
	private List<AccountDto> accounts;
	private String userId;
	private String accountStatus;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
		System.out.println("set id:"+userId);
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
		System.out.println("set status:"+accountStatus);
	}
	
	public void execute() throws IOException  {
		System.out.println("Execute");
		changeAccountStatusService.changeAccountStatus(userId, accountStatus);
		HttpServletResponse response = ServletActionContext.getResponse();
		accounts=getAccountsService.getAccounts();
		response.setContentType("application/json");
		response.getWriter().print(new Gson().toJson(accounts));
	}
}
