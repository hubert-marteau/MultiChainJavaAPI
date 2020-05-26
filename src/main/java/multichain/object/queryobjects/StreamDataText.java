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
public class StreamDataText extends StreamData {
  private String text;

  /**
   * 
   */
  public StreamDataText() {
    super();
  }

  /**
   * @param text
   */
  public StreamDataText(String text) {
    super();
    this.text = text;
  }

  /**
   * @param jsonObject
   */
  public StreamDataText(LinkedTreeMap<?, ?> jsonObject) {
    this(((StreamDataText) GenericOutputFormatter.format(jsonObject, StreamDataText.class))
        .getText());
  }

  /**
   * @param jsonObject
   */
  public StreamDataText(Object jsonObject) {
    this(((StreamDataText) GenericOutputFormatter.format((LinkedTreeMap<?, ?>) jsonObject,
        StreamDataText.class)).getText());
  }

  /**
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * @param text the text to set
   */
  public void setText(String text) {
    this.text = text;
  }

  @Override
  public JsonObject getPublicationValue() {
    return getJsonValue(this);
  }

}
