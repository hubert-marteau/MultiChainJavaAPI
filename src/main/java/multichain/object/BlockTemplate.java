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
public class BlockTemplate {
  Long version = null;
  Double previousblockhash = null;
  List<BlockTemplateTransation> transactions = null;
  Map<String, String> coinbaseaux = null;
  Long coinbasevalue = null;
  String coinbasetxn = null;
  String target = null;
  String mintime = null;
  List<String> mutable = null;
  String noncerange = null;
  Long sigoplimit = null;
  Long sizelimit = null;
  Long curtime = null;
  String bits = null;
  Long height = null;

  /**
   * @return the version
   */
  public Long getVersion() {
    return version;
  }

  /**
   * @param version the version to set
   */
  public void setVersion(Long version) {
    this.version = version;
  }

  /**
   * @return the previousblockhash
   */
  public Double getPreviousblockhash() {
    return previousblockhash;
  }

  /**
   * @param previousblockhash the previousblockhash to set
   */
  public void setPreviousblockhash(Double previousblockhash) {
    this.previousblockhash = previousblockhash;
  }

  /**
   * @return the transactions
   */
  public List<BlockTemplateTransation> getTransactions() {
    return transactions;
  }

  /**
   * @param transactions the transactions to set
   */
  public void setTransactions(List<BlockTemplateTransation> transactions) {
    this.transactions = transactions;
  }

  /**
   * @return the coinbaseaux
   */
  public Map<String, String> getCoinbaseaux() {
    return coinbaseaux;
  }

  /**
   * @param coinbaseaux the coinbaseaux to set
   */
  public void setCoinbaseaux(Map<String, String> coinbaseaux) {
    this.coinbaseaux = coinbaseaux;
  }

  /**
   * @return the coinbasevalue
   */
  public Long getCoinbasevalue() {
    return coinbasevalue;
  }

  /**
   * @param coinbasevalue the coinbasevalue to set
   */
  public void setCoinbasevalue(Long coinbasevalue) {
    this.coinbasevalue = coinbasevalue;
  }

  /**
   * @return the coinbasetxn
   */
  public String getCoinbasetxn() {
    return coinbasetxn;
  }

  /**
   * @param coinbasetxn the coinbasetxn to set
   */
  public void setCoinbasetxn(String coinbasetxn) {
    this.coinbasetxn = coinbasetxn;
  }

  /**
   * @return the target
   */
  public String getTarget() {
    return target;
  }

  /**
   * @param target the target to set
   */
  public void setTarget(String target) {
    this.target = target;
  }

  /**
   * @return the mintime
   */
  public String getMintime() {
    return mintime;
  }

  /**
   * @param mintime the mintime to set
   */
  public void setMintime(String mintime) {
    this.mintime = mintime;
  }

  /**
   * @return the mutable
   */
  public List<String> getMutable() {
    return mutable;
  }

  /**
   * @param mutable the mutable to set
   */
  public void setMutable(List<String> mutable) {
    this.mutable = mutable;
  }

  /**
   * @return the noncerange
   */
  public String getNoncerange() {
    return noncerange;
  }

  /**
   * @param noncerange the noncerange to set
   */
  public void setNoncerange(String noncerange) {
    this.noncerange = noncerange;
  }

  /**
   * @return the sigoplimit
   */
  public Long getSigoplimit() {
    return sigoplimit;
  }

  /**
   * @param sigoplimit the sigoplimit to set
   */
  public void setSigoplimit(Long sigoplimit) {
    this.sigoplimit = sigoplimit;
  }

  /**
   * @return the sizelimit
   */
  public Long getSizelimit() {
    return sizelimit;
  }

  /**
   * @param sizelimit the sizelimit to set
   */
  public void setSizelimit(Long sizelimit) {
    this.sizelimit = sizelimit;
  }

  /**
   * @return the curtime
   */
  public Long getCurtime() {
    return curtime;
  }

  /**
   * @param curtime the curtime to set
   */
  public void setCurtime(Long curtime) {
    this.curtime = curtime;
  }

  /**
   * @return the bits
   */
  public String getBits() {
    return bits;
  }

  /**
   * @param bits the bits to set
   */
  public void setBits(String bits) {
    this.bits = bits;
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


}
