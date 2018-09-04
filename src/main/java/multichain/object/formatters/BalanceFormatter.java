/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import multichain.object.BalanceAsset;
import multichain.object.BalanceAssetGeneral;
import multichain.object.MultiBalance;

/**
 * @author Ub - H. MARTEAU
 * @version 4.13
 */
public class BalanceFormatter {
	public final static BalanceAssetGeneral formatBalanceAssetGeneral(Object objectBalanceAsset) {
		BalanceAssetGeneral balanceAsset = new BalanceAssetGeneral();

		if (objectBalanceAsset != null && LinkedTreeMap.class.isInstance(objectBalanceAsset)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectBalanceAsset);
			balanceAsset = gson.fromJson(jsonValue, BalanceAssetGeneral.class);
		}

		return balanceAsset;
	}

	public final static List<BalanceAssetGeneral> formatBalanceAssetsGeneral(List<Object> objectBalanceAssets) {
		List<BalanceAssetGeneral> balanceAsset = new ArrayList<BalanceAssetGeneral>();

		if (objectBalanceAssets != null) {
			for (Object objectBalanceAsset : objectBalanceAssets) {
				balanceAsset.add(formatBalanceAssetGeneral(objectBalanceAsset));
			}
		}

		return balanceAsset;
	}	
	
	public final static BalanceAsset formatBalanceAsset(Object objectBalanceAsset) {
		BalanceAsset balanceAsset = new BalanceAsset();

		if (objectBalanceAsset != null && LinkedTreeMap.class.isInstance(objectBalanceAsset)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectBalanceAsset);
			balanceAsset = gson.fromJson(jsonValue, BalanceAsset.class);
		}

		return balanceAsset;
	}

	public final static List<BalanceAsset> formatBalanceAssets(List<Object> objectBalanceAssets) {
		List<BalanceAsset> balanceAsset = new ArrayList<BalanceAsset>();

		if (objectBalanceAssets != null) {
			for (Object objectBalanceAsset : objectBalanceAssets) {
				balanceAsset.add(formatBalanceAsset(objectBalanceAsset));
			}
		}

		return balanceAsset;
	}

	public final static MultiBalance formatMultiBalance(Object objectMultiBalance) {
		MultiBalance multiBalance = new MultiBalance();

		if (objectMultiBalance != null && LinkedTreeMap.class.isInstance(objectMultiBalance)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectMultiBalance);
			multiBalance = gson.fromJson(jsonValue, MultiBalance.class);
		}

		return multiBalance;
	}


}
