package com.techlabs.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.service.AadharNoAvailabilityService;

@SuppressWarnings("serial")
public class AadharNoAvailabilityAction extends ActionSupport
{
	@Autowired
	private AadharNoAvailabilityService aadharNoAvailabilityService;
	private Long aadharNo;
	private InputStream stream;
	
	public Long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
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
		if((aadharNo.toString().length()==12))
		{
			if (!aadharNoAvailabilityService.isAadharNoAvailable(aadharNo)) {
				msg = "This Aadhar number is exists...!!! Try another Aadhar number...!!! ";
				stream = new ByteArrayInputStream(msg.getBytes());
				System.out.println("Action...AadharNo Not Available");
			} else {
				msg = "Available";
				stream = new ByteArrayInputStream(msg.getBytes());
				System.out.println("Action...AadharNo Available");
			}
		}
		else {
			msg="Please Enter AadharNo...!!!";
			stream = new ByteArrayInputStream(msg.getBytes());
		}
		return SUCCESS;
	}
}
