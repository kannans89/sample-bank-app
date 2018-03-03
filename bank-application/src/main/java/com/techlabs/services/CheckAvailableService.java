package com.techlabs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.dao.BankDao;

@Service
public class CheckAvailableService {
	
	@Autowired
	private BankDao bankDao;
	public CheckAvailableService() {
		System.out.println("CheckAvailableService-constr");
	}
	public boolean checkEmailId(String emailId){
		return bankDao.checkEmailIdAvailble(emailId);	
	}
	public boolean checkPanNoAvailable(String panNo) {
		return bankDao.checkPanNoAvailable(panNo);
	}
	public boolean checkAadharNoAvailable(String aadharNo) {
		return bankDao.checkAadharNoAvailable(aadharNo);
	}
	
	

}
