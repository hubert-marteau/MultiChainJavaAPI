/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.queryobjects;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.1
 */
public class DataParamHex implements DataParam {
  private String hexValue = null;

  @Override
  public String getFormatedvalue() {
    return getHexValue();
  }

  /**
   * 
   */
  public DataParamHex() {
    super();
  }

  /**
   * @param hexValue
   */
  public DataParamHex(String hexValue) {
    this.hexValue = hexValue;
  }

  /**
   * @return the hexValue
   */
  public String getHexValue() {
    return hexValue;
  }

  /**
   * @param hexValue the hexValue to set
   */
  public void setHexValue(String hexValue) {
    this.hexValue = hexValue;
  }


}
