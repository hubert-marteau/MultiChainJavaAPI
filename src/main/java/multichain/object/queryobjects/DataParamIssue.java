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
public class DataParamIssue implements DataParam {
  // "create" : asset (string,required) asset
  // "name" : asset-name (string,optional) Asset name
  // "multiple" : n (numeric,optional, default 1) Number of raw units in one displayed unit
  // "open" : true|false (boolean, optional, default false) True if follow-on issues are allowed
  // "details" : (object, optional) a json object with custom fields
  // {
  // "param-name": "param-value" (strings, required) The key is the parameter name, the value is
  // parameter value
  // ,...
  // }

  private String create = "asset";
  private String name = null;
  private Long multiple = null;
  private Boolean open = null;
  private Map<String, String> details = null;

  @Override
  public DataParamIssue getFormatedvalue() {
    return this;
  }

  /**
   * 
   */
  public DataParamIssue() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param name
   * @param multiple
   * @param open
   * @param details
   */
  public DataParamIssue(String name, Long multiple, Boolean open, Map<String, String> details) {
    this.name = name;
    this.multiple = multiple;
    this.open = open;
    this.details = details;
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
   * @return the multiple
   */
  public Long getMultiple() {
    return multiple;
  }

  /**
   * @param multiple the multiple to set
   */
  public void setMultiple(Long multiple) {
    this.multiple = multiple;
  }

  /**
   * @return the open
   */
  public Boolean isOpen() {
    return open;
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
  public void addDetails(CustomParamString detail) {
    if (details == null) {
      details = new HashMap<>();
    }
    details.put(detail.getName(), detail.getValue());
  }

  /**
   * @return the create
   */
  public String getCreate() {
    return create;
  }


}
