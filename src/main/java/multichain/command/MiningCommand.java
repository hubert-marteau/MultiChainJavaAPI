/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

import multichain.command.builders.QueryBuilderMining;

/**
 * @author Ub - H. MARTEAU
 * @version 4.15
 */
public class MiningCommand extends QueryBuilderMining {
	public MiningCommand(String ip, String port, String login, String password, RuntimeParameters runtimeparameters) {
		initialize(ip, port, login, password, runtimeparameters);
	}
	
	public Object pauseMining() throws MultichainException {
		return executePauseMining();
	}
	
	public Object resumeMining() throws MultichainException {
		return executeResumeMining();
	}
	
}
