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
public class TxIdVout {
  String txid = null;
  Long vout = null;

  /**
   * @return the txid
   */
  public String getTxid() {
    return txid;
  }

  /**
   * @param txid the txid to set
   */
  public void setTxid(String txid) {
    this.txid = txid;
  }

  /**
   * @return the vout
   */
  public Long getVout() {
    return vout;
  }

  /**
   * @param vout the vout to set
   */
  public void setVout(Long vout) {
    this.vout = vout;
  }



}
