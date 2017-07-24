/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import java.lang.reflect.Type;
import java.util.List;

import multichain.object.StreamKeyItem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author Ub - H. MARTEAU
 * @version 1.1
 */
public class StreamFormatter {
	public final static List<StreamKeyItem> formatStreamKeyItem(String stringStreamKeyItem) {
		final Gson gson = new GsonBuilder().create();

		Type listType = new TypeToken<List<StreamKeyItem>>() {
		}.getType();
		final List<StreamKeyItem> listStreamKeyItem = gson.fromJson(stringStreamKeyItem, listType);

		return listStreamKeyItem;
	}
}
