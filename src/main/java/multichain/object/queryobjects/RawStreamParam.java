/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.queryobjects;

import multichain.object.formatters.GsonFormatters;

/**
 * @author Ub - H. MARTEAU
 * @version 4.13
 */
public class RawStreamParam extends GsonFormatters {
	String for_;
	String key;
	String data;
	
	/**
	 * @param for_
	 * @param key
	 * @param data
	 */
	public RawStreamParam(String for_, String key, String data) {
		super();
		this.for_ = for_;
		this.key = key;
		this.data = data;
	}
	
	public boolean isFilled() {
		if (for_ == null || "".equals(for_)) {
			return false;
		}
		if (key == null || "".equals(key)) {
			return false;
		}
		if (data == null || "".equals(data)) {
			return false;
		}

		return true;
	}

	
	/**
	 * @return the for_
	 */
	public String getFor_() {
		return for_;
	}
	/**
	 * @param for_ the for_ to set
	 */
	public void setFor_(String for_) {
		this.for_ = for_;
	}
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}


}
