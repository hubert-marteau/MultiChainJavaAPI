/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.1
 */
public class BalanceAssetGeneral {
  String name = null;
  String assetref = null;
  Double qty = null;

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "BalanceAssetGeneral [name=" + name + ", assetref=" + assetref + ", qty=" + qty + "]";
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
   * @return the assetref
   */
  public String getAssetref() {
    return assetref;
  }

  /**
   * @param assetref the assetref to set
   */
  public void setAssetref(String assetref) {
    this.assetref = assetref;
  }

  /**
   * @return the qty
   */
  public double getQty() {
    return qty;
  }

  /**
   * @param qty the qty to set
   */
  public void setQty(double qty) {
    this.qty = qty;
  }

}
