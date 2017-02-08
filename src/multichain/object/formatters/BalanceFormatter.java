/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import multichain.object.BalanceAsset;
import multichain.object.MultiBalance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class BalanceFormatter {
	public final static List<BalanceAsset> formatBalanceAssets(String stringBalanceAsset) {
		final Gson gson = new GsonBuilder().create();

		Type listType = new TypeToken<List<BalanceAsset>>(){}.getType();
		final List<BalanceAsset> balanceAsset = gson.fromJson(stringBalanceAsset, listType);

		return balanceAsset;
	}

	public final static BalanceAsset formatBalanceAsset(String stringBalanceAsset) {
		final Gson gson = new GsonBuilder().create();
		final BalanceAsset balanceAsset = gson.fromJson(stringBalanceAsset, BalanceAsset.class);

		return balanceAsset;
	}

	public final static List<MultiBalance> formatMultiBalances(String stringMultiBalance) {
		final Gson gson = new GsonBuilder().create();

		Type listType = new TypeToken<HashMap<String,List<BalanceAsset>>>(){}.getType();
		final HashMap<String,List<BalanceAsset>> multiBalanceHash = gson.fromJson(stringMultiBalance, listType);

		List<String> keys = new ArrayList<>(multiBalanceHash.keySet());

		List<MultiBalance> multiBalanceList = new ArrayList<MultiBalance>();
		for (String key : keys) {
			MultiBalance m = new MultiBalance();
			m.setAssets((List<BalanceAsset>)multiBalanceHash.get(key));
			m.setLabel(key);

			multiBalanceList.add(m);
		}

		return multiBalanceList;
	}



}
