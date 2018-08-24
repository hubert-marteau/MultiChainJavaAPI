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
 * @version 4.13
 */
public class TransactionWalletVInfo {
	List<String> addresses;
	String type;
	boolean ismine;
	boolean iswatchonly;
	double amount;
	List<BalanceAssetWalletTransaction> assets;

	/**
	 *
	 */
	public TransactionWalletVInfo() {
		super();
		addresses = new ArrayList<String>();
		assets = new ArrayList<BalanceAssetWalletTransaction>();
		type = "";
	}

	/**
	 *
	 */
	public TransactionWalletVInfo(TransactionWalletVInfo info) {
		super();
		this.addresses = info.getAddresses();
		this.type = info.getType();
		this.ismine = info.isIsmine();
		this.iswatchonly = info.isIswatchonly();
		this.assets = info.getAssets();
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the ismine
	 */
	public boolean isIsmine() {
		return ismine;
	}
	/**
	 * @param ismine the ismine to set
	 */
	public void setIsmine(boolean ismine) {
		this.ismine = ismine;
	}
	/**
	 * @return the iswatchonly
	 */
	public boolean isIswatchonly() {
		return iswatchonly;
	}
	/**
	 * @param iswatchonly the iswatchonly to set
	 */
	public void setIswatchonly(boolean iswatchonly) {
		this.iswatchonly = iswatchonly;
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
	 * @return the assets
	 */
	public List<BalanceAssetWalletTransaction> getAssets() {
		return assets;
	}

	/**
	 * @param assets the assets to set
	 */
	public void setAssets(List<BalanceAssetWalletTransaction> assets) {
		this.assets = assets;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
