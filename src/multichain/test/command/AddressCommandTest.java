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
import multichain.object.Address;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0
 */
public class AddressCommandTest {
	static MultiChainCommand multiChainCommand;

	/**
	 *
	 */
	public AddressCommandTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testgetAddresses() {
		List<String> result = null;
		try {
			result = multiChainCommand.getAddressCommand().getAddresses();
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testgetAddresses - result list is empty");
		} else {
			System.out.println("Result :");
			for (String ad : result) {
				System.out.println(ad);
			}
		}
	}

	private static void testvalidateAddress() {
		List<String> resultAddresses = null;
		Address result = null;
		try {
			resultAddresses = multiChainCommand.getAddressCommand().getAddresses();
			if (resultAddresses != null && resultAddresses.size() != 0) {
				for (String addressString : resultAddresses) {
					result = multiChainCommand.getAddressCommand().validateAddress(addressString);
					System.out.println("testvalidateAddress - result for address " + addressString + " :");
					System.out.println(result);

					if (result == null || result.getAddress() == null || "".equals(result.getAddress())) {
						System.err.println("testvalidateAddress - result is not correct");
					}
					;
				}
			} else {
				System.err.println("testgetAddresses - result list is empty");
			}
			;
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of AddressCommandTest ---");

		// BlockChain TestCommand has to be created and started before
		multiChainCommand = new MultiChainCommand("TestAPI1");

		testgetAddresses();
		testvalidateAddress();

		System.out.println("--- End of AddressCommandTest ---");
	}

}
