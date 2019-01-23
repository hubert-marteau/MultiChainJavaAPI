/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.List;
import multichain.object.AssetTransaction;

/**
 * @version 4.18
 */
public class AssetTransactionFormatter {
	public final static List<AssetTransaction> formatListAssetTransaction(List<Object> objectAssetTransactions) {
		List<AssetTransaction> assetTransactionList = new ArrayList<AssetTransaction>();
		if (objectAssetTransactions != null) {
			for (Object objectAssetTransaction : objectAssetTransactions) {
				assetTransactionList.add(formatAssetTransaction(objectAssetTransaction));
			}
		}
		return assetTransactionList;
	}

	public final static AssetTransaction formatAssetTransaction(Object objectAssetTransaction) {
		AssetTransaction assetTransaction = new AssetTransaction();
		if (objectAssetTransaction != null && LinkedTreeMap.class.isInstance(objectAssetTransaction)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectAssetTransaction);
			assetTransaction = gson.fromJson(jsonValue, AssetTransaction.class);
		}
		return assetTransaction;
	}

}
