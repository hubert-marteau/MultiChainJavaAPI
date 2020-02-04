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
public class PeerInfo {
  Long id = null;
  String addr = null;
  String addrlocal = null;
  String services = null;
  Long lastsend = null;
  Long lastrecv = null;
  Long bytessent = null;
  Long bytesrecv = null;
  Long conntime = null;
  Double pingtime = null;
  Long pingwait = null;
  Long version = null;
  String subver = null;
  String handshakelocal = null;
  String handshake = null;
  Boolean inbound = null;
  Long startingheight = null;
  Long banscore = null;
  Long synced_headers = null;
  Long synced_blocks = null;
  List<Long> inflight = null;

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @return the addr
   */
  public String getAddr() {
    return addr;
  }

  /**
   * @param addr the addr to set
   */
  public void setAddr(String addr) {
    this.addr = addr;
  }

  /**
   * @return the addrlocal
   */
  public String getAddrlocal() {
    return addrlocal;
  }

  /**
   * @param addrlocal the addrlocal to set
   */
  public void setAddrlocal(String addrlocal) {
    this.addrlocal = addrlocal;
  }

  /**
   * @return the services
   */
  public String getServices() {
    return services;
  }

  /**
   * @param services the services to set
   */
  public void setServices(String services) {
    this.services = services;
  }

  /**
   * @return the lastsend
   */
  public Long getLastsend() {
    return lastsend;
  }

  /**
   * @param lastsend the lastsend to set
   */
  public void setLastsend(Long lastsend) {
    this.lastsend = lastsend;
  }

  /**
   * @return the lastrecv
   */
  public Long getLastrecv() {
    return lastrecv;
  }

  /**
   * @param lastrecv the lastrecv to set
   */
  public void setLastrecv(Long lastrecv) {
    this.lastrecv = lastrecv;
  }

  /**
   * @return the bytessent
   */
  public Long getBytessent() {
    return bytessent;
  }

  /**
   * @param bytessent the bytessent to set
   */
  public void setBytessent(Long bytessent) {
    this.bytessent = bytessent;
  }

  /**
   * @return the bytesrecv
   */
  public Long getBytesrecv() {
    return bytesrecv;
  }

  /**
   * @param bytesrecv the bytesrecv to set
   */
  public void setBytesrecv(Long bytesrecv) {
    this.bytesrecv = bytesrecv;
  }

  /**
   * @return the conntime
   */
  public Long getConntime() {
    return conntime;
  }

  /**
   * @param conntime the conntime to set
   */
  public void setConntime(Long conntime) {
    this.conntime = conntime;
  }

  /**
   * @return the pingtime
   */
  public Double getPingtime() {
    return pingtime;
  }

  /**
   * @param pingtime the pingtime to set
   */
  public void setPingtime(Double pingtime) {
    this.pingtime = pingtime;
  }

  /**
   * @return the pingwait
   */
  public Long getPingwait() {
    return pingwait;
  }

  /**
   * @param pingwait the pingwait to set
   */
  public void setPingwait(Long pingwait) {
    this.pingwait = pingwait;
  }

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
   * @return the subver
   */
  public String getSubver() {
    return subver;
  }

  /**
   * @param subver the subver to set
   */
  public void setSubver(String subver) {
    this.subver = subver;
  }

  /**
   * @return the handshakelocal
   */
  public String getHandshakelocal() {
    return handshakelocal;
  }

  /**
   * @param handshakelocal the handshakelocal to set
   */
  public void setHandshakelocal(String handshakelocal) {
    this.handshakelocal = handshakelocal;
  }

  /**
   * @return the handshake
   */
  public String getHandshake() {
    return handshake;
  }

  /**
   * @param handshake the handshake to set
   */
  public void setHandshake(String handshake) {
    this.handshake = handshake;
  }

  /**
   * @return the inbound
   */
  public Boolean getInbound() {
    return inbound;
  }

  /**
   * @param inbound the inbound to set
   */
  public void setInbound(Boolean inbound) {
    this.inbound = inbound;
  }

  /**
   * @return the startingheight
   */
  public Long getStartingheight() {
    return startingheight;
  }

  /**
   * @param startingheight the startingheight to set
   */
  public void setStartingheight(Long startingheight) {
    this.startingheight = startingheight;
  }

  /**
   * @return the banscore
   */
  public Long getBanscore() {
    return banscore;
  }

  /**
   * @param banscore the banscore to set
   */
  public void setBanscore(Long banscore) {
    this.banscore = banscore;
  }

  /**
   * @return the synced_headers
   */
  public Long getSynced_headers() {
    return synced_headers;
  }

  /**
   * @param synced_headers the synced_headers to set
   */
  public void setSynced_headers(Long synced_headers) {
    this.synced_headers = synced_headers;
  }

  /**
   * @return the synced_blocks
   */
  public Long getSynced_blocks() {
    return synced_blocks;
  }

  /**
   * @param synced_blocks the synced_blocks to set
   */
  public void setSynced_blocks(Long synced_blocks) {
    this.synced_blocks = synced_blocks;
  }

  /**
   * @return the inflight
   */
  public List<Long> getInflight() {
    return inflight;
  }

  /**
   * @param inflight the inflight to set
   */
  public void setInflight(List<Long> inflight) {
    this.inflight = inflight;
  }


}
