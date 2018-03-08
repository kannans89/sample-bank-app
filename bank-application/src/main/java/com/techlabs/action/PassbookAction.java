package com.techlabs.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.entity.Account;
import com.techlabs.service.PassbookService;
import com.techlabs.viewmodel.PassbookViewModel;

@SuppressWarnings("serial")
public class PassbookAction extends ActionSupport implements ModelDriven<PassbookViewModel>,SessionAware
{
	@Autowired
	private PassbookService passbookService;
	private PassbookViewModel passbookVM;
	private Map<String,Object> session;
	
	@Override
	public PassbookViewModel getModel() {
		 passbookVM=new PassbookViewModel();
		return passbookVM;
	}
	
	@Override
	public String execute() throws IOException
	{	
		Account account=(Account) session.get("account");
		if(!passbookVM.isPostBack()) {
			System.out.println("get transaction from here");
			passbookVM.setBankTransactions(passbookService.getPassbook(account.getAccountNo()));
			return NONE;  
		}
		else {
			System.out.println("post download");
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/csv");
			String bookName=account.getAccountNo()+"Passbook.csv";
			response.setHeader("Content-disposition", "attachment;filename="+bookName);
			
			Iterator<String> iter = passbookService.getCsvData(account.getAccountNo()).iterator();
			while (iter.hasNext()) {
				String outputString = (String) iter.next();
				response.getOutputStream().println();
				response.getOutputStream().print(outputString);
			}
			response.getOutputStream().flush();
			
			return SUCCESS;  
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
}
