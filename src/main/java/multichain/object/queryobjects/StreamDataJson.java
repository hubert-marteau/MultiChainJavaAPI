/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.queryobjects;

import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import multichain.object.formatters.GenericOutputFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.2
 */
public class StreamDataJson extends StreamData {
  private JsonObject json;

  /**
   * 
   */
  public StreamDataJson() {
    super();
  }

  /**
   * @param text
   */
  public StreamDataJson(JsonObject json) {
    super();
    this.json = json;
  }

  /**
   * @param jsonObject
   */
  public StreamDataJson(LinkedTreeMap<?, ?> jsonObject) {
    this(((StreamDataJson) GenericOutputFormatter.format(jsonObject, StreamDataJson.class))
        .getJson());
  }

  /**
   * @param jsonObject
   */
  public StreamDataJson(Object jsonObject) {
    this(((StreamDataJson) GenericOutputFormatter.format((LinkedTreeMap<?, ?>) jsonObject,
        StreamDataJson.class)).getJson());
  }



  @Override
  public JsonObject getPublicationValue() {
    return getJsonValue(this);
  }

  /**
   * @return the json
   */
  public JsonObject getJson() {
    return json;
  }

  /**
   * @param json the json to set
   */
  public void setJson(JsonObject json) {
    this.json = json;
  }

}
