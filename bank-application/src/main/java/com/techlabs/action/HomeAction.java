package com.techlabs.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.entity.Account;
import com.techlabs.service.HomeService;
import com.techlabs.viewmodel.HomeViewModel;

public class HomeAction implements Action,SessionAware,ModelDriven<HomeViewModel>
{
	@Autowired
	private HomeService homeService;
	private Map<String,Object> session;
	private HomeViewModel homeVM;
	
	@Override
	public HomeViewModel getModel() {
		homeVM=new HomeViewModel();
		return homeVM;
	}
	
	@Override
	public String execute() throws Exception {
		Account account=(Account) session.get("account");
		homeVM.setAccount(account);
		homeVM.setBase64EncodedImage(homeService.getBase64EncodedImage());
		return Action.SUCCESS;  
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
}
