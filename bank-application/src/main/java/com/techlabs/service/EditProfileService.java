package com.techlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.dao.AccountDao;
import com.techlabs.entity.Account;

@Service("editProfileService")
public class EditProfileService {

	@Autowired
	private AccountDao accountDao;
	
	public EditProfileService() {
		System.out.println("Edit Profile Service");
	}
	@Transactional
	public void updateProfile(Account account){
		accountDao.updateAccount(account);
	}
}
