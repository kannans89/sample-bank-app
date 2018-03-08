package com.techlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.techlabs.dao.AccountDao;

@Service("aadharNoAvailabilityService")
public class AadharNoAvailabilityService {
	@Autowired
	private AccountDao accountDao;
	
	public AadharNoAvailabilityService() {
		System.out.println("Aadhar no AvailabilityService constructor");
	}
	@Transactional
	public boolean isAadharNoAvailable(Long aadharNo) {
		return accountDao.isAadharNoAvailable(aadharNo);
	}
}
