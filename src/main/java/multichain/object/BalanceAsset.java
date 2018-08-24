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
 * @version 4.13
 */
public class BalanceAsset {
	String name;
	String issuetxid;
	String assetref;
	long multiple;
	double units;
	boolean open;
	Object details;
	double issueqty;
	long issueraw;
	boolean subscribed;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BalanceAsset [name=" + name + ", issuetxid=" + issuetxid + ", assetref=" + assetref + ", multiple="
				+ multiple + ", units=" + units + ", open=" + open + ", details=" + details + ", issueqty=" + issueqty
				+ ", issueraw=" + issueraw + ", subscribed=" + subscribed + "]";
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
	 * @return the raw
	 */
	public long getRaw() {
		return issueraw;
	}

	/**
	 * @param raw
	 *            the raw to set
	 */
	public void setRaw(long raw) {
		this.issueraw = raw;
	}

	/**
	 * @return the raw
	 */
	public long getIssueraw() {
		return issueraw;
	}

	/**
	 * @param raw
	 *            the raw to set
	 */
	public void setIssueraw(long raw) {
		this.issueraw = raw;
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
	 * @return the subscribed
	 */
	public boolean isSubscribed() {
		return subscribed;
	}

	/**
	 * @param subscribed the subscribed to set
	 */
	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the issueqty
	 */
	public double getIssueqty() {
		return issueqty;
	}

	/**
	 * @param issueqty the issueqty to set
	 */
	public void setIssueqty(double issueqty) {
		this.issueqty = issueqty;
	}

}
