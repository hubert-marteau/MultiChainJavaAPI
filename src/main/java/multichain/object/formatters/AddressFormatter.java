/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import multichain.object.Address;
import multichain.object.KeyPairs;

/**
 * @author Ub - H. MARTEAU
 * @version 4.3
 */
public class AddressFormatter {
	public final static Address formatAddress(Object objectAddress) {
		Address address = new Address();

		if (objectAddress != null && LinkedTreeMap.class.isInstance(objectAddress)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectAddress);
			address = gson.fromJson(jsonValue, Address.class);
		}

		return address;
	}

	public final static List<Address> formatAddressesList(List<Object> objectAddresses) {
		List<Address> addresses = new ArrayList<Address>();

		if (objectAddresses != null) {
			for (Object objectAddress : objectAddresses) {
				addresses.add(formatAddress(objectAddress));
			}
		}

		return addresses;
	}

	public final static KeyPairs formatKeyPairs(Object objectKeyPair) {
		KeyPairs keyPairs = new KeyPairs();

		if (objectKeyPair != null && LinkedTreeMap.class.isInstance(objectKeyPair)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectKeyPair);
			keyPairs = gson.fromJson(jsonValue, KeyPairs.class);
		}

		return keyPairs;
	}

	public final static List<KeyPairs> formatKeyPairsList(List<Object> objectKeyPairs) {
		List<KeyPairs> listKeyPairs = new ArrayList<KeyPairs>();

		if (objectKeyPairs != null) {
			for (Object objectKeyPair : objectKeyPairs) {
				listKeyPairs.add(formatKeyPairs(objectKeyPair));
			}
		}

		return listKeyPairs;
	}

}