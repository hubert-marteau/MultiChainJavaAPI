/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import multichain.object.TxOut;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class TxOutFormatter {
	public final static TxOut formatTxOut(String stringTxOut) {
		final Gson gson = new GsonBuilder().create();

		final TxOut txOut = gson.fromJson(stringTxOut, TxOut.class);

		return txOut;
	}

}
