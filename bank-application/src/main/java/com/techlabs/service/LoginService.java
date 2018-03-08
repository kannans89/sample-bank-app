package com.techlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.dao.AccountDao;
import com.techlabs.entity.Account;

@Service("loginService")
public class LoginService 
{
	@Autowired
	private AccountDao accountDao;
	
	public LoginService() {
		System.out.println("Login Service Constructor");
	}
	@Transactional
	public boolean validateUser(String userId,String password) {
		return accountDao.validateUser(userId, password);
	}
	@Transactional
	public Account getAccount() {
		return accountDao.getAccount();
	}
	@Transactional
	public void deactivateUser(String userId) {
		System.out.println("Account has been Locked");
		accountDao.deactivateUser(userId);
	}
	@Transactional
	public boolean isUserActive(String userId) {
		return accountDao.isUserActive(userId);
	}
	@Transactional
	public boolean checkLoginAttempts(String userId) {
		return accountDao.checkLoginAttempts(userId);
	}
	@Transactional
	public void updateLoginAttempts(String userId) {
		accountDao.updateLoginAttempts(userId);
	}
	@Transactional
	public boolean isAdmin(Account account) {
		return accountDao.isAdmin(account);
	}
}
