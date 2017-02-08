/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import multichain.object.Transaction;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class TransactionFormatter {


	public final static Transaction formatTransaction(String stringTransaction) {
		final Gson gson = new GsonBuilder().create();

		final Transaction transaction = gson.fromJson(stringTransaction, Transaction.class);

		return transaction;
	}

}
