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
 * @version 3.2
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
		List<Address> resultAddress = null;
		try {
			result = multiChainCommand.getAddressCommand().getAddresses();
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testgetAddresses - result list is empty");
		} else {
			System.out.println("testgetAddresses - Result :");
			for (String ad : result) {
				System.out.println(ad);
			}
		}
		System.out.println("");
		System.out.println("");
		try {
			resultAddress = multiChainCommand.getAddressCommand().getAddressesList();
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (resultAddress == null || resultAddress.size() == 0) {
			System.err.println("testgetAddressesList - result list is empty");
		} else {
			System.out.println("testgetAddressesList - Result :");
			for (Address ad : resultAddress) {
				System.out.println(ad.toString());
			}
		}
		System.out.println("");
		System.out.println("");
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
					System.out.println("");
				}
			} else {
				System.err.println("testgetAddresses - result list is empty");
			}
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testgetNewAddress() {
		String resultAddress = "";
		Address result = null;

		System.out.println("testgetNewAddress");
		try {
			resultAddress = multiChainCommand.getAddressCommand().getNewAddress();
			if (resultAddress != null && !"".equals(resultAddress)) {
				System.out.println("   getNewAddress :");
				System.out.println(resultAddress);
			} else {
				System.err.println("getNewAddress - result is empty");
			}
			System.out.println();
			System.out.println();

			result = multiChainCommand.getAddressCommand().getNewAddressFilled();
			if (result != null && result.getAddress() != null && !"".equals(result.getAddress())) {
				System.out.println("   getNewAddressFilled :");
				System.out.println(result);
			} else {
				System.err.println("getNewAddress - result is empty");
			}
			System.out.println();
			System.out.println();

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
		multiChainCommand = new MultiChainCommand("localhost", "6824", "multichainrpc",
				"73oYQWzx45hossFPPWUgicpLvHhsD8PempYxnSF6bnY9");

		testgetAddresses();
		testvalidateAddress();

		System.out.println();
		System.out.println();

		testgetNewAddress();

		System.out.println("--- End of AddressCommandTest ---");
	}

}
