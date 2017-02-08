/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import multichain.object.Block;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class BlockFormatter {
	public final static long formatBlockCount(String stringBlockCount) {
		final Gson gson = new GsonBuilder().create();

		final Long blockCount = gson.fromJson(stringBlockCount, Long.class);

		return blockCount.longValue();
	}

	public final static Block formatBlock(String stringBlock) {
		final Gson gson = new GsonBuilder().create();

		final Block block = gson.fromJson(stringBlock, Block.class);

		return block;
	}

}
