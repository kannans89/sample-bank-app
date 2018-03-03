package com.techlabs.services;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.dao.BankDao;
import com.techlabs.entity.Account;
import com.techlabs.entity.BankTransaction;
import com.techlabs.entity.LoginDetails;
import com.techlabs.entity.Role;
import com.techlabs.entity.Status;
import com.techlabs.entity.TransactionType;
import com.techlabs.entity.User;

@Service
public class BankServices {

	@Autowired
	private BankDao bankDao;

	@Autowired
	private MailService mailSSL;

	@Autowired
	private DateTime dateTime;

	public BankServices() {
		System.out.println("bankService-constr");
	}

	@Transactional
	public void registeration(User user) throws AddressException, MessagingException {

		BankTransaction bankTransaction = new BankTransaction(1000.0, TransactionType.DEPOSITE, dateTime.getDate(),
				dateTime.getTime(), user.getAccount());

		bankDao.addNewAccount(user);
		bankDao.addTransactionDetails(bankTransaction);

		String msg = "Welcome to bank of india... " + "userId: " + user.getUserId() + "  password: "
				+ user.getPassword();

		mailSSL.sendMail(user.getAccount().getEmailId(), msg);
	}

	public boolean isValidUser(String userId, String password) {

		return bankDao.getUserRole(userId, password) != null;
	}

	public Role getUserRole(String userId, String password) {

		return bankDao.getUserRole(userId, password);
	}

	public Account getAccount(String userId) {
		return bankDao.getUserDetails(userId);
	}

	public void updateAccount(Account account, Account editAccount) {

		account.setFirstName(editAccount.getFirstName());
		account.setLastName(editAccount.getLastName());
		account.setMiddleName(editAccount.getMiddleName());

		account.setPanNo(editAccount.getPanNo());
		account.setMobileNo(editAccount.getMobileNo());

		account.setAadharNo(editAccount.getAadharNo());
		account.getAddress().setStreet(editAccount.getAddress().getStreet());
		account.getAddress().setCity(editAccount.getAddress().getCity());
		account.getAddress().setState(editAccount.getAddress().getState());

		account.getAddress().setDistrict(editAccount.getAddress().getDistrict());
		account.getAddress().setZipcode(editAccount.getAddress().getZipcode());

		bankDao.updateAccount(account);
	}

	@SuppressWarnings("rawtypes")
	public List getTransactionForCSV(Account account) {
		ArrayList<String> transactionEntry = new ArrayList<String>();
		transactionEntry.add("trns Id,Amount,Date,Time,Type");

		for (BankTransaction tr : bankDao.getTransactionDetails(account)) {
			transactionEntry.add(tr.getTransId() + "," + tr.getAmount() + "," + tr.getDate() + "," + tr.getTime() + ","
					+ tr.getType());
		}
		return transactionEntry;
	}

	public boolean transactionOperation(double amount, TransactionType type, Account account) {
		return bankDao.transactionOperation(amount, type, account);
	}

	public boolean genrateNewPassword(String email, String userId) throws AddressException, MessagingException {
		return bankDao.genrateNewPassword(email, userId);
	}

	@SuppressWarnings("rawtypes")
	public List getTransactions(Account account) {
		return bankDao.getTransactionDetails(account);
	}

	public boolean isAvailableToLogin(String userId) {
		if (bankDao.isAvailableToLogin(userId) == Status.ENABLE) {
			return true;
		}
		return false;
	}

	public void addLoginDetails(String userId, String password, boolean loginSucess) {
		dateTime.getDate();
		LoginDetails loginDetails = new LoginDetails(dateTime.getDate(), dateTime.getTime(), userId, loginSucess);
		bankDao.addLoginDetails(loginDetails);
	}

	public void updateFailLoginAttemps(String userId, boolean loginSuccess) {
		bankDao.updateFailLoginAttemps(userId, loginSuccess);
	}

	public boolean isuserIdValid(String userId) {
		System.out.println("#####-isuserIdValid");
		return bankDao.isUserIdValid(userId);
	}

}
