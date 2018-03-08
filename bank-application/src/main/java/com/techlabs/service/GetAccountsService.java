package com.techlabs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.dao.AccountDao;
import com.techlabs.dto.AccountDto;
import com.techlabs.entity.Account;

@Service("getAccountService")
public class GetAccountsService 
{
	@Autowired
	private AccountDao accountDao;
	private AccountDto accountDto;
	private ArrayList<AccountDto> accounts;
	
	public GetAccountsService() {
		System.out.println("GetAccountService() here");
	}
	
	@Transactional
	public ArrayList<AccountDto> getAccounts() {
		accounts=new ArrayList<AccountDto>();
		for(Account account:accountDao.getAccounts())
		{
			if(!accountDao.isAdmin(account)) {
				accountDto=new AccountDto(account.getFirstName(), account.getMiddleName(), account.getLastName(),
					account.getMobile(), account.getEmail(), account.getAddress(),account.getAadharNo(),
					account.getPanNo(), account.getProfileImage(),account.getUserId(), 
					account.getPassword(),account.getBalance(), account.getAccountStatus(), 
					account.getLoginAttempts(), account.getAccountNo());
				accounts.add(accountDto);
				System.out.println("In for loop :"+accounts.size());
			}
		}
		return accounts;
	}
}
