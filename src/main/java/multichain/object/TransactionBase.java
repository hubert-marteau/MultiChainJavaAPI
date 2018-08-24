/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

/**
 * @author Ub - H. MARTEAU
 * @version 4.14
 */
public class TransactionBase {
	Long confirmations = null;
	String blockhash = null;
	Long blockindex = null;
	Long blocktime = null;
	String txid = null;
	Boolean valid = null;
	Long time = null;
	Long timereceived = null;
	Long version = null;
	Long locktime = null;

	/**
	 *
	 */
	public TransactionBase() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param confirmations
	 * @param blockhash
	 * @param blockindex
	 * @param blocktime
	 * @param txid
	 * @param time
	 * @param timereceived
	 * @param version
	 * @param locktime
	 */
	public TransactionBase(TransactionBase transactionBase) {
		super();
		this.confirmations = transactionBase.confirmations;
		this.blockhash = transactionBase.blockhash;
		this.blockindex = transactionBase.blockindex;
		this.blocktime = transactionBase.blocktime;
		this.txid = transactionBase.txid;
		this.time = transactionBase.time;
		this.timereceived = transactionBase.timereceived;
		this.version = transactionBase.version;
		this.locktime = transactionBase.locktime;
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


}
