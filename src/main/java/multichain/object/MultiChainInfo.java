/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

import java.util.List;

/**
 * @author Ub - H. MARTEAU
 * @version 4.14
 */
public class MultiChainInfo {

	/*
	 * {"method":"issue","params":["169dyfazv83kBFXdUFyjChVR9kqDcve4VQtUaN",
	 * "Data source 2",10000,1.00000000],"id":1,"chain_name":"testIssue"}
	 */
	String method = null;
	List<Object> params;
	Integer id = null;
	String chain_name = null;

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method
	 *            the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the params
	 */
	public List<Object> getParams() {
		return params;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(List<Object> params) {
		this.params = params;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the chain_name
	 */
	public String getChain_name() {
		return chain_name;
	}

	/**
	 * @param chain_name
	 *            the chain_name to set
	 */
	public void setChain_name(String chain_name) {
		this.chain_name = chain_name;
	}

}
