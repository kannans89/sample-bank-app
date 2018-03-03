package com.techlabs.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.entity.Account;
import com.techlabs.services.BankServices;
import com.techlabs.vm.ProfileVM;

public class ProfileAction extends ActionSupport implements SessionAware, ModelDriven<ProfileVM> {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private ProfileVM profileVM;

	@Autowired
	private BankServices bankServices;

	@Override
	public String execute() throws Exception {
		profileVM.setReadOnly(true);
		if (profileVM.isEditFlag()) {
			profileVM.setReadOnly(false);
		}

		if (profileVM.isProfilePostBack()) {

			System.out.println("in prfoileileaction post");
			bankServices.updateAccount(((Account) session.get("user")), profileVM.getAccount());

			return SUCCESS;
		}
		profileVM.setAccount((Account) session.get("user"));
		
		return "show";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public ProfileVM getModel() {
		profileVM = new ProfileVM();
		return profileVM;
	}

}
