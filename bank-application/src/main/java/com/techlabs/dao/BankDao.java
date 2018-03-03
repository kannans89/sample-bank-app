package com.techlabs.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.entity.Account;
import com.techlabs.entity.BankTransaction;
import com.techlabs.entity.LoginDetails;
import com.techlabs.entity.Role;
import com.techlabs.entity.Status;
import com.techlabs.entity.TransactionType;
import com.techlabs.entity.User;
import com.techlabs.services.DateTime;
import com.techlabs.services.PasswordGenrator;
import com.techlabs.services.MailService;

@Repository
public class BankDao {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	public BankDao() {
		System.out.println("bankdao-constr");
	}

	public void addNewAccount(User user) {
		System.out.println("bankDao-addNewAccount: name- " + user.getAccount().getFirstName());
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	public void addTransactionDetails(BankTransaction bankTransaction) {
		System.out.println("transactionOperation");
		session = sessionFactory.getCurrentSession();
		session.save(bankTransaction);
	}

	public Role getUserRole(String userId, String password) {
		System.out.println("in isUserValid");
		Session session = sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		java.util.List users = null;

		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", userId)).add(Restrictions.eq("password", password));
		users = criteria.list();

		for (@SuppressWarnings("rawtypes")
		Iterator iterator = users.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			System.out.println("valid user");
			return user.getRole();
		}
		return null;
	}

	@Transactional
	public Account getUserDetails(String userId) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(userId);
		Account account = null;
		User user = (User) session.get(User.class, userId);
		account = user.getAccount();
		return account;

	}

	@Transactional
	public void updateAccount(Account editAccount) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("in update account bankdao " + editAccount.getPanNo() + " ");
		session.update(editAccount);

	}

	@Transactional
	public List<BankTransaction> getTransactionDetails(Account account) {

		System.out.println("in gettrasction--" + account.getAccNo());

		session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(BankTransaction.class);

		criteria.add(Restrictions.eq("account", account));
		@SuppressWarnings("unchecked")
		List<BankTransaction> transactionDetails = criteria.list();
		System.out.println("in bank dao:-" + transactionDetails.size());

		return transactionDetails;
	}

	@Transactional
	public boolean transactionOperation(double amount, TransactionType type, Account account) {
		System.out.println("transactionOperation");

		System.out.println(account.getBalance());
		double balance = account.getBalance();
		if (type == TransactionType.WITHDRAW) {
			System.out.println("witdraw-");
			if (balance - amount > 1000) {
				System.out.println(" true-");
				balance -= amount;

			} else {
				System.out.println("withdrawl fail");
				return false;
			}
		} else {
			System.out.println("in deposite operation");
			balance += amount;
		}
		System.out.println("add to table");
		DateTime dateTime = new DateTime();
		BankTransaction bankTransaction = new BankTransaction(amount, type, dateTime.getDate(), dateTime.getTime(),
				account);
		addTransactionDetails(bankTransaction);
		account.setBalance(balance);
		return true;
	}

	@Transactional
	public boolean genrateNewPassword(String email, String userId) throws AddressException, MessagingException {
		session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		java.util.List users = null;

		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", userId));
		users = criteria.list();
		if (((User) users.get(0)).getAccount().getEmailId().equals(email)) {

			String password = new PasswordGenrator().createPassword();
			((User) users.get(0)).setPassword(password);

			String msg = "your password has been change successfully. " + "userId: " + userId + "  password: "
					+ password;

			new MailService().sendMail(email, msg);
			return true;
		}
		return false;

	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public boolean checkEmailIdAvailble(String emailId) {
		System.out.println("emailAviChk");
		session = sessionFactory.getCurrentSession();

		java.util.List users = null;

		Criteria criteria = session.createCriteria(Account.class);
		criteria.add(Restrictions.eq("emailId", emailId));
		users = criteria.list();
		for (Iterator iterator = users.iterator(); iterator.hasNext();) {
			System.out.println("present");
			return false;
		}
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public boolean checkPanNoAvailable(String panNo) {
		System.out.println("panChk");
		session = sessionFactory.getCurrentSession();
		java.util.List users = null;

		Criteria criteria = session.createCriteria(Account.class);
		criteria.add(Restrictions.eq("panNo", panNo));
		users = criteria.list();
		for (Iterator iterator = users.iterator(); iterator.hasNext();) {
			System.out.println("present");
			return false;
		}
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public boolean checkAadharNoAvailable(String aadharNo) {

		System.out.println("aadhrChk");
		session = sessionFactory.getCurrentSession();
		java.util.List users = null;

		Criteria criteria = session.createCriteria(Account.class);
		criteria.add(Restrictions.eq("aadharNo", aadharNo));
		users = criteria.list();
		for (Iterator iterator = users.iterator(); iterator.hasNext();) {
			System.out.println("present");
			return false;
		}
		return true;
	}

	@Transactional
	public void addLoginDetails(LoginDetails loginDetails) {

		System.out.println("in bankdao-add logindetails");
		Session session = sessionFactory.getCurrentSession();
		session.save(loginDetails);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<LoginDetails> getLoginDetails(String userId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(LoginDetails.class);
		criteria.add(Restrictions.eq("userId", userId));
		List<LoginDetails> loginDetails = criteria.list();
		return loginDetails;
	}

	@Transactional
	public void changeUserStatus(Status status, String userId) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(status);
		User user = (User) session.get(User.class, userId);
		user.setStatus(status);
		session.update(user);
	}

	@Transactional
	public Status isAvailableToLogin(String userId) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("#######");
		
		User user = (User) session.get(User.class, userId);
		if(user==null){
			return Status.ENABLE;
		}
		Status status = user.getStatus();
		return status;
	}

	@Transactional
	public void updateFailLoginAttemps(String userId, boolean loginSuccess) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, userId);

		if (!loginSuccess) {
			int numberOfFailAttemps = user.getNumberOfFailAttemps();
			System.out.println("number of fail attemps- " + numberOfFailAttemps);
			user.setNumberOfFailAttemps(numberOfFailAttemps + 1);
			if (numberOfFailAttemps > 3)
				changeUserStatus(Status.DISABLE, userId);
		} else {
			user.setNumberOfFailAttemps(0);
		}
		session.update(user);
	}

	@Transactional
	public List getUsersDetails() {
		Session session = sessionFactory.getCurrentSession();
		List users = session.createQuery("FROM User").list();
		System.out.println(users.size());
		return users;

	}
	@Transactional
	public void adminChangeUserStatus(String userId) {
		System.out.println("*************-bankdao-adminChangeUserStatus-************");
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, userId);
		System.out.println(user.getStatus());
		if(user.getStatus()==Status.DISABLE) {
			user.setStatus(Status.ENABLE);
		}else {
			user.setStatus(Status.DISABLE);
		}
		System.out.println(user.getStatus());
		session.update(user);
	}
	
	@Transactional
	public List getStatics(Date fromDate,Date toDate){
		Session session = sessionFactory.getCurrentSession();
		
		List<String> details=new ArrayList<String>();
		
		Query q1 = session.createQuery("select 1 from User where role='CUSTMORE'");
		int numOfAcc = 0;
		if(q1.list()!=null){
		     numOfAcc=q1.list().size();
		}
		details.add(String.valueOf(numOfAcc));
		System.out.println("number of ACCOUNT- "+numOfAcc); 
		
		Query q2 = session.createQuery("select 1 from BankTransaction where type='DEPOSITE' AND date>:fromDate AND date<:toDate");
		q2.setParameter("fromDate", fromDate);
		q2.setParameter("toDate", toDate);
		
		int numOfDeposite = 0;
		if(q2.list()!=null){
			numOfDeposite=q2.list().size();
		}
		details.add(String.valueOf(numOfDeposite));
		System.out.println("number of DEPOSITE- "+numOfDeposite); 
		
	    Query q3 = session.createQuery("select 1 from BankTransaction where type='WITHDRAW'  AND date>:fromDate AND date<:toDate");
	    q3.setParameter("fromDate", fromDate);
		q3.setParameter("toDate", toDate);
		int numOfWithdraw = 0;
		if(q3.list()!=null){
			numOfWithdraw=q3.list().size();
		}
		details.add(String.valueOf(numOfWithdraw));
	    System.out.println("number of WITHDRAW- "+numOfWithdraw); 
	    
	    Query q4 = session.createQuery("select sum(amount) from BankTransaction where type='DEPOSITE' AND date>:fromDate AND date<:toDate");
	    q4.setParameter("fromDate", fromDate);
		q4.setParameter("toDate", toDate);		
	    double totalDeposite=0;
		if(q4.list().get(0)!=null){
			totalDeposite=(double) q4.list().get(0);
		}
		details.add(String.valueOf(totalDeposite));
		System.out.println("total DEPOSITE- "+totalDeposite);
	    
		Query q5 = session.createQuery("select sum(amount) from BankTransaction where type='WITHDRAW'  AND date>:fromDate AND date<:toDate");
		q5.setParameter("fromDate", fromDate);
		q5.setParameter("toDate", toDate);
		  double totalWithdraw=0;
			if(q5.list().get(0)!=null){
				totalWithdraw=(double) q5.list().get(0);
			}
			details.add(String.valueOf(totalWithdraw));
		System.out.println("total WITHDRAW- "+totalWithdraw);
		
		Query q6 = session.createQuery("select MAX(balance) from Account");
		  double highestBal=0;
			if(q6.list().get(0)!=null){
				highestBal=(double) q6.list().get(0);
			}
			details.add(String.valueOf(highestBal));
		System.out.println("higest balance amount- "+highestBal);
		
		Query q7 = session.createQuery("select 1 from User where status='ENABLE'");
		int numOfEnableAcc= 0;
			if(q7.list()!=null){
				numOfEnableAcc=(int) q7.list().size();
			}
			details.add(String.valueOf(numOfEnableAcc));
		System.out.println("number of enable account- "+numOfEnableAcc);
		 
		Query q8 = session.createQuery("select 1 from User where status='DISABLE'");
		  int numOfDisableAcc=0;
			if(q8.list()!=null){
				numOfDisableAcc=(int) q8.list().size();
			}
			details.add(String.valueOf(numOfDisableAcc));
		System.out.println("number of disable account- "+numOfDisableAcc);
		
		return details;

	}

	public boolean isUserIdValid(String userId) {
		
		Session session = sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		

		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", userId));
		List users = criteria.list();
		System.out.println(users);
		return users!=null;
		
		
	}
	

}
