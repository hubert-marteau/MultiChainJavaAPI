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
public class TxOutInfo {
  Long height = null;
  String bestblock = null;
  Long transactions = null;
  Long txouts = null;
  Long bytes_serialized = null;
  String hash_serialized = null;
  Double total_amount = null;

  /**
   * @return the height
   */
  public Long getHeight() {
    return height;
  }

  /**
   * @param height the height to set
   */
  public void setHeight(Long height) {
    this.height = height;
  }

  /**
   * @return the bestblock
   */
  public String getBestblock() {
    return bestblock;
  }

  /**
   * @param bestblock the bestblock to set
   */
  public void setBestblock(String bestblock) {
    this.bestblock = bestblock;
  }

  /**
   * @return the transactions
   */
  public Long getTransactions() {
    return transactions;
  }

  /**
   * @param transactions the transactions to set
   */
  public void setTransactions(Long transactions) {
    this.transactions = transactions;
  }

  /**
   * @return the txouts
   */
  public Long getTxouts() {
    return txouts;
  }

  /**
   * @param txouts the txouts to set
   */
  public void setTxouts(Long txouts) {
    this.txouts = txouts;
  }

  /**
   * @return the bytes_serialized
   */
  public Long getBytes_serialized() {
    return bytes_serialized;
  }

  /**
   * @param bytes_serialized the bytes_serialized to set
   */
  public void setBytes_serialized(Long bytes_serialized) {
    this.bytes_serialized = bytes_serialized;
  }

  /**
   * @return the hash_serialized
   */
  public String getHash_serialized() {
    return hash_serialized;
  }

  /**
   * @param hash_serialized the hash_serialized to set
   */
  public void setHash_serialized(String hash_serialized) {
    this.hash_serialized = hash_serialized;
  }

  /**
   * @return the total_amount
   */
  public Double getTotal_amount() {
    return total_amount;
  }

  /**
   * @param total_amount the total_amount to set
   */
  public void setTotal_amount(Double total_amount) {
    this.total_amount = total_amount;
  }


}
