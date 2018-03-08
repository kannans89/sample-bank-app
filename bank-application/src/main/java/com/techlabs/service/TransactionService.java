package com.techlabs.service;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.dao.AccountDao;
import com.techlabs.dao.BankTransactionDao;
import com.techlabs.entity.Account;
import com.techlabs.entity.BankTransaction;
@Service("transactionService")
public class TransactionService 
{
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private BankTransactionDao bankTransactionDao;
	private Account account;
	private BankTransaction bankTransaction;
	
	public TransactionService() {
		System.out.println("Transaction service constructor");
	}
	public boolean checkBalance(double amount) {
		account=accountDao.getAccount();
		if(account.getBalance()-amount>=1000)
			return true;
		else
		return false;
	}
	@Transactional
	public void withdraw(double amount) {
		account.setBalance(account.getBalance()-amount);
		bankTransaction=new BankTransaction(UUID.randomUUID().toString().replace("-", ""), 
				account, amount, "WITHDRAW", new Date(System.currentTimeMillis()),new Time(System.currentTimeMillis()));
		accountDao.updateAccount(account);
		bankTransactionDao.updateTransaction(bankTransaction);
	}
	@Transactional
	public void deposit(double amount) {
		account=accountDao.getAccount();
		account.setBalance(account.getBalance()+amount);
		bankTransaction=new BankTransaction(UUID.randomUUID().toString().replace("-", ""), 
				account, amount, "DEPOSITE", new Date(System.currentTimeMillis()),new Time(System.currentTimeMillis()));
		accountDao.updateAccount(account);
		bankTransactionDao.updateTransaction(bankTransaction);
	}
}
