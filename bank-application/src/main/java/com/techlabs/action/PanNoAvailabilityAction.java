package com.techlabs.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.service.PanNoAvailabilityService;

@SuppressWarnings("serial")
public class PanNoAvailabilityAction extends ActionSupport
{
	@Autowired
	private PanNoAvailabilityService panNoAvailabilityService;
	private String panNo;
	private InputStream stream;
	
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
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
		if((panNo.toString().length()==10))
		{
			if (!panNoAvailabilityService.isPanNoAvailable(panNo)) {
				msg = "This PAN number is exists...!!! Try another PAN number...!!! ";
				stream = new ByteArrayInputStream(msg.getBytes());
				System.out.println("Action...PAN Not Available");
			} else {
				msg = "Available";
				stream = new ByteArrayInputStream(msg.getBytes());
				System.out.println("Action...PAN Available");
			}
		}
		else {
			msg="Please Enter PAN...!!!";
			stream = new ByteArrayInputStream(msg.getBytes());
		}
		return SUCCESS;
	}
}
