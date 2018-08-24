/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ub - H. MARTEAU
 * @version 4.14
 */
public class ScriptPubKey {
    String asm = null;
    String hex = null;
    Long reqSigs = null;
    String type = null;
    List<String> addresses;

    /**
	 *
	 */
	public ScriptPubKey() {
		super();
		addresses = new ArrayList<String>();
	}

	/**
	 * @return the asm
	 */
	public String getAsm() {
		return asm;
	}

	/**
	 * @param asm the asm to set
	 */
	public void setAsm(String asm) {
		this.asm = asm;
	}

	/**
	 * @return the hex
	 */
	public String getHex() {
		return hex;
	}

	/**
	 * @param hex the hex to set
	 */
	public void setHex(String hex) {
		this.hex = hex;
	}

	/**
	 * @return the reqSigs
	 */
	public long getReqSigs() {
		return reqSigs;
	}

	/**
	 * @param reqSigs the reqSigs to set
	 */
	public void setReqSigs(long reqSigs) {
		this.reqSigs = reqSigs;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the addresses
	 */
	public List<String> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

}
