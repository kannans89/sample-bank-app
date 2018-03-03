package com.techlabs.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {
	@Id
	private String accNo;
	private double balance;

	private String firstName;
	private String middleName;
	private String lastName;

	private long mobileNo;
	private String emailId;

	private String panNo;
	private String aadharNo;

	private byte[] userImage;
	private String imageName;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
//
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<BankTransaction>bankTransactions;
	
	public Account() {
		System.out.println("Account-constr");
	}

	public Account(double balance, String firstName, String middleName, String lastName, long mobileNo, String emailId,
			String panNo, String aadharNo, byte[] byteImage, Address address, String imageName,Status status) {
		super();

		UUID uuid = UUID.randomUUID();
		this.accNo = uuid.toString().replace("-", "");
		this.balance = balance;

		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;

		this.mobileNo = mobileNo;
		this.emailId = emailId;

		this.panNo = panNo;
		this.aadharNo = aadharNo;

		this.userImage = byteImage;
		this.imageName=imageName;
		this.address = address;
		
		this.status=status;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
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

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getAccNo() {
		return accNo;
	}

	public byte[] getUserImage() {
		return userImage;
	}

	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
//
//	public List<BankTransaction> getBankTransactions() {
//		return bankTransactions;
//	}
//
//	public void setBankTransactions(List<BankTransaction> bankTransactions) {
//		this.bankTransactions = bankTransactions;
//	}
	
}
