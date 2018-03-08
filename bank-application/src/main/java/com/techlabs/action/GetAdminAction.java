package com.techlabs.action;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import com.google.gson.Gson;
import com.techlabs.entity.Account;

public class GetAdminAction implements SessionAware
{
	private String admin;
	private Map<String, Object> session;
	
	public GetAdminAction() {
		System.out.println("Get Accounts Action()");
		
	}

	public void execute() throws IOException  {
		HttpServletResponse response = ServletActionContext.getResponse();
		admin=((Account) session.get("account")).getUserId();
		response.setContentType("application/json");
		response.getWriter().print(new Gson().toJson(admin));
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
}
