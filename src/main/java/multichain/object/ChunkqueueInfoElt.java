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
public class ChunkqueueInfoElt {
  Long waiting = null;
  Long querying = null;
  Long retrieving = null;

  /**
   * @return the waiting
   */
  public Long getWaiting() {
    return waiting;
  }

  /**
   * @param waiting the waiting to set
   */
  public void setWaiting(Long waiting) {
    this.waiting = waiting;
  }

  /**
   * @return the querying
   */
  public Long getQuerying() {
    return querying;
  }

  /**
   * @param querying the querying to set
   */
  public void setQuerying(Long querying) {
    this.querying = querying;
  }

  /**
   * @return the retrieving
   */
  public Long getRetrieving() {
    return retrieving;
  }

  /**
   * @param retrieving the retrieving to set
   */
  public void setRetrieving(Long retrieving) {
    this.retrieving = retrieving;
  }


}
