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
 * @version 4.13
 */
public class PermissionDetailed {

	boolean connect;
	boolean send;
	boolean receive;
	boolean create;
	boolean issue;
	boolean mine;
	boolean admin;
	boolean activate;
	long startblock;
	long endblock;
	long timestamp;
	List<String> addresses;

	/**
	 *
	 */
	public PermissionDetailed() {
		super();
		addresses = new ArrayList<String>();
	}
	/**
	 * @return the connect
	 */
	public boolean isConnect() {
		return connect;
	}
	/**
	 * @param connect the connect to set
	 */
	public void setConnect(boolean connect) {
		this.connect = connect;
	}
	/**
	 * @return the send
	 */
	public boolean isSend() {
		return send;
	}
	/**
	 * @param send the send to set
	 */
	public void setSend(boolean send) {
		this.send = send;
	}
	/**
	 * @return the receive
	 */
	public boolean isReceive() {
		return receive;
	}
	/**
	 * @param receive the receive to set
	 */
	public void setReceive(boolean receive) {
		this.receive = receive;
	}
	/**
	 * @return the issue
	 */
	public boolean isIssue() {
		return issue;
	}
	/**
	 * @param issue the issue to set
	 */
	public void setIssue(boolean issue) {
		this.issue = issue;
	}
	/**
	 * @return the mine
	 */
	public boolean isMine() {
		return mine;
	}
	/**
	 * @param mine the mine to set
	 */
	public void setMine(boolean mine) {
		this.mine = mine;
	}
	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}
	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	/**
	 * @return the activate
	 */
	public boolean isActivate() {
		return activate;
	}
	/**
	 * @param activate the activate to set
	 */
	public void setActivate(boolean activate) {
		this.activate = activate;
	}
	/**
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
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
	/**
	 * @return the create
	 */
	public boolean isCreate() {
		return create;
	}
	/**
	 * @param create the create to set
	 */
	public void setCreate(boolean create) {
		this.create = create;
	}
	/**
	 * @return the startblock
	 */
	public long getStartblock() {
		return startblock;
	}
	/**
	 * @param startblock the startblock to set
	 */
	public void setStartblock(long startblock) {
		this.startblock = startblock;
	}
	/**
	 * @return the endblock
	 */
	public long getEndblock() {
		return endblock;
	}
	/**
	 * @param endblock the endblock to set
	 */
	public void setEndblock(long endblock) {
		this.endblock = endblock;
	}

}
