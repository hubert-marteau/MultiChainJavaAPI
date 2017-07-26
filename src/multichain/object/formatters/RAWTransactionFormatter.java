/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import multichain.object.SignedTransactionRAW;
import multichain.object.TransactionRAW;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

/**
 * @author Ub - H. MARTEAU
 * @version 3.0
 */
public class RAWTransactionFormatter {
	public final static TransactionRAW formatTransactionRAW(Object objectTransactionRAW) {
		TransactionRAW transactionRAW = new TransactionRAW();

		if (objectTransactionRAW != null && LinkedTreeMap.class.isInstance(objectTransactionRAW)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectTransactionRAW);
			transactionRAW = gson.fromJson(jsonValue, TransactionRAW.class);
		}

		return transactionRAW;
	}

	public final static SignedTransactionRAW formatSignedTransactionRAW(Object objectSignedTransactionRAW) {
		SignedTransactionRAW signedTransactionRAW = new SignedTransactionRAW();

		if (objectSignedTransactionRAW != null && LinkedTreeMap.class.isInstance(objectSignedTransactionRAW)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectSignedTransactionRAW);
			signedTransactionRAW = gson.fromJson(jsonValue, SignedTransactionRAW.class);
		}

		return signedTransactionRAW;
	}

}
