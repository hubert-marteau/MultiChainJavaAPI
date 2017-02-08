/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.test.object.formatters;

import java.util.List;

import multichain.object.Address;
import multichain.object.formatters.AddressFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class AddressFormatterTest {

	/**
	 *
	 */
	public AddressFormatterTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testformatAddress() {
		String jsonAddress = "{"
			    + "\"isvalid\" : true,"
			    + "\"address\" : \"aBcDeFgH123IjKlMnOp456\","
			    + "\"ismine\" : false,"
			    + "\"iswatchonly\" : true,"
			    + "\"isscript\" : false,"
			    + "\"pubkey\" : \"qRsT789uVw456xYz123AbC456DeF789\","
			    + "\"iscompressed\" : true,"
			    + "\"account\" : \"Account1\"}";

		Address address = AddressFormatter.formatAddress(jsonAddress);

		if (!address.isIsvalid()) { System.err.println("testformatAddress - isvalid <> true"); };
		if (!"aBcDeFgH123IjKlMnOp456".equals(address.getAddress())) { System.err.println("testformatAddress - address <> aBcDeFgH123IjKlMnOp456"); };
		if (address.isIsmine()) { System.err.println("testformatAddress - ismine <> false"); };
		if (!address.isIswatchonly()) { System.err.println("testformatAddress - iswatchonly <> true"); };
		if (address.isIsscript()) { System.err.println("testformatAddress - isscript <> false"); };
		if (!"qRsT789uVw456xYz123AbC456DeF789".equals(address.getPubkey())) { System.err.println("testformatAddress - pubkey <> qRsT789uVw456xYz123AbC456DeF789"); };
		if (!address.isIscompressed()) { System.err.println("testformatAddress - iscompressed <> true"); };

	}


	private static void testformatAddressesStringList() {
		String jsonAddresses = "["
				+ "\"address1aBcDeFgH123IjKlMnOp456\","
				+ "\"address2aBcDeFgH123IjKlMnOp456\","
				+ "\"address3aBcDeFgH123IjKlMnOp456\","
				+ "\"address4aBcDeFgH123IjKlMnOp456\""
				+ "]";

		List<String> addressStringList = AddressFormatter.formatAddressesStringList(jsonAddresses);

		if (addressStringList.size() != 4) { System.err.println("testformatAddressesStringList - result list size <> 4"); };
		if (!"address1aBcDeFgH123IjKlMnOp456".equals(addressStringList.get(0))) { System.err.println("testformatAddressesStringList - address[0] <> address1aBcDeFgH123IjKlMnOp456"); };
		if (!"address2aBcDeFgH123IjKlMnOp456".equals(addressStringList.get(1))) { System.err.println("testformatAddressesStringList - address[1] <> address2aBcDeFgH123IjKlMnOp456"); };
		if (!"address3aBcDeFgH123IjKlMnOp456".equals(addressStringList.get(2))) { System.err.println("testformatAddressesStringList - address[2] <> address3aBcDeFgH123IjKlMnOp456"); };
		if (!"address4aBcDeFgH123IjKlMnOp456".equals(addressStringList.get(3))) { System.err.println("testformatAddressesStringList - address[3] <> address4aBcDeFgH123IjKlMnOp456"); };


	}

	private static void testformatAddressesList() {
		String jsonAddresses = "["
				+ "{"
				+ "\"address\" : \"address1aBcDeFgH123IjKlMnOp456\","
				+ "\"ismine\" : true,"
				+ "\"iswatchonly\" : false,"
				+ "\"isscript\" : false,"
				+ "\"pubkey\" : \"qRsT789uVw456xYz123AbC456DeF789\","
				+ "\"iscompressed\" : true,"
				+ "\"account\" : \"Account1\""
				+ "},"
				+ "{"
				+ "\"address\" : \"address2aBcDeFgH123IjKlMnOp456\","
				+ "\"ismine\" : true,"
				+ "\"iswatchonly\" : false,"
				+ "\"isscript\" : false,"
				+ "\"pubkey\" : \"qRsT789uVw456xYz123AbC456DeF789\","
				+ "\"iscompressed\" : true,"
				+ "\"account\" : \"\""
				+ "}"
				+ "]";

		List<Address> addressList = AddressFormatter.formatAddressesList(jsonAddresses);

		if (addressList.size() != 2) { System.err.println("testformatAddressesList - result list size <> 2"); };
		if (!"address1aBcDeFgH123IjKlMnOp456".equals(addressList.get(0).getAddress())) { System.err.println("testformatAddressesList - address[0].address <> address1aBcDeFgH123IjKlMnOp456"); };
		if (!addressList.get(0).isIsmine()) { System.err.println("testformatAddressesList - address[0].ismine <> true"); };
		if (addressList.get(0).isIswatchonly()) { System.err.println("testformatAddressesList - address[0].iswatchonly <> false"); };
		if (addressList.get(0).isIsscript()) { System.err.println("testformatAddressesList - address[0].isscript <> false"); };
		if (!"qRsT789uVw456xYz123AbC456DeF789".equals(addressList.get(0).getPubkey())) { System.err.println("testformatAddressesList - address[0].pubkey <> qRsT789uVw456xYz123AbC456DeF789"); };
		if (!addressList.get(0).isIscompressed()) { System.err.println("testformatAddressesList - address[0].iscompressed <> true"); };

		if (!"address2aBcDeFgH123IjKlMnOp456".equals(addressList.get(1).getAddress())) { System.err.println("testformatAddressesList - address[1].address <> address2aBcDeFgH123IjKlMnOp456"); };
		if (!addressList.get(1).isIsmine()) { System.err.println("testformatAddressesList - address[1].ismine <> true"); };
		if (addressList.get(1).isIswatchonly()) { System.err.println("testformatAddressesList - address[1].iswatchonly <> false"); };
		if (addressList.get(1).isIsscript()) { System.err.println("testformatAddressesList - address[1].isscript <> false"); };
		if (!"qRsT789uVw456xYz123AbC456DeF789".equals(addressList.get(1).getPubkey())) { System.err.println("testformatAddressesList - address[1].pubkey <> qRsT789uVw456xYz123AbC456DeF789"); };
		if (!addressList.get(1).isIscompressed()) { System.err.println("testformatAddressesList - address[1].iscompressed <> true"); };


	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of AddressFormatterTest ---");

		testformatAddress();
		testformatAddressesStringList();
		testformatAddressesList();

		System.out.println("--- End of AddressFormatterTest ---");
	}

}

