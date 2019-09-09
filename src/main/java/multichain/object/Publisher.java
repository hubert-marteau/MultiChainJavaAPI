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
public class Publisher {
  String publisher = null;
  Long items = null;
  Long confirmed = null;
  StreamKeyItem first = null;
  StreamKeyItem last = null;

  /**
   * @return the publisher
   */
  public String getPublisher() {
    return publisher;
  }

  /**
   * @param publisher the publisher to set
   */
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  /**
   * @return the items
   */
  public Long getItems() {
    return items;
  }

  /**
   * @param items the items to set
   */
  public void setItems(Long items) {
    this.items = items;
  }

  /**
   * @return the confirmed
   */
  public Long getConfirmed() {
    return confirmed;
  }

  /**
   * @param confirmed the confirmed to set
   */
  public void setConfirmed(Long confirmed) {
    this.confirmed = confirmed;
  }

  /**
   * @return the first
   */
  public StreamKeyItem getFirst() {
    return first;
  }

  /**
   * @param first the first to set
   */
  public void setFirst(StreamKeyItem first) {
    this.first = first;
  }

  /**
   * @return the last
   */
  public StreamKeyItem getLast() {
    return last;
  }

  /**
   * @param last the last to set
   */
  public void setLast(StreamKeyItem last) {
    this.last = last;
  }


}
