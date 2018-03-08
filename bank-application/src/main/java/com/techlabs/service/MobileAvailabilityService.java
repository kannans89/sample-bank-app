package com.techlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.techlabs.dao.AccountDao;

@Service("mobileAvailabilityService")
public class MobileAvailabilityService {

	@Autowired
	private AccountDao accountDao;
	
	public MobileAvailabilityService() {
		System.out.println("Mobile AvailabilityService constructor");
	}
	@Transactional
	public boolean isMobileAvailable(Long mobile) {
		return accountDao.isMobileAvailable(mobile);
	}
}
