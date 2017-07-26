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
 * @version 3.0
 */
public class QueryBuilderChain extends QueryBuilderCommon {

	protected Object executeGetInfo() throws MultichainException {
		return execute(CommandEnum.GETINFO);
	}

}
