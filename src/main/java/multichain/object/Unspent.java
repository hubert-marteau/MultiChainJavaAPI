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
public class Unspent {
  String txid = null;
  Long vout = null;
  String address = null;
  String account = null;
  String scriptPubKey = null;
  Double amount = null;
  Long confirmations = null;

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
   * @return the scriptPubKey
   */
  public String getScriptPubKey() {
    return scriptPubKey;
  }

  /**
   * @param scriptPubKey the scriptPubKey to set
   */
  public void setScriptPubKey(String scriptPubKey) {
    this.scriptPubKey = scriptPubKey;
  }

  /**
   * @return the amount
   */
  public Double getAmount() {
    return amount;
  }

  /**
   * @param amount the amount to set
   */
  public void setAmount(Double amount) {
    this.amount = amount;
  }

  /**
   * @return the confirmations
   */
  public Long getConfirmations() {
    return confirmations;
  }

  /**
   * @param confirmations the confirmations to set
   */
  public void setConfirmations(Long confirmations) {
    this.confirmations = confirmations;
  }


}
