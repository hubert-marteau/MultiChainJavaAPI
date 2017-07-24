/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command.builders;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0
 */
public class QueryBuilderChain extends QueryBuilderCommon {

	/**
	 * Initialze the BlockChain to use
	 * 
	 * @param nameChain
	 *            name of the blockChain to use
	 */
	protected void initializeChain(String nameChain) {
		setCHAIN(nameChain);
	}

}
