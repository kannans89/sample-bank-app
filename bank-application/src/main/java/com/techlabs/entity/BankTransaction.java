package com.techlabs.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class BankTransaction {

	@Id
	private String transId;
	private double amount;
	
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	private Date date;
	private Time time;

//	@JoinColumn
	@ManyToOne( cascade = CascadeType.ALL)
	private Account account;
	
	public BankTransaction() {
		System.out.println("");
	}

	public BankTransaction( double amount, TransactionType type, Date date, Time time, Account account) {
		super();
		
		UUID uuid = UUID.randomUUID();
		this.transId = uuid.toString().replace("-", "");
		 
		this.amount = amount;
		this.type = type;
		this.date = date;
		this.time = time;
		this.account = account;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getTransId() {
		return transId;
	}
	

	
	
}
