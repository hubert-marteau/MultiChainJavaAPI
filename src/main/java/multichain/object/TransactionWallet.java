/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class TransactionWallet extends TransactionBase {
	Balance balance;
	List<String> myaddresses;
	List<String> addresses;
	List<PermissionDetailed> permissions;
	BalanceAsset issue;
	List<String> data;
	/**
	 *
	 */
	public TransactionWallet() {
		super();
		balance = new Balance();
		myaddresses = new ArrayList<String>();
		addresses = new ArrayList<String>();
		permissions = new ArrayList<PermissionDetailed>();
		issue = new BalanceAsset();
		data = new ArrayList<String>();
	}

	public TransactionWallet(TransactionWallet transaction) {
		super(transaction);
		balance = transaction.getBalance();
		myaddresses = transaction.getAddresses();
		addresses = transaction.getAddresses();
		permissions = transaction.getPermissions();
		issue = transaction.getIssue();
		data = transaction.getData();
	}

	public TransactionWallet(TransactionBase base) {
		super(base);
		balance = new Balance();
		myaddresses = new ArrayList<String>();
		addresses = new ArrayList<String>();
		permissions = new ArrayList<PermissionDetailed>();
		issue = new BalanceAsset();
		data = new ArrayList<String>();
	}

	/**
	 * @return the issue
	 */
	public BalanceAsset getIssue() {
		return issue;
	}

	/**
	 * @param issue the issue to set
	 */
	public void setIssue(BalanceAsset issue) {
		this.issue = issue;
	}

	/**
	 * @return the balance
	 */
	public Balance getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	/**
	 * @return the permissions
	 */
	public List<PermissionDetailed> getPermissions() {
		return permissions;
	}
	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(List<PermissionDetailed> permissions) {
		this.permissions = permissions;
	}
	/**
	 * @param permission to add
	 */
	public void addPermission(PermissionDetailed permission) {
		this.permissions.add(permission);
	}
	/**
	 * @return the data
	 */
	public List<String> getData() {
		return data;
	}
	/**
	 *
	 * @return data in 1 String
	 */
	public String getDataString() {
		String returnedString = "";
		if (data != null) {
			for (String dat : data) {
				returnedString += dat + "\r\n";
			}
		}
		return returnedString;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(List<String> data) {
		this.data = data;
	}
	/**
	 * @param data to add
	 */
	public void addData(String dataStr) {
		this.data.add(dataStr);
	}

	/**
	 * @return the myaddresses
	 */
	public List<String> getMyaddresses() {
		return myaddresses;
	}

	/**
	 * @param myaddresses the myaddresses to set
	 */
	public void setMyaddresses(List<String> myaddresses) {
		this.myaddresses = myaddresses;
	}

	/**
	 * @return the addresses
	 */
	public List<String> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}
}
