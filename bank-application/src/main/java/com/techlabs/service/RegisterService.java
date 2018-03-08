package com.techlabs.service;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.techlabs.entity.*;
import com.techlabs.dao.AccountDao;
import com.techlabs.dao.BankTransactionDao;
import com.techlabs.dao.UserDao;

@Service("registerService")
public class RegisterService 
{
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private BankTransactionDao bankTransactionDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private GenerateIdPasswordService generateIdPasswordService;
	@Autowired
	private SendEmailService sendEmailService;
	
	public RegisterService() {
		System.out.println("In register service");
	}
	
	@Transactional
	public void registerUser(String firstName,String middleName,String lastName,String email,Long 
				mobile,String address,Long aadharNo,String panNo, byte[] userImage)
	{
		String accountNo=UUID.randomUUID().toString().replace("-", "");
		String password=generateIdPasswordService.generatePassword();
		String userId=generateIdPasswordService.generateUserId();
		Date date = new Date(System.currentTimeMillis());
		Time time=new Time(System.currentTimeMillis());
		
		Account account=new Account(firstName, middleName, lastName, mobile, email, address, aadharNo, 
				panNo, userImage,userId, password, 1000, accountNo,"Active",0,date,time);
		String transactionId=UUID.randomUUID().toString().replace("-", "");
		String transactionType="DEPOSITE";
		BankTransaction bankTransaction = new BankTransaction(transactionId,account,1000,transactionType,date,time);
		account.getBankTransaction().add(bankTransaction);
		User user=new User("C",account);
				
		accountDao.createAccount(account);
		bankTransactionDao.updateTransaction(bankTransaction);
		userDao.createUser(user);
		String subject="Welcome,Enjoy Santy's Bank";
		String body="Hii "+firstName+",\n I’m so glad you decided to try out Santy's Bank. "
          		+ "\n Your login crediantials are as follows\n UserId:"+userId+"\n Password :"+password+"\n Thank you";
		sendEmailService.sendEmail(email,subject,body);
	}
}
