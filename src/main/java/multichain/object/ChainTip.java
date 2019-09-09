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
public class ChainTip {
  String height = null;
  String hash = null;
  Long branchlen = null;
  String status = null;

  /**
   * @return the height
   */
  public String getHeight() {
    return height;
  }

  /**
   * @param height the height to set
   */
  public void setHeight(String height) {
    this.height = height;
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
   * @return the branchlen
   */
  public Long getBranchlen() {
    return branchlen;
  }

  /**
   * @param branchlen the branchlen to set
   */
  public void setBranchlen(Long branchlen) {
    this.branchlen = branchlen;
  }

  /**
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }


}
