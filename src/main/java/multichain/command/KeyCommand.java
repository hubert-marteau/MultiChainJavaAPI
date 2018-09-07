/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

import multichain.command.builders.QueryBuilderKey;

/**
 * @author Ub - H. MARTEAU
 * @version 4.15
 */
public class KeyCommand extends QueryBuilderKey {
	public KeyCommand(String ip, String port, String login, String password, RuntimeParameters runtimeparameters) {
		initialize(ip, port, login, password, runtimeparameters);
	}

	public Object getPrivkey(String privkey) throws MultichainException {
		return executeDumpPrivkey(privkey);
	}
	
	public Object importPrivkey(String privkey) throws MultichainException {
		return executeImportPrivkey(privkey);
	}

}
