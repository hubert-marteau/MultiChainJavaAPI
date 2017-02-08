/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.test.object.formatters;

import java.util.List;

import multichain.object.BalanceAsset;
import multichain.object.MultiBalance;
import multichain.object.formatters.BalanceFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class BalanceFormatterTest {

	/**
	 *
	 */
	public BalanceFormatterTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testformatBalanceAsset() {
		String jsonBalanceAsset = "{"
				+ "\"name\" : \"Asset1\","
				+ "\"assetref\" : \"5572-266-20618\","
				+ "\"qty\" : 1.00000000"
				+ "}";

		BalanceAsset balanceAsset = BalanceFormatter.formatBalanceAsset(jsonBalanceAsset);

		if (!"Asset1".equals(balanceAsset.getName())) { System.err.println("testformatBalanceAsset - name <> Asset1"); };
		if (!"5572-266-20618".equals(balanceAsset.getAssetref())) { System.err.println("testformatBalanceAsset - assetref <> 5572-266-20618"); };
		if (balanceAsset.getQty() != 1) { System.err.println("testformatBalanceAsset - qty <> 1"); };
	}


	private static void testformatBalanceAssets() {
		String jsonBalanceAsset = "["
				+ "{"
				+ "\"name\" : \"Asset2\","
				+ "\"assetref\" : \"5572-532-23163\","
				+ "\"qty\" : 2.00000000"
				+ "},"
				+ "{"
				+ "\"name\" : \"Asset1\","
				+ "\"assetref\" : \"5572-266-20618\","
				+ "\"qty\" : 1.00000000"
				+ "}"
				+ "]";

		List<BalanceAsset> balanceAssets = BalanceFormatter.formatBalanceAssets(jsonBalanceAsset);

		if (balanceAssets.size() != 2) { System.err.println("testformatBalanceAsset - result list size <> 2"); };

		if (!"Asset2".equals(balanceAssets.get(0).getName())) { System.err.println("testformatBalanceAsset - balanceAssets[0].name <> Asset2"); };
		if (!"5572-532-23163".equals(balanceAssets.get(0).getAssetref())) { System.err.println("testformatBalanceAsset - balanceAssets[0].assetref <> 5572-532-23163"); };
		if (balanceAssets.get(0).getQty() != 2) { System.err.println("testformatBalanceAsset - balanceAssets[0].qty <> 2"); };

		if (!"Asset1".equals(balanceAssets.get(1).getName())) { System.err.println("testformatBalanceAsset - balanceAssets[1].name <> Asset1"); };
		if (!"5572-266-20618".equals(balanceAssets.get(1).getAssetref())) { System.err.println("testformatBalanceAsset - balanceAssets[1].assetref <> 5572-266-20618"); };
		if (balanceAssets.get(1).getQty() != 1) { System.err.println("testformatBalanceAsset - balanceAssets[1].qty <> 1"); };
	}

	private static void testformatMultiBalances() {
		String jsonMultiBalance = "{"
				+ "\"address1aBcDeFgH123IjKlMnOp456\" : ["
				+ "{"
				+ "\"name\" : \"Asset2\","
				+ "\"assetref\" : \"5572-532-23163\","
				+ "\"qty\" : 2.00000000"
				+ "}"
				+ "],"
				+ "\"address2aBcDeFgH123IjKlMnOp456\" : ["
				+ "{"
				+ "\"name\" : \"Asset1\","
				+ "\"assetref\" : \"5572-266-20618\","
				+ "\"qty\" : 1.00000000"
				+ "}"
				+ "],"
				+ "\"total\" : ["
				+ "{"
				+ "\"name\" : \"Asset2\","
				+ "\"assetref\" : \"5572-532-23163\","
				+ "\"qty\" : 2.00000000"
				+ "},"
				+ "{"
				+ "\"name\" : \"Asset1\","
				+ "\"assetref\" : \"5572-266-20618\","
				+ "\"qty\" : 1.00000000"
				+ "}"
				+ "]"
				+ "}";


		List<MultiBalance> multiBalance = BalanceFormatter.formatMultiBalances(jsonMultiBalance);

		if (multiBalance.size() != 3) { System.err.println("testformatMultiBalances - result list size <> 2"); };

		if (!"total".equals(multiBalance.get(0).getLabel())) { System.err.println("testformatMultiBalances - multiBalance[0].label <> total"); };
		if (!"Asset2".equals(multiBalance.get(0).getAssets().get(0).getName())) { System.err.println("testformatBalanceAsset - balanceAssets[0].name <> Asset2"); };
		if (!"5572-532-23163".equals(multiBalance.get(0).getAssets().get(0).getAssetref())) { System.err.println("testformatBalanceAsset - balanceAssets[0].assetref <> 5572-532-23163"); };
		if (multiBalance.get(0).getAssets().get(0).getQty() != 2) { System.err.println("testformatBalanceAsset - balanceAssets[0].qty <> 2"); };

		if (!"Asset1".equals(multiBalance.get(0).getAssets().get(1).getName())) { System.err.println("testformatBalanceAsset - balanceAssets[1].name <> Asset1"); };
		if (!"5572-266-20618".equals(multiBalance.get(0).getAssets().get(1).getAssetref())) { System.err.println("testformatBalanceAsset - balanceAssets[1].assetref <> 5572-266-20618"); };
		if (multiBalance.get(0).getAssets().get(1).getQty() != 1) { System.err.println("testformatBalanceAsset - balanceAssets[1].qty <> 1"); };



		if (!"address2aBcDeFgH123IjKlMnOp456".equals(multiBalance.get(1).getLabel())) { System.err.println("testformatMultiBalances - multiBalance[1].label <> total"); };

		if (!"Asset1".equals(multiBalance.get(1).getAssets().get(0).getName())) { System.err.println("testformatBalanceAsset - balanceAssets[1].name <> Asset1"); };
		if (!"5572-266-20618".equals(multiBalance.get(1).getAssets().get(0).getAssetref())) { System.err.println("testformatBalanceAsset - balanceAssets[1].assetref <> 5572-266-20618"); };
		if (multiBalance.get(1).getAssets().get(0).getQty() != 1) { System.err.println("testformatBalanceAsset - balanceAssets[1].qty <> 1"); };



		if (!"address1aBcDeFgH123IjKlMnOp456".equals(multiBalance.get(2).getLabel())) { System.err.println("testformatMultiBalances - multiBalance[2].label <> total"); };

		if (!"Asset2".equals(multiBalance.get(2).getAssets().get(0).getName())) { System.err.println("testformatBalanceAsset - balanceAssets[0].name <> Asset2"); };
		if (!"5572-532-23163".equals(multiBalance.get(2).getAssets().get(0).getAssetref())) { System.err.println("testformatBalanceAsset - balanceAssets[0].assetref <> 5572-532-23163"); };
		if (multiBalance.get(2).getAssets().get(0).getQty() != 2) { System.err.println("testformatBalanceAsset - balanceAssets[0].qty <> 2"); };


	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of BalanceFormatterTest ---");

		testformatBalanceAsset();
		testformatBalanceAssets();
		testformatMultiBalances();

		System.out.println("--- End of BalanceFormatterTest ---");
	}

}

