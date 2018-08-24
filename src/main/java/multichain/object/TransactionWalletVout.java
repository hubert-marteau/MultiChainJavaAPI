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
 * @version 4.13
 */
public class TransactionWalletVout extends TransactionWalletVInfo{
	long n;
	List<Permission> permissions;
	List<Item> items;

	/**
	 *
	 */
	public TransactionWalletVout() {
		super();
		permissions = new ArrayList<Permission>();
		items = new ArrayList<Item>();
	}
	/**
	 * @param info
	 */
	public TransactionWalletVout(TransactionWalletVInfo info) {
		super(info);
		permissions = new ArrayList<Permission>();
		items = new ArrayList<Item>();
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
