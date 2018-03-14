/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.queryobjects;

import multichain.command.MultichainException;
import multichain.command.tools.MultichainTestParameter;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class TxIdVout {
	String txid;
	int vout;

	public void isFilled() throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("txId", txid);
		MultichainTestParameter.valueIsNotNegative("vOut", vout);
	}

	/**
	 * @return the txId
	 */
	public String getTxId() {
		return txid;
	}
	/**
	 * @param txId the txId to set
	 */
	public void setTxId(String txId) {
		this.txid = txId;
	}
	/**
	 * @return the vOut
	 */
	public int getvOut() {
		return vout;
	}
	/**
	 * @param vOut the vOut to set
	 */
	public void setvOut(int vOut) {
		this.vout = vOut;
	}


}
