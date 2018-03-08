package com.techlabs.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.service.EmailAvailabilityService;

@SuppressWarnings("serial")
public class EmailAvailabilityAction extends ActionSupport
{
	@Autowired
	private EmailAvailabilityService emailAvailabilityService;
	private String email;
	private InputStream stream;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public InputStream getStream() {
		return stream;
	}
	public void setStream(InputStream stream) {
		this.stream = stream;
	}
	
	@Override
	public String execute() throws Exception {
		String msg;
		System.out.println("Execute function ");
		if(!email.equals(""))
		{
			if (!emailAvailabilityService.isEmailAvailable(email)) {
				msg = "This email is exists...!!! Try another email...!!! ";
				stream = new ByteArrayInputStream(msg.getBytes());
				System.out.println("Action...email Not Available");
			} else {
				msg = "Available";
				stream = new ByteArrayInputStream(msg.getBytes());
				System.out.println("Action...email Available");
			}
		}
		else {
			msg="Please Enter Email...!!!";
			stream = new ByteArrayInputStream(msg.getBytes());
		}
		return SUCCESS;
	}
}
