package com.techlabs.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.services.AdminServices;

public class ChangeStatusAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	   private AdminServices adminServices;
	
	private String userId;

	private boolean postBack;
	
	@Override
	public String execute() throws Exception {
		System.out.println("in changestatus action******************************"+postBack);
		if(postBack) {
			postBack=false;
			return INPUT;
		}

		adminServices.changeUserStatus(userId);	
		return INPUT;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isPostBack() {
		return postBack;
	}

	public void setPostBack(boolean postBack) {
		this.postBack = postBack;
	}
	
	

	

}
