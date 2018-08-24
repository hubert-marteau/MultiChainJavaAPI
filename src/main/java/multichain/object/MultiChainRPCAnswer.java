/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

import com.google.gson.internal.LinkedTreeMap;

/**
 * @author Ub - H. MARTEAU
 * @version 4.14
 */
public class MultiChainRPCAnswer {

	Object result = null;
	LinkedTreeMap<String, Object> error;
	String id = null;

	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * @return the error
	 */
	public LinkedTreeMap<String, Object> getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(LinkedTreeMap<String, Object> error) {
		this.error = error;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

}
