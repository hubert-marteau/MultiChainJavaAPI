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
public class NetworkInfoLocalAddress {
  String address = null;
  Long port = null;
  Long score = null;

  /**
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return the port
   */
  public Long getPort() {
    return port;
  }

  /**
   * @param port the port to set
   */
  public void setPort(Long port) {
    this.port = port;
  }

  /**
   * @return the score
   */
  public Long getScore() {
    return score;
  }

  /**
   * @param score the score to set
   */
  public void setScore(Long score) {
    this.score = score;
  }



}
