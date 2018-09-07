/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

/**
 * @author Ub - H. MARTEAU
 * @version 4.15
 */
public class RuntimeParameters {
	String datadir = null;
	String rpcport = null;
	
	/**
	 * 
	 */
	public RuntimeParameters() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param datadir
	 * @param rpcport
	 */
	public RuntimeParameters(String datadir, String rpcport) {
		super();
		this.datadir = datadir;
		this.rpcport = rpcport;
	}

	/**
	 * @return the datadir
	 */
	public String getDatadir() {
		return datadir;
	}
	/**
	 * @param datadir the datadir to set
	 */
	public void setDatadir(String datadir) {
		this.datadir = datadir;
	}
	/**
	 * @return the rpcport
	 */
	public String getRpcport() {
		return rpcport;
	}
	/**
	 * @param rpcport the rpcport to set
	 */
	public void setRpcport(String rpcport) {
		this.rpcport = rpcport;
	}
	
}
