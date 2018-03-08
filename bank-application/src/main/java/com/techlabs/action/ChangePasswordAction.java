package com.techlabs.action;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.service.ChangePasswordService;
import com.techlabs.viewmodel.ChangePasswordViewModel;

@SuppressWarnings("serial")
public class ChangePasswordAction extends ActionSupport implements ModelDriven<ChangePasswordViewModel>,SessionAware
{
	@Autowired
	private ChangePasswordService changePasswordService;
	private ChangePasswordViewModel changePasswordViewModel;
	private Map<String,Object> session;
	
	@Override
	public ChangePasswordViewModel getModel() {
		changePasswordViewModel=new ChangePasswordViewModel();
		return changePasswordViewModel;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	@Override
	public String execute()
	{
		if(!changePasswordViewModel.isPostBack()) {
			System.out.println("get in change");
			return "none";
		}
		else {
			System.out.println("post in change");
			if(changePasswordService.changePassword(changePasswordViewModel.getUserId(),
					changePasswordViewModel.getPassword(),changePasswordViewModel.getNewPassword()))
			{
				session.put("changePassword", "Password reset Successfully");
				return "success";
			}
			else {
				addActionError("Incorrect UserId or Password...!!!");
				return "none";
			}
		}
	}
	
	@Override
	public void validate() {  
		if(changePasswordViewModel.isPostBack()) {
			if(changePasswordViewModel.getUserId().equals("")) 
				addFieldError("userId","User Id should not Blank");  
			if(changePasswordViewModel.getPassword().equals("")) 
				addFieldError("password","Password should not Blank");
			
			if(changePasswordViewModel.getConfirmNewPassword().equals("")) 
				addFieldError("confirmNewPassword","Confirm New Password should not Blank");  
			if(!changePasswordViewModel.getNewPassword().equals(changePasswordViewModel.getConfirmNewPassword()))
				addFieldError("confirmNewPassword","New password not match");
			System.out.println("new old "+changePasswordViewModel.getNewPassword()+changePasswordViewModel.getConfirmNewPassword());
			if(changePasswordViewModel.getNewPassword().equals("")) 
				addFieldError("newPassword","New Password should not Blank");
			/*else {
				   //String  expression="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])$";//(?=/S+$).{8,}$";
				   String  expression="((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16})";
				   CharSequence inputStr = changePasswordViewModel.getNewPassword();
	               Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
	               Matcher matcher = pattern.matcher(inputStr);
	               if(!matcher.matches())
	                   addFieldError("newPassword","Password should alphanumeric");
			}*/
			
			if(changePasswordViewModel.getNewPassword().length()<6 || changePasswordViewModel.getNewPassword().length()>12) 
				addFieldError("newPassword","New Password should not less than 6 digit or more thane 12 digit");
		}
	}
}
