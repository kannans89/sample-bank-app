package com.techlabs.dao;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.entity.Account;
import com.techlabs.entity.BankTransaction;

@Repository("bankTransactionDao")
public class BankTransactionDao {

	@Autowired
	private SessionFactory factory;
	private Session session;
	
	public BankTransactionDao() {
		System.out.println("BankTransaction Dao Constructor");
	}
	
	public void updateTransaction(BankTransaction bankTransaction) {
		session = factory.getCurrentSession();
		session.save(bankTransaction);
	}

	public Set<BankTransaction> getPassbook(String accountNo) {
		session=factory.openSession();
		Account account=(Account)session.get(Account.class, accountNo);
		session.close();
		return account.getBankTransaction();
	}
}
