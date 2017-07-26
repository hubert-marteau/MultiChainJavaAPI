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
import com.google.gson.internal.LinkedTreeMap;

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

	public final static Block formatBlock(Object objectBlock) {
		Block block = new Block();

		if (objectBlock != null && LinkedTreeMap.class.isInstance(objectBlock)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectBlock);
			block = gson.fromJson(jsonValue, Block.class);
		}

		return block;
	}

}
