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
public class ChunkqueueTotal {
  ChunkqueueTotalElt chunks = null;
  ChunkqueueTotalElt bytes = null;

  /**
   * @return the chunks
   */
  public ChunkqueueTotalElt getChunks() {
    return chunks;
  }

  /**
   * @param chunks the chunks to set
   */
  public void setChunks(ChunkqueueTotalElt chunks) {
    this.chunks = chunks;
  }

  /**
   * @return the bytes
   */
  public ChunkqueueTotalElt getBytes() {
    return bytes;
  }

  /**
   * @param bytes the bytes to set
   */
  public void setBytes(ChunkqueueTotalElt bytes) {
    this.bytes = bytes;
  }


}
