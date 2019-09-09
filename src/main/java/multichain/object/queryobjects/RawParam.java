/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.queryobjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import multichain.object.formatters.GsonFormatters;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.1
 */
public class RawParam extends GsonFormatters {
  String address;
  float amount = -1;
  List<AssetQuantity> assets;

  /**
   * @param address
   * @param amount
   * @param assets
   */
  public RawParam(String address, float amount) {
    super();
    this.address = address;
    this.amount = amount;
  }

  /**
   * @param address
   * @param amount
   * @param assets
   */
  public RawParam(String address, List<AssetQuantity> assets) {
    super();
    this.address = address;
    this.assets = assets;
  }

  public boolean isFilled() {
    if (address == null || "".equals(address)) {
      return false;
    }
    if (amount >= 0) {
      return true;
    } else {
      if (assets == null || assets.size() == 0) {
        return false;
      }
      boolean assetReturn = false;
      for (AssetQuantity asset : assets) {
        assetReturn = assetReturn || asset.isFilled();
      }
    }

    return true;
  }

  public Object getValue() {
    Map<String, Float> filledAssets = new HashMap<String, Float>();
    if (assets != null && assets.size() != 0) {
      for (AssetQuantity asset : assets) {
        if (asset.isFilled()) {
          filledAssets.put(asset.getName(), new Float(asset.getQuantity()));
        }
      }
    }
    if (filledAssets.size() > 0) {
      return filledAssets;
    } else {
      return amount;
    }
  }

  /**
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return the amount
   */
  public float getAmount() {
    return amount;
  }

  /**
   * @param amount the amount to set
   */
  public void setAmount(float amount) {
    this.amount = amount;
  }

  /**
   * @return the assets
   */
  public List<AssetQuantity> getAssets() {
    return assets;
  }

  /**
   * @param assets the assets to set
   */
  public void setAssets(List<AssetQuantity> assets) {
    this.assets = assets;
  }

}
