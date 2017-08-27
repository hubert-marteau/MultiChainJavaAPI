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
public class TransactionWalletDetailed extends TransactionWallet {
	List<TransactionWalletVin> vin;
	List<TransactionWalletVout> vout;
	String hex;

	/**
	 *
	 */
	public TransactionWalletDetailed() {
		super();
		vin = new ArrayList<TransactionWalletVin>();
		vout = new ArrayList<TransactionWalletVout>();
		hex = "";
	}

	/**
	 * @param base
	 */
	public TransactionWalletDetailed(TransactionWallet wallet) {
		super(wallet);
		vin = new ArrayList<TransactionWalletVin>();
		vout = new ArrayList<TransactionWalletVout>();
		hex = "";
	}

	/**
	 * @param base
	 */
	public TransactionWalletDetailed(TransactionBase base) {
		super(base);
		vin = new ArrayList<TransactionWalletVin>();
		vout = new ArrayList<TransactionWalletVout>();
		hex = "";
	}



	/**
	 * @return the vin
	 */
	public List<TransactionWalletVin> getVin() {
		return vin;
	}

	/**
	 * @param vin the vin to set
	 */
	public void setVin(List<TransactionWalletVin> vin) {
		this.vin = vin;
	}

	public void addVin(TransactionWalletVin vin) {
		this.vin.add(vin);
	}

	/**
	 * @return the vout
	 */
	public List<TransactionWalletVout> getVout() {
		return vout;
	}

	/**
	 * @param vout the vout to set
	 */
	public void setVout(List<TransactionWalletVout> vout) {
		this.vout = vout;
	}

	public void addVout(TransactionWalletVout vout) {
		this.vout.add(vout);
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
