package com.techlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.dao.AccountDao;
import com.techlabs.dto.AccountDto;

@Service("notificationService")
public class NotificationService {

	public NotificationService() {
		System.out.println("Notification Service");
	}
	
	@Autowired
	private GetAccountsService getAccountsService;
	@Autowired
	private SendEmailService sendEmailService;
	@Autowired
	private AccountDao accountDao;
	
	@Transactional
	public void sendNotificationToAllUsers() {
		for(AccountDto account:getAccountsService.getAccounts()) {
			sendEmailService.sendEmail(account.getEmail(), "Marketing Campaign", "Dear "+account.getFirstName()+",\nWe are so glad "
					+ "because you are using Santy's Bank."
					+ "\n\nHappiness is Times Points away.\nUpgrade to the Times Points Debit Card with easy online redemptions."
					+"Have you always wished that you could get discounts and benefits every time you spend? In that case, the Times Points Debit Card from Santy's Bank is just for you."
					+"With Times Points Debit Card you get minimum 10% discount on categories "
					+ "\n\n\n\nWarm regards,"
					+ "\nSantosh Sonmankar"
					+ "\nCountry Head - Merchant Acquiring Services & Marketing "
					+ "\n\nBank aapki mutthi mein... Bank at your fingertips...\nThank you");
		}
	}
	
	@Transactional
	public void sendNotificationToSpecificUser(String userId) {
		sendEmailService.sendEmail(accountDao.getEmail(userId), "Marketing Campaign", "Dear "+accountDao.getFirstName(userId)+",\nWe are so glad "
				+ "because you are using Santy's Bank."
				+ "\n\nHappiness is Times Points away.\nUpgrade to the Times Points Debit Card with easy online redemptions."
				+"Have you always wished that you could get discounts and benefits every time you spend? In that case, the Times Points Debit Card from Santy's Bank is just for you."
				+"With Times Points Debit Card you get minimum 10% discount on categories "
				+ "\n\n\n\nWarm regards,"
				+ "\nSantosh Sonmankar"
				+ "\nCountry Head - Merchant Acquiring Services & Marketing "
				+ "\n\nBank aapki mutthi mein... Bank at your fingertips...\nThank you");
	}
}
