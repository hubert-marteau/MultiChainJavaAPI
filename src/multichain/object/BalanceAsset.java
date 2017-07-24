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
public class BalanceAsset extends BalanceAssetBase {
	String assetref;
	long multiple;
	double units;
	boolean open;
	Object details;
	String type;
	long raw;
	String issuetxid;
	List<String> addresses = new ArrayList<String>();
	boolean issue;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BalanceAsset [assetref=" + assetref + ", multiple=" + multiple + ", units=" + units + ", open=" + open
				+ ", details=" + details + ", type=" + type + ", raw=" + raw + ", issuetxid=" + issuetxid
				+ ", addresses=" + addresses + ", issue=" + issue + "]";
	}

	/**
	 *
	 */
	public BalanceAsset() {
		super();
	}

	/**
	 * @return the multiple
	 */
	public long getMultiple() {
		return multiple;
	}

	/**
	 * @param multiple
	 *            the multiple to set
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
	 * @param units
	 *            the units to set
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
	 * @param open
	 *            the open to set
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}

	/**
	 * @return the details
	 */
	public Object getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(Object details) {
		this.details = details;
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
	 * @return the assetref
	 */
	public String getAssetref() {
		return assetref;
	}

	/**
	 * @param assetref
	 *            the assetref to set
	 */
	public void setAssetref(String assetref) {
		this.assetref = assetref;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the raw
	 */
	public long getRaw() {
		return raw;
	}

	/**
	 * @param raw
	 *            the raw to set
	 */
	public void setRaw(long raw) {
		this.raw = raw;
	}

	/**
	 * @return the raw
	 */
	public long getIssueraw() {
		return raw;
	}

	/**
	 * @param raw
	 *            the raw to set
	 */
	public void setIssueraw(long raw) {
		this.raw = raw;
	}

	/**
	 * @return the issuetxid
	 */
	public String getIssuetxid() {
		return issuetxid;
	}

	/**
	 * @param issuetxid
	 *            the issuetxid to set
	 */
	public void setIssuetxid(String issuetxid) {
		this.issuetxid = issuetxid;
	}

	/**
	 * @return the issue
	 */
	public boolean isIssue() {
		return issue;
	}

	/**
	 * @param issue
	 *            the issue to set
	 */
	public void setIssue(boolean issue) {
		this.issue = issue;
	}

}
