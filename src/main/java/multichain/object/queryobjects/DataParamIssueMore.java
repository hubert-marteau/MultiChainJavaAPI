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
public class DataParamIssueMore implements DataParam {
  // "update" : asset-identifier (string,required) Asset identifier - one of the following: asset
  // txid, asset reference, asset name.
  // "details" : (object, optional) a json object with custom fields
  // {
  // "param-name": "param-value" (strings, required) The key is the parameter name, the value is
  // parameter value
  // ,...
  // }

  private String update = null;
  private Map<String, String> details = null;

  @Override
  public DataParamIssueMore getFormatedvalue() {
    return this;
  }

  /**
   * 
   */
  public DataParamIssueMore() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param update
   * @param details
   */
  public DataParamIssueMore(String update, Map<String, String> details) {
    this.update = update;
    this.details = details;
  }

  /**
   * @return the update
   */
  public String getUpdate() {
    return update;
  }

  /**
   * @param update the update to set
   */
  public void setUpdate(String update) {
    this.update = update;
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


}
