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
 * @version 2.0.1
 */
public class RuntimeParams {
  Long port = null;
  Boolean reindex = null;
  Boolean rescan = null;
  Boolean txindex = null;
  Long autocombineminconf = null;
  Long autocombinemininputs = null;
  Long autocombinemaxinputs = null;
  Long autocombinedelay = null;
  Long autocombinesuspend = null;
  String autosubscribe = null;
  String handshakelocal = null;
  String bantx = null;
  String lockblock = null;
  Boolean hideknownopdrops = null;
  Long maxshowndata = null;
  Long maxqueryscanitems = null;
  Boolean v1apicompatible = null;
  Boolean miningrequirespeers = null;
  Long mineemptyrounds = null;
  Double miningturnover = null;
  Long lockadminminerounds = null;
  Boolean gen = null;
  Long genproclimit = null;
  Boolean lockinlinemetadata = null;
  Long acceptfiltertimeout = null;
  Long sendfiltertimeout = null;

  /**
   * @return the port
   */
  public Long getPort() {
    return port;
  }

  /**
   * @param port the port to set
   */
  public void setPort(Long port) {
    this.port = port;
  }

  /**
   * @return the reindex
   */
  public Boolean getReindex() {
    return reindex;
  }

  /**
   * @param reindex the reindex to set
   */
  public void setReindex(Boolean reindex) {
    this.reindex = reindex;
  }

  /**
   * @return the rescan
   */
  public Boolean getRescan() {
    return rescan;
  }

  /**
   * @param rescan the rescan to set
   */
  public void setRescan(Boolean rescan) {
    this.rescan = rescan;
  }

  /**
   * @return the txindex
   */
  public Boolean getTxindex() {
    return txindex;
  }

  /**
   * @param txindex the txindex to set
   */
  public void setTxindex(Boolean txindex) {
    this.txindex = txindex;
  }

  /**
   * @return the autocombineminconf
   */
  public Long getAutocombineminconf() {
    return autocombineminconf;
  }

  /**
   * @param autocombineminconf the autocombineminconf to set
   */
  public void setAutocombineminconf(Long autocombineminconf) {
    this.autocombineminconf = autocombineminconf;
  }

  /**
   * @return the autocombinemininputs
   */
  public Long getAutocombinemininputs() {
    return autocombinemininputs;
  }

  /**
   * @param autocombinemininputs the autocombinemininputs to set
   */
  public void setAutocombinemininputs(Long autocombinemininputs) {
    this.autocombinemininputs = autocombinemininputs;
  }

  /**
   * @return the autocombinemaxinputs
   */
  public Long getAutocombinemaxinputs() {
    return autocombinemaxinputs;
  }

  /**
   * @param autocombinemaxinputs the autocombinemaxinputs to set
   */
  public void setAutocombinemaxinputs(Long autocombinemaxinputs) {
    this.autocombinemaxinputs = autocombinemaxinputs;
  }

  /**
   * @return the autocombinedelay
   */
  public Long getAutocombinedelay() {
    return autocombinedelay;
  }

  /**
   * @param autocombinedelay the autocombinedelay to set
   */
  public void setAutocombinedelay(Long autocombinedelay) {
    this.autocombinedelay = autocombinedelay;
  }

  /**
   * @return the autocombinesuspend
   */
  public Long getAutocombinesuspend() {
    return autocombinesuspend;
  }

  /**
   * @param autocombinesuspend the autocombinesuspend to set
   */
  public void setAutocombinesuspend(Long autocombinesuspend) {
    this.autocombinesuspend = autocombinesuspend;
  }

  /**
   * @return the autosubscribe
   */
  public String getAutosubscribe() {
    return autosubscribe;
  }

  /**
   * @param autosubscribe the autosubscribe to set
   */
  public void setAutosubscribe(String autosubscribe) {
    this.autosubscribe = autosubscribe;
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
   * @return the bantx
   */
  public String getBantx() {
    return bantx;
  }

  /**
   * @param bantx the bantx to set
   */
  public void setBantx(String bantx) {
    this.bantx = bantx;
  }

  /**
   * @return the lockblock
   */
  public String getLockblock() {
    return lockblock;
  }

  /**
   * @param lockblock the lockblock to set
   */
  public void setLockblock(String lockblock) {
    this.lockblock = lockblock;
  }

  /**
   * @return the hideknownopdrops
   */
  public Boolean getHideknownopdrops() {
    return hideknownopdrops;
  }

  /**
   * @param hideknownopdrops the hideknownopdrops to set
   */
  public void setHideknownopdrops(Boolean hideknownopdrops) {
    this.hideknownopdrops = hideknownopdrops;
  }

  /**
   * @return the maxshowndata
   */
  public Long getMaxshowndata() {
    return maxshowndata;
  }

  /**
   * @param maxshowndata the maxshowndata to set
   */
  public void setMaxshowndata(Long maxshowndata) {
    this.maxshowndata = maxshowndata;
  }

  /**
   * @return the maxqueryscanitems
   */
  public Long getMaxqueryscanitems() {
    return maxqueryscanitems;
  }

  /**
   * @param maxqueryscanitems the maxqueryscanitems to set
   */
  public void setMaxqueryscanitems(Long maxqueryscanitems) {
    this.maxqueryscanitems = maxqueryscanitems;
  }

  /**
   * @return the v1apicompatible
   */
  public Boolean getV1apicompatible() {
    return v1apicompatible;
  }

  /**
   * @param v1apicompatible the v1apicompatible to set
   */
  public void setV1apicompatible(Boolean v1apicompatible) {
    this.v1apicompatible = v1apicompatible;
  }

  /**
   * @return the miningrequirespeers
   */
  public Boolean getMiningrequirespeers() {
    return miningrequirespeers;
  }

  /**
   * @param miningrequirespeers the miningrequirespeers to set
   */
  public void setMiningrequirespeers(Boolean miningrequirespeers) {
    this.miningrequirespeers = miningrequirespeers;
  }

  /**
   * @return the mineemptyrounds
   */
  public Long getMineemptyrounds() {
    return mineemptyrounds;
  }

  /**
   * @param mineemptyrounds the mineemptyrounds to set
   */
  public void setMineemptyrounds(Long mineemptyrounds) {
    this.mineemptyrounds = mineemptyrounds;
  }

  /**
   * @return the miningturnover
   */
  public Double getMiningturnover() {
    return miningturnover;
  }

  /**
   * @param miningturnover the miningturnover to set
   */
  public void setMiningturnover(Double miningturnover) {
    this.miningturnover = miningturnover;
  }

  /**
   * @return the lockadminminerounds
   */
  public Long getLockadminminerounds() {
    return lockadminminerounds;
  }

  /**
   * @param lockadminminerounds the lockadminminerounds to set
   */
  public void setLockadminminerounds(Long lockadminminerounds) {
    this.lockadminminerounds = lockadminminerounds;
  }

  /**
   * @return the gen
   */
  public Boolean getGen() {
    return gen;
  }

  /**
   * @param gen the gen to set
   */
  public void setGen(Boolean gen) {
    this.gen = gen;
  }

  /**
   * @return the genproclimit
   */
  public Long getGenproclimit() {
    return genproclimit;
  }

  /**
   * @param genproclimit the genproclimit to set
   */
  public void setGenproclimit(Long genproclimit) {
    this.genproclimit = genproclimit;
  }

  /**
   * @return the lockinlinemetadata
   */
  public Boolean getLockinlinemetadata() {
    return lockinlinemetadata;
  }

  /**
   * @param lockinlinemetadata the lockinlinemetadata to set
   */
  public void setLockinlinemetadata(Boolean lockinlinemetadata) {
    this.lockinlinemetadata = lockinlinemetadata;
  }

  /**
   * @return the acceptfiltertimeout
   */
  public Long getAcceptfiltertimeout() {
    return acceptfiltertimeout;
  }

  /**
   * @param acceptfiltertimeout the acceptfiltertimeout to set
   */
  public void setAcceptfiltertimeout(Long acceptfiltertimeout) {
    this.acceptfiltertimeout = acceptfiltertimeout;
  }

  /**
   * @return the sendfiltertimeout
   */
  public Long getSendfiltertimeout() {
    return sendfiltertimeout;
  }

  /**
   * @param sendfiltertimeout the sendfiltertimeout to set
   */
  public void setSendfiltertimeout(Long sendfiltertimeout) {
    this.sendfiltertimeout = sendfiltertimeout;
  }


}
