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
 * @version 4.15
 */
public class TransactionRAW {
	String txid = null;
	Integer version = null;
	Long locktime = null;
	List<TransactionRAWVin> vin;
	List<TransactionRAWVout> vout;
	AssetWalletTransaction issue = null;
	List<String> data;

	/**
	 *
	 */
	public TransactionRAW() {
		super();
		vin = new ArrayList<TransactionRAWVin>();
		vout = new ArrayList<TransactionRAWVout>();
		data = new ArrayList<String>();
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
	 * @return the locktime
	 */
	public long getLocktime() {
		return locktime;
	}

	/**
	 * @param locktime the locktime to set
	 */
	public void setLocktime(long locktime) {
		this.locktime = locktime;
	}

	/**
	 * @return the data
	 */
	public List<String> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<String> data) {
		this.data = data;
	}

	/**
	 * @param data to add to the data list
	 */
	public void addData(String data) {
		this.data.add(data);
	}

	/**
	 * @return the vin
	 */
	public List<TransactionRAWVin> getVin() {
		return vin;
	}

	/**
	 * @param vins the vin to set
	 */
	public void setVin(List<TransactionRAWVin> vin) {
		this.vin = vin;
	}

	/**
	 * @param vin to add to the vin list
	 */
	public void addVin(TransactionRAWVin vin) {
		this.vin.add(vin);
	}

	/**
	 * @return the vout
	 */
	public List<TransactionRAWVout> getVout() {
		return vout;
	}

	/**
	 * @param vouts the vout to set
	 */
	public void setVout(List<TransactionRAWVout> vout) {
		this.vout = vout;
	}

	/**
	 * @param vout to add to the vout list
	 */
	public void addVout(TransactionRAWVout vout) {
		this.vout.add(vout);
	}



	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}



	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the issue
	 */
	public AssetWalletTransaction getIssue() {
		return issue;
	}

	/**
	 * @param issue the issue to set
	 */
	public void setIssue(AssetWalletTransaction issue) {
		this.issue = issue;
	}

}
