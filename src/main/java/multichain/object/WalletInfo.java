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
public class WalletInfo {
  Long walletversion = null;
  Long balance = null;
  Long txcount = null;
  Long walletdbversion = null;
  Long keypoololdest = null;
  Long keypoolsize = null;
  Long unlocked_until = null;

  /**
   * @return the walletversion
   */
  public Long getWalletversion() {
    return walletversion;
  }

  /**
   * @param walletversion the walletversion to set
   */
  public void setWalletversion(Long walletversion) {
    this.walletversion = walletversion;
  }

  /**
   * @return the balance
   */
  public Long getBalance() {
    return balance;
  }

  /**
   * @param balance the balance to set
   */
  public void setBalance(Long balance) {
    this.balance = balance;
  }

  /**
   * @return the txcount
   */
  public Long getTxcount() {
    return txcount;
  }

  /**
   * @param txcount the txcount to set
   */
  public void setTxcount(Long txcount) {
    this.txcount = txcount;
  }

  /**
   * @return the walletdbversion
   */
  public Long getWalletdbversion() {
    return walletdbversion;
  }

  /**
   * @param walletdbversion the walletdbversion to set
   */
  public void setWalletdbversion(Long walletdbversion) {
    this.walletdbversion = walletdbversion;
  }

  /**
   * @return the keypoololdest
   */
  public Long getKeypoololdest() {
    return keypoololdest;
  }

  /**
   * @param keypoololdest the keypoololdest to set
   */
  public void setKeypoololdest(Long keypoololdest) {
    this.keypoololdest = keypoololdest;
  }

  /**
   * @return the keypoolsize
   */
  public Long getKeypoolsize() {
    return keypoolsize;
  }

  /**
   * @param keypoolsize the keypoolsize to set
   */
  public void setKeypoolsize(Long keypoolsize) {
    this.keypoolsize = keypoolsize;
  }

  /**
   * @return the unlocked_until
   */
  public Long getUnlocked_until() {
    return unlocked_until;
  }

  /**
   * @param unlocked_until the unlocked_until to set
   */
  public void setUnlocked_until(Long unlocked_until) {
    this.unlocked_until = unlocked_until;
  }


}
