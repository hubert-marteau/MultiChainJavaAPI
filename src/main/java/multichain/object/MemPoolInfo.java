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
public class MemPoolInfo {
  Long size = null;
  Long bytes = null;

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
   * @return the bytes
   */
  public Long getBytes() {
    return bytes;
  }

  /**
   * @param bytes the bytes to set
   */
  public void setBytes(Long bytes) {
    this.bytes = bytes;
  }


}
