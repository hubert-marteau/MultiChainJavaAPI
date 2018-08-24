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
public class Item {
	String type = null; // For example "Stream"
	String name = null; // For example name of the Stream
	String streamref = null;
	List<String> publishers; // @ of publishers
	String key = null; // For example key used to publish in the Stream
	String data = null; // For example data published in the Stream

	/**
	 * 
	 */
	public Item() {
		super();
		publishers = new ArrayList<String>();
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the streamref
	 */
	public String getStreamref() {
		return streamref;
	}

	/**
	 * @param streamref
	 *            the streamref to set
	 */
	public void setStreamref(String streamref) {
		this.streamref = streamref;
	}

	/**
	 * @return the publishers
	 */
	public List<String> getPublishers() {
		return publishers;
	}

	/**
	 * @param publishers
	 *            the publishers to set
	 */
	public void setPublishers(List<String> publishers) {
		this.publishers = publishers;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
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
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

}
