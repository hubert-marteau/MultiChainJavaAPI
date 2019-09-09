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
public class Address {
  String address = null;
  Boolean isvalid = null;
  Boolean ismine = null;
  Boolean iswatchonly = null;
  Boolean isscript = null;
  String pubkey = null;
  String hex = null;
  List<String> addresses = null;
  Long sigsrequired = null;
  Boolean iscompressed = null;
  String account = null;
  Boolean issynchronized = null;
  Long startblock = null;

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Address [address=" + address + ", " + super.toString() + "isvalid=" + isvalid
        + ", ismine=" + ismine + ", iswatchonly=" + iswatchonly + ", isscript=" + isscript
        + ", pubkey=" + pubkey + ", iscompressed=" + iscompressed + "]";
  }

  /**
   *
   */
  public Address() {
    super();
  }

  /**
   * @param address
   */
  public Address(String address) {
    super();
    this.address = address;
  }

  /**
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return the isvalid
   */
  public boolean isIsvalid() {
    return isvalid;
  }

  /**
   * @param isvalid the isvalid to set
   */
  public void setIsvalid(boolean isvalid) {
    this.isvalid = isvalid;
  }

  /**
   * @return the ismine
   */
  public boolean isIsmine() {
    return ismine;
  }

  /**
   * @param ismine the ismine to set
   */
  public void setIsmine(boolean ismine) {
    this.ismine = ismine;
  }

  /**
   * @return the iswatchonly
   */
  public boolean isIswatchonly() {
    return iswatchonly;
  }

  /**
   * @param iswatchonly the iswatchonly to set
   */
  public void setIswatchonly(boolean iswatchonly) {
    this.iswatchonly = iswatchonly;
  }

  /**
   * @return the isscript
   */
  public boolean isIsscript() {
    return isscript;
  }

  /**
   * @param isscript the isscript to set
   */
  public void setIsscript(boolean isscript) {
    this.isscript = isscript;
  }

  /**
   * @return the pubkey
   */
  public String getPubkey() {
    return pubkey;
  }

  /**
   * @param pubkey the pubkey to set
   */
  public void setPubkey(String pubkey) {
    this.pubkey = pubkey;
  }

  /**
   * @return the iscompressed
   */
  public boolean isIscompressed() {
    return iscompressed;
  }

  /**
   * @param iscompressed the iscompressed to set
   */
  public void setIscompressed(boolean iscompressed) {
    this.iscompressed = iscompressed;
  }

  /**
   * @return the account
   */
  public String getAccount() {
    return account;
  }

  /**
   * @param account the account to set
   */
  public void setAccount(String account) {
    this.account = account;
  }

  /**
   * @return the isvalid
   */
  public Boolean getIsvalid() {
    return isvalid;
  }

  /**
   * @param isvalid the isvalid to set
   */
  public void setIsvalid(Boolean isvalid) {
    this.isvalid = isvalid;
  }

  /**
   * @return the ismine
   */
  public Boolean getIsmine() {
    return ismine;
  }

  /**
   * @param ismine the ismine to set
   */
  public void setIsmine(Boolean ismine) {
    this.ismine = ismine;
  }

  /**
   * @return the iswatchonly
   */
  public Boolean getIswatchonly() {
    return iswatchonly;
  }

  /**
   * @param iswatchonly the iswatchonly to set
   */
  public void setIswatchonly(Boolean iswatchonly) {
    this.iswatchonly = iswatchonly;
  }

  /**
   * @return the isscript
   */
  public Boolean getIsscript() {
    return isscript;
  }

  /**
   * @param isscript the isscript to set
   */
  public void setIsscript(Boolean isscript) {
    this.isscript = isscript;
  }

  /**
   * @return the hex
   */
  public String getHex() {
    return hex;
  }

  /**
   * @param hex the hex to set
   */
  public void setHex(String hex) {
    this.hex = hex;
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
   * @return the sigsrequired
   */
  public Long getSigsrequired() {
    return sigsrequired;
  }

  /**
   * @param sigsrequired the sigsrequired to set
   */
  public void setSigsrequired(Long sigsrequired) {
    this.sigsrequired = sigsrequired;
  }

  /**
   * @return the iscompressed
   */
  public Boolean getIscompressed() {
    return iscompressed;
  }

  /**
   * @param iscompressed the iscompressed to set
   */
  public void setIscompressed(Boolean iscompressed) {
    this.iscompressed = iscompressed;
  }

  /**
   * @return the issynchronized
   */
  public Boolean getIssynchronized() {
    return issynchronized;
  }

  /**
   * @param issynchronized the issynchronized to set
   */
  public void setIssynchronized(Boolean issynchronized) {
    this.issynchronized = issynchronized;
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

}
