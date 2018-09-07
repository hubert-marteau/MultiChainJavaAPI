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
 * @version 4.15
 */
public class AssetWalletTransaction extends BalanceAssetWalletTransaction {
	Long multiple = null;
    Double units = null;
    Boolean open = null;
	
	Object details;
	Long raw = null;
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
	/**
	 * @return the multiple
	 */
	public long getMultiple() {
		return multiple;
	}
	/**
	 * @param multiple the multiple to set
	 */
	public void setMultiple(long multiple) {
		this.multiple = multiple;
	}
	/**
	 * @return the units
	 */
	public double getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(double units) {
		this.units = units;
	}
	/**
	 * @return the open
	 */
	public boolean isOpen() {
		return open;
	}
	/**
	 * @param open the open to set
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}
	
	
	
}
