package com.techlabs.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.entity.Account;
import com.techlabs.entity.Role;
import com.techlabs.services.BankServices;
import com.techlabs.vm.LoginVM;

public class LoginAction extends ActionSupport implements SessionAware, ModelDriven<LoginVM> {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private LoginVM loginVM;

	@Autowired
	private BankServices bankServices;

	public LoginAction() {
		System.out.println("LoginAction-constr");
	}

	@Override
	public String execute() throws Exception {

		if (loginVM.isLoginPostBack()) {
			
			if (!bankServices.isAvailableToLogin(loginVM.getUserId())) {
				loginVM.setLoginErrorMsg("This account is disabled");
				return INPUT;
			}

			System.out.println("loginPostBack");

			boolean isValidUser = bankServices.isValidUser(loginVM.getUserId(), loginVM.getPassword());
			if (!isValidUser) {
				loginVM.setLoginErrorMsg("wrong userId or Password");
				
				bankServices.addLoginDetails(loginVM.getUserId(), loginVM.getPassword(), false);
				if(!bankServices.isuserIdValid(loginVM.getUserId()))
				bankServices.updateFailLoginAttemps(loginVM.getUserId(),false);

				return INPUT;
			} else {
				Account account = bankServices.getAccount(loginVM.getUserId());
				if(!bankServices.isuserIdValid(loginVM.getUserId()))
				bankServices.updateFailLoginAttemps(loginVM.getUserId(),true);
				session.put("user", account);
				bankServices.addLoginDetails(loginVM.getUserId(), loginVM.getPassword(), true);
				Role role=bankServices.getUserRole(loginVM.getUserId(), loginVM.getPassword());
				if (role == Role.CUSTMORE) {
					return "customerPage";
				}

				else if (role == Role.ADMIN) {
					return "adminPage";
				}
			}
		}

		return INPUT;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		System.out.println("setSession");
	}

	@Override
	public LoginVM getModel() {
		loginVM = new LoginVM();
		return loginVM;
	}

}
