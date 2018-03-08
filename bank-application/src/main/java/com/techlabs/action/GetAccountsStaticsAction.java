package com.techlabs.action;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.techlabs.dto.AccountStaticsDto;
import com.techlabs.service.GetAccountsStaticsService;

public class GetAccountsStaticsAction 
{
	@Autowired
	private GetAccountsStaticsService staticService;
	private AccountStaticsDto statics;
	private String sortBy;
	
	public GetAccountsStaticsAction() {
		System.out.println("Statics Action()");
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
		System.out.println("sort by: "+sortBy);
	}
	
	public void execute() throws IOException  {
		if(sortBy.equalsIgnoreCase("Last Week")) 
			statics=staticService.getAccountStaticsOfLastWeek();
		else if(sortBy.equalsIgnoreCase("Last Month"))
			statics=staticService.getAccountStaticsOfLastMonth();
		else if(sortBy.equalsIgnoreCase("Last Year"))
			statics=staticService.getAccountStaticsOfLastYear();
		else
			statics=staticService.getAccountStaticsOfDefault();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.getWriter().print(new Gson().toJson(statics));
	}
}
