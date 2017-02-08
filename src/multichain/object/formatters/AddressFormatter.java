/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import java.lang.reflect.Type;
import java.util.List;

import multichain.object.Address;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class AddressFormatter {
	public final static Address formatAddress(String stringAddress) {
		final Gson gson = new GsonBuilder().create();
		final Address address = gson.fromJson(stringAddress, Address.class);

		return address;
	}


	public final static List<String> formatAddressesStringList(String stringAddresses) {
		final Gson gson = new GsonBuilder().create();

		Type listType = new TypeToken<List<String>>(){}.getType();
		final List<String> addresses = gson.fromJson(stringAddresses, listType);

		return addresses;
	}

	public final static List<Address> formatAddressesList(String stringAddresses) {
		final Gson gson = new GsonBuilder().create();

		Type listType = new TypeToken<List<Address>>(){}.getType();
		final List<Address> addresses = gson.fromJson(stringAddresses, listType);

		return addresses;
	}
}