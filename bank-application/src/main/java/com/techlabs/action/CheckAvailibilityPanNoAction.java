package com.techlabs.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.techlabs.services.CheckAvailableService;

public class CheckAvailibilityPanNoAction {

	private String panNo;
	
	@Autowired
	private CheckAvailableService checkAvailableService;
	
	public void execute() throws IOException  {
		System.out.println("in checkAvialibilty");
		String msg = "not available";
		if(checkAvailableService.checkPanNoAvailable(panNo)){
			msg="available";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write(msg);	
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
}
