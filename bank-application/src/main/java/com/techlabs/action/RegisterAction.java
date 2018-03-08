package com.techlabs.action;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import cn.apiclub.captcha.Captcha;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.service.RegisterService;
import com.techlabs.viewmodel.RegisterViewModel;

@SuppressWarnings("serial")
public class RegisterAction extends ActionSupport implements SessionAware,ModelDriven<RegisterViewModel>
{
	private Map<String, Object> session;
	private RegisterViewModel registerVM;
	@Autowired
	private RegisterService registerService;
	
	@Override
	public RegisterViewModel getModel() {
		registerVM=new RegisterViewModel();
		return registerVM;
	}
	
	@Override
	public String execute() throws Exception {
	
		System.out.println("Register action execute: "+registerVM.isPostBack());
		if(!registerVM.isPostBack()) {
			System.out.println("register action get execute ");
			return Action.NONE;  
		}
		else {
			System.out.println("register action post execute ");
			
			Captcha captcha=(Captcha)session.get(Captcha.NAME);
			if(!captcha.isCorrect(registerVM.getCaptchaAnswer())) {
				addFieldError("captchaAnswer", "Invalid Captcha");
				return INPUT;
			}
			
			registerService.registerUser(registerVM.getFirstName(),registerVM.getMiddleName(),registerVM.getLastName(),
					registerVM.getEmail(),registerVM.getMobile(),registerVM.getAddress(),registerVM.getAadharNo(),
					registerVM.getPanNo(),registerVM.getByteImage());
			
			System.out.println("in file upload/ username:"+registerVM.getFirstName());
			session.put("register", "Registered");
			return Action.SUCCESS;  
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	@Override
	public void validate() {  
		if(registerVM.isPostBack()) {
			System.out.println("validate here");
			if(registerVM.getFirstName().equals(""))
				addFieldError("firstName","First Name should not Blank"); 
			if(registerVM.getMiddleName().equals(""))
				addFieldError("middleName","Middle Name should not Blank"); 
			if(registerVM.getLastName().equals(""))
				addFieldError("lastName","Last Name should not Blank"); 
			if(registerVM.getEmail().equals(""))
				addFieldError("email","Email should not Blank"); 
			else {
				   String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	               CharSequence inputStr = registerVM.getEmail();
	               Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
	               Matcher matcher = pattern.matcher(inputStr);
	               if(!matcher.matches())
	                   addFieldError("email","Invalid email address");
			}
			if(registerVM.getMobile().toString().length()<10||registerVM.getMobile().toString().length()>10)
				addFieldError("mobile","Mobile Number should be of 10 digit"); 
			if(registerVM.getAddress().equals(""))
				addFieldError("address","Address should not Blank"); 
			if(registerVM.getAadharNo().toString().length()<12||registerVM.getAadharNo().toString().length()>12)
				addFieldError("aadharNo","Aadhar Number should be of 12 digit"); 
			if(registerVM.getPanNo().equals(""))
				addFieldError("panNo","PAN Number should not Blank"); 
			if(registerVM.getPanNo().length()<10||registerVM.getPanNo().length()>10)
				addFieldError("panNo","PAN Number should be 10 digit"); 
			//else if(registerVM.getUserImage().toString().equals(""))
			//	addFieldError("userImage","User Image should not Blank"); 
		}
	}
}
