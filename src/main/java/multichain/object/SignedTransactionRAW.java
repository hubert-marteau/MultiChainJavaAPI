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
public class SignedTransactionRAW {
	String hex = null;
	Boolean complete = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SignedTransactionRAW [hex=" + hex + ", complete=" + complete + "]";
	}

	/**
	 * @return the hex
	 */
	public String getHex() {
		return hex;
	}

	/**
	 * @param hex
	 *            the hex to set
	 */
	public void setHex(String hex) {
		this.hex = hex;
	}

	/**
	 * @return the complete
	 */
	public boolean isComplete() {
		return complete;
	}

	/**
	 * @param complete
	 *            the complete to set
	 */
	public void setComplete(boolean complete) {
		this.complete = complete;
	}

}
