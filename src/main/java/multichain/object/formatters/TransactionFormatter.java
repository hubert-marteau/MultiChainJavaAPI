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
import com.google.gson.internal.LinkedTreeMap;

/**
 * @author Ub - H. MARTEAU
 * @version 3.0
 */
public class TransactionFormatter {

	public final static Transaction formatTransaction(Object objectTransaction) {
		Transaction transaction = new Transaction();

		if (objectTransaction != null && LinkedTreeMap.class.isInstance(objectTransaction)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectTransaction);
			transaction = gson.fromJson(jsonValue, Transaction.class);
		}

		return transaction;
	}

}
