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
public class AssetIssues {

  String txid = null;
  Long qty = null;
  Long raw = null;
  Map<String, String> details = null;
  List<String> issuers = null;

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
   * @return the qty
   */
  public Long getQty() {
    return qty;
  }

  /**
   * @param qty the qty to set
   */
  public void setQty(Long qty) {
    this.qty = qty;
  }

  /**
   * @return the raw
   */
  public Long getRaw() {
    return raw;
  }

  /**
   * @param raw the raw to set
   */
  public void setRaw(Long raw) {
    this.raw = raw;
  }

  /**
   * @return the details
   */
  public Map<String, String> getDetails() {
    return details;
  }

  /**
   * @param details the details to set
   */
  public void setDetails(Map<String, String> details) {
    this.details = details;
  }

  /**
   * @return the issuers
   */
  public List<String> getIssuers() {
    return issuers;
  }

  /**
   * @param issuers the issuers to set
   */
  public void setIssuers(List<String> issuers) {
    this.issuers = issuers;
  }



}
