package com.techlabs.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.action.AdminHomeVM;
import com.techlabs.action.AdminPassbookVM;
import com.techlabs.dao.BankDao;
import com.techlabs.entity.Account;
import com.techlabs.entity.BankTransaction;
import com.techlabs.entity.Role;
import com.techlabs.entity.User;

@Service
public class AdminServices {

	@Autowired
	private BankDao bankDao;
	
	@Autowired
	private MailService mailService;

	public List<AdminHomeVM> getUsersDetails() {
		List<User> users = bankDao.getUsersDetails();
		System.out.println(users.size());
		List<AdminHomeVM> userList = new ArrayList<AdminHomeVM>();

		for (User user : users) {
			if (user.getRole() == Role.CUSTMORE) {
				List transactions = bankDao.getTransactionDetails(user.getAccount());
				userList.add(new AdminHomeVM(user.getUserId(), user.getStatus(), user.getPassword(), user.getRole(),
						user.getAccount(), transactions));
			}
		}
		System.out.println(userList.size());
		return userList;
	}

	public void changeUserStatus(String userId) {
		bankDao.adminChangeUserStatus(userId);
	}

	public List<BankTransaction> getUserTransactions(String userId) {
		return bankDao.getTransactionDetails(bankDao.getUserDetails(userId));
	}

	public void sendPromotionalEmail(List<String> list) throws AddressException, MessagingException {
		String msg="this is the promtioanl email address";
		for (String item : list) {
			Account account = bankDao.getUserDetails(item);
			mailService.sendMail(account.getEmailId(), account.getFirstName()+", "+msg);
		}
	}
	
	public List getStatics(List dateList){
		
		 Date fromDate=Date.valueOf(((String) dateList.get(0)).substring(0, 10));  
	     System.out.println("Date is: "+fromDate);  
	     
		 Date toDate=Date.valueOf(((String) dateList.get(1)).substring(0, 10));  
	     System.out.println("Date is: "+toDate);  
		
		return bankDao.getStatics(fromDate, toDate);
	}

}
