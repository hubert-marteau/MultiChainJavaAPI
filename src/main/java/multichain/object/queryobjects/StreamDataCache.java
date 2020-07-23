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
public class StreamDataCache extends StreamData {
  private String cache;

  /**
   * 
   */
  public StreamDataCache() {
    super();
  }

  /**
   * @param text
   */
  public StreamDataCache(String cache) {
    super();
    this.cache = cache;
  }

  /**
   * @param jsonObject
   */
  public StreamDataCache(LinkedTreeMap<?, ?> jsonObject) {
    this(((StreamDataCache) GenericOutputFormatter.format(jsonObject, StreamDataCache.class))
        .getCache());
  }

  /**
   * @param jsonObject
   */
  public StreamDataCache(Object jsonObject) {
    this(((StreamDataCache) GenericOutputFormatter.format((LinkedTreeMap<?, ?>) jsonObject,
        StreamDataCache.class)).getCache());
  }


  @Override
  public JsonObject getPublicationValue() {
    return getJsonValue(this);
  }

  /**
   * @return the cache
   */
  public String getCache() {
    return cache;
  }

  /**
   * @param cache the cache to set
   */
  public void setCache(String cache) {
    this.cache = cache;
  }

}
