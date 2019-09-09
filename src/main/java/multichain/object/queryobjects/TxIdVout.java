/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.queryobjects;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.1
 */
public class TxIdVout {
  String txid;
  int vout;

  /**
   * @return the txId
   */
  public String getTxId() {
    return txid;
  }

  /**
   * @param txId the txId to set
   */
  public void setTxId(String txId) {
    this.txid = txId;
  }

  /**
   * @return the vOut
   */
  public int getvOut() {
    return vout;
  }

  /**
   * @param vOut the vOut to set
   */
  public void setvOut(int vOut) {
    this.vout = vOut;
  }


}
