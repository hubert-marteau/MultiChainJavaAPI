/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.queryobjects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.2
 */
public abstract class StreamData {
  public abstract JsonObject getPublicationValue();

  protected JsonObject getJsonValue(Object object) {
    final GsonBuilder builder = new GsonBuilder();
    final Gson gson = builder.create();

    JsonElement jsonElement = gson.toJsonTree(object);
    JsonObject jsonObject = (JsonObject) jsonElement;
    // property removal
    jsonObject.remove("property");

    return jsonObject;
  }


}
