/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.test.command;

import java.util.ArrayList;
import java.util.List;

import multichain.command.MultiChainCommand;
import multichain.command.MultichainException;
import multichain.object.SignedTransactionRAW;
import multichain.object.formatters.GsonFormatters;
import multichain.object.queryobjects.AssetQuantity;
import multichain.object.queryobjects.RawParam;

/**
 * @author Ub - H. MARTEAU
 * @version 2.1
 */
public class RAWTransactionCommandTest extends GsonFormatters {

	static MultiChainCommand multiChainCommand;

	static String address1;
	static String address2;
	static String assetName;

	private static void testcreateRawSendFrom() {
		String result1 = "";
		String result2 = "";
		SignedTransactionRAW result3 = null;
		try {
			List<RawParam> params = new ArrayList<RawParam>();
			List<AssetQuantity> assets = new ArrayList<AssetQuantity>();
			assets.add(new AssetQuantity(assetName, 42));

			params.add(new RawParam(address2, assets));
			String[] data = { "0a1b2c3d4e5f" };

			result1 = multiChainCommand.getRawTransactionCommand().createRawSendFrom(address1, params);
			result2 = multiChainCommand.getRawTransactionCommand().createRawSendFrom(address1, params, data);
			result3 = multiChainCommand.getRawTransactionCommand().createRawSendFrom(address1, params, data, "sign");

		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result1 == null || "".equals(result1)) {
			System.err.println("testcreateRawSendFrom - result1 is empty");
		} else {
			System.out.println("testcreateRawSendFrom");
			System.out.println("Result (single) :");
			System.out.println(result1);
		}
		if (result2 == null || "".equals(result2)) {
			System.err.println("testcreateRawSendFrom - result2 is empty");
		} else {
			System.out.println("testcreateRawSendFrom");
			System.out.println("Result (with data) :");
			System.out.println(result2);
		}
		if (result3 == null) {
			System.err.println("testcreateRawSendFrom - result3 is empty");
		} else {
			System.out.println("testcreateRawSendFrom");
			System.out.println("Result (with data & action) :");
			System.out.println(result3);
		}
	}

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

		multiChainCommand = new MultiChainCommand("TestAPI1");

		// // BlockChain TestCommand has to be created and started before
		// address1 = AddressCommand.getNewAddress();
		// System.out.println("Created Address1 : " + address1);
		// address2 = AddressCommand.getNewAddress();
		// System.out.println("Created Address2 : " + address2);
		// System.out.println("Created Address2 : " + formatJson(address2));
		//
		// GrantCommand.grant(address1, GrantCommand.CONNECT | GrantCommand.ISSUE | GrantCommand.RECEIVE
		// | GrantCommand.SEND);
		// System.out.println("Rights Address1 : done !");
		// GrantCommand.grant(address2, GrantCommand.CONNECT | GrantCommand.ISSUE | GrantCommand.RECEIVE
		// | GrantCommand.SEND);
		// System.out.println("Rights Address2 : done !");
		//
		// SimpleDateFormat formater = new SimpleDateFormat("ddMMyyhhmmss");
		// assetName = "TestAPI1" + formater.format(new Date());
		//
		// IssueCommand.issue(address1, assetName, 100, 1, 0);
		// System.out.println("Created Asset : " + assetName);
		//
		// System.out.println("Initialization done !");
		//
		// testcreateRawSendFrom();

		testsignRawTransaction();

		System.out.println("--- End of RAWTransactionCommandTest ---");
	}

}
