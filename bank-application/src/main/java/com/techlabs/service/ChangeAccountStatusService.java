package com.techlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.dao.AccountDao;

@Service("changeCurrentStatusService")
public class ChangeAccountStatusService 
{
	@Autowired
	private AccountDao accountDao;
	
	@Transactional
	public void changeAccountStatus(String userId,String accountStatus) {
		accountDao.changeAccountStatus(userId,accountStatus);
	}
}
