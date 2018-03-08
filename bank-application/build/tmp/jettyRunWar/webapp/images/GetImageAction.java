package com.techlabs.action;

import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.Action;
import com.techlabs.entity.Account;

public class GetImageAction implements Action,SessionAware
{

	private Map<String,Object> session;
	
	@Override
	public String execute() throws Exception {
		Account account=(Account) session.get("account");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("image/jpg");
		response.getOutputStream().write(account.getProfileImage());
		response.getOutputStream().flush();
		return Action.SUCCESS;  
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
}
