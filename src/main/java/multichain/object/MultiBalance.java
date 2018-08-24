/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ub - H. MARTEAU
 * @version 4.14
 */
public class MultiBalance extends HashMap<String, List<BalanceAssetGeneral>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8083084604911767367L;

	/**
	 * 
	 */
	public MultiBalance() {
		super();
	}

	/**
	 * @param initialCapacity
	 * @param loadFactor
	 */
	public MultiBalance(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	/**
	 * @param initialCapacity
	 */
	public MultiBalance(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * @param m
	 */
	public MultiBalance(Map<? extends String, ? extends List<BalanceAssetGeneral>> m) {
		super(m);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String multiBalance = "MultiBalance [";
		for (String key : this.keySet()) {
			multiBalance += key + ":";

			List<BalanceAssetGeneral> listBalanceAsset = this.get(key);
			for (BalanceAssetGeneral balanceAsset : listBalanceAsset) {
				multiBalance += balanceAsset.toString() + ",";
			}
		}
		multiBalance += "]";

		return multiBalance;
	}

	// /**
	// * @return the label
	// */
	// public String getLabel() {
	// return label;
	// }
	//
	// /**
	// * @param label
	// * the label to set
	// */
	// public void setLabel(String label) {
	// this.label = label;
	// }
	//
	// /**
	// * @return the assets
	// */
	// public List<BalanceAsset> getAssets() {
	// return assets;
	// }
	//
	// public BalanceAsset getFirstAsset() {
	// BalanceAsset returnedValue;
	// if (this.assets != null && this.assets.size() > 0) {
	// returnedValue = this.assets.get(0);
	// } else {
	// returnedValue = new BalanceAsset();
	// }
	// return returnedValue;
	// }
	//
	// /**
	// * @param assets
	// * the assets to set
	// */
	// public void setAssets(List<BalanceAsset> assets) {
	// this.assets = assets;
	// }
	//
	// /**
	// * @param asset
	// * to add
	// */
	// public void addAsset(BalanceAsset asset) {
	// this.assets.add(asset);
	// }
}
