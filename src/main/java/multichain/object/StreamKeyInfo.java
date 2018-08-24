/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

import java.util.List;

/**
 * @author Ub - H. MARTEAU
 * @version 4.14
 */
public class StreamKeyInfo {
	List<String> publishers;
	String key = null;
	String data = null;
	Long confirmations = null;
	String blockhash = null;
	Long blockindex = null;
	Long blocktime = null;
	String txid = null;
	Long vout = null;
	Boolean valid = null;
	Long time = null;
	Long timereceived = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StreamKeyInfo [publishers=" + publishers + ", key=" + key + ", data=" + data + ", confirmations="
				+ confirmations + ", blockhash=" + blockhash + ", blockindex=" + blockindex + ", blocktime="
				+ blocktime + ", txid=" + txid + ", vout=" + vout + ", valid=" + valid + ", time=" + time
				+ ", timereceived=" + timereceived + "]";
	}

	/**
	 * @return the publishers
	 */
	public List<String> getPublishers() {
		return publishers;
	}

	/**
	 * @param publishers
	 *            the publishers to set
	 */
	public void setPublishers(List<String> publishers) {
		this.publishers = publishers;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the confirmations
	 */
	public long getConfirmations() {
		return confirmations;
	}

	/**
	 * @param confirmations
	 *            the confirmations to set
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
	 * @param blockhash
	 *            the blockhash to set
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
	 * @param blockindex
	 *            the blockindex to set
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
	 * @param blocktime
	 *            the blocktime to set
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
	 * @param txid
	 *            the txid to set
	 */
	public void setTxid(String txid) {
		this.txid = txid;
	}

	/**
	 * @return the vout
	 */
	public long getVout() {
		return vout;
	}

	/**
	 * @param vout
	 *            the vout to set
	 */
	public void setVout(long vout) {
		this.vout = vout;
	}

	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * @param valid
	 *            the valid to set
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
	 * @param time
	 *            the time to set
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
	 * @param timereceived
	 *            the timereceived to set
	 */
	public void setTimereceived(long timereceived) {
		this.timereceived = timereceived;
	}

}
