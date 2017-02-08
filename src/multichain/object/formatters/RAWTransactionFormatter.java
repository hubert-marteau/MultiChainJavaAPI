/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import multichain.object.TransactionRAW;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class RAWTransactionFormatter {
	public final static TransactionRAW formatTransactionRAW(String stringTransactionRAW) {
		final Gson gson = new GsonBuilder().create();

		final TransactionRAW transactionRAW = gson.fromJson(stringTransactionRAW, TransactionRAW.class);

		return transactionRAW;
	}
}
