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
public class NetTotals {
  Long totalbytesrecv = null;
  Long totalbytessent = null;
  Long timemillis = null;

  /**
   * @return the totalbytesrecv
   */
  public Long getTotalbytesrecv() {
    return totalbytesrecv;
  }

  /**
   * @param totalbytesrecv the totalbytesrecv to set
   */
  public void setTotalbytesrecv(Long totalbytesrecv) {
    this.totalbytesrecv = totalbytesrecv;
  }

  /**
   * @return the totalbytessent
   */
  public Long getTotalbytessent() {
    return totalbytessent;
  }

  /**
   * @param totalbytessent the totalbytessent to set
   */
  public void setTotalbytessent(Long totalbytessent) {
    this.totalbytessent = totalbytessent;
  }

  /**
   * @return the timemillis
   */
  public Long getTimemillis() {
    return timemillis;
  }

  /**
   * @param timemillis the timemillis to set
   */
  public void setTimemillis(Long timemillis) {
    this.timemillis = timemillis;
  }


}
