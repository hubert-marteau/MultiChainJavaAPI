/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command.builders;

import multichain.command.MultichainException;

/**
 * @author Ub - H. MARTEAU
 * @version 4.13
 */
public class QueryBuilderChain extends QueryBuilderCommon {

	protected String executeGetInfo() throws MultichainException {
		return execute(CommandEnum.GETINFO).toString();
	}
	
	protected String executeHelp(String arg)  throws MultichainException {
		if(arg == null) {
			return (String) execute(CommandEnum.HELP);
		} else {
			return (String) execute(CommandEnum.HELP, arg);
		}
	}

}
