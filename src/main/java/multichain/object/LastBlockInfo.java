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
public class LastBlockInfo {
  String hash = null;
  Long height = null;
  Long time = null;
  Long txcount = null;
  String miner = null;

  /**
   * @return the hash
   */
  public String getHash() {
    return hash;
  }

  /**
   * @param hash the hash to set
   */
  public void setHash(String hash) {
    this.hash = hash;
  }

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
   * @return the miner
   */
  public String getMiner() {
    return miner;
  }

  /**
   * @param miner the miner to set
   */
  public void setMiner(String miner) {
    this.miner = miner;
  }


}
