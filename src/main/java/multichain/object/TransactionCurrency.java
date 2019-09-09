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
public class TransactionCurrency {
  String account = null;
  String address = null;
  String category = null;
  Double amount = null;
  Long vout = null;
  Double fee = null;
  Long confirmations = null;
  String blockhash = null;
  Long blockindex = null;
  Long blocktime = null;
  String txid = null;
  Long time = null;
  Long timereceived = null;
  String comment = null;
  String to = null;

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
   * @return the category
   */
  public String getCategory() {
    return category;
  }

  /**
   * @param category the category to set
   */
  public void setCategory(String category) {
    this.category = category;
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
   * @return the fee
   */
  public Double getFee() {
    return fee;
  }

  /**
   * @param fee the fee to set
   */
  public void setFee(Double fee) {
    this.fee = fee;
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

  /**
   * @return the blockhash
   */
  public String getBlockhash() {
    return blockhash;
  }

  /**
   * @param blockhash the blockhash to set
   */
  public void setBlockhash(String blockhash) {
    this.blockhash = blockhash;
  }

  /**
   * @return the blockindex
   */
  public Long getBlockindex() {
    return blockindex;
  }

  /**
   * @param blockindex the blockindex to set
   */
  public void setBlockindex(Long blockindex) {
    this.blockindex = blockindex;
  }

  /**
   * @return the blocktime
   */
  public Long getBlocktime() {
    return blocktime;
  }

  /**
   * @param blocktime the blocktime to set
   */
  public void setBlocktime(Long blocktime) {
    this.blocktime = blocktime;
  }

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
   * @return the time
   */
  public Long getTime() {
    return time;
  }

  /**
   * @param time the time to set
   */
  public void setTime(Long time) {
    this.time = time;
  }

  /**
   * @return the timereceived
   */
  public Long getTimereceived() {
    return timereceived;
  }

  /**
   * @param timereceived the timereceived to set
   */
  public void setTimereceived(Long timereceived) {
    this.timereceived = timereceived;
  }

  /**
   * @return the comment
   */
  public String getComment() {
    return comment;
  }

  /**
   * @param comment the comment to set
   */
  public void setComment(String comment) {
    this.comment = comment;
  }

  /**
   * @return the to
   */
  public String getTo() {
    return to;
  }

  /**
   * @param to the to to set
   */
  public void setTo(String to) {
    this.to = to;
  }


}
