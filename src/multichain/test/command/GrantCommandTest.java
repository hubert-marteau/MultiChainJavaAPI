/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.test.command;

import java.util.List;

import multichain.command.MultiChainCommand;
import multichain.command.MultichainException;
import multichain.object.Permission;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0
 */
public class GrantCommandTest {
	static MultiChainCommand multiChainCommand;

	/**
	 *
	 */
	public GrantCommandTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testlistPermissions() {
		List<Permission> result = null;
		try {
			result = multiChainCommand.getGrantCommand().listPermissions(multiChainCommand.getGrantCommand().WALLET);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result == null || result.size() == 0) {
			System.err.println("testlistPermissions (WALLET) - result list is empty");
		} else {
			System.out.println("testlistPermissions (WALLET) - Result :");
			for (Permission res : result) {
				System.out.println(res);
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of AddressCommandTest ---");

		// BlockChain TestCommand has to be created and started before
		multiChainCommand = new MultiChainCommand("localhost", "6824", "multichainrpc",
				"73oYQWzx45hossFPPWUgicpLvHhsD8PempYxnSF6bnY9");

		testlistPermissions();

		System.out.println("--- End of AddressCommandTest ---");
	}

}
