/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

/**
 * @author Ub - H. MARTEAU
 * @version 4.14
 */
public class KeyPairs {
	String address = null;
	String pubkey = null;
	String privkey = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "KeyPairs [address=" + address + ", pubkey=" + pubkey + ", privkey=" + privkey + "]";
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the pubkey
	 */
	public String getPubkey() {
		return pubkey;
	}

	/**
	 * @param pubkey
	 *            the pubkey to set
	 */
	public void setPubkey(String pubkey) {
		this.pubkey = pubkey;
	}

	/**
	 * @return the privkey
	 */
	public String getPrivkey() {
		return privkey;
	}

	/**
	 * @param privkey
	 *            the privkey to set
	 */
	public void setPrivkey(String privkey) {
		this.privkey = privkey;
	}

}
