package com.techlabs.action;

import java.sql.Date;
import java.text.DateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.services.AdminServices;

public class AdminStaticsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
    private String dates;
    @Autowired
    private AdminServices adminServices;
    
    private List<String> staticsDetails;
	
	@Override
	public String execute() throws Exception {
		System.out.println("AdminStaticsAction-execute");
		System.out.println("dates- "+dates);
		
		 Gson gsonReceiver = new Gson();
		 List dateList = gsonReceiver.fromJson(dates, List.class);
		 System.out.println(dateList);

		 staticsDetails=adminServices.getStatics(dateList);
		 System.out.println(staticsDetails);
		
		return SUCCESS;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public List<String> getStaticsDetails() {
		return staticsDetails;
	}
	

}
