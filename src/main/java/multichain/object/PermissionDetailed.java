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
public class PermissionDetailed {

	Boolean connect = null;
	Boolean send = null;
	Boolean receive = null;
	Boolean create = null;
	Boolean issue = null;
	Boolean mine = null;
	Boolean admin = null;
	Boolean activate = null;
	Long startblock = null;
	Long endblock = null;
	Long timestamp = null;
	List<String> addresses = null;
	
	/**
	 *
	 */
	public PermissionDetailed() {
		super();
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
	 * @return the connect
	 */
	public Boolean getConnect() {
		return connect;
	}

	/**
	 * @param connect the connect to set
	 */
	public void setConnect(Boolean connect) {
		this.connect = connect;
	}

	/**
	 * @return the send
	 */
	public Boolean getSend() {
		return send;
	}

	/**
	 * @param send the send to set
	 */
	public void setSend(Boolean send) {
		this.send = send;
	}

	/**
	 * @return the receive
	 */
	public Boolean getReceive() {
		return receive;
	}

	/**
	 * @param receive the receive to set
	 */
	public void setReceive(Boolean receive) {
		this.receive = receive;
	}

	/**
	 * @return the create
	 */
	public Boolean getCreate() {
		return create;
	}

	/**
	 * @param create the create to set
	 */
	public void setCreate(Boolean create) {
		this.create = create;
	}

	/**
	 * @return the issue
	 */
	public Boolean getIssue() {
		return issue;
	}

	/**
	 * @param issue the issue to set
	 */
	public void setIssue(Boolean issue) {
		this.issue = issue;
	}

	/**
	 * @return the mine
	 */
	public Boolean getMine() {
		return mine;
	}

	/**
	 * @param mine the mine to set
	 */
	public void setMine(Boolean mine) {
		this.mine = mine;
	}

	/**
	 * @return the admin
	 */
	public Boolean getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	/**
	 * @return the activate
	 */
	public Boolean getActivate() {
		return activate;
	}

	/**
	 * @param activate the activate to set
	 */
	public void setActivate(Boolean activate) {
		this.activate = activate;
	}

	/**
	 * @return the startblock
	 */
	public Long getStartblock() {
		return startblock;
	}

	/**
	 * @param startblock the startblock to set
	 */
	public void setStartblock(Long startblock) {
		this.startblock = startblock;
	}

	/**
	 * @return the endblock
	 */
	public Long getEndblock() {
		return endblock;
	}

	/**
	 * @param endblock the endblock to set
	 */
	public void setEndblock(Long endblock) {
		this.endblock = endblock;
	}

	/**
	 * @return the timestamp
	 */
	public Long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}