package com.techlabs.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.entity.Account;
import com.techlabs.service.LoginService;

@SuppressWarnings("serial")
public class AdminAction extends ActionSupport implements SessionAware
{
	@Autowired
	private LoginService loginService;
	private Map<String,Object> session;
	@Override
	public String execute() throws Exception {
		if(loginService.isAdmin((Account) session.get("account")))
			 return SUCCESS;
		else return "login";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
}
