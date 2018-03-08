package com.techlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.dao.AccountDao;
import com.techlabs.entity.Account;

@Service("forgotPasswordService")
public class ForgotPasswordService {
	
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private SendEmailService sendEmail;
	@Transactional
	public boolean forgotPassword(String accountNo,String email)
	{
		if(accountDao.forgotPassword(accountNo, email))
		{
			Account account=accountDao.getAccount();
			String subject="Forgot Password";
			String body="\n Dear "+account.getFirstName()+",\n Your login crediantials are as follows\n UserId:"
									+account.getUserId()+"\n Password :"+account.getPassword()+"\n Thank you";
			sendEmail.sendEmail(email, subject, body);
			return true;
		}
		else return false;
	}
}
