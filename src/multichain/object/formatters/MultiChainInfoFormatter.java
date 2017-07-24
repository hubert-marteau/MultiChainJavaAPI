/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import multichain.object.MultiChainInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class MultiChainInfoFormatter {

	public final static MultiChainInfo formatMultiChainInfo(
			String stringMultiChainInfo) {
		final Gson gson = new GsonBuilder().create();
		final MultiChainInfo multiChainInfo = gson.fromJson(
				stringMultiChainInfo, MultiChainInfo.class);

		return multiChainInfo;
	}

}
