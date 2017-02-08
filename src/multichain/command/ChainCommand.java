/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

import multichain.command.builders.QueryBuilderChain;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class ChainCommand extends QueryBuilderChain {

	/**
	 * Initialize usage BlockChain
	 * @param nameChain name of the BlockChain to use
	 */
	public static void initializeChain(String nameChain) {
		QueryBuilderChain.initializeChain(nameChain);
	}

}
