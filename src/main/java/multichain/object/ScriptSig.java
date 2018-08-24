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
public class ScriptSig {
    String asm = null;
    String hex = null;

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


}
