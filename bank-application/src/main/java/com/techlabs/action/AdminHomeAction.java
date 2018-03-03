package com.techlabs.action;

import java.util.List;
import java.util.Map;


import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.services.AdminServices;

public class AdminHomeAction extends ActionSupport 
							implements  SessionAware {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
    private List<AdminHomeVM> list;

@Autowired
   private AdminServices adminServices;
	
	
	@Override
	public String execute() throws Exception {
		System.out.println("AdminHomeAction");
		list=adminServices.getUsersDetails();
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	public List<AdminHomeVM> getList() {
		return list;
	}

	public void setList(List<AdminHomeVM> list) {
		this.list = list;
	}

}
