/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.test.object.formatters;

import multichain.object.Transaction;
import multichain.object.formatters.TransactionFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class TransactionFormatterTest {

	/**
	 *
	 */
	public TransactionFormatterTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testformatTransaction() {
		String jsonTransaction  = "{"
				+ "\"amount\" : 0.00000000,"
				+ "\"fee\" : 0.00000000,"
				+ "\"confirmations\" : 1901,"
				+ "\"blockhash\" : \"00000001c18c61dd590f8a5921cf24df39a1dd5207a731de8fc1584fce0006d0\","
				+ "\"blockindex\" : 1,"
				+ "\"blocktime\" : 1481641995,"
				+ "\"txid\" : \"69773ce91da4af37d358d660db9a9edde8885704c73e7d818be426612ec4da3c\","
				+ "\"walletconflicts\" : ["
				+ "],"
				+ "\"time\" : 1481641992,"
				+ "\"timereceived\" : 1481641992,"
				+ "\"details\" : ["
				+ "{"
				+ "\"account\" : \"\","
				+ "\"address\" : \"address2aBcDeFgH123IjKlMnOp456\","
				+ "\"category\" : \"send\","
				+ "\"amount\" : 0.00000000,"
				+ "\"vout\" : 0,"
				+ "\"fee\" : 0.00000000"
				+ "},"
				+ "{"
				+ "\"account\" : \"\","
				+ "\"address\" : \"address1aBcDeFgH123IjKlMnOp456\","
				+ "\"category\" : \"send\","
				+ "\"amount\" : 0.00000000,"
				+ "\"vout\" : 2,"
				+ "\"fee\" : 0.00000000"
				+ "},"
				+ "{"
				+ "\"account\" : \"Account1\","
				+ "\"address\" : \"address2aBcDeFgH123IjKlMnOp456\","
				+ "\"category\" : \"receive\","
				+ "\"amount\" : 1.23456789,"
				+ "\"vout\" : 0"
				+ "},"
				+ "{"
				+ "\"account\" : \"\","
				+ "\"address\" : \"address1aBcDeFgH123IjKlMnOp456\","
				+ "\"category\" : \"receive\","
				+ "\"amount\" : 0.00000000,"
				+ "\"vout\" : 2"
				+ "}"
				+ "],"
				+ "\"hex\" : \"verylonghex122333444455555666666777777788888888999999999azertyuiop\""
				+ "}";

		Transaction transaction = TransactionFormatter.formatTransaction(jsonTransaction);

		if (transaction.getAmount() != 0.0) { System.err.println("testformatTransaction - amount <> 0.0"); };
		if (transaction.getFee() != 0.0) { System.err.println("testformatTransaction - fee <> 0.0"); };
		if (transaction.getConfirmations() != 1901) { System.err.println("testformatTransaction - confirmations <> 1901"); };
		if (!"00000001c18c61dd590f8a5921cf24df39a1dd5207a731de8fc1584fce0006d0".equals(transaction.getBlockhash())) { System.err.println("testformatTransaction - blockhash <> 00000001c18c61dd590f8a5921cf24df39a1dd5207a731de8fc1584fce0006d0"); };
		if (transaction.getBlockindex() != 1) { System.err.println("testformatTransaction - blockindex <> 1"); };
		if (transaction.getBlocktime() != 1481641995L) { System.err.println("testformatTransaction - blocktime <> 1481641995"); };
		if (!"69773ce91da4af37d358d660db9a9edde8885704c73e7d818be426612ec4da3c".equals(transaction.getTxid())) { System.err.println("testformatTransaction - txid <> 69773ce91da4af37d358d660db9a9edde8885704c73e7d818be426612ec4da3c"); };

		if (transaction.getWalletconflicts().size() != 0) { System.err.println("testformatTransactionRAW - walletconflicts list size <> 0"); };

		if (transaction.getTime() != 1481641992L) { System.err.println("testformatTransaction - time <> 1481641992"); };
		if (transaction.getTimereceived() != 1481641992L) { System.err.println("testformatTransaction - timereceived <> 1481641992"); };

		if (transaction.getDetails().size() != 4) { System.err.println("testformatTransactionRAW - details list size <> 4"); };

		if (!"".equals(transaction.getDetails().get(0).getAccount())) { System.err.println("testformatTransaction - detail[0].account <> \"\""); };
		if (!"address2aBcDeFgH123IjKlMnOp456".equals(transaction.getDetails().get(0).getAddress())) { System.err.println("testformatTransaction - detail[0].address <> address2aBcDeFgH123IjKlMnOp456"); };
		if (!"send".equals(transaction.getDetails().get(0).getCategory())) { System.err.println("testformatTransaction - detail[0].category <> send"); };
		if (transaction.getDetails().get(0).getAmount() != 0.0) { System.err.println("testformatTransaction - detail[0].amount <> 0.0"); };
		if (transaction.getDetails().get(0).getVout() != 0) { System.err.println("testformatTransaction - detail[0].vout <> 0"); };
		if (transaction.getDetails().get(0).getFee() != 0.0) { System.err.println("testformatTransaction - detail[0].fee <> 0.0"); };

		if (!"".equals(transaction.getDetails().get(1).getAccount())) { System.err.println("testformatTransaction - detail[1].account <> \"\""); };
		if (!"address1aBcDeFgH123IjKlMnOp456".equals(transaction.getDetails().get(1).getAddress())) { System.err.println("testformatTransaction - detail[1].address <> address1aBcDeFgH123IjKlMnOp456"); };
		if (!"send".equals(transaction.getDetails().get(1).getCategory())) { System.err.println("testformatTransaction - detail[1].category <> send"); };
		if (transaction.getDetails().get(1).getAmount() != 0.0) { System.err.println("testformatTransaction - detail[1].amount <> 0.0"); };
		if (transaction.getDetails().get(1).getVout() != 2) { System.err.println("testformatTransaction - detail[1].vout <> 2"); };
		if (transaction.getDetails().get(1).getFee() != 0.0) { System.err.println("testformatTransaction - detail[1].fee <> 0.0"); };

		if (!"Account1".equals(transaction.getDetails().get(2).getAccount())) { System.err.println("testformatTransaction - detail[2].account <> Account1"); };
		if (!"address2aBcDeFgH123IjKlMnOp456".equals(transaction.getDetails().get(2).getAddress())) { System.err.println("testformatTransaction - detail[2].address <> address2aBcDeFgH123IjKlMnOp456"); };
		if (!"receive".equals(transaction.getDetails().get(2).getCategory())) { System.err.println("testformatTransaction - detail[2].category <> receive"); };
		if (transaction.getDetails().get(2).getAmount() != 1.23456789) { System.err.println("testformatTransaction - detail[2].amount <> 1.23456789"); };
		if (transaction.getDetails().get(2).getVout() != 0) { System.err.println("testformatTransaction - detail[2].vout <> 0"); };

		if (!"".equals(transaction.getDetails().get(3).getAccount())) { System.err.println("testformatTransaction - detail[3].account <> \"\""); };
		if (!"address1aBcDeFgH123IjKlMnOp456".equals(transaction.getDetails().get(3).getAddress())) { System.err.println("testformatTransaction - detail[3].address <> address1aBcDeFgH123IjKlMnOp456"); };
		if (!"receive".equals(transaction.getDetails().get(3).getCategory())) { System.err.println("testformatTransaction - detail[3].category <> receive"); };
		if (transaction.getDetails().get(3).getAmount() != 0.0) { System.err.println("testformatTransaction - detail[3].amount <> 0.0"); };
		if (transaction.getDetails().get(3).getVout() != 2) { System.err.println("testformatTransaction - detail[3].vout <> 2"); };

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of TransactionFormatterTest ---");

		testformatTransaction();

		System.out.println("--- End of TransactionFormatterTest ---");
	}

}
