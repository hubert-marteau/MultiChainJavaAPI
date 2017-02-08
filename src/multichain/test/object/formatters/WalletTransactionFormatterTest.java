/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.test.object.formatters;

import java.util.List;

import multichain.object.TransactionWallet;
import multichain.object.TransactionWalletDetailed;
import multichain.object.formatters.WalletTransactionFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class WalletTransactionFormatterTest {

	/**
	 *
	 */
	public WalletTransactionFormatterTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testformatListTransactionWallet() {
		String jsonListTransactionWallet = "["
						+ "{"
						+ "\"balance\" : {"
						+ "\"amount\" : 1.23456789,"
						+ "\"assets\" : ["
						+ "{"
						+ "\"name\" : \"Asset2\","
						+ "\"assetref\" : \"5572-532-23163\","
						+ "\"qty\" : 2.00000000"
						+ "}"
						+ "]"
						+ "},"
						+ "\"myaddresses\" : ["
						+ "\"aBcDeFgH123IjKlMnOp456\""
						+ "],"
						+ "\"addresses\" : ["
						+ "\"aBcDeFgH123IjKlMnOp456\""
						+ "],"
						+ "\"permissions\" : ["
						+ "{"
						+ "\"connect\" : false,"
						+ "\"send\" : true,"
						+ "\"receive\" : true,"
						+ "\"issue\" : true,"
						+ "\"mine\" : false,"
						+ "\"admin\" : false,"
						+ "\"activate\" : false,"
						+ "\"startblock\" : 0,"
						+ "\"endblock\" : 4294967295,"
						+ "\"timestamp\" : 1481637649,"
						+ "\"addresses\" : ["
						+ "\"aBcDeFgH123IjKlMnOp456\""
						+ "]"
						+ "}"
						+ "],"
						+ "\"issue\" : {"
						+ "\"name\" : \"Asset1\","
						+ "\"assetref\" : \"5572-266-20618\","
						+ "\"multiple\" : 1,"
						+ "\"units\" : 1.00000000,"
						+ "\"open\" : false,"
						+ "\"details\" : {"
						+ "},"
						+ "\"qty\" : 1.00000000,"
						+ "\"raw\" : 1,"
						+ "\"addresses\" : ["
						+ "\"aBcDeFgH123IjKlMnOp456\""
						+ "]"
						+ "},"
						+ "\"data\" : ["
						+ "\"verylonghex122333444455555666666777777788888888999999999azertyuiop\""
						+ "],"
						+ "\"confirmations\" : -1,"
						+ "\"txid\" : \"ed0e84b1b150550606745557f29fd55f4554f534c0edbb60a948718f9ec5b717\","
						+ "\"time\" : 1480002218,"
						+ "\"timereceived\" : 1480002218"
						+ "}"
						+ "]";

		List<TransactionWallet> listTransactionWallet = WalletTransactionFormatter.formatListTransactionWallet(jsonListTransactionWallet);

		if (listTransactionWallet.size() != 1) { System.err.println("result list size <> 1"); };

		TransactionWallet transactionWallet = listTransactionWallet.get(0);

		if (transactionWallet.getBalance().getAmount() != 1.23456789) { System.err.println("testformatListTransactionWallet - balance - amount <> 1.23456789"); };
		if (transactionWallet.getBalance().getAssets().size() != 1) { System.err.println("testformatListTransactionWallet - balance - assets size <> 1"); };
		if (!"Asset2".equals(transactionWallet.getBalance().getAssets().get(0).getName())) { System.err.println("testformatListTransactionWallet - balance - assets[0] - name <> Asset2"); };
		if (!"5572-532-23163".equals(transactionWallet.getBalance().getAssets().get(0).getAssetref())) { System.err.println("testformatListTransactionWallet - balance - assets[0] - assetref <> 5572-532-23163"); };
		if (transactionWallet.getBalance().getAssets().get(0).getQty() != 2.0) { System.err.println("testformatListTransactionWallet - balance - assets[0] - qty <> 2.0"); };

		if (transactionWallet.getMyaddresses().size() != 1) { System.err.println("testformatListTransactionWallet - myaddresses size <> 1"); };
		if (!"aBcDeFgH123IjKlMnOp456".equals(transactionWallet.getMyaddresses().get(0))) { System.err.println("testformatListTransactionWallet - myaddresses[0] <> aBcDeFgH123IjKlMnOp456"); };

		if (transactionWallet.getAddresses().size() != 1) { System.err.println("testformatListTransactionWallet - addresses size <> 1"); };
		if (!"aBcDeFgH123IjKlMnOp456".equals(transactionWallet.getAddresses().get(0))) { System.err.println("testformatListTransactionWallet - addresses[0] <> aBcDeFgH123IjKlMnOp456"); };

		if (transactionWallet.getPermissions().size() != 1) { System.err.println("testformatListTransactionWallet - permissions size <> 1"); };
		if (transactionWallet.getPermissions().get(0).isConnect()) { System.err.println("testformatListTransactionWallet - permissions[0] - connect <> false"); };
		if (!transactionWallet.getPermissions().get(0).isSend()) { System.err.println("testformatListTransactionWallet - permissions[0] - send <> true"); };
		if (!transactionWallet.getPermissions().get(0).isReceive()) { System.err.println("testformatListTransactionWallet - permissions[0] - receive <> true"); };
		if (!transactionWallet.getPermissions().get(0).isIssue()) { System.err.println("testformatListTransactionWallet - permissions[0] - issue <> true"); };
		if (transactionWallet.getPermissions().get(0).isMine()) { System.err.println("testformatListTransactionWallet - permissions[0] - mine <> false"); };
		if (transactionWallet.getPermissions().get(0).isAdmin()) { System.err.println("testformatListTransactionWallet - permissions[0] - admin <> false"); };
		if (transactionWallet.getPermissions().get(0).isActivate()) { System.err.println("testformatListTransactionWallet - permissions[0] - activate <> false"); };
		if (transactionWallet.getPermissions().get(0).getStartblock() != 0) { System.err.println("testformatListTransactionWallet - permissions[0] - startblock <> 0"); };
		if (transactionWallet.getPermissions().get(0).getEndblock() != 4294967295L) { System.err.println("testformatListTransactionWallet - permissions[0] - endblock <> 4294967295"); };
		if (transactionWallet.getPermissions().get(0).getTimestamp() != 1481637649) { System.err.println("testformatListTransactionWallet - permissions[0] - timestamp <> 1481637649"); };
		if (transactionWallet.getPermissions().get(0).getAddresses().size() != 1) { System.err.println("testformatListTransactionWallet - permissions[0] - addresses size <> 1"); };
		if (!"aBcDeFgH123IjKlMnOp456".equals(transactionWallet.getPermissions().get(0).getAddresses().get(0))) { System.err.println("testformatListTransactionWallet - permissions[0] - addresses[0] <> aBcDeFgH123IjKlMnOp456"); };

		if (!"Asset1".equals(transactionWallet.getIssue().getName())) { System.err.println("testformatListTransactionWallet - issue - name <> Asset1"); };
		if (!"5572-266-20618".equals(transactionWallet.getIssue().getAssetref())) { System.err.println("testformatListTransactionWallet - issue - assetref <> 5572-266-20618"); };
		if (transactionWallet.getIssue().getMultiple() != 1) { System.err.println("testformatListTransactionWallet - issue - multiple <> 1"); };
		if (transactionWallet.getIssue().getUnits() != 1.00000000) { System.err.println("testformatListTransactionWallet - issue - units <> 1.00000000"); };
		if (transactionWallet.getIssue().isOpen()) { System.err.println("testformatListTransactionWallet - issue - open <> false"); };
		if (transactionWallet.getIssue().getQty() != 1.00000000) { System.err.println("testformatListTransactionWallet - issue - qty <> 1.00000000"); };
		if (transactionWallet.getIssue().getRaw() != 1) { System.err.println("testformatListTransactionWallet - issue - raw <> 1"); };
		if (transactionWallet.getIssue().getAddresses().size() != 1) { System.err.println("testformatListTransactionWallet - issue - addresses size <> 1"); };
		if (!"aBcDeFgH123IjKlMnOp456".equals(transactionWallet.getIssue().getAddresses().get(0))) { System.err.println("testformatListTransactionWallet - issue - addresses[0] <> aBcDeFgH123IjKlMnOp456"); };

		if (transactionWallet.getData().size() != 1) { System.err.println("testformatListTransactionWallet - data size <> 1"); };
		if (!"verylonghex122333444455555666666777777788888888999999999azertyuiop".equals(transactionWallet.getData().get(0))) { System.err.println("testformatListTransactionWallet - Data[0] <> verylonghex122333444455555666666777777788888888999999999azertyuiop"); };

		if (transactionWallet.getConfirmations() != -1) { System.err.println("testformatTransactionRAW - confirmations <> -1"); };
		if (!"ed0e84b1b150550606745557f29fd55f4554f534c0edbb60a948718f9ec5b717".equals(transactionWallet.getTxid())) { System.err.println("testformatListTransactionWallet - txid <> ed0e84b1b150550606745557f29fd55f4554f534c0edbb60a948718f9ec5b717"); };
		if (transactionWallet.getTime() != 1480002218) { System.err.println("testformatTransactionRAW - time <> 1480002218"); };
		if (transactionWallet.getTimereceived() != 1480002218) { System.err.println("testformatTransactionRAW - timereceived <> 1480002218"); };
	}

	private static void testformatTransactionWallet() {
		String jsonTransactionWallet = "{"
						+ "\"balance\" : {"
						+ "\"amount\" : 1.23456789,"
						+ "\"assets\" : ["
						+ "{"
						+ "\"name\" : \"Asset2\","
						+ "\"assetref\" : \"5572-532-23163\","
						+ "\"qty\" : 2.00000000"
						+ "}"
						+ "]"
						+ "},"
						+ "\"myaddresses\" : ["
						+ "\"aBcDeFgH123IjKlMnOp456\""
						+ "],"
						+ "\"addresses\" : ["
						+ "\"aBcDeFgH123IjKlMnOp456\""
						+ "],"
						+ "\"permissions\" : ["
						+ "{"
						+ "\"connect\" : false,"
						+ "\"send\" : true,"
						+ "\"receive\" : true,"
						+ "\"issue\" : true,"
						+ "\"mine\" : false,"
						+ "\"admin\" : false,"
						+ "\"activate\" : false,"
						+ "\"startblock\" : 0,"
						+ "\"endblock\" : 4294967295,"
						+ "\"timestamp\" : 1481637649,"
						+ "\"addresses\" : ["
						+ "\"aBcDeFgH123IjKlMnOp456\""
						+ "]"
						+ "}"
						+ "],"
						+ "\"issue\" : {"
						+ "\"name\" : \"Asset1\","
						+ "\"assetref\" : \"5572-266-20618\","
						+ "\"multiple\" : 1,"
						+ "\"units\" : 1.00000000,"
						+ "\"open\" : false,"
						+ "\"details\" : {"
						+ "},"
						+ "\"qty\" : 1.00000000,"
						+ "\"raw\" : 1,"
						+ "\"addresses\" : ["
						+ "\"aBcDeFgH123IjKlMnOp456\""
						+ "]"
						+ "},"
						+ "\"data\" : ["
						+ "\"verylonghex122333444455555666666777777788888888999999999azertyuiop\""
						+ "],"
						+ "\"confirmations\" : -1,"
						+ "\"txid\" : \"ed0e84b1b150550606745557f29fd55f4554f534c0edbb60a948718f9ec5b717\","
						+ "\"time\" : 1480002218,"
						+ "\"timereceived\" : 1480002218"
						+ "}";

		TransactionWallet transactionWallet = WalletTransactionFormatter.formatTransactionWallet(jsonTransactionWallet);

		if (transactionWallet.getBalance().getAmount() != 1.23456789) { System.err.println("testformatListTransactionWallet - balance - amount <> 1.23456789"); };
		if (transactionWallet.getBalance().getAssets().size() != 1) { System.err.println("testformatListTransactionWallet - balance - assets size <> 1"); };
		if (!"Asset2".equals(transactionWallet.getBalance().getAssets().get(0).getName())) { System.err.println("testformatListTransactionWallet - balance - assets[0] - name <> Asset2"); };
		if (!"5572-532-23163".equals(transactionWallet.getBalance().getAssets().get(0).getAssetref())) { System.err.println("testformatListTransactionWallet - balance - assets[0] - assetref <> 5572-532-23163"); };
		if (transactionWallet.getBalance().getAssets().get(0).getQty() != 2.0) { System.err.println("testformatListTransactionWallet - balance - assets[0] - qty <> 2.0"); };

		if (transactionWallet.getMyaddresses().size() != 1) { System.err.println("testformatListTransactionWallet - myaddresses size <> 1"); };
		if (!"aBcDeFgH123IjKlMnOp456".equals(transactionWallet.getMyaddresses().get(0))) { System.err.println("testformatListTransactionWallet - myaddresses[0] <> aBcDeFgH123IjKlMnOp456"); };

		if (transactionWallet.getAddresses().size() != 1) { System.err.println("testformatListTransactionWallet - addresses size <> 1"); };
		if (!"aBcDeFgH123IjKlMnOp456".equals(transactionWallet.getAddresses().get(0))) { System.err.println("testformatListTransactionWallet - addresses[0] <> aBcDeFgH123IjKlMnOp456"); };

		if (transactionWallet.getPermissions().size() != 1) { System.err.println("testformatListTransactionWallet - permissions size <> 1"); };
		if (transactionWallet.getPermissions().get(0).isConnect()) { System.err.println("testformatListTransactionWallet - permissions[0] - connect <> false"); };
		if (!transactionWallet.getPermissions().get(0).isSend()) { System.err.println("testformatListTransactionWallet - permissions[0] - send <> true"); };
		if (!transactionWallet.getPermissions().get(0).isReceive()) { System.err.println("testformatListTransactionWallet - permissions[0] - receive <> true"); };
		if (!transactionWallet.getPermissions().get(0).isIssue()) { System.err.println("testformatListTransactionWallet - permissions[0] - issue <> true"); };
		if (transactionWallet.getPermissions().get(0).isMine()) { System.err.println("testformatListTransactionWallet - permissions[0] - mine <> false"); };
		if (transactionWallet.getPermissions().get(0).isAdmin()) { System.err.println("testformatListTransactionWallet - permissions[0] - admin <> false"); };
		if (transactionWallet.getPermissions().get(0).isActivate()) { System.err.println("testformatListTransactionWallet - permissions[0] - activate <> false"); };
		if (transactionWallet.getPermissions().get(0).getStartblock() != 0) { System.err.println("testformatListTransactionWallet - permissions[0] - startblock <> 0"); };
		if (transactionWallet.getPermissions().get(0).getEndblock() != 4294967295L) { System.err.println("testformatListTransactionWallet - permissions[0] - endblock <> 4294967295"); };
		if (transactionWallet.getPermissions().get(0).getTimestamp() != 1481637649) { System.err.println("testformatListTransactionWallet - permissions[0] - timestamp <> 1481637649"); };
		if (transactionWallet.getPermissions().get(0).getAddresses().size() != 1) { System.err.println("testformatListTransactionWallet - permissions[0] - addresses size <> 1"); };
		if (!"aBcDeFgH123IjKlMnOp456".equals(transactionWallet.getPermissions().get(0).getAddresses().get(0))) { System.err.println("testformatListTransactionWallet - permissions[0] - addresses[0] <> aBcDeFgH123IjKlMnOp456"); };

		if (!"Asset1".equals(transactionWallet.getIssue().getName())) { System.err.println("testformatListTransactionWallet - issue - name <> Asset1"); };
		if (!"5572-266-20618".equals(transactionWallet.getIssue().getAssetref())) { System.err.println("testformatListTransactionWallet - issue - assetref <> 5572-266-20618"); };
		if (transactionWallet.getIssue().getMultiple() != 1) { System.err.println("testformatListTransactionWallet - issue - multiple <> 1"); };
		if (transactionWallet.getIssue().getUnits() != 1.00000000) { System.err.println("testformatListTransactionWallet - issue - units <> 1.00000000"); };
		if (transactionWallet.getIssue().isOpen()) { System.err.println("testformatListTransactionWallet - issue - open <> false"); };
		if (transactionWallet.getIssue().getQty() != 1.00000000) { System.err.println("testformatListTransactionWallet - issue - qty <> 1.00000000"); };
		if (transactionWallet.getIssue().getRaw() != 1) { System.err.println("testformatListTransactionWallet - issue - raw <> 1"); };
		if (transactionWallet.getIssue().getAddresses().size() != 1) { System.err.println("testformatListTransactionWallet - issue - addresses size <> 1"); };
		if (!"aBcDeFgH123IjKlMnOp456".equals(transactionWallet.getIssue().getAddresses().get(0))) { System.err.println("testformatListTransactionWallet - issue - addresses[0] <> aBcDeFgH123IjKlMnOp456"); };

		if (transactionWallet.getData().size() != 1) { System.err.println("testformatListTransactionWallet - data size <> 1"); };
		if (!"verylonghex122333444455555666666777777788888888999999999azertyuiop".equals(transactionWallet.getData().get(0))) { System.err.println("testformatListTransactionWallet - Data[0] <> verylonghex122333444455555666666777777788888888999999999azertyuiop"); };

		if (transactionWallet.getConfirmations() != -1) { System.err.println("testformatTransactionRAW - confirmations <> -1"); };
		if (!"ed0e84b1b150550606745557f29fd55f4554f534c0edbb60a948718f9ec5b717".equals(transactionWallet.getTxid())) { System.err.println("testformatListTransactionWallet - txid <> ed0e84b1b150550606745557f29fd55f4554f534c0edbb60a948718f9ec5b717"); };
		if (transactionWallet.getTime() != 1480002218) { System.err.println("testformatTransactionRAW - time <> 1480002218"); };
		if (transactionWallet.getTimereceived() != 1480002218) { System.err.println("testformatTransactionRAW - timereceived <> 1480002218"); };
	}

	private static void testformatTransactionWalletDetailed() {
		String jsonTransactionWalletDetailed = "{"
						+ "\"balance\" : {"
						+ "\"amount\" : 1.23456789,"
						+ "\"assets\" : ["
						+ "{"
						+ "\"name\" : \"Asset2\","
						+ "\"assetref\" : \"5572-532-23163\","
						+ "\"qty\" : 2.00000000"
						+ "}"
						+ "]"
						+ "},"
						+ "\"myaddresses\" : ["
						+ "\"aBcDeFgH123IjKlMnOp456\""
						+ "],"
						+ "\"addresses\" : ["
						+ "\"aBcDeFgH123IjKlMnOp456\""
						+ "],"
						+ "\"permissions\" : ["
						+ "{"
						+ "\"connect\" : false,"
						+ "\"send\" : true,"
						+ "\"receive\" : true,"
						+ "\"issue\" : true,"
						+ "\"mine\" : false,"
						+ "\"admin\" : false,"
						+ "\"activate\" : false,"
						+ "\"startblock\" : 0,"
						+ "\"endblock\" : 4294967295,"
						+ "\"timestamp\" : 1481637649,"
						+ "\"addresses\" : ["
						+ "\"aBcDeFgH123IjKlMnOp456\""
						+ "]"
						+ "}"
						+ "],"
						+ "\"issue\" : {"
						+ "\"name\" : \"Asset1\","
						+ "\"assetref\" : \"5572-266-20618\","
						+ "\"multiple\" : 1,"
						+ "\"units\" : 1.00000000,"
						+ "\"open\" : false,"
						+ "\"details\" : {"
						+ "},"
						+ "\"qty\" : 1.00000000,"
						+ "\"raw\" : 1,"
						+ "\"addresses\" : ["
						+ "\"aBcDeFgH123IjKlMnOp456\""
						+ "]"
						+ "},"
						+ "\"data\" : ["
						+ "\"verylonghex122333444455555666666777777788888888999999999azertyuiop\""
						+ "],"
						+ "\"confirmations\" : -1,"
						+ "\"txid\" : \"ed0e84b1b150550606745557f29fd55f4554f534c0edbb60a948718f9ec5b717\","
						+ "\"time\" : 1480002218,"
						+ "\"timereceived\" : 1480002218,"
						+ "\"blockhash\" : \"verylonghex122333444455555666666777777788888888999999999azertyuiop\","
						+ "\"blockindex\" : 1480002218,"
						+ "\"vin\" : ["
						+ "{"
						+ "\"txid\" : \"1727bbac6fee5108c1c0218de02c31bdbf0be79591cda0c66d2f76560776c90f\","
						+ "\"vout\" : 0,"
						+ "\"addresses\" : ["
						+ "\"aBcDeFgH123IjKlMnOp456\""
						+ "],"
						+ "\"type\" : \"pubkeyhash\","
						+ "\"ismine\" : true,"
						+ "\"iswatchonly\" : false,"
						+ "\"amount\" : 1.23456789,"
						+ "\"assets\" : ["
						+ "]"
						+ "}"
						+ "],"
						+ "\"vout\" : ["
						+ "{"
						+ "\"n\" : 0,"
						+ "\"addresses\" : ["
						+ "\"aBcDeFgH123IjKlMnOp456\""
						+ "],"
						+ "\"type\" : \"pubkeyhash\","
						+ "\"ismine\" : true,"
						+ "\"iswatchonly\" : false,"
						+ "\"amount\" : 1.23456789,"
						+ "\"assets\" : ["
						+ "],"
						+ "\"permissions\" : ["
						+ "]"
						+ "}"
						+ "],"
						+ "\"hex\" : \"verylonghex122333444455555666666777777788888888999999999azertyuiop\""
						+ "}";

		TransactionWalletDetailed transactionWalletDetailed = WalletTransactionFormatter.formatTransactionWalletDetailed(jsonTransactionWalletDetailed);

		if (transactionWalletDetailed.getBalance().getAmount() != 1.23456789) { System.err.println("testformatListTransactionWallet - balance - amount <> 1.23456789"); };
		if (transactionWalletDetailed.getBalance().getAssets().size() != 1) { System.err.println("testformatListTransactionWallet - balance - assets size <> 1"); };
		if (!"Asset2".equals(transactionWalletDetailed.getBalance().getAssets().get(0).getName())) { System.err.println("testformatListTransactionWallet - balance - assets[0] - name <> Asset2"); };
		if (!"5572-532-23163".equals(transactionWalletDetailed.getBalance().getAssets().get(0).getAssetref())) { System.err.println("testformatListTransactionWallet - balance - assets[0] - assetref <> 5572-532-23163"); };
		if (transactionWalletDetailed.getBalance().getAssets().get(0).getQty() != 2.0) { System.err.println("testformatListTransactionWallet - balance - assets[0] - qty <> 2.0"); };

		if (transactionWalletDetailed.getMyaddresses().size() != 1) { System.err.println("testformatListTransactionWallet - myaddresses size <> 1"); };
		if (!"aBcDeFgH123IjKlMnOp456".equals(transactionWalletDetailed.getMyaddresses().get(0))) { System.err.println("testformatListTransactionWallet - myaddresses[0] <> aBcDeFgH123IjKlMnOp456"); };

		if (transactionWalletDetailed.getAddresses().size() != 1) { System.err.println("testformatListTransactionWallet - addresses size <> 1"); };
		if (!"aBcDeFgH123IjKlMnOp456".equals(transactionWalletDetailed.getAddresses().get(0))) { System.err.println("testformatListTransactionWallet - addresses[0] <> aBcDeFgH123IjKlMnOp456"); };

		if (transactionWalletDetailed.getPermissions().size() != 1) { System.err.println("testformatListTransactionWallet - permissions size <> 1"); };
		if (transactionWalletDetailed.getPermissions().get(0).isConnect()) { System.err.println("testformatListTransactionWallet - permissions[0] - connect <> false"); };
		if (!transactionWalletDetailed.getPermissions().get(0).isSend()) { System.err.println("testformatListTransactionWallet - permissions[0] - send <> true"); };
		if (!transactionWalletDetailed.getPermissions().get(0).isReceive()) { System.err.println("testformatListTransactionWallet - permissions[0] - receive <> true"); };
		if (!transactionWalletDetailed.getPermissions().get(0).isIssue()) { System.err.println("testformatListTransactionWallet - permissions[0] - issue <> true"); };
		if (transactionWalletDetailed.getPermissions().get(0).isMine()) { System.err.println("testformatListTransactionWallet - permissions[0] - mine <> false"); };
		if (transactionWalletDetailed.getPermissions().get(0).isAdmin()) { System.err.println("testformatListTransactionWallet - permissions[0] - admin <> false"); };
		if (transactionWalletDetailed.getPermissions().get(0).isActivate()) { System.err.println("testformatListTransactionWallet - permissions[0] - activate <> false"); };
		if (transactionWalletDetailed.getPermissions().get(0).getStartblock() != 0) { System.err.println("testformatListTransactionWallet - permissions[0] - startblock <> 0"); };
		if (transactionWalletDetailed.getPermissions().get(0).getEndblock() != 4294967295L) { System.err.println("testformatListTransactionWallet - permissions[0] - endblock <> 4294967295"); };
		if (transactionWalletDetailed.getPermissions().get(0).getTimestamp() != 1481637649) { System.err.println("testformatListTransactionWallet - permissions[0] - timestamp <> 1481637649"); };
		if (transactionWalletDetailed.getPermissions().get(0).getAddresses().size() != 1) { System.err.println("testformatListTransactionWallet - permissions[0] - addresses size <> 1"); };
		if (!"aBcDeFgH123IjKlMnOp456".equals(transactionWalletDetailed.getPermissions().get(0).getAddresses().get(0))) { System.err.println("testformatListTransactionWallet - permissions[0] - addresses[0] <> aBcDeFgH123IjKlMnOp456"); };

		if (!"Asset1".equals(transactionWalletDetailed.getIssue().getName())) { System.err.println("testformatListTransactionWallet - issue - name <> Asset1"); };
		if (!"5572-266-20618".equals(transactionWalletDetailed.getIssue().getAssetref())) { System.err.println("testformatListTransactionWallet - issue - assetref <> 5572-266-20618"); };
		if (transactionWalletDetailed.getIssue().getMultiple() != 1) { System.err.println("testformatListTransactionWallet - issue - multiple <> 1"); };
		if (transactionWalletDetailed.getIssue().getUnits() != 1.00000000) { System.err.println("testformatListTransactionWallet - issue - units <> 1.00000000"); };
		if (transactionWalletDetailed.getIssue().isOpen()) { System.err.println("testformatListTransactionWallet - issue - open <> false"); };
		if (transactionWalletDetailed.getIssue().getQty() != 1.00000000) { System.err.println("testformatListTransactionWallet - issue - qty <> 1.00000000"); };
		if (transactionWalletDetailed.getIssue().getRaw() != 1) { System.err.println("testformatListTransactionWallet - issue - raw <> 1"); };
		if (transactionWalletDetailed.getIssue().getAddresses().size() != 1) { System.err.println("testformatListTransactionWallet - issue - addresses size <> 1"); };
		if (!"aBcDeFgH123IjKlMnOp456".equals(transactionWalletDetailed.getIssue().getAddresses().get(0))) { System.err.println("testformatListTransactionWallet - issue - addresses[0] <> aBcDeFgH123IjKlMnOp456"); };

		if (transactionWalletDetailed.getData().size() != 1) { System.err.println("testformatListTransactionWallet - data size <> 1"); };
		if (!"verylonghex122333444455555666666777777788888888999999999azertyuiop".equals(transactionWalletDetailed.getData().get(0))) { System.err.println("testformatListTransactionWallet - Data[0] <> verylonghex122333444455555666666777777788888888999999999azertyuiop"); };

		if (transactionWalletDetailed.getConfirmations() != -1) { System.err.println("testformatTransactionRAW - confirmations <> -1"); };
		if (!"ed0e84b1b150550606745557f29fd55f4554f534c0edbb60a948718f9ec5b717".equals(transactionWalletDetailed.getTxid())) { System.err.println("testformatListTransactionWallet - txid <> ed0e84b1b150550606745557f29fd55f4554f534c0edbb60a948718f9ec5b717"); };
		if (transactionWalletDetailed.getTime() != 1480002218) { System.err.println("testformatTransactionRAW - time <> 1480002218"); };
		if (transactionWalletDetailed.getTimereceived() != 1480002218) { System.err.println("testformatTransactionRAW - timereceived <> 1480002218"); };

		if (!"verylonghex122333444455555666666777777788888888999999999azertyuiop".equals(transactionWalletDetailed.getBlockhash())) { System.err.println("testformatListTransactionWallet - blockhash <> verylonghex122333444455555666666777777788888888999999999azertyuiop"); };
		if (transactionWalletDetailed.getBlockindex() != 1480002218) { System.err.println("testformatTransactionRAW - blockindex <> 1480002218"); };

		if (transactionWalletDetailed.getVin().size() != 1) { System.err.println("testformatListTransactionWallet - vin size <> 1"); };
		if (!"1727bbac6fee5108c1c0218de02c31bdbf0be79591cda0c66d2f76560776c90f".equals(transactionWalletDetailed.getVin().get(0).getTxid())) { System.err.println("testformatListTransactionWallet - vin[0] - txid <> 1727bbac6fee5108c1c0218de02c31bdbf0be79591cda0c66d2f76560776c90f"); };
		if (transactionWalletDetailed.getVin().get(0).getVout() != 0) { System.err.println("testformatListTransactionWallet - vin[0] - vout <> 0"); };
		if (transactionWalletDetailed.getVin().get(0).getAddresses().size() != 1) { System.err.println("testformatListTransactionWallet - vin[0] - addresses size <> 1"); };
		if (!"aBcDeFgH123IjKlMnOp456".equals(transactionWalletDetailed.getVin().get(0).getAddresses().get(0))) { System.err.println("testformatListTransactionWallet - vin[0] - addresses[0] <> aBcDeFgH123IjKlMnOp456"); };
		if (!"pubkeyhash".equals(transactionWalletDetailed.getVin().get(0).getType())) { System.err.println("testformatListTransactionWallet - vin[0] - type <> pubkeyhash"); };
		if (!transactionWalletDetailed.getVin().get(0).isIsmine()) { System.err.println("testformatListTransactionWallet - vin[0] - ismine <> true"); };
		if (transactionWalletDetailed.getVin().get(0).isIswatchonly()) { System.err.println("testformatListTransactionWallet - vin[0] - iswatchonly <> false"); };
		if (transactionWalletDetailed.getVin().get(0).getAmount() != 1.23456789) { System.err.println("testformatListTransactionWallet - vin[0] - amount <> 1.23456789"); };
		if (transactionWalletDetailed.getVin().get(0).getAssets().size() != 0) { System.err.println("testformatListTransactionWallet - vin[0] - assets size <> 0"); };

		if (transactionWalletDetailed.getVout().size() != 1) { System.err.println("testformatListTransactionWallet - vout size <> 1"); };
		if (transactionWalletDetailed.getVout().get(0).getN() != 0) { System.err.println("testformatListTransactionWallet - vout[0] - n <> 0"); };
		if (transactionWalletDetailed.getVout().get(0).getAddresses().size() != 1) { System.err.println("testformatListTransactionWallet - vout[0] - addresses size <> 1"); };
		if (!"aBcDeFgH123IjKlMnOp456".equals(transactionWalletDetailed.getVout().get(0).getAddresses().get(0))) { System.err.println("testformatListTransactionWallet - vout[0] - addresses[0] <> aBcDeFgH123IjKlMnOp456"); };
		if (!"pubkeyhash".equals(transactionWalletDetailed.getVout().get(0).getType())) { System.err.println("testformatListTransactionWallet - vout[0] - type <> pubkeyhash"); };
		if (!transactionWalletDetailed.getVout().get(0).isIsmine()) { System.err.println("testformatListTransactionWallet - vout[0] - ismine <> true"); };
		if (transactionWalletDetailed.getVout().get(0).isIswatchonly()) { System.err.println("testformatListTransactionWallet - vout[0] - iswatchonly <> false"); };
		if (transactionWalletDetailed.getVout().get(0).getAmount() != 1.23456789) { System.err.println("testformatListTransactionWallet - vout[0] - amount <> 1.23456789"); };
		if (transactionWalletDetailed.getVout().get(0).getAssets().size() != 0) { System.err.println("testformatListTransactionWallet - vout[0] - assets size <> 0"); };

		if (!"verylonghex122333444455555666666777777788888888999999999azertyuiop".equals(transactionWalletDetailed.getHex())) { System.err.println("testformatListTransactionWallet - hex <> verylonghex122333444455555666666777777788888888999999999azertyuiop"); };

	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of WalletTransactionFormatterTest ---");

		testformatListTransactionWallet();
		testformatTransactionWallet();
		testformatTransactionWalletDetailed();

		System.out.println("--- Start of WalletTransactionFormatterTest ---");
	}

}
