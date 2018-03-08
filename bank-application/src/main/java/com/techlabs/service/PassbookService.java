package com.techlabs.service;

import java.util.ArrayList;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techlabs.dao.BankTransactionDao;
import com.techlabs.entity.BankTransaction;

@Service("passbookService")
public class PassbookService implements Comparable<BankTransaction>
{
	@Autowired
	private BankTransactionDao bankTransactionDao;
	private ArrayList<String> rows;
	
	public PassbookService() {
		System.out.println("Passbook Service Constructor");
		 rows = new ArrayList<String>();
	}
	
	public Set<BankTransaction> getPassbook(String accountNo){
		return bankTransactionDao.getPassbook(accountNo);
	}
	
	public ArrayList<String> getCsvData(String accountNo)
	{
		rows.clear();
		rows.add("Transaction Id,Amount,Transaction Type,Date,Time");
		for(BankTransaction transaction:getPassbook(accountNo)) {
			rows.add(transaction.getTransactionId()+","+Double.toString(transaction.getAmount())+","
					 	+transaction.getTransactionType()+","+transaction.getDate()+","+transaction.getTime());
		}
		return rows;
	}
	
	@Override
	public int compareTo(BankTransaction object) {
		return 0;
	}
}
