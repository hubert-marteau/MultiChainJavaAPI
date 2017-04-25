/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

import java.util.logging.Logger;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class MultichainException extends Exception {
	private final Logger log = Logger.getAnonymousLogger();
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 2412952380749244614L;

	public MultichainException(String object, String reason){
		log.info(object +" \nReason: "+reason);
	}
}
