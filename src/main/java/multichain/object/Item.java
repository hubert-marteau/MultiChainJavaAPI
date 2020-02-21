/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file. https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

import java.util.List;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.1
 */
public class Item {

	String type = null; // For example "Stream"
	String name = null; // For example name of the Stream
	String streamref = null;
	List<String> publishers; // @ of publishers
	List<String> keys = null; // For example key used to publish in the Stream
	Boolean offchain = null; // For example data published in the Stream
	Boolean available = null;
	Object data = null;

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
	public void setType(final String type) {

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
	public void setName(final String name) {

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
	public void setStreamref(final String streamref) {

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
	public void setPublishers(final List<String> publishers) {

		this.publishers = publishers;
	}

	/**
	 * @return the keys
	 */
	public List<String> getKeys() {

		return keys;
	}

	/**
	 * @param keys
	 *            the keys to set
	 */
	public void setKeys(final List<String> keys) {

		this.keys = keys;
	}

	/**
	 * @return the offchain
	 */
	public Boolean getOffchain() {

		return offchain;
	}

	/**
	 * @param offchain
	 *            the offchain to set
	 */
	public void setOffchain(final Boolean offchain) {

		this.offchain = offchain;
	}

	/**
	 * @return the available
	 */
	public Boolean getAvailable() {

		return available;
	}

	/**
	 * @param available
	 *            the available to set
	 */
	public void setAvailable(final Boolean available) {

		this.available = available;
	}

	/**
	 * @return the data
	 */
	public Object getData() {

		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(final Object data) {

		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return String.format("Item [type=%s, name=%s, streamref=%s, publishers=%s, keys=%s, offchain=%s, available=%s, data=%s]", type, name, streamref,
				publishers, keys, offchain, available, data);
	}

}
