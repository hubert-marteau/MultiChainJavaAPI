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
 * @version 4.14
 */
public class TxOut {

	String bestblock = null;
	Long confirmations = null;
	Double value = null;
	ScriptPubKey scriptPubKey = null;
	Long version = null;
	Boolean coinbase = null;
	List<BalanceAsset> assets;

	public TxOut() {
		super();
		scriptPubKey = new ScriptPubKey();
		assets = new ArrayList<BalanceAsset>();
	}

	/**
	 * @return the bestblock
	 */
	public String getBestblock() {
		return bestblock;
	}

	/**
	 * @param bestblock the bestblock to set
	 */
	public void setBestblock(String bestblock) {
		this.bestblock = bestblock;
	}

	/**
	 * @return the confirmations
	 */
	public long getConfirmations() {
		return confirmations;
	}

	/**
	 * @param confirmations the confirmations to set
	 */
	public void setConfirmations(long confirmations) {
		this.confirmations = confirmations;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * @return the scriptPubKey
	 */
	public ScriptPubKey getScriptPubKey() {
		return scriptPubKey;
	}

	/**
	 * @param scriptPubKey the scriptPubKey to set
	 */
	public void setScriptPubKey(ScriptPubKey scriptPubKey) {
		this.scriptPubKey = scriptPubKey;
	}

	/**
	 * @return the version
	 */
	public long getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(long version) {
		this.version = version;
	}

	/**
	 * @return the coinbase
	 */
	public boolean isCoinbase() {
		return coinbase;
	}

	/**
	 * @param coinbase the coinbase to set
	 */
	public void setCoinbase(boolean coinbase) {
		this.coinbase = coinbase;
	}

	/**
	 * @return the assets
	 */
	public List<BalanceAsset> getAssets() {
		return assets;
	}

	/**
	 * @param assets the assets to set
	 */
	public void setAssets(List<BalanceAsset> assets) {
		this.assets = assets;
	}

	/**
	 * @param asset the asset to add
	 */
	public void addAsset(BalanceAsset asset) {
		this.assets.add(asset);
	}
}
