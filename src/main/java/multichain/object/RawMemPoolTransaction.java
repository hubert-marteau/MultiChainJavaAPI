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
public class RawMemPoolTransaction {
  Long size = null;
  Double fee = null;
  Long time = null;
  Long height = null;
  Long startingpriority = null;
  Long currentpriority = null;
  List<String> depends = null;

  /**
   * @return the size
   */
  public Long getSize() {
    return size;
  }

  /**
   * @param size the size to set
   */
  public void setSize(Long size) {
    this.size = size;
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
   * @return the startingpriority
   */
  public Long getStartingpriority() {
    return startingpriority;
  }

  /**
   * @param startingpriority the startingpriority to set
   */
  public void setStartingpriority(Long startingpriority) {
    this.startingpriority = startingpriority;
  }

  /**
   * @return the currentpriority
   */
  public Long getCurrentpriority() {
    return currentpriority;
  }

  /**
   * @param currentpriority the currentpriority to set
   */
  public void setCurrentpriority(Long currentpriority) {
    this.currentpriority = currentpriority;
  }

  /**
   * @return the depends
   */
  public List<String> getDepends() {
    return depends;
  }

  /**
   * @param depends the depends to set
   */
  public void setDepends(List<String> depends) {
    this.depends = depends;
  }


}
