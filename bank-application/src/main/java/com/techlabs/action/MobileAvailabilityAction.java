package com.techlabs.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.service.MobileAvailabilityService;

@SuppressWarnings("serial")
public class MobileAvailabilityAction extends ActionSupport
{
	@Autowired
	private MobileAvailabilityService mobileAvailabilityService;
	private Long mobile;
	private InputStream stream;
	
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
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
		if((mobile.toString().length()==10))
		{
			if (!mobileAvailabilityService.isMobileAvailable(mobile)) {
				msg = "This Mobile number is exists...!!! Try another mobile number...!!! ";
				stream = new ByteArrayInputStream(msg.getBytes());
				System.out.println("Action...Mobile Not Available");
			} else {
				msg = "Available";
				stream = new ByteArrayInputStream(msg.getBytes());
				System.out.println("Action...Mobile Available");
			}
		}
		else {
			msg="Please Enter Mobile...!!!";
			stream = new ByteArrayInputStream(msg.getBytes());
		}
		return SUCCESS;
	}
}
