/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import multichain.command.builders.QueryBuilderBlock;
import multichain.object.Block;
import multichain.object.formatters.BlockFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 4.8
 */
public class BlockCommand extends QueryBuilderBlock {

	public BlockCommand(String ip, String port, String login, String password) {
		initialize(ip, port, login, password);
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
		String stringBestBlockHash = "";

		Object objectBestBlockHash = executeGetBestBlockHash();
		if (verifyInstance(objectBestBlockHash, String.class)) {
			stringBestBlockHash = (String) objectBestBlockHash;
		}

		return stringBestBlockHash;
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
	 * @param hash
	 * @param verbose
	 * @return Block : information about the block with hash (retrievable from getblockhash) or at the given height in
	 *         the active chain
	 * @throws MultichainException
	 */
	public Block getBlock(String blockHash, boolean verbose) throws MultichainException {
		Object objectBlock = executeGetBlock(blockHash, verbose);
		Block block = BlockFormatter.formatBlock(objectBlock);

		return block;
	}

        /****
         * added by leo
         * @param blockidentifiers
         * @param verbose
         * @return List<Block>
         */
        public List<Block> listBlocksList(String blockidentifiers,boolean verbose){
            try {
                List<Block> blocks=new ArrayList<Block>();
                Object objectBlock=executeListBlocks(blockidentifiers,verbose);
                int size=((ArrayList)objectBlock).size();
                for(int a=0;a<size;a++){
                    blocks.add(BlockFormatter.formatBlock(((ArrayList)objectBlock).get(a)));
                }
                return blocks;
            } catch (MultichainException ex) {
                Logger.getLogger(BlockCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
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
		return getBlock(blockHash, true);
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
	 * @param height
	 * @param verbose
	 * @return Block : information about the block with hash (retrievable from getblockhash) or at the given height in
	 *         the active chain
	 * @throws MultichainException
	 */
	public Block getBlock(int blockHeight, boolean verbose) throws MultichainException {
		Object objectBlock = executeGetBlock(blockHeight, verbose);
		Block block = BlockFormatter.formatBlock(objectBlock);

		return block;
	}

	/**
	 * {@link #getBlock(long, boolean)} without verbose
	 * 
	 * @param blockHash
	 * @return Block : information about the block with hash (retrievable from getblockhash) or at the given height in
	 *         the active chain
	 * @throws MultichainException
	 */
	public Block getBlock(int blockHeight) throws MultichainException {
		return getBlock(blockHeight, true);
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
		long stringBlockCount = 0;

		Object objectBlockCount = executeGetBlockCount();
		if (verifyInstance(objectBlockCount, long.class)) {
			stringBlockCount = (long) objectBlockCount;
		} else if (verifyInstance(objectBlockCount, Double.class)) {
			stringBlockCount = ((Double)objectBlockCount).longValue();
		}

		return stringBlockCount;
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
		String stringBlockHash = "";

		Object objectBlockHash = executeGetBlockHash(index);
		if (verifyInstance(objectBlockHash, String.class)) {
			stringBlockHash = (String) objectBlockHash;
		}

		return stringBlockHash;
	}

}
