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
public class Transaction extends TransactionGeneral {
	List<TransactionDetail> details;
	String hex = null;

	/**
	 *
	 */
	public Transaction() {
		super();
		details = new ArrayList<TransactionDetail>();
	}

	/**
	 *
	 */
	public Transaction(TransactionBase transactionBase) {
		super(transactionBase);
		details = new ArrayList<TransactionDetail>();
	}

	/**
	 * @return the details
	 */
	public List<TransactionDetail> getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(List<TransactionDetail> details) {
		this.details = details;
	}

	/**
	 * @param detail the detail to add to details
	 */
	public void addDetails(TransactionDetail detail) {
		this.details.add(detail);
	}

	/**
	 * @return the hex
	 */
	public String getHex() {
		return hex;
	}

	/**
	 * @param hex the hex to set
	 */
	public void setHex(String hex) {
		this.hex = hex;
	}



}
