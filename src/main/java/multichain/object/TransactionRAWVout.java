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
public class TransactionRAWVout {
	double value;
	long n;
	ScriptPubKey scriptPubKey;
	List<BalanceAsset> assets;
	List<Permission> permissions;
	List<Item> items;

	/**
	 *
	 */
	public TransactionRAWVout() {
		super();
		scriptPubKey = new ScriptPubKey();
		assets = new ArrayList<BalanceAsset>();
		permissions = new ArrayList<Permission>();
		items = new ArrayList<Item>();
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
	 * @return the n
	 */
	public long getN() {
		return n;
	}

	/**
	 * @param n the n to set
	 */
	public void setN(long n) {
		this.n = n;
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
	 * @param asset to add to the assets list
	 */
	public void addAsset(BalanceAsset asset) {
		this.assets.add(asset);
	}

	/**
	 * @return the permissions
	 */
	public List<Permission> getPermissions() {
		return permissions;
	}

	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	/**
	 * @param permissions the permissions to set
	 */
	public void addPermission(Permission permission) {
		this.permissions.add(permission);
	}

  /**
   * @return the items
   */
  public List<Item> getItems() {
    return items;
  }

  /**
   * @param items the items to set
   */
  public void setItems(List<Item> items) {
    this.items = items;
  }


}
