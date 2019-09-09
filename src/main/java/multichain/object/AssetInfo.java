/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

import java.util.List;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.1
 */
public class AssetInfo extends BalanceAsset {
  List<AssetIssues> issues = null;

  /**
   * @return the issues
   */
  public List<AssetIssues> getIssues() {
    return issues;
  }

  /**
   * @param issues the issues to set
   */
  public void setIssues(List<AssetIssues> issues) {
    this.issues = issues;
  }

}
