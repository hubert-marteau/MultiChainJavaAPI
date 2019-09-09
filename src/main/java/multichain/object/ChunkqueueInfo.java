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
public class ChunkqueueInfo {
  ChunkqueueInfoElt chunks = null;
  ChunkqueueInfoElt bytes = null;

  /**
   * @return the chunks
   */
  public ChunkqueueInfoElt getChunks() {
    return chunks;
  }

  /**
   * @param chunks the chunks to set
   */
  public void setChunks(ChunkqueueInfoElt chunks) {
    this.chunks = chunks;
  }

  /**
   * @return the bytes
   */
  public ChunkqueueInfoElt getBytes() {
    return bytes;
  }

  /**
   * @param bytes the bytes to set
   */
  public void setBytes(ChunkqueueInfoElt bytes) {
    this.bytes = bytes;
  }


}
