package com.techlabs.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.entity.Account;
import com.techlabs.entity.Address;
import com.techlabs.entity.Role;
import com.techlabs.entity.Status;
import com.techlabs.entity.User;
import com.techlabs.services.BankServices;
import com.techlabs.services.PasswordGenrator;
import com.techlabs.vm.RegisterVM;

import cn.apiclub.captcha.Captcha;

public class RegisterAction extends ActionSupport implements SessionAware, ModelDriven<RegisterVM> {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Map<String, Object> session;
	private RegisterVM registerVm;
	
	@Autowired
	private BankServices bankServices;

	@Override
	public String execute() {

		
		if (registerVm.isPostBack()) {
//
//			Captcha captcha = (Captcha) session.get(Captcha.NAME);
//			if (!captcha.isCorrect(registerVm.getCaptchaAnswer())) {
//				addFieldError("captchaAnswer", "INCORRECT_CAPTCHA");
//				return INPUT;
//			}

//			String filePath = ServletActionContext.getServletContext().getRealPath("/external/");
//			System.out.println(filePath);

			FileInputStream stream;
			try {
				stream = new FileInputStream(registerVm.getUserImage());
				registerVm.setByteImage(new byte[(int) registerVm.getUserImage().length()]);
				stream.read(registerVm.getByteImage());
				stream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			Address address = new Address(registerVm.getStreet(), registerVm.getCity(), registerVm.getDistrict(),
					registerVm.getState(), registerVm.getZipcode());
			Account account = new Account(1000.0, registerVm.getFirstName(), registerVm.getMiddleName(),
					registerVm.getLastName(), registerVm.getMobileNo(), registerVm.getEmailId(), registerVm.getPanNo(),
					registerVm.getAadharNo(), registerVm.getByteImage(), address, registerVm.getUserImageFileName(),Status.ENABLE);
			PasswordGenrator passwordGenrator = new PasswordGenrator();
			String password = passwordGenrator.createPassword();
			User user = new User(Role.CUSTMORE, password, account, 0, Status.ENABLE);

			System.out.println(user.getAccount().getAadharNo());

			try {
				bankServices.registeration(user);
			} catch (MessagingException e) {
				System.out.println("mail not send");
				return INPUT;
			}

			return "success";
		}
		return "input";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	@Override
	public RegisterVM getModel() {
		registerVm = new RegisterVM();
		return registerVm;
	}

	// @Override
	// public void validate() {
	// //if (postBack) {
	// if (firstName == null && firstName.trim().equals("")) {
	// addFieldError("firstName", "first Name is required");
	// }
	// if (lastName == null && lastName.trim().equals("")) {
	// addFieldError("lastName", "last Name is required");
	// }
	// if (middleName == null && middleName.trim().equals("")) {
	// addFieldError("middleName", "middle Name is required");
	// }
	//
	// if (mobileNo == 0 && postBack) {
	// addFieldError("mobile", "mobile no. is required");
	// }
	// if (emailId == null && emailId.trim().equals("")) {
	// addFieldError("emailId", "emailId is required");
	// }
	// if (panNo == null && panNo.trim().equals("")) {
	// addFieldError("panNo", "pan no. is required");
	// }
	// if (aadharNo == null && aadharNo.trim().equals("")) {
	// addFieldError("aadharNo", "aadhar no. is required");
	// }
	//
	// if (street == null && street.trim().equals("")) {
	// addFieldError("street", "street is required");
	// }
	// if (district == null && district.trim().equals("")) {
	// addFieldError("district", "first Name is required");
	// }
	// if (city == null && city.trim().equals("")) {
	// addFieldError("city", "city Name is required");
	// }
	//
	// if (state == null && state.trim().equals("")) {
	// addFieldError("state", "state Name is required");
	// }
	// if (zipcode == 0) {
	// addFieldError("zipcode", "zipcode is required");
	// }
	//
	// if (userImage == null) {
	// addActionError("image required");
	// }
	//
	// }
	//// }

}
