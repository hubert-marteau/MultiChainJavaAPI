/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.test.object.formatters;

import multichain.object.Block;
import multichain.object.formatters.BlockFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class BlockFormatterTest {

	/**
	 *
	 */
	public BlockFormatterTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testformatBlockCount() {
		String jsonBlockCount = "6227";

		long blockCount = BlockFormatter.formatBlockCount(jsonBlockCount);

		if (blockCount != 6227) { System.err.println("testformatBlockCount - blockCount <> 6227"); };
	}


	private static void testformatBlock() {
		String jsonBlock = "{"
				+ "\"hash\" : \"00006f5cdb572a1261f5c2964357f67e2f6bc526c4ebc95a57486cd1ff818429\","
				+ "\"miner\" : \"MyMinerAddress123456789\","
				+ "\"confirmations\" : 9999,"
				+ "\"size\" : 999,"
				+ "\"height\" : 99,"
				+ "\"version\" : 9,"
				+ "\"merkleroot\" : \"fbb6cd7a6b21082e2a67539df2e39ec8bdb270102e4f5f8f50ab1bb2ffdd9fb0\","
				+ "\"tx\" : ["
				+ "\"fbb6cd7a6b21082e2a67539df2e39ec8bdb270102e4f5f8f50ab1bb2ffdd9fb0\""
				+ "],"
				+ "\"time\" : 1473067437,"
				+ "\"nonce\" : 14252,"
				+ "\"bits\" : \"1f00ffff\","
				+ "\"difficulty\" : 0.00001526,"
				+ "\"chainwork\" : \"00000000000000000000000000000000000000000000000000000000000b000b\","
				+ "\"previousblockhash\" : \"00000b0a2c5fb9d449c6cb8489cdce8b4cae667cb868b37764a4962a93945814\","
				+ "\"nextblockhash\" : \"00009c43b734e61a18c82e2a288f8f71ab64f91b9888cd34c8edbe0495be3136\""
				+ "}";

		Block block = BlockFormatter.formatBlock(jsonBlock);

		if (!"00006f5cdb572a1261f5c2964357f67e2f6bc526c4ebc95a57486cd1ff818429".equals(block.getHash())) { System.err.println("testformatBlock - hash <> 00006f5cdb572a1261f5c2964357f67e2f6bc526c4ebc95a57486cd1ff818429"); };
		if (!"MyMinerAddress123456789".equals(block.getMiner())) { System.err.println("testformatBlock - miner <> 00006f5cdb572a1261f5c2964357f67e2f6bc526c4ebc95a57486cd1ff818429"); };
		if (block.getConfirmations() != 9999) { System.err.println("testformatBlock - confirmations <> 9999"); };
		if (block.getSize() != 999) { System.err.println("testformatBlock - size <> 999"); };
		if (block.getHeight() != 99) { System.err.println("testformatBlock - height <> 99"); };
		if (block.getVersion() != 9) { System.err.println("testformatBlock - version <> 9"); };
		if (!"fbb6cd7a6b21082e2a67539df2e39ec8bdb270102e4f5f8f50ab1bb2ffdd9fb0".equals(block.getMerkleroot())) { System.err.println("testformatBlock - merkleroot <> fbb6cd7a6b21082e2a67539df2e39ec8bdb270102e4f5f8f50ab1bb2ffdd9fb0"); };

		if (block.getTx().size() != 1) { System.err.println("testformatBlock - Tx list size <> 1"); };
		if (!"fbb6cd7a6b21082e2a67539df2e39ec8bdb270102e4f5f8f50ab1bb2ffdd9fb0".equals(block.getTx().get(0))) { System.err.println("testformatBlock - Tx[0] <> fbb6cd7a6b21082e2a67539df2e39ec8bdb270102e4f5f8f50ab1bb2ffdd9fb0"); };

		if (block.getTime() != 1473067437) { System.err.println("testformatBlock - time <> 1473067437"); };
		if (block.getNonce() != 14252) { System.err.println("testformatBlock - nonce <> 14252"); };
		if (!"1f00ffff".equals(block.getBits())) { System.err.println("testformatBlock - bits <> 1f00ffff"); };
		if (block.getDifficulty() != 0.00001526) { System.err.println("testformatBlock - difficulty <> 0.00001526"); };
		if (!"00000000000000000000000000000000000000000000000000000000000b000b".equals(block.getChainwork())) { System.err.println("testformatBlock - chainwork <> 00000000000000000000000000000000000000000000000000000000000b000b"); };
		if (!"00000b0a2c5fb9d449c6cb8489cdce8b4cae667cb868b37764a4962a93945814".equals(block.getPreviousblockhash())) { System.err.println("testformatBlock - previousblockhash <> 00000b0a2c5fb9d449c6cb8489cdce8b4cae667cb868b37764a4962a93945814"); };
		if (!"00009c43b734e61a18c82e2a288f8f71ab64f91b9888cd34c8edbe0495be3136".equals(block.getNextblockhash())) { System.err.println("testformatBlock - nextblockhash <> 00009c43b734e61a18c82e2a288f8f71ab64f91b9888cd34c8edbe0495be3136"); };
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of BlockFormatterTest ---");

		testformatBlockCount();
		testformatBlock();

		System.out.println("--- End of BlockFormatterTest ---");
	}

}
