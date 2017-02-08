/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class MultiBalance {

	String label;
	List<BalanceAsset> assets;


	public MultiBalance() {
		super();
		assets = new ArrayList<BalanceAsset>();
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}


	/**
	 * @return the assets
	 */
	public List<BalanceAsset> getAssets() {
		return assets;
	}


	public BalanceAsset getFirstAsset() {
		BalanceAsset returnedValue;
		if (this.assets != null && this.assets.size() > 0) {
			returnedValue = this.assets.get(0);
		} else {
			returnedValue = new BalanceAsset();
		}
		return returnedValue;
	}

	/**
	 * @param assets the assets to set
	 */
	public void setAssets(List<BalanceAsset> assets) {
		this.assets = assets;
	}

	/**
	 * @param asset to add
	 */
	public void addAsset(BalanceAsset asset) {
		this.assets.add(asset);
	}
}
