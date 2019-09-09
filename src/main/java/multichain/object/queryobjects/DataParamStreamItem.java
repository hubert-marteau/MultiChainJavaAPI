/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.queryobjects;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.1
 */
public class DataParamStreamItem implements DataParam {
  // "for" : stream-identifier (string,required) Stream identifier - one of the following: stream
  // txid, stream reference, stream name.
  // "key" : key (string,optional, default: "") Item key
  // "data" : data-hex (string,optional, default: "") Data hex string

  private String for_;
  private String key;
  private String data;


  @Override
  public Map<String, String> getFormatedvalue() {
    Map<String, String> value = new HashMap<>();

    value.put("for", for_);
    value.put("key", key);
    value.put("data", data);

    return value;
  }

  /**
   * 
   */
  public DataParamStreamItem() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param for_
   * @param key
   * @param data
   */
  public DataParamStreamItem(String for_, String key, String data) {
    this.for_ = for_;
    this.key = key;
    this.data = data;
  }

  /**
   * @return the for_
   */
  public String getFor() {
    return for_;
  }

  /**
   * @param for_ the for_ to set
   */
  public void setFor(String for_) {
    this.for_ = for_;
  }

  /**
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * @param key the key to set
   */
  public void setKey(String key) {
    this.key = key;
  }

  /**
   * @return the data
   */
  public String getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(String data) {
    this.data = data;
  }



}
