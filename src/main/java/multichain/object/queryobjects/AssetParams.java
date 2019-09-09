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
public class AssetParams {
  String name;
  boolean open;

  /**
   * @param name
   * @param open
   */
  public AssetParams(String name, boolean open) {
    super();
    this.name = name;
    this.open = open;
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
  public boolean isOpen() {
    return open;
  }

  /**
   * @param open the open to set
   */
  public void setOpen(boolean open) {
    this.open = open;
  }

}
