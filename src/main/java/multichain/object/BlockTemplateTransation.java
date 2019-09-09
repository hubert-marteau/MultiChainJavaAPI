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
public class BlockTemplateTransation {
  String data = null;
  String hash = null;
  List<Long> depends = null;
  Long fee = null;
  Long sigops = null;
  Boolean required = null;

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
   * @return the depends
   */
  public List<Long> getDepends() {
    return depends;
  }

  /**
   * @param depends the depends to set
   */
  public void setDepends(List<Long> depends) {
    this.depends = depends;
  }

  /**
   * @return the fee
   */
  public Long getFee() {
    return fee;
  }

  /**
   * @param fee the fee to set
   */
  public void setFee(Long fee) {
    this.fee = fee;
  }

  /**
   * @return the sigops
   */
  public Long getSigops() {
    return sigops;
  }

  /**
   * @param sigops the sigops to set
   */
  public void setSigops(Long sigops) {
    this.sigops = sigops;
  }

  /**
   * @return the required
   */
  public Boolean getRequired() {
    return required;
  }

  /**
   * @param required the required to set
   */
  public void setRequired(Boolean required) {
    this.required = required;
  }


}
