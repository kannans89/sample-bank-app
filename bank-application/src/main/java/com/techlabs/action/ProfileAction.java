package com.techlabs.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.entity.Account;
import com.techlabs.service.HomeService;
import com.techlabs.viewmodel.ProfileViewModel;

@SuppressWarnings("serial")
public class ProfileAction extends ActionSupport implements ModelDriven<ProfileViewModel>,SessionAware
{

	@Autowired
	private HomeService homeService;
	private Map<String,Object> session;
	private ProfileViewModel profileViewModel;
	
	@Override
	public ProfileViewModel getModel() {
		profileViewModel=new ProfileViewModel();
		return profileViewModel;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	@Override
	public String execute() {
		if(session.get("editProfile")!=null) {
			addActionMessage("Your Profile Updated Successfully");
			session.remove("editProfile");
		}
		
		if(session.get("changePassword")!=null) {
			addActionMessage("Your Password Reset Successfully...!!! Your Login Crediantials "
					+ "are sent on your Email..Please check..!!!");
			session.remove("changePassword");
		}
		
		profileViewModel.setAccount((Account) session.get("account"));
		profileViewModel.setBase64EncodedImage(homeService.getBase64EncodedImage());
		return "success";
	}
}
