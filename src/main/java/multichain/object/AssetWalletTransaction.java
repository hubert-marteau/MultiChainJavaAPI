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
 * @version 4.13
 */
public class AssetWalletTransaction extends BalanceAssetWalletTransaction {
	Object details;
	long raw;
	List<String> addresses;
	/**
	 * @return the details
	 */
	public Object getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(Object details) {
		this.details = details;
	}
	/**
	 * @return the raw
	 */
	public long getRaw() {
		return raw;
	}
	/**
	 * @param raw the raw to set
	 */
	public void setRaw(long raw) {
		this.raw = raw;
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
