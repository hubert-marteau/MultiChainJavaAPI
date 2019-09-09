/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

import java.util.List;
import java.util.Map;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.1
 */
public class AssetTransaction {

  Map<String, Double> addresses;
  List<Item> items;
  List<String> data;
  Long confirmations;
  String blockhash;
  Long blockindex;
  Long blocktime;
  String txid;
  Boolean valid;
  Long time;
  Long timereceived;
  List<TransactionWalletVin> vin;
  List<TransactionWalletVout> vout;

  public AssetTransaction() {}

  public Map<String, Double> getAddresses() {
    return addresses;
  }

  public void setAddresses(Map<String, Double> addresses) {
    this.addresses = addresses;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public List<String> getData() {
    return data;
  }

  public void setData(List<String> data) {
    this.data = data;
  }

  public Long getConfirmations() {
    return confirmations;
  }

  public void setConfirmations(Long confirmations) {
    this.confirmations = confirmations;
  }

  public String getBlockhash() {
    return blockhash;
  }

  public void setBlockhash(String blockhash) {
    this.blockhash = blockhash;
  }

  public Long getBlockindex() {
    return blockindex;
  }

  public void setBlockindex(Long blockindex) {
    this.blockindex = blockindex;
  }

  public Long getBlocktime() {
    return blocktime;
  }

  public void setBlocktime(Long blocktime) {
    this.blocktime = blocktime;
  }

  public String getTxid() {
    return txid;
  }

  public void setTxid(String txid) {
    this.txid = txid;
  }

  public Boolean getValid() {
    return valid;
  }

  public void setValid(Boolean valid) {
    this.valid = valid;
  }

  public Long getTime() {
    return time;
  }

  public void setTime(Long time) {
    this.time = time;
  }

  public Long getTimereceived() {
    return timereceived;
  }

  public void setTimereceived(Long timereceived) {
    this.timereceived = timereceived;
  }

  public List<TransactionWalletVin> getVin() {
    return vin;
  }

  public void setVin(List<TransactionWalletVin> vin) {
    this.vin = vin;
  }

  public List<TransactionWalletVout> getVout() {
    return vout;
  }

  public void setVout(List<TransactionWalletVout> vout) {
    this.vout = vout;
  }
}
