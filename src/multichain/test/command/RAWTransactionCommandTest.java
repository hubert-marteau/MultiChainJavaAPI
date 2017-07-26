/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.test.command;

import multichain.command.MultiChainCommand;
import multichain.command.MultichainException;
import multichain.object.SignedTransactionRAW;
import multichain.object.formatters.GsonFormatters;

/**
 * @author Ub - H. MARTEAU
 * @version 2.1
 */
public class RAWTransactionCommandTest extends GsonFormatters {

	static MultiChainCommand multiChainCommand;

	static String address1;
	static String address2;
	static String assetName;

	private static void testsignRawTransaction() {
		String rawtransaction = "010000000103b800bda672b9a23d5e039b6d895a17cfa8d467431e3a18a4879cc86025b77e0000000000ffffffff0200000000000000003776a914c8054354dc1ca5542aaec06bc1521b83664e067088ac1c73706b71cfa8d467431e3a18a4879cc86025b77e010000000000000075000000000000000035a914cd94314baf6d7dc041e262103569ebb9af254491871c73706b71cfa8d467431e3a18a4879cc86025b77e0f270000000000007500000000";

		SignedTransactionRAW result = null;

		try {
			result = multiChainCommand.getRawTransactionCommand().signRawTransaction(rawtransaction);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result == null) {
			System.err.println("testsignRawTransaction - result is empty");
		} else {
			System.out.println("testsignRawTransaction");
			System.out.println("Result :");
			System.out.println(result);
		}

	}

	/**
	 * @param args
	 * @throws MultichainException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws MultichainException, InterruptedException {
		System.out.println("--- Start of RAWTransactionCommandTest ---");

		// BlockChain TestCommand has to be created and started before
		multiChainCommand = new MultiChainCommand("localhost", "6824", "multichainrpc",
				"73oYQWzx45hossFPPWUgicpLvHhsD8PempYxnSF6bnY9");

		testsignRawTransaction();

		System.out.println("--- End of RAWTransactionCommandTest ---");
	}

}
