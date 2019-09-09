/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

import java.util.List;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.1
 */
public enum GrantElt {
  CONNECT("connect"),
  SEND("send"),
  RECEIVE("receive"),
  ISSUE("issue"),
  MINE("mine"),
  ACTIVATE("activate"),
  ADMIN("admin"),
  CREATE("create");

  String grant = null;

  private GrantElt(String grant) {
    this.grant = grant;
  }

  public static String grantElements(List<GrantElt> grantelements) {
    StringBuilder value = new StringBuilder("");

    if (!grantelements.isEmpty()) {
      value.append(grantelements.get(0).getGrant());
      for (int i = 1; i < grantelements.size(); i++) {
        value.append(",");
        value.append(grantelements.get(i).getGrant());
      }
    }

    return value.toString();
  }

  /**
   * @return the grant
   */
  public String getGrant() {
    return grant;
  }

  /**
   * @param grant the grant to set
   */
  public void setGrant(String grant) {
    this.grant = grant;
  }

}
