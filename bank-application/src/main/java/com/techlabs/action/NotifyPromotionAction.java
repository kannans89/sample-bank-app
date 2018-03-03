package com.techlabs.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.services.AdminServices;

public class NotifyPromotionAction extends ActionSupport{

	private String checkedList;
	@Autowired
	private AdminServices adminServices;
	
	@Override
	public String execute() throws Exception {
		System.out.println("NotifyPromotionAction");
		System.out.println(checkedList);
	
	    Gson gsonReceiver = new Gson();
	    List list = gsonReceiver.fromJson(checkedList, List.class);
	    System.out.println(list);
	    
	    adminServices.sendPromotionalEmail(list);

		return SUCCESS;
	}

	public String getCheckedList() {
		return checkedList;
	}

	public void setCheckedList(String checkedList) {
		this.checkedList = checkedList;
	}

	
	
}
