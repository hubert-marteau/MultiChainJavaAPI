/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.test.command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import multichain.command.MultiChainCommand;
import multichain.command.MultichainException;
import multichain.object.BalanceAsset;
import multichain.object.queryobjects.CustomParamString;

/**
 * @author Ub - H. MARTEAU
 * @version 2.1
 */
public class IssueCommandTest {
	static MultiChainCommand multiChainCommand;

	static String assetName = "";

	/**
	 *
	 */
	public IssueCommandTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testissue() {
		String result = "";
		try {
			List<String> addresses = multiChainCommand.getAddressCommand().getAddresses();
			if (addresses != null && addresses.size() > 0) {
				String address = addresses.get(0);

				List<CustomParamString> customFields = new ArrayList<CustomParamString>();
				customFields.add(new CustomParamString("name1", "value1"));
				customFields.add(new CustomParamString("name2", "value2"));
				customFields.add(new CustomParamString("name3", "value3"));
				result = multiChainCommand.getIssueCommand().issue(address, assetName, 100, 1, 0, customFields);
			}
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || "".equals(result)) {
			System.err.println("testissue - result is empty");
		} else {
			System.out.println("testissue");
			System.out.println("Result :");
			System.out.println(result);
		}
	}

	private static void testlistAssets() {
		List<BalanceAsset> result = null;
		try {
			result = multiChainCommand.getIssueCommand().listAssets(assetName);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() != 1) {
			System.err.println("testlistAssets - result is empty");
		} else {
			BalanceAsset balanceAsset = result.get(0);
			System.out.println("testlistAssets");
			System.out.println("Result :");
			System.out.println(balanceAsset.toString());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of IssueCommandTest ---");

		// BlockChain TestCommand has to be created and started before
		multiChainCommand = new MultiChainCommand("TestAPI1");

		SimpleDateFormat formater = new SimpleDateFormat("ddMMyyhhmmss");
		assetName = "TestAPI1" + formater.format(new Date());
		testissue();
		testlistAssets();

		System.out.println("--- End of IssueCommandTest ---");
	}

}
