/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

import multichain.command.MultichainException;
import multichain.command.tools.MultichainTestParameter;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class BalanceAssetBase {
	String name;
	double qty;

	public void isFilled() throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("name", getName());
		MultichainTestParameter.valueIsPositive("qty", getQty());
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
	 * @return the qty
	 */
	public double getQty() {
		return qty;
	}
	/**
	 * @param qty the qty to set
	 */
	public void setQty(double qty) {
		this.qty = qty;
	}
	/**
	 * @return the qty
	 */
	public double getIssueqty() {
		return qty;
	}
	/**
	 * @param qty the qty to set
	 */
	public void setIssueqty(double qty) {
		this.qty = qty;
	}



}
