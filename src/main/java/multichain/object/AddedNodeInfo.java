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
 * @version 2.0.1
 */
public class AddedNodeInfo {
  String addednode = null;
  Boolean connected = null;
  List<AddedNodeInfoAddress> addresses = null;

  /**
   * @return the addednode
   */
  public String getAddednode() {
    return addednode;
  }

  /**
   * @param addednode the addednode to set
   */
  public void setAddednode(String addednode) {
    this.addednode = addednode;
  }

  /**
   * @return the connected
   */
  public Boolean getConnected() {
    return connected;
  }

  /**
   * @param connected the connected to set
   */
  public void setConnected(Boolean connected) {
    this.connected = connected;
  }

  /**
   * @return the addresses
   */
  public List<AddedNodeInfoAddress> getAddresses() {
    return addresses;
  }

  /**
   * @param addresses the addresses to set
   */
  public void setAddresses(List<AddedNodeInfoAddress> addresses) {
    this.addresses = addresses;
  }


}
