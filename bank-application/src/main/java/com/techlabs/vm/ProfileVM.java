package com.techlabs.vm;

import com.techlabs.entity.Account;

public class ProfileVM {
	private boolean profilePostBack;
	private Account account;
	private boolean readOnly;
	private boolean editFlag;

	public boolean isProfilePostBack() {
		return profilePostBack;
	}

	public void setProfilePostBack(boolean profilePostBack) {
		this.profilePostBack = profilePostBack;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		System.out.println("in profilevm set account");
		System.out.println(account.getEmailId());
		this.account = account;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public boolean isEditFlag() {
		return editFlag;
	}

	public void setEditFlag(boolean editFlag) {
		this.editFlag = editFlag;
	}

}
