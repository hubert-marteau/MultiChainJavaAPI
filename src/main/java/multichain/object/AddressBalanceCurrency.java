/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

import multichain.command.MultichainException;
import multichain.command.tools.MultichainTestParameter;

/**
 * @author Ub - H. MARTEAU
 * @version 4.14
 */
public class AddressBalanceCurrency implements AddressBalance {
	String address = null;
	Double currencyValue = null;

	public AddressBalanceCurrency() {
	}

	public void isFilled() throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		MultichainTestParameter.valueIsNotNegative("currency value", currencyValue);
	}
	
	public Double getValue() {
		return new Double(currencyValue);
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the currencyValue
	 */
	public double getCurrencyValue() {
		return currencyValue;
	}

	/**
	 * @param currencyValue the currencyValue to set
	 */
	public void setCurrencyValue(double currencyValue) {
		this.currencyValue = currencyValue;
	}



}
