package com.techlabs.action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.entity.Account;
import com.techlabs.vm.HomeVM;

//import Decoder.BASE64Encoder;

public class HomeAction extends ActionSupport implements SessionAware, ModelDriven<HomeVM> {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private HomeVM homeVM;
	
	

	@Override
	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/csv");
		homeVM.setAccount((Account) session.get("user"));
		homeVM.setName(homeVM.getAccount().getImageName());

		byte data[] = homeVM.getAccount().getUserImage();
		//BASE64Encoder base64Encoder = new BASE64Encoder();
		StringBuilder imageString = new StringBuilder();
		imageString.append("data:image/png;base64,");
		//imageString.append(base64Encoder.encode(data));
		imageString.append(data);
		homeVM.setImage(imageString.toString());

		System.out.println(homeVM.getAccount().getBalance());
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public HomeVM getModel() {
		homeVM = new HomeVM();
		return homeVM;
	}

}
