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
public class StreamKey {
	String key = null;
	Long items = null;
	Long confirmed = null;
	StreamKeyInfo first = null;
	StreamKeyInfo last = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String value = "StreamKey [key=" + key + ", items=" + items + ", confirmed=" + confirmed;
		if (first != null) {
			value += ", first=" + first.toString();
		}
		if (last != null) {
			value += ", last=" + last.toString();
		}
		value += "]";

		return value;
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
	 * @return the items
	 */
	public long getItems() {
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(long items) {
		this.items = items;
	}

	/**
	 * @return the confirmed
	 */
	public long getConfirmed() {
		return confirmed;
	}

	/**
	 * @param confirmed
	 *            the confirmed to set
	 */
	public void setConfirmed(long confirmed) {
		this.confirmed = confirmed;
	}

	/**
	 * @return the first
	 */
	public StreamKeyInfo getFirst() {
		return first;
	}

	/**
	 * @param first
	 *            the first to set
	 */
	public void setFirst(StreamKeyInfo first) {
		this.first = first;
	}

	/**
	 * @return the last
	 */
	public StreamKeyInfo getLast() {
		return last;
	}

	/**
	 * @param last
	 *            the last to set
	 */
	public void setLast(StreamKeyInfo last) {
		this.last = last;
	}

}
