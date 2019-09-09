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
public class Script {
  String asm = null;
  String hex = null;
  String type = null;
  Long reqSigs = null;
  List<String> addresses = null;
  String p2sh = null;

  /**
   * @return the asm
   */
  public String getAsm() {
    return asm;
  }

  /**
   * @param asm the asm to set
   */
  public void setAsm(String asm) {
    this.asm = asm;
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
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @return the reqSigs
   */
  public Long getReqSigs() {
    return reqSigs;
  }

  /**
   * @param reqSigs the reqSigs to set
   */
  public void setReqSigs(Long reqSigs) {
    this.reqSigs = reqSigs;
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
   * @return the p2sh
   */
  public String getP2sh() {
    return p2sh;
  }

  /**
   * @param p2sh the p2sh to set
   */
  public void setP2sh(String p2sh) {
    this.p2sh = p2sh;
  }


}
