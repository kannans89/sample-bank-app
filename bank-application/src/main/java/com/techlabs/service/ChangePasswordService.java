package com.techlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.dao.AccountDao;
import com.techlabs.entity.Account;

@Service("changePasswordService")
public class ChangePasswordService 
{
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private SendEmailService sendEmail;
	
	public ChangePasswordService() {
		System.out.println("Change Password Service");
	}
	
	@Transactional
	public boolean changePassword(String userId,String password,String newPassword)
	{
		Account account=accountDao.getAccount();
		if(account.getUserId().equals(userId)&&account.getPassword().equals(password)) {
			account.setPassword(newPassword);
			accountDao.updateAccount(account);
			String subject="Change Password";
			String body="\n Dear "+account.getFirstName()+",You changed your password successfully...!!!\n Your login crediantials are as follows\n UserId:"
					+userId+"\n Password :"+newPassword+"\n Thank you";
			sendEmail.sendEmail(account.getEmail(), subject, body);
			return true;
		}
		else
			return false;
	}
}
