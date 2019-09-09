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
public class SinceBlock {
  List<TransactionCurrency> transactions = null;
  String lastblock = null;

  /**
   * @return the transactions
   */
  public List<TransactionCurrency> getTransactions() {
    return transactions;
  }

  /**
   * @param transactions the transactions to set
   */
  public void setTransactions(List<TransactionCurrency> transactions) {
    this.transactions = transactions;
  }

  /**
   * @return the lastblock
   */
  public String getLastblock() {
    return lastblock;
  }

  /**
   * @param lastblock the lastblock to set
   */
  public void setLastblock(String lastblock) {
    this.lastblock = lastblock;
  }


}
