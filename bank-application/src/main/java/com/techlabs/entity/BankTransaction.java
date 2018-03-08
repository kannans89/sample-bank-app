package com.techlabs.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="transaction_table")
public class BankTransaction {

	@Id
	private String transactionId;
	@ManyToOne
	@JoinColumn
	private Account account;
	private double amount;
	private String transactionType;
	private Date date;
	private Time time;

	public BankTransaction() {
		// TODO Auto-generated constructor stub
	}
	public BankTransaction(String transactionId, Account account, double amount,
			String transactionType, Date date,Time time) {
		super();
		this.transactionId = transactionId;
		this.account = account;
		this.amount = amount;
		this.transactionType = transactionType;
		this.date = date;
		this.time=time;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
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
}
