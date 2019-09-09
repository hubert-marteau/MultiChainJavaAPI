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
public class AddressReceived {
  Boolean involvesWatchonly = null;
  String address = null;
  String account = null;
  Double amount = null;
  Long confirmations = null;

  /**
   * @return the involvesWatchonly
   */
  public Boolean getInvolvesWatchonly() {
    return involvesWatchonly;
  }

  /**
   * @param involvesWatchonly the involvesWatchonly to set
   */
  public void setInvolvesWatchonly(Boolean involvesWatchonly) {
    this.involvesWatchonly = involvesWatchonly;
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
