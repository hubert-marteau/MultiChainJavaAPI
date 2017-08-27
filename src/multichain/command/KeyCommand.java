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
import multichain.command.builders.QueryBuilderKey;
import multichain.object.BalanceAsset;
import multichain.object.formatters.BalanceFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 3.0
 */
public class KeyCommand extends QueryBuilderKey {
	public KeyCommand(String ip, String port, String login, String password) {
		initialize(ip, port, login, password);
	}

	public Object getPrivkey(String privkey) throws MultichainException {
		return executeDumpPrivkey(privkey);
	}
	
	public Object importPrivkey(String privkey) throws MultichainException {
		return executeImportPrivkey(privkey);
	}

}
