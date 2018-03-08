package com.techlabs.service;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.dao.AccountDao;
import com.techlabs.dao.BankTransactionDao;
import com.techlabs.dto.AccountStaticsDto;
import com.techlabs.entity.Account;
import com.techlabs.entity.BankTransaction;

@Service("staticsService")
public class GetAccountsStaticsService 
{
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private BankTransactionDao bankTransactionDao;
	private AccountStaticsDto staticsDto;
	private final ZonedDateTime startOfLastWeek = ZonedDateTime.now().minusWeeks(1).with(DayOfWeek.MONDAY);
	private final ZonedDateTime endOfLastWeek = startOfLastWeek.plusDays(6);
	private final LocalDate firstOfMonth = YearMonth.now().minusMonths( 1 ).atDay( 1 );
	private final LocalDate lastOfMonth = YearMonth.now().minusMonths( 1 ).atEndOfMonth();
	private final LocalDate firstOfYear = Year.now().minusYears(1).atDay( 1 );
	private final LocalDate lastOfYear = Year.now().minusYears(1).atMonth(12).atEndOfMonth();
	
	public GetAccountsStaticsService() {
		System.out.println("Statics service constructor");
	}
	
	@Transactional
	public AccountStaticsDto getAccountStaticsOfLastWeek() {
		System.out.println("By last week called ");
		try {
			return getAccountsStatics(accountDao.getAccountsStatics(startOfLastWeek.format(DateTimeFormatter.ISO_LOCAL_DATE),endOfLastWeek.format(DateTimeFormatter.ISO_LOCAL_DATE)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public AccountStaticsDto getAccountStaticsOfLastMonth() {
		System.out.println("By last month called ");
		try {
			return getAccountsStatics(accountDao.getAccountsStatics(firstOfMonth.format(DateTimeFormatter.ISO_LOCAL_DATE),lastOfMonth.format(DateTimeFormatter.ISO_LOCAL_DATE)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public AccountStaticsDto getAccountStaticsOfLastYear() {
		System.out.println("By last year called ");
		try {
			return getAccountsStatics(accountDao.getAccountsStatics(firstOfYear.format(DateTimeFormatter.ISO_LOCAL_DATE),lastOfYear.format(DateTimeFormatter.ISO_LOCAL_DATE)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public AccountStaticsDto getAccountStaticsOfDefault() {
		System.out.println("default called ");
		return getAccountsStatics(accountDao.getAccounts());
	}
	
	public AccountStaticsDto getAccountsStatics(ArrayList<Account> accounts) {
		staticsDto = new AccountStaticsDto();
		double balance=0;
		
		for(Account account:accounts) {
			if(!accountDao.isAdmin(account)) {
				//for active , deactive
				if(account.getAccountStatus().equals("Active"))
					staticsDto.setNoOfActiveAccounts(staticsDto.getNoOfActiveAccounts()+1);
				else
					staticsDto.setNoOfDeactiveAccounts(staticsDto.getNoOfDeactiveAccounts()+1);
				//for reach man
				if(balance<account.getBalance()) {
					staticsDto.setReachUserId(account.getUserId());
					balance=account.getBalance();
				}
				//for deposite and withdraw
				for(BankTransaction transaction:account.getBankTransaction()) {
					if(transaction.getTransactionType().equalsIgnoreCase("WITHDRAW")) {
						staticsDto.setNoOfTransactions(staticsDto.getNoOfTransactions()+1);
						staticsDto.setTotalAmountWithdrawal(staticsDto.getTotalAmountWithdrawal()+transaction.getAmount());
					}
					else {
						staticsDto.setNoOfTransactions(staticsDto.getNoOfTransactions()+1);
						staticsDto.setTotalAmountDeposited(staticsDto.getTotalAmountDeposited()+transaction.getAmount());
					}
				}
				//for no of opened acc
				staticsDto.setNoOfOpenedAccounts(staticsDto.getNoOfOpenedAccounts()+1);
			}
		}
		return staticsDto;
	}
}
