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
public class ChunkqueueTotalElt {
  Long queries = null;
  Long responded = null;
  Long unresponded = null;
  Long requests = null;
  Long delivered = null;
  Long undelivered = null;
  Long baddelivered = null;

  /**
   * @return the queries
   */
  public Long getQueries() {
    return queries;
  }

  /**
   * @param queries the queries to set
   */
  public void setQueries(Long queries) {
    this.queries = queries;
  }

  /**
   * @return the responded
   */
  public Long getResponded() {
    return responded;
  }

  /**
   * @param responded the responded to set
   */
  public void setResponded(Long responded) {
    this.responded = responded;
  }

  /**
   * @return the unresponded
   */
  public Long getUnresponded() {
    return unresponded;
  }

  /**
   * @param unresponded the unresponded to set
   */
  public void setUnresponded(Long unresponded) {
    this.unresponded = unresponded;
  }

  /**
   * @return the requests
   */
  public Long getRequests() {
    return requests;
  }

  /**
   * @param requests the requests to set
   */
  public void setRequests(Long requests) {
    this.requests = requests;
  }

  /**
   * @return the delivered
   */
  public Long getDelivered() {
    return delivered;
  }

  /**
   * @param delivered the delivered to set
   */
  public void setDelivered(Long delivered) {
    this.delivered = delivered;
  }

  /**
   * @return the undelivered
   */
  public Long getUndelivered() {
    return undelivered;
  }

  /**
   * @param undelivered the undelivered to set
   */
  public void setUndelivered(Long undelivered) {
    this.undelivered = undelivered;
  }

  /**
   * @return the baddelivered
   */
  public Long getBaddelivered() {
    return baddelivered;
  }

  /**
   * @param baddelivered the baddelivered to set
   */
  public void setBaddelivered(Long baddelivered) {
    this.baddelivered = baddelivered;
  }


}
