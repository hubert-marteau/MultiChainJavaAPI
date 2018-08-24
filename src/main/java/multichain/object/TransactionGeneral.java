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
abstract class TransactionGeneral extends TransactionBase {
	Double amount = null;
	Double fee = null;
	List<String> walletconflicts;

	/**
	 *
	 */
	public TransactionGeneral() {
		super();
		walletconflicts = new ArrayList<String>();
	}

	/**
	 *
	 */
	public TransactionGeneral(TransactionBase transactionBase) {
		super(transactionBase);
		walletconflicts = new ArrayList<String>();
	}

	/**
	 * @param amount
	 * @param fee
	 * @param walletconflicts
	 */
	public TransactionGeneral(TransactionGeneral transactionGeneral) {
		super(transactionGeneral);
		this.amount = transactionGeneral.getAmount();
		this.fee = transactionGeneral.getFee();
		this.walletconflicts = transactionGeneral.getWalletconflicts();
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

	/**
	 * @return the fee
	 */
	public double getFee() {
		return fee;
	}

	/**
	 * @param fee the fee to set
	 */
	public void setFee(double fee) {
		this.fee = fee;
	}

	/**
	 * @return the walletconflicts
	 */
	public List<String> getWalletconflicts() {
		return walletconflicts;
	}

	/**
	 * @param walletconflicts the walletconflicts to set
	 */
	public void setWalletconflicts(List<String> walletconflicts) {
		this.walletconflicts = walletconflicts;
	}

	/**
	 * @param walletconflict the walletconflict to add to walletconflicts
	 */
	public void addWalletconflicts(String walletconflict) {
		this.walletconflicts.add(walletconflict);
	}

}
