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
public class NetworkInfo {
  Long version = null;
  String subversion = null;
  Long protocolversion = null;
  String localservices = null;
  Long timeoffset = null;
  Long connections = null;
  List<NetworkInfoNetwork> networks = null;
  Double relayfee = null;
  List<NetworkInfoLocalAddress> localaddresses = null;

  /**
   * @return the version
   */
  public Long getVersion() {
    return version;
  }

  /**
   * @param version the version to set
   */
  public void setVersion(Long version) {
    this.version = version;
  }

  /**
   * @return the subversion
   */
  public String getSubversion() {
    return subversion;
  }

  /**
   * @param subversion the subversion to set
   */
  public void setSubversion(String subversion) {
    this.subversion = subversion;
  }

  /**
   * @return the protocolversion
   */
  public Long getProtocolversion() {
    return protocolversion;
  }

  /**
   * @param protocolversion the protocolversion to set
   */
  public void setProtocolversion(Long protocolversion) {
    this.protocolversion = protocolversion;
  }

  /**
   * @return the localservices
   */
  public String getLocalservices() {
    return localservices;
  }

  /**
   * @param localservices the localservices to set
   */
  public void setLocalservices(String localservices) {
    this.localservices = localservices;
  }

  /**
   * @return the timeoffset
   */
  public Long getTimeoffset() {
    return timeoffset;
  }

  /**
   * @param timeoffset the timeoffset to set
   */
  public void setTimeoffset(Long timeoffset) {
    this.timeoffset = timeoffset;
  }

  /**
   * @return the connections
   */
  public Long getConnections() {
    return connections;
  }

  /**
   * @param connections the connections to set
   */
  public void setConnections(Long connections) {
    this.connections = connections;
  }

  /**
   * @return the networks
   */
  public List<NetworkInfoNetwork> getNetworks() {
    return networks;
  }

  /**
   * @param networks the networks to set
   */
  public void setNetworks(List<NetworkInfoNetwork> networks) {
    this.networks = networks;
  }

  /**
   * @return the relayfee
   */
  public Double getRelayfee() {
    return relayfee;
  }

  /**
   * @param relayfee the relayfee to set
   */
  public void setRelayfee(Double relayfee) {
    this.relayfee = relayfee;
  }

  /**
   * @return the localaddresses
   */
  public List<NetworkInfoLocalAddress> getLocaladdresses() {
    return localaddresses;
  }

  /**
   * @param localaddresses the localaddresses to set
   */
  public void setLocaladdresses(List<NetworkInfoLocalAddress> localaddresses) {
    this.localaddresses = localaddresses;
  }


}
