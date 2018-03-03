package com.techlabs.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.services.BankServices;
import com.techlabs.vm.ForgetPasswordVM;

public class ForgetPasswordAction extends ActionSupport implements ModelDriven<ForgetPasswordVM> {

	private static final long serialVersionUID = 1L;
	private ForgetPasswordVM forgetPasswordVM;

	@Autowired
	private BankServices bankServices;

	public ForgetPasswordAction() {

		System.out.println("ForgetPasswordAction");
	}

	@Override
	public String execute() throws Exception {
		if (forgetPasswordVM.isPostBack()) {
			bankServices.genrateNewPassword(forgetPasswordVM.getEmail(), forgetPasswordVM.getUserId());
			return SUCCESS;
		}

		return INPUT;
	}

	@Override
	public ForgetPasswordVM getModel() {
		forgetPasswordVM = new ForgetPasswordVM();
		return forgetPasswordVM;
	}

}
