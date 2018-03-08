package com.techlabs.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.entity.Account;

@Repository("accountDao")
public class AccountDao 
{
	@Autowired
	private SessionFactory factory;
	private Session session;
	private Account account;
	
	public AccountDao() {
		System.out.println("Account Dao Constructor");
	}
	
	public void createAccount(Account account) {
		session = factory.getCurrentSession();
		session.save(account);
	}
	
	public void updateAccount(Account account) {
		session = factory.getCurrentSession();
		session.update(account);
	}
	
	@SuppressWarnings("rawtypes")
	public boolean validateUser(String userId, String password) {
		session=factory.getCurrentSession();
		Query query=session.createQuery("select a.accountNo from Account a where a.userId=:userId "
										+ "and a.password=:password");
		query.setParameter("userId", userId);
		query.setParameter("password", password);
		List accList=query.list();
		if(accList.isEmpty()) {
			return false;
		}
		else {
			String accountNo=(String) accList.get(0);
			account=(Account)session.get(Account.class,accountNo);
			if(account.getLoginAttempts()!=0)
				resetLoginAttempts(account);
			return true;
		}
	}
	
	public Account getAccount() {
		return account;
	}
	
	@SuppressWarnings("rawtypes")
	public String getAccountNo(String userId)
	{
		String accountNo=null;
		session=factory.getCurrentSession();
		Query query =session.createQuery("select a.accountNo from Account a where a.userId=:userId ");
		query.setParameter("userId", userId);
		List accList=query.list();
		if(accList.isEmpty())
			return null;
		else {
			accountNo=(String) accList.get(0);
			return accountNo;
		}
	}

	public boolean forgotPassword(String accountNo,String email) {
		session=factory.getCurrentSession();
		Account forgotAccount=(Account) session.get(Account.class, accountNo);
		if(forgotAccount!=null && forgotAccount.getAccountNo().equals(accountNo)&&
								forgotAccount.getEmail().equals(email))
		{
			account=forgotAccount;
			return true;
		}
		else return false;
	}
	
	public void deactivateUser(String userId) {
		session=factory.getCurrentSession();
		Account account=(Account) session.get(Account.class, getAccountNo(userId));
		account.setAccountStatus("Deactive");
		session.update(account);
	}
	
	public boolean isEmailAvailable(String email) {
		System.out.println("Bank Dao::is email available:"+email);
		session=factory.getCurrentSession();
		Query query = session.createQuery("SELECT a.email from Account a where a.email=:email");
		query.setParameter("email", email);
		List list = query.list();
		if (list.isEmpty()) {
			System.out.println("available");
			return true;
		} else {
			System.out.println("not available");
			return false;
		}
	}
	
	public boolean isMobileAvailable(Long mobile) {
		System.out.println("Bank Dao::is Mobile available:"+mobile);
		session=factory.getCurrentSession();
		Query query = session.createQuery("SELECT a.mobile from Account a where a.mobile=:mobile");
		query.setParameter("mobile", mobile);
		List list = query.list();
		if (list.isEmpty()) {
			System.out.println("available");
			return true;
		} else {
			System.out.println("not available");
			return false;
		}
	}
	
	public boolean isAadharNoAvailable(Long aadharNo) {
		System.out.println("Bank Dao::is Aadhar available:"+aadharNo);
		session=factory.getCurrentSession();
		Query query = session.createQuery("SELECT a.aadharNo from Account a where a.aadharNo=:aadharNo");
		query.setParameter("aadharNo", aadharNo);
		List list = query.list();
		if (list.isEmpty()) {
			System.out.println("available");
			return true;
		} else {
			System.out.println("not available");
			return false;
		}
	}
	
	public boolean isPanNoAvailable(String panNo) {
		System.out.println("Bank Dao::is panNo available:"+panNo);
		session=factory.getCurrentSession();
		Query query = session.createQuery("SELECT a.panNo from Account a where a.panNo=:panNo");
		query.setParameter("panNo", panNo);
		List list = query.list();
		if (list.isEmpty()) {
			System.out.println("available");
			return true;
		} else {
			System.out.println("not available");
			return false;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public boolean isUserActive(String userId) {
		session=factory.getCurrentSession();
		Query query=session.createQuery("select a.accountStatus from Account a where a.userId=:userId");
		query.setParameter("userId", userId);
		List accList=query.list();
		if(accList.isEmpty())
		{
			System.out.println("list is empty");
			return false;
		}
		else {
			String accountStatus=(String) accList.get(0);
			System.out.println("status: "+accountStatus);
			if(accountStatus.equalsIgnoreCase("Active"))
				return true;
			else return false;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public boolean checkLoginAttempts(String userId)
	{
		System.out.println("Check login attempts here acc dao");
		session=factory.getCurrentSession();
		Query query=session.createQuery("select a.loginAttempts from Account a where a.userId=:userId");
		query.setParameter("userId", userId);
		List accList=query.list();	
		int loginAttempts=(int) accList.get(0);
		System.out.println("Login Attempt status: "+loginAttempts);
		if(loginAttempts<3)
			return true;
		else
			return false;
	}
	
	public void resetLoginAttempts(Account account) { 
		System.out.println("reset login attempts here acc dao");
		session=factory.getCurrentSession();
		account.setLoginAttempts(0);
		session.update(account);
	}
	
	public void updateLoginAttempts(String userId) {
		System.out.println("Update login attempts here acc dao");
		session=factory.getCurrentSession();
		Account account=(Account) session.get(Account.class, getAccountNo(userId));
		account.setLoginAttempts((account.getLoginAttempts())+1);
		session.update(account);
	}
	
	@SuppressWarnings("rawtypes")
	public boolean isAdmin(Account account) {
		session=factory.getCurrentSession();
		Query query = session.createQuery("SELECT u.role from User u where u.account=:account");
		query.setParameter("account", account);
		List list = query.list();
		if(list.get(0).equals("A"))
			return true;
		else return false;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Account> getAccounts()
	{
		System.out.println("getAccounts() here acc dao");
		session=factory.getCurrentSession();
		Query query = session.createQuery("from Account");
		List list = query.list();
		System.out.println("List size"+list.size());
		return (ArrayList<Account>) list;
	}
	
	public void changeAccountStatus(String userId,String accountStatus) {
		session=factory.getCurrentSession();
		String accountNo=getAccountNo(userId);
		Account account=(Account)session.get(Account.class,accountNo);
		account.setAccountStatus(accountStatus);
		session.update(account);
	}
	
	public String getEmail(String userId) {
		session=factory.getCurrentSession();
		String accountNo=getAccountNo(userId);
		Account account=(Account)session.get(Account.class,accountNo);
		return account.getEmail();
	}
	
	public String getFirstName(String userId) {
		session=factory.getCurrentSession();
		String accountNo=getAccountNo(userId);
		Account account=(Account)session.get(Account.class,accountNo);
		return account.getFirstName();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Account> getAccountsStatics(String startDate, String endDate) throws ParseException
	{
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 java.util.Date date = sdf.parse(startDate);
		 java.sql.Date sqlStartDate = new Date(date.getTime());
		 java.util.Date date1 = sdf.parse(endDate);
		 java.sql.Date sqlEndDate = new Date(date1.getTime());
   		   
		System.out.println("getAccounts() here acc dao");
		session=factory.getCurrentSession();
		Query query = session.createQuery("FROM Account a WHERE a.date BETWEEN :startDate AND :endDate ");
		query.setDate("startDate",sqlStartDate);
		query.setDate("endDate",sqlEndDate);
		List list = query.list();
		System.out.println("date wise List size"+list.size());
		return (ArrayList<Account>) list;
	}
}
