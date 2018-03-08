package com.techlabs.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;

import org.hibernate.annotations.OrderBy;
@Entity
@Table(name="account_table")
public class Account {

	private String firstName;
	private String middleName;
	private String lastName;
	private Long mobile;
	private String email;
	private String address;
	private Long aadharNo;
	private String panNo;
	@Column(columnDefinition = "LONGBLOB")
	private byte[] profileImage;
	private String userId;
	private String password;
	private double balance;
	private String accountStatus;
	private int loginAttempts;
	private Date date;
	private Time time;
	
	@Id
	private String accountNo;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="account",cascade=CascadeType.ALL)
	@OrderBy(clause = "date desc,time desc")
	private Set<BankTransaction> bankTransaction;

	public Account() {
	}
	
	public Account(String firstName, String middleName, String lastName,
			Long mobile, String email, String address, Long aadharNo,
			String panNo, byte[] profileImage,String userID,
			String password, double balance, String accountNo,String accountStatus,int loginAttempts, Date date,Time time) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.aadharNo = aadharNo;
		this.panNo = panNo;
		this.profileImage = profileImage;
		this.userId=userID;
		this.password = password;
		this.balance = balance;
		this.accountNo = accountNo;
		this.accountStatus=accountStatus;
		this.loginAttempts=loginAttempts;
		this.date = date;
		this.time=time;
		bankTransaction=new HashSet<BankTransaction>();
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

	public int getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}
	
	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public byte[] getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}
	public Set<BankTransaction> getBankTransaction() {
		return bankTransaction;
	}

	public void setBankTransaction(Set<BankTransaction> transaction) {
		this.bankTransaction = transaction;
	}
}
