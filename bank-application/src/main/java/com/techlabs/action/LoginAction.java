package com.techlabs.action;

import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.service.LoginService;
import com.techlabs.viewmodel.LoginViewModel;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements SessionAware,
								ModelDriven<LoginViewModel>
{
	@Autowired
	private LoginService loginService;
	private Map<String, Object> session;
	private LoginViewModel loginVM;
	
	public LoginAction() {
		System.out.println("Login action constructor");
	}
	@Override
	public LoginViewModel getModel() {
		loginVM=new LoginViewModel();
		return loginVM;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("Login Action Execute ");
		
		if(!loginVM.isPostBack()) {
			if(session.get("register")!=null)
				addActionMessage("You are registered successfully...!!! "
						+ "Your Login Crediantils sent on your registered email...Please check..!!!");
			if(session.get("forgotPassword")!=null)
				addActionMessage("Password recovered Successfully...Your Login Crediantils are sent on your email...Please check..!!!");
			return Action.NONE;
		}
		
		else {
			if(loginService.isUserActive(loginVM.getUserId()))
			{
				if(loginService.validateUser(loginVM.getUserId(), loginVM.getPassword())) {  
				  session.put("account", loginService.getAccount());
				  ServletActionContext.getRequest().getSession().setAttribute("userName", loginService.getAccount().getFirstName());
				  if(loginService.isAdmin(loginService.getAccount()))
					  return "ADMIN";
				  else return SUCCESS;  
				}  
				else {
					if(loginService.checkLoginAttempts(loginVM.getUserId())) {
						loginService.updateLoginAttempts(loginVM.getUserId());
					}
					else {
						loginService.deactivateUser(loginVM.getUserId());
						addActionError("You crossed 4 attempt...Your account has been locked..."
								+ "Please co-ordinate with your bank manager..!!!");
					}
					
					addActionError("Username and password are incorrect");
					return Action.ERROR; 
				}
			}
			else {
				addActionError("Either Your Account has been blocked or user Id does not exits...!!!"
						+ " Please contact to your Branch...!!!");
				return Action.ERROR;
			}
			
		}
	}
	public String logout() {
		session.clear();
		addActionMessage("You are logged out successfully...!!! ");
		 return Action.SUCCESS;  
	}
	
	@Override
	public void validate() {  
		if(loginVM.isPostBack()) {
			System.out.println("validate here");
			if(loginVM.getUserId().equals(""))
				addFieldError("userId","User Id should not Blank"); 
			if(loginVM.getPassword().equals(""))
				addFieldError("password","Password should not Blank"); 
		}
	}
}
