/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

import multichain.command.builders.QueryBuilderBlock;
import multichain.object.Block;
import multichain.object.formatters.BlockFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0
 */
public class BlockCommand extends QueryBuilderBlock {

	public BlockCommand(String chainName) {
		setCHAIN(chainName);
	}

	/**
	 * getbestblockhash
	 * 
	 * Returns the hash of the best (tip) block in the longest block chain.
	 * 
	 * Result
	 * "hex" (string) the block hash hex encoded
	 * 
	 * @return the hash of the best block
	 * @throws MultichainException
	 */
	public String getBestBlockHash() throws MultichainException {
		return executeGetBestBlockHash();
	}

	/**
	 * getblock "hash/height" ( verbose )
	 * 
	 * If verbose is false, returns a string that is serialized, hex-encoded data for block 'hash'.
	 * If verbose is true, returns an Object with information about block <hash>.
	 * 
	 * Arguments:
	 * 1. "hash/height" (string, required) The block hash or block height in active chain
	 * 2. verbose (boolean, optional, default=true) true for a json object, false for the hex encoded data
	 * 
	 * Result (for verbose = true):
	 * {
	 * "hash" : "hash", (string) the block hash (same as provided)
	 * "miner" : "miner", (string) the address of the miner
	 * "confirmations" : n, (numeric) The number of confirmations, or -1 if the block is not on the main chain
	 * "size" : n, (numeric) The block size
	 * "height" : n, (numeric) The block height or index
	 * "version" : n, (numeric) The block version
	 * "merkleroot" : "xxxx", (string) The merkle root
	 * "tx" : [ (array of string) The transaction ids
	 * "transactionid" (string) The transaction id
	 * ,...
	 * ],
	 * "time" : ttt, (numeric) The block time in seconds since epoch (Jan 1 1970 GMT)
	 * "nonce" : n, (numeric) The nonce
	 * "bits" : "1d00ffff", (string) The bits
	 * "difficulty" : x.xxx, (numeric) The difficulty
	 * "previousblockhash" : "hash", (string) The hash of the previous block
	 * "nextblockhash" : "hash" (string) The hash of the next block
	 * }
	 * 
	 * Result (for verbose=false):
	 * "data" (string) A string that is serialized, hex-encoded data for block 'hash'.
	 * 
	 * 
	 * @param hashOrHeight
	 * @param verbose
	 * @return Block : information about the block with hash (retrievable from getblockhash) or at the given height in
	 *         the active chain
	 * @throws MultichainException
	 */
	public Block getBlock(String blockHash, boolean verbose) throws MultichainException {
		String stringBlock = executeGetBlock(blockHash, verbose);

		return BlockFormatter.formatBlock(stringBlock);
	}

	/**
	 * {@link #getBlock(String, boolean)} without verbose
	 * 
	 * @param blockHash
	 * @return Block : information about the block with hash (retrievable from getblockhash) or at the given height in
	 *         the active chain
	 * @throws MultichainException
	 */
	public Block getBlock(String blockHash) throws MultichainException {
		String stringBlock = executeGetBlock(blockHash, true);

		return BlockFormatter.formatBlock(stringBlock);
	}

	/**
	 * {@link #getBlock(String, boolean)} with long value of Height
	 * 
	 * @param blockHash
	 * @param verbose
	 * @return Block : information about the block with hash (retrievable from getblockhash) or at the given height in
	 *         the active chain
	 * @throws MultichainException
	 */
	public Block getBlock(long blockHeight, boolean verbose) throws MultichainException {
		String blockHash = Long.toString(blockHeight);

		return getBlock(blockHash, verbose);
	}

	/**
	 * {@link #getBlock(long, boolean)} without verbose
	 * 
	 * @param blockHash
	 * @return Block : information about the block with hash (retrievable from getblockhash) or at the given height in
	 *         the active chain
	 * @throws MultichainException
	 */
	public Block getBlock(long blockHeight) throws MultichainException {
		String blockHash = Long.toString(blockHeight);

		return getBlock(blockHash, true);
	}

	/**
	 * getblockcount
	 * 
	 * Returns the number of blocks in the longest block chain.
	 * 
	 * Result:
	 * n (numeric) The current block count
	 * 
	 * @return The Actual count of blocks in the BlockChain.
	 * @throws MultichainException
	 */
	public long getBlockCount() throws MultichainException {
		String stringBlockCount = executeGetBlockCount();

		return BlockFormatter.formatBlockCount(stringBlockCount);
	}

	/**
	 * getblockhash index
	 * 
	 * Returns hash of block in best-block-chain at index provided.
	 * 
	 * Arguments:
	 * 1. index (numeric, required) The block index
	 * 
	 * Result:
	 * "hash" (string) The block hash
	 * 
	 * @return the hash of the best block
	 * @throws MultichainException
	 */
	public String getBlockHash(long index) throws MultichainException {
		return executeGetBlockHash(index);
	}

}
