package com.techlabs.action;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.entity.Account;
import com.techlabs.service.EditProfileService;
import com.techlabs.viewmodel.EditProfileViewModel;

@SuppressWarnings("serial")
public class EditProfileAction extends ActionSupport implements SessionAware,ModelDriven<EditProfileViewModel>
{
	@Autowired
	private EditProfileService editProfileService;
	private Map<String,Object> session;
	private EditProfileViewModel editProfileViewModel;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	@Override
	public EditProfileViewModel getModel() {
		editProfileViewModel=new EditProfileViewModel();
		return editProfileViewModel;
	}

	@Override
	public String execute() {
		Account account=(Account) session.get("account");
		if(!editProfileViewModel.isPostBack()) {
			editProfileViewModel.setAccount(account);
			return "none";
		}
		else {
			System.out.println("Post call");
			account.setFirstName(editProfileViewModel.getAccount().getFirstName());
			account.setMiddleName(editProfileViewModel.getAccount().getMiddleName());
			account.setLastName(editProfileViewModel.getAccount().getLastName());
			account.setEmail(editProfileViewModel.getAccount().getEmail());
			account.setMobile(editProfileViewModel.getAccount().getMobile());
			account.setAddress(editProfileViewModel.getAccount().getAddress());
			account.setAadharNo(editProfileViewModel.getAccount().getAadharNo());
			account.setPanNo(editProfileViewModel.getAccount().getPanNo());
			editProfileService.updateProfile(account);
			session.put("editProfile", "Your Profile updated successfully");
			return "success";
		}
	}
	
	@Override
	public void validate() {  
		if(editProfileViewModel.isPostBack()) {
			System.out.println("validate here");
			if(editProfileViewModel.getAccount().getFirstName().equals(""))
				addFieldError("account.firstName","First Name should not Blank"); 
			if(editProfileViewModel.getAccount().getMiddleName().equals(""))
				addFieldError("account.middleName","Middle Name should not Blank"); 
			if(editProfileViewModel.getAccount().getLastName().equals(""))
				addFieldError("account.lastName","Last Name should not Blank"); 
			if(editProfileViewModel.getAccount().getEmail().equals(""))
				addFieldError("account.email","Email should not Blank"); 
			else {
				   String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	               CharSequence inputStr = editProfileViewModel.getAccount().getEmail();
	               Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
	               Matcher matcher = pattern.matcher(inputStr);
	               if(!matcher.matches())
	                   addFieldError("account.email","Invalid email address");
			}
			if(editProfileViewModel.getAccount().getMobile().toString().length()<10||
					editProfileViewModel.getAccount().getMobile().toString().length()>10)
				addFieldError("account.mobile","Mobile should be 10 digit"); 
			if(editProfileViewModel.getAccount().getAddress().equals(""))
				addFieldError("account.address","Address should not Blank"); 
			if(editProfileViewModel.getAccount().getAadharNo().toString().length()<12||
					editProfileViewModel.getAccount().getAadharNo().toString().length()>12)
				addFieldError("account.aadharNo","Aadhar Number should be 12 digit"); 
			if(editProfileViewModel.getAccount().getPanNo().toString().length()<10||
					editProfileViewModel.getAccount().getPanNo().toString().length()>10)
				addFieldError("account.panNo","PAN Number should be 10 digit"); 
		}
	}
}
