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
public class MultisigAddress {
  String address = null;
  String redeemScript = null;

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
   * @return the redeemScript
   */
  public String getRedeemScript() {
    return redeemScript;
  }

  /**
   * @param redeemScript the redeemScript to set
   */
  public void setRedeemScript(String redeemScript) {
    this.redeemScript = redeemScript;
  }


}
