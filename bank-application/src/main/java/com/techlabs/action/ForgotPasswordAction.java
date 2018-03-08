package com.techlabs.action;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.service.ForgotPasswordService;
import com.techlabs.viewmodel.ForgotPasswordViewModel;

@SuppressWarnings("serial")
public class ForgotPasswordAction extends ActionSupport implements 
								SessionAware,ModelDriven<ForgotPasswordViewModel>
{
	@Autowired
	private ForgotPasswordService forgotPasswordService;
	private ForgotPasswordViewModel forgotPasswordVM;
	private Map<String, Object> session;
	
	@Override
	public ForgotPasswordViewModel getModel() {
		forgotPasswordVM=new ForgotPasswordViewModel();
		return forgotPasswordVM;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	@Override
	public String execute()
	{
		if(!forgotPasswordVM.isPostBack())
			return Action.NONE;
		else {
			if(forgotPasswordService.forgotPassword(forgotPasswordVM.getAccountNo(), 
												forgotPasswordVM.getEmail())) {
				session.put("forgotPassword", "Password recovered..");
				return "success";
			}
			else {
				addActionError("Incorrect Account Number or Email");
				return Action.NONE;
			}
		}
	}
	@Override
	public void validate() {  
		if(forgotPasswordVM.isPostBack()) {
			System.out.println("validate here");
			if(forgotPasswordVM.getAccountNo().equals(""))
				addFieldError("accountNo","Account Number Should not blank");
			
			if(forgotPasswordVM.getEmail().equals(""))
				addFieldError("email","Email should not Blank"); 
			else {
				   String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	               CharSequence inputStr = forgotPasswordVM.getEmail();
	               Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
	               Matcher matcher = pattern.matcher(inputStr);
	               if(!matcher.matches())
	                   addFieldError("email","Invalid email address");
			}
		}
	}
}
