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
public class MiningInfo {
  Long blocks = null;
  Long currentblocksize = null;
  Long currentblocktx = null;
  Double difficulty = null;
  String errors = null;
  Long genproclimit = null;
  Long networkhashps = null;
  Long pooledtx = null;
  Boolean testnet = null;
  String chain = null;
  Boolean generate = null;
  Long hashespersec = null;

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
   * @return the currentblocksize
   */
  public Long getCurrentblocksize() {
    return currentblocksize;
  }

  /**
   * @param currentblocksize the currentblocksize to set
   */
  public void setCurrentblocksize(Long currentblocksize) {
    this.currentblocksize = currentblocksize;
  }

  /**
   * @return the currentblocktx
   */
  public Long getCurrentblocktx() {
    return currentblocktx;
  }

  /**
   * @param currentblocktx the currentblocktx to set
   */
  public void setCurrentblocktx(Long currentblocktx) {
    this.currentblocktx = currentblocktx;
  }

  /**
   * @return the difficulty
   */
  public Double getDifficulty() {
    return difficulty;
  }

  /**
   * @param difficulty the difficulty to set
   */
  public void setDifficulty(Double difficulty) {
    this.difficulty = difficulty;
  }

  /**
   * @return the errors
   */
  public String getErrors() {
    return errors;
  }

  /**
   * @param errors the errors to set
   */
  public void setErrors(String errors) {
    this.errors = errors;
  }

  /**
   * @return the genproclimit
   */
  public Long getGenproclimit() {
    return genproclimit;
  }

  /**
   * @param genproclimit the genproclimit to set
   */
  public void setGenproclimit(Long genproclimit) {
    this.genproclimit = genproclimit;
  }

  /**
   * @return the networkhashps
   */
  public Long getNetworkhashps() {
    return networkhashps;
  }

  /**
   * @param networkhashps the networkhashps to set
   */
  public void setNetworkhashps(Long networkhashps) {
    this.networkhashps = networkhashps;
  }

  /**
   * @return the pooledtx
   */
  public Long getPooledtx() {
    return pooledtx;
  }

  /**
   * @param pooledtx the pooledtx to set
   */
  public void setPooledtx(Long pooledtx) {
    this.pooledtx = pooledtx;
  }

  /**
   * @return the testnet
   */
  public Boolean getTestnet() {
    return testnet;
  }

  /**
   * @param testnet the testnet to set
   */
  public void setTestnet(Boolean testnet) {
    this.testnet = testnet;
  }

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
   * @return the generate
   */
  public Boolean getGenerate() {
    return generate;
  }

  /**
   * @param generate the generate to set
   */
  public void setGenerate(Boolean generate) {
    this.generate = generate;
  }

  /**
   * @return the hashespersec
   */
  public Long getHashespersec() {
    return hashespersec;
  }

  /**
   * @param hashespersec the hashespersec to set
   */
  public void setHashespersec(Long hashespersec) {
    this.hashespersec = hashespersec;
  }


}
