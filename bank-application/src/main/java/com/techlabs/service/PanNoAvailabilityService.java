package com.techlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.dao.AccountDao;

@Service("panNoAvailabilityService")
public class PanNoAvailabilityService {
	@Autowired
	private AccountDao accountDao;
	
	public PanNoAvailabilityService() {
		System.out.println("PAN no AvailabilityService constructor");
	}
	@Transactional
	public boolean isPanNoAvailable(String panNo) {
		return accountDao.isPanNoAvailable(panNo);
	}
}
