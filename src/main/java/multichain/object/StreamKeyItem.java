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
public class StreamKeyItem {
  List<String> publishers;
  String key = null;
  List<String> keys;
  Boolean offchain;
  Boolean available;
  String data = null;
  Long confirmations = null;
  String blockhash = null;
  Long blockindex = null;
  Long blocktime = null;
  String txid = null;
  Long vout = null;
  Boolean valid = null;
  Long time = null;
  Long timereceived = null;

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "StreamKeyItem [publishers=" + publishers.toString() + ",\n key=" + key + ",\n keys="
        + keys.toString() + ",\n data=" + data + ",\n confirmations=" + confirmations
        + ",\n blockhash=" + blockhash + ",\n blockindex=" + blockindex + ",\n blocktime="
        + blocktime + ",\n txid=" + txid + ",\n vout=" + vout + ",\n valid=" + valid + ",\n time="
        + time + ",\n timereceived=" + timereceived + "]";
  }

  /**
   * @return the publishers
   */
  public List<String> getPublishers() {
    return publishers;
  }

  /**
   * @param publishers the publishers to set
   */
  public void setPublishers(List<String> publishers) {
    this.publishers = publishers;
  }

  /**
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * @param key the key to set
   */
  public void setKey(String key) {
    this.key = key;
  }

  /**
   * @return the data
   */
  public String getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(String data) {
    this.data = data;
  }

  /**
   * @return the confirmations
   */
  public long getConfirmations() {
    return confirmations;
  }

  /**
   * @param confirmations the confirmations to set
   */
  public void setConfirmations(long confirmations) {
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
  public long getBlockindex() {
    return blockindex;
  }

  /**
   * @param blockindex the blockindex to set
   */
  public void setBlockindex(long blockindex) {
    this.blockindex = blockindex;
  }

  /**
   * @return the blocktime
   */
  public long getBlocktime() {
    return blocktime;
  }

  /**
   * @param blocktime the blocktime to set
   */
  public void setBlocktime(long blocktime) {
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
   * @return the vout
   */
  public long getVout() {
    return vout;
  }

  /**
   * @param vout the vout to set
   */
  public void setVout(long vout) {
    this.vout = vout;
  }

  /**
   * @return the valid
   */
  public boolean isValid() {
    return valid;
  }

  /**
   * @param valid the valid to set
   */
  public void setValid(boolean valid) {
    this.valid = valid;
  }

  /**
   * @return the time
   */
  public long getTime() {
    return time;
  }

  /**
   * @param time the time to set
   */
  public void setTime(long time) {
    this.time = time;
  }

  /**
   * @return the timereceived
   */
  public long getTimereceived() {
    return timereceived;
  }

  /**
   * @param timereceived the timereceived to set
   */
  public void setTimereceived(long timereceived) {
    this.timereceived = timereceived;
  }

  /**
   * @return the keys
   */
  public List<String> getKeys() {
    return keys;
  }

  /**
   * @param keys the keys to set
   */
  public void setKeys(List<String> keys) {
    this.keys = keys;
  }

  /**
   * @return the offchain
   */
  public Boolean getOffchain() {
    return offchain;
  }

  /**
   * @param offchain the offchain to set
   */
  public void setOffchain(Boolean offchain) {
    this.offchain = offchain;
  }

  /**
   * @return the available
   */
  public Boolean getAvailable() {
    return available;
  }

  /**
   * @param available the available to set
   */
  public void setAvailable(Boolean available) {
    this.available = available;
  }

  /**
   * @return the valid
   */
  public Boolean getValid() {
    return valid;
  }

  /**
   * @param valid the valid to set
   */
  public void setValid(Boolean valid) {
    this.valid = valid;
  }

  /**
   * @param confirmations the confirmations to set
   */
  public void setConfirmations(Long confirmations) {
    this.confirmations = confirmations;
  }

  /**
   * @param blockindex the blockindex to set
   */
  public void setBlockindex(Long blockindex) {
    this.blockindex = blockindex;
  }

  /**
   * @param blocktime the blocktime to set
   */
  public void setBlocktime(Long blocktime) {
    this.blocktime = blocktime;
  }

  /**
   * @param vout the vout to set
   */
  public void setVout(Long vout) {
    this.vout = vout;
  }

  /**
   * @param time the time to set
   */
  public void setTime(Long time) {
    this.time = time;
  }

  /**
   * @param timereceived the timereceived to set
   */
  public void setTimereceived(Long timereceived) {
    this.timereceived = timereceived;
  }

}
