/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command.builders;

import multichain.command.MultichainException;
import multichain.command.builders.QueryBuilderCommon.CommandEnum;

/**
 * @author Ub - H. MARTEAU
 * @version 3.0
 */
public class QueryBuilderKey extends QueryBuilderCommon {

	protected Object executeDumpPrivkey(String privkey) throws MultichainException {
		return execute(CommandEnum.DUMPPRIVKEY, privkey);
	}
	
	protected Object executeImportPrivkey(String privkey) throws MultichainException {
		return execute(CommandEnum.IMPORTPRIVKEY, privkey);
	}
	
}
