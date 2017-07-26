/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import java.util.ArrayList;
import java.util.List;

import multichain.object.StreamKeyItem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

/**
 * @author Ub - H. MARTEAU
 * @version 3.0
 */
public class StreamFormatter {
	public final static StreamKeyItem formatStreamKeyItem(Object objectStreamKeyItem) {
		StreamKeyItem streamKeyItem = new StreamKeyItem();

		if (objectStreamKeyItem != null && LinkedTreeMap.class.isInstance(objectStreamKeyItem)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectStreamKeyItem);
			streamKeyItem = gson.fromJson(jsonValue, StreamKeyItem.class);
		}

		return streamKeyItem;
	}

	public final static List<StreamKeyItem> formatStreamKeyItems(List<Object> objectStreamKeyItems) {
		List<StreamKeyItem> streamKeyItems = new ArrayList<StreamKeyItem>();

		if (objectStreamKeyItems != null) {
			for (Object objectStreamKeyItem : objectStreamKeyItems) {
				streamKeyItems.add(formatStreamKeyItem(objectStreamKeyItem));
			}
		}

		return streamKeyItems;
	}
}
