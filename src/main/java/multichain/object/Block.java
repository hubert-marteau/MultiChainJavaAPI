/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ub - H. MARTEAU
 * @version 4.14
 */
public class Block {
    String hash = null;
    String miner = null;
    Long confirmations = null;
    Long size = null;
    Long height = null;
    Long version = null;
    String merkleroot = null;
    List<String> tx;
    Long time = null;
    Long nonce = null;
    String bits = null;
    Double difficulty = null;
    String chainwork = null;
    String previousblockhash = null;
    String nextblockhash = null;

    /**
	 *
	 */
	public Block() {
		super();
		tx = new ArrayList<String>();
	}

	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}
	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}
	/**
	 * @return the miner
	 */
	public String getMiner() {
		return miner;
	}
	/**
	 * @param miner the miner to set
	 */
	public void setMiner(String miner) {
		this.miner = miner;
	}
	/**
	 * @return the confirmations
	 */
	public long getConfirmations() {
		return confirmations;
	}
	/**
	 * @param confirmations the confirmations to set
	 */
	public void setConfirmations(long confirmations) {
		this.confirmations = confirmations;
	}
	/**
	 * @return the size
	 */
	public long getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(long size) {
		this.size = size;
	}
	/**
	 * @return the height
	 */
	public long getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(long height) {
		this.height = height;
	}
	/**
	 * @return the version
	 */
	public long getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(long version) {
		this.version = version;
	}
	/**
	 * @return the merkleroot
	 */
	public String getMerkleroot() {
		return merkleroot;
	}
	/**
	 * @param merkleroot the merkleroot to set
	 */
	public void setMerkleroot(String merkleroot) {
		this.merkleroot = merkleroot;
	}
	/**
	 * @return the tx
	 */
	public List<String> getTx() {
		return tx;
	}
	/**
	 * @param tx the tx to set
	 */
	public void setTx(List<String> tx) {
		this.tx = tx;
	}

	/**
	 * @param tx the tx to set
	 */
	public void addTx(String value) {
		this.tx.add(value);
	}


	/**
	 * @return the time
	 */
	public long getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(long time) {
		this.time = time;
	}
	/**
	 * @return the nonce
	 */
	public long getNonce() {
		return nonce;
	}
	/**
	 * @param nonce the nonce to set
	 */
	public void setNonce(long nonce) {
		this.nonce = nonce;
	}
	/**
	 * @return the bits
	 */
	public String getBits() {
		return bits;
	}
	/**
	 * @param bits the bits to set
	 */
	public void setBits(String bits) {
		this.bits = bits;
	}
	/**
	 * @return the difficulty
	 */
	public double getDifficulty() {
		return difficulty;
	}
	/**
	 * @param difficulty the difficulty to set
	 */
	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
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
	/**
	 * @return the previousblockhash
	 */
	public String getPreviousblockhash() {
		return previousblockhash;
	}
	/**
	 * @param previousblockhash the previousblockhash to set
	 */
	public void setPreviousblockhash(String previousblockhash) {
		this.previousblockhash = previousblockhash;
	}
	/**
	 * @return the nextblockhash
	 */
	public String getNextblockhash() {
		return nextblockhash;
	}
	/**
	 * @param nextblockhash the nextblockhash to set
	 */
	public void setNextblockhash(String nextblockhash) {
		this.nextblockhash = nextblockhash;
	}

	public String toStringTx() {
		String toString = " - ";
		for(String value : tx) {
			toString += value + " - ";
		}
		return toString;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Block [hash=" + hash + ", miner=" + miner + ", confirmations=" + confirmations + ", size=" + size + ", height=" + height + ", version="
				+ version + ", merkleroot=" + merkleroot + ", tx=" + toStringTx() + ", time=" + time + ", nonce=" + nonce + ", bits=" + bits + ", difficulty="
				+ difficulty + ", chainwork=" + chainwork + ", previousblockhash=" + previousblockhash + ", nextblockhash=" + nextblockhash + "]";
	}


}
