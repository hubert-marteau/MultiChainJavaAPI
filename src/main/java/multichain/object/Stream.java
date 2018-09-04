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
 * @author Ub - H. MARTEAU & Jagrut KOSTI
 * @version 4.14
 */
public class Stream {
	String name = null;
	String createtxid = null;
	String streamref = null;
	Boolean open = null;
	Object details = null;
	List<String> creators;
	Boolean subscribed = null;
	Boolean synchronized_ = null;
	Integer items = null;
	Integer confirmed = null;
	Integer keys = null;
	Integer publishers = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stream [name=" + name + ", createtxid=" + createtxid + ", streamref=" + streamref + ", open=" + open
				+ ", details=" + details + ", creators=" + creators + ", subscribed=" + subscribed + ", synchronized_="
				+ synchronized_ + ", items=" + items + ", confirmed=" + confirmed + ", keys=" + keys + ", publishers="
				+ publishers + "]";
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
	 * @return the createtxid
	 */
	public String getCreatetxid() {
		return createtxid;
	}

	/**
	 * @param createtxid
	 *            the createtxid to set
	 */
	public void setCreatetxid(String createtxid) {
		this.createtxid = createtxid;
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
	 * @return the open
	 */
	public boolean isOpen() {
		return open;
	}

	/**
	 * @param open
	 *            the open to set
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}

	/**
	 * @return the details
	 */
	public Object getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(Object details) {
		this.details = details;
	}

	/**
	 * @return the creators
	 */
	public List<String> getCreators() {
		return creators;
	}

	/**
	 * @param creators
	 *            the creators to set
	 */
	public void setCreators(List<String> creators) {
		this.creators = creators;
	}

	/**
	 * @return the subscribed
	 */
	public boolean isSubscribed() {
		return subscribed;
	}

	/**
	 * @param subscribed
	 *            the subscribed to set
	 */
	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	/**
	 * @return the synchronized_
	 */
	public boolean isSynchronized_() {
		return synchronized_;
	}

	/**
	 * @param synchronized_
	 *            the synchronized_ to set
	 */
	public void setSynchronized_(boolean synchronized_) {
		this.synchronized_ = synchronized_;
	}

	/**
	 * @return the items
	 */
	public int getItems() {
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(int items) {
		this.items = items;
	}

	/**
	 * @return the confirmed
	 */
	public int getConfirmed() {
		return confirmed;
	}

	/**
	 * @param confirmed
	 *            the confirmed to set
	 */
	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}

	/**
	 * @return the keys
	 */
	public int getKeys() {
		return keys;
	}

	/**
	 * @param keys
	 *            the keys to set
	 */
	public void setKeys(int keys) {
		this.keys = keys;
	}

	/**
	 * @return the publishers
	 */
	public int getPublishers() {
		return publishers;
	}

	/**
	 * @param publishers
	 *            the publishers to set
	 */
	public void setPublishers(int publishers) {
		this.publishers = publishers;
	}
}
