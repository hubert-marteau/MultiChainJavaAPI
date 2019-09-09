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
public class DataParamCreate implements DataParam {
  // "create" : stream (string,required) stream
  // "name" : stream-name (string,optional) Stream name
  // "open" : true|false (string,optional, default: false) If true, anyone can publish
  // "details" : (object,optional) a json object with custom fields
  // {
  // "param-name": "param-value" (strings, required) The key is the parameter name, the value is
  // parameter value
  // ,...
  // }

  private String create = "stream";
  private String name = null;
  private Boolean open = null;
  private Map<String, String> details = null;

  @Override
  public DataParamCreate getFormatedvalue() {
    return this;
  }

  /**
   * 
   */
  public DataParamCreate() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param create
   * @param name
   * @param open
   * @param details
   */
  public DataParamCreate(String create, String name, Boolean open, Map<String, String> details) {
    this.create = create;
    this.name = name;
    this.open = open;
    this.details = details;
  }

  /**
   * @return the create
   */
  public String getCreate() {
    return create;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the open
   */
  public Boolean getOpen() {
    return open;
  }

  /**
   * @param open the open to set
   */
  public void setOpen(Boolean open) {
    this.open = open;
  }

  /**
   * @return the details
   */
  public Map<String, String> getDetails() {
    return details;
  }

  /**
   * @param details the details to set
   */
  public void setDetails(Map<String, String> details) {
    this.details = details;
  }

  /**
   * @param details the details to set
   */
  public void addDetails(CustomParamString detail) {
    if (details == null) {
      details = new HashMap<>();
    }
    details.put(detail.getName(), detail.getValue());
  }



}
