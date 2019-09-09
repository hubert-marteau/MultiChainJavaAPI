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
public class BlockchainInfo {
  String chain = null;
  String chainname = null;
  String description = null;
  String protocol = null;
  String setupblocks = null;
  Long blocks = null;
  Long headers = null;
  String bestblockhash = null;
  Long difficulty = null;
  Long verificationprogress = null;
  String chainwork = null;

  /**
   * @return the chain
   */
  public String getChain() {
    return chain;
  }

  /**
   * @param chain the chain to set
   */
  public void setChain(String chain) {
    this.chain = chain;
  }

  /**
   * @return the chainname
   */
  public String getChainname() {
    return chainname;
  }

  /**
   * @param chainname the chainname to set
   */
  public void setChainname(String chainname) {
    this.chainname = chainname;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the protocol
   */
  public String getProtocol() {
    return protocol;
  }

  /**
   * @param protocol the protocol to set
   */
  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  /**
   * @return the setupblocks
   */
  public String getSetupblocks() {
    return setupblocks;
  }

  /**
   * @param setupblocks the setupblocks to set
   */
  public void setSetupblocks(String setupblocks) {
    this.setupblocks = setupblocks;
  }

  /**
   * @return the blocks
   */
  public Long getBlocks() {
    return blocks;
  }

  /**
   * @param blocks the blocks to set
   */
  public void setBlocks(Long blocks) {
    this.blocks = blocks;
  }

  /**
   * @return the headers
   */
  public Long getHeaders() {
    return headers;
  }

  /**
   * @param headers the headers to set
   */
  public void setHeaders(Long headers) {
    this.headers = headers;
  }

  /**
   * @return the bestblockhash
   */
  public String getBestblockhash() {
    return bestblockhash;
  }

  /**
   * @param bestblockhash the bestblockhash to set
   */
  public void setBestblockhash(String bestblockhash) {
    this.bestblockhash = bestblockhash;
  }

  /**
   * @return the difficulty
   */
  public Long getDifficulty() {
    return difficulty;
  }

  /**
   * @param difficulty the difficulty to set
   */
  public void setDifficulty(Long difficulty) {
    this.difficulty = difficulty;
  }

  /**
   * @return the verificationprogress
   */
  public Long getVerificationprogress() {
    return verificationprogress;
  }

  /**
   * @param verificationprogress the verificationprogress to set
   */
  public void setVerificationprogress(Long verificationprogress) {
    this.verificationprogress = verificationprogress;
  }

  /**
   * @return the chainwork
   */
  public String getChainwork() {
    return chainwork;
  }

  /**
   * @param chainwork the chainwork to set
   */
  public void setChainwork(String chainwork) {
    this.chainwork = chainwork;
  }


}
