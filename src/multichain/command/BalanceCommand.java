/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

import java.util.ArrayList;
import java.util.List;

import multichain.command.builders.QueryBuilderBalance;
import multichain.object.BalanceAsset;
import multichain.object.formatters.BalanceFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0
 */
public class BalanceCommand extends QueryBuilderBalance {
	public BalanceCommand(String chainName) {
		setCHAIN(chainName);
	}

	/**
	 * 
	 * gettotalbalances ( minconf includeWatchonly includeLocked)
	 * 
	 * If account is not specified, returns the server's total available asset
	 * balances. If account is specified, returns the balances in the account.
	 * Note that the account "" is not the same as leaving the parameter out.
	 * The server total may be different to the balance in the default ""
	 * account.
	 * 
	 * Arguments: 1. minconf (numeric, optional, default=1) Only include
	 * transactions confirmed at least this many times. 2. includeWatchonly
	 * (bool, optional, default=false) Also include balance in watchonly
	 * addresses (see 'importaddress') 3. includeLocked (bool, optional,
	 * default=false) Also take locked outputs into account Results are an array
	 * of Objects with totals and details for each asset.
	 * 
	 * @return a list of all the asset balances in this node’s wallet
	 * @throws MultichainException
	 */
	public List<BalanceAsset> getTotalBalances() throws MultichainException {
		List<BalanceAsset> listBalanceAsset = new ArrayList<BalanceAsset>();

		String stringBalanceAsset = executeGetTotalBalances();
		listBalanceAsset = BalanceFormatter.formatBalanceAssets(stringBalanceAsset);

		return listBalanceAsset;
	}

	/**
	 * 
	 * getunconfirmedbalance Returns the server's total unconfirmed balance
	 * 
	 * @return not formated balance
	 * @throws MultichainException
	 */
	public String getUnconfirmedBalance() throws MultichainException {
		return executeGetUnconfirmedBalance();
	}

}
