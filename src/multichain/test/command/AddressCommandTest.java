/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.test.command;

import java.util.Arrays;
import java.util.List;

import multichain.command.*;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class AddressCommandTest {

	/**
	 *
	 */
	public AddressCommandTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testgetAddresses() {
		List<String> result = null;
		try {
			result = AddressCommand.getAddresses();
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) { System.err.println("testgetAddresses - result list is empty"); }
		else {
            for (String address : result) {
                grantPermissionCreate(address);
            }
        }
	}

	private static void grantPermissionCreate(String address){
        try {
            String result = GrantCommand.grant(address, GrantCommand.CREATE);
            System.out.println(result);
        } catch (MultichainException e) {
            e.printStackTrace();
        }
    }

	private static void testCreateStream() {
		String transactionId = null;
		try {
			transactionId = StreamCommand.createStream("teststream1", true);
		} catch (MultichainException e) {
			e.printStackTrace();
		}
		System.out.println(transactionId);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of AddressCommandTest ---");

		//BlockChain TestCommand has to be created and started before
		ChainCommand.initializeChain("plagchain");
		testCreateStream();
		//testgetAddresses();
		System.out.println("--- End of AddressCommandTest ---");
	}

}
