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
 * @version 4.14
 */
public class TransactionWallet {
	BalanceWalletTransaction balance = null;
	List<String> myaddresses;
	List<String> addresses;
	List<PermissionDetailed> permissions;
	Create create = null;
	AssetWalletTransaction issue = null;
	List<Item> items;
	List<String> data;
	Long confirmations = null;
	String blockhash = null;
	Long blockindex = null;
	Long blocktime = null;
	String txid = null;
	Boolean valid = null;
	Long time = null;
	Long timereceived = null;
	

	/**
	 *
	 */
	public TransactionWallet() {
		super();
		balance = new BalanceWalletTransaction();
		myaddresses = new ArrayList<String>();
		addresses = new ArrayList<String>();
		permissions = new ArrayList<PermissionDetailed>();
		create = null;
		issue = null;
		data = new ArrayList<String>();
		items = new ArrayList<>();
	}

	public TransactionWallet(TransactionWallet transaction) {
		balance = transaction.getBalance();
		myaddresses = transaction.getAddresses();
		addresses = transaction.getAddresses();
		permissions = transaction.getPermissions();
		create = transaction.getCreate();
		issue = transaction.getIssue();
		data = transaction.getData();
		items = transaction.getItems();
	}

	/**
	 * @return the issue
	 */
	public AssetWalletTransaction getIssue() {
		return issue;
	}

	/**
	 * @param issue
	 *            the issue to set
	 */
	public void setIssue(AssetWalletTransaction issue) {
		this.issue = issue;
	}

	/**
	 * @return the balance
	 */
	public BalanceWalletTransaction getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(BalanceWalletTransaction balance) {
		this.balance = balance;
	}

	/**
	 * @return the permissions
	 */
	public List<PermissionDetailed> getPermissions() {
		return permissions;
	}

	/**
	 * @param permissions
	 *            the permissions to set
	 */
	public void setPermissions(List<PermissionDetailed> permissions) {
		this.permissions = permissions;
	}

	/**
	 * @param permission
	 *            to add
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
	 * @param data
	 *            the data to set
	 */
	public void setData(List<String> data) {
		this.data = data;
	}

	/**
	 * @param data
	 *            to add
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
	 * @param myaddresses
	 *            the myaddresses to set
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
	 * @param addresses
	 *            the addresses to set
	 */
	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	/**
	 * @return the confirmations
	 */
	public long getConfirmations() {
		return confirmations;
	}

	/**
	 * @param confirmations the confirmations to set
	 */
	public void setConfirmations(long confirmations) {
		this.confirmations = confirmations;
	}

	/**
	 * @return the blockhash
	 */
	public String getBlockhash() {
		return blockhash;
	}

	/**
	 * @param blockhash the blockhash to set
	 */
	public void setBlockhash(String blockhash) {
		this.blockhash = blockhash;
	}

	/**
	 * @return the blockindex
	 */
	public long getBlockindex() {
		return blockindex;
	}

	/**
	 * @param blockindex the blockindex to set
	 */
	public void setBlockindex(long blockindex) {
		this.blockindex = blockindex;
	}

	/**
	 * @return the blocktime
	 */
	public long getBlocktime() {
		return blocktime;
	}

	/**
	 * @param blocktime the blocktime to set
	 */
	public void setBlocktime(long blocktime) {
		this.blocktime = blocktime;
	}

	/**
	 * @return the txid
	 */
	public String getTxid() {
		return txid;
	}

	/**
	 * @param txid the txid to set
	 */
	public void setTxid(String txid) {
		this.txid = txid;
	}

	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	/**
	 * @return the time
	 */
	public long getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(long time) {
		this.time = time;
	}

	/**
	 * @return the timereceived
	 */
	public long getTimereceived() {
		return timereceived;
	}

	/**
	 * @param timereceived the timereceived to set
	 */
	public void setTimereceived(long timereceived) {
		this.timereceived = timereceived;
	}

	/**
	 * @return the create
	 */
	public Create getCreate() {
		return create;
	}

	/**
	 * @param create the create to set
	 */
	public void setCreate(Create create) {
		this.create = create;
	}
}
