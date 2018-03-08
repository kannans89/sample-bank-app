package com.techlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.dao.AccountDao;

@Service("emailAvailabilityService")
public class EmailAvailabilityService {
	
	@Autowired
	private AccountDao accountDao;
	
	public EmailAvailabilityService() {
		System.out.println("EmailAvailabilityService constructor");
	}
	@Transactional
	public boolean isEmailAvailable(String email) {
		return accountDao.isEmailAvailable(email);
	}
}
