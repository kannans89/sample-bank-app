package com.techlabs.action;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.entity.Account;
import com.techlabs.services.BankServices;
import com.techlabs.vm.PassbookVM;

public class PassbookAction extends ActionSupport implements SessionAware, ModelDriven<PassbookVM> {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private PassbookVM passbookVM;

	@Autowired
	private BankServices bankServices;

	@SuppressWarnings("rawtypes")
	@Override
	public String execute() throws Exception {
		
		Account account=(Account) session.get("user");

		passbookVM.setAccount(account);
		passbookVM.setFileName(
				passbookVM.getAccount().getAccNo().substring(0, 9) + "XXXXXXXXXXXXXXXXXXXXXXX_passbook.csv");

		if (passbookVM.isPostBack()) {

			System.out.println("in post");

			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/csv");
			response.setHeader("Content-disposition", "attachment;filename=" + passbookVM.getFileName());
			ServletOutputStream out = response.getOutputStream();

			for (Iterator iterator = bankServices.getTransactionForCSV(passbookVM.getAccount()).iterator(); iterator
					.hasNext();) {
				String outputString = (String) iterator.next();
				System.out.println(outputString);

				out.println();
				out.print(outputString);

			}
			response.flushBuffer();
			out.flush();

		}
		
		passbookVM.setTransactions(bankServices.getTransactions(account));

		return "none";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	@Override
	public PassbookVM getModel() {
		passbookVM = new PassbookVM();
		return passbookVM;
	}

}
