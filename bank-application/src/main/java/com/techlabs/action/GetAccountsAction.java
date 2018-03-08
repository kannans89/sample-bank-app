package com.techlabs.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.gson.Gson;
import com.techlabs.dto.AccountDto;
import com.techlabs.service.GetAccountsService;

public class GetAccountsAction
{
	@Autowired
	private GetAccountsService getAccountsService;
	private List<AccountDto> accounts;

	public GetAccountsAction() {
		System.out.println("Get Accounts Action()");
		
	}

	public void execute() throws IOException  {
		HttpServletResponse response = ServletActionContext.getResponse();
		accounts=getAccountsService.getAccounts();
		response.setContentType("application/json");
		response.getWriter().print(new Gson().toJson(accounts));
	}
}
