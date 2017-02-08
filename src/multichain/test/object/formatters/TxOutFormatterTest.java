/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.test.object.formatters;

import multichain.object.TxOut;
import multichain.object.formatters.TxOutFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class TxOutFormatterTest {

	/**
	 *
	 */
	public TxOutFormatterTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testformatTxOut() {
		String jsonTxOut  = "{"
					+ "\"bestblock\" : \"00000001c18c61dd590f8a5921cf24df39a1dd5207a731de8fc1584fce0006d0\","
					+ "\"confirmations\" : 1234,"
					+ "\"value\" : 1.23456789,"
					+ "\"scriptPubKey\" : {"
					+ "\"asm\" : \"OP_DUP OP_HASH160 1asm2asm3asm4asm5asm6asm7asm8asm9asm 9asm8asm7asm6asm5asm4asm3asm2asm1asm OP_DROP\","
					+ "\"hex\" : \"verylonghex122333444455555666666777777788888888999999999azertyuiop\","
					+ "\"reqSigs\" : 1,"
					+ "\"type\" : \"pubkeyhash\","
					+ "\"addresses\" : ["
					+ "\"aBcDeFgH123IjKlMnOp456\""
					+ "]"
					+ "},"
					+ "\"version\" : 1,"
					+ "\"coinbase\" : false,"
					+ "\"assets\" : ["
					+ "{"
					+ "\"name\" : \"Asset3\","
					+ "\"issuetxid\" : \"69773ce91da4af37d358d660db9a9edde8885704c73e7d818be426612ec4da3c\","
					+ "\"assetref\" : \"5872-267-30569\","
					+ "\"qty\" : 3.456789,"
					+ "\"raw\" : 3,"
					+ "\"issue\" : true"
					+ "}"
					+ "],"
					+ "\"permissions\" : ["
					+ "]"
					+ "}";

		TxOut txOut = TxOutFormatter.formatTxOut(jsonTxOut);


		if (!"00000001c18c61dd590f8a5921cf24df39a1dd5207a731de8fc1584fce0006d0".equals(txOut.getBestblock())) { System.err.println("testformatTxOut - bestblock <> 00000001c18c61dd590f8a5921cf24df39a1dd5207a731de8fc1584fce0006d0"); };
		if (txOut.getConfirmations() != 1234) { System.err.println("testformatTxOut - confirmations <> 1234"); };
		if (txOut.getValue() != 1.23456789) { System.err.println("testformatTxOut - value <> 1.23456789"); };

		if (txOut.getScriptPubKey() == null) { System.err.println("testformatTxOut - scriptPubKey is null"); };

		if (!"OP_DUP OP_HASH160 1asm2asm3asm4asm5asm6asm7asm8asm9asm 9asm8asm7asm6asm5asm4asm3asm2asm1asm OP_DROP".equals(txOut.getScriptPubKey().getAsm())) { System.err.println("testformatTxOut - scriptPubKey - asm <> OP_DUP OP_HASH160 1asm2asm3asm4asm5asm6asm7asm8asm9asm 9asm8asm7asm6asm5asm4asm3asm2asm1asm OP_DROP"); };
		if (!"verylonghex122333444455555666666777777788888888999999999azertyuiop".equals(txOut.getScriptPubKey().getHex())) { System.err.println("testformatTxOut - scriptPubKey - hex <> verylonghex122333444455555666666777777788888888999999999azertyuiop"); };
		if (txOut.getScriptPubKey().getReqSigs() != 1) { System.err.println("testformatTxOut - scriptPubKey - reqSigs <> 1"); };
		if (!"pubkeyhash".equals(txOut.getScriptPubKey().getType())) { System.err.println("testformatTxOut - scriptPubKey - type <> pubkeyhash"); };

		if (txOut.getScriptPubKey().getAddresses().size() != 1) { System.err.println("testformatTxOut - scriptPubKey - addresses list size <> 1"); };
		if (!"aBcDeFgH123IjKlMnOp456".equals(txOut.getScriptPubKey().getAddresses().get(0))) { System.err.println("testformatTxOut - scriptPubKey - addresses[0] <> aBcDeFgH123IjKlMnOp456"); };

		if (txOut.getVersion() != 1) { System.err.println("testformatTxOut - confirmations <> 1"); };
		if (txOut.isCoinbase()) { System.err.println("testformatTxOut - coinbase <> false"); };

		if (txOut.getAssets().size() != 1) { System.err.println("testformatTxOut - assets list size <> 1"); };

		if (!"Asset3".equals(txOut.getAssets().get(0).getName())) { System.err.println("testformatTxOut - assets[0] - name <> Asset3"); };
		if (!"69773ce91da4af37d358d660db9a9edde8885704c73e7d818be426612ec4da3c".equals(txOut.getAssets().get(0).getIssuetxid())) { System.err.println("testformatTxOut - assets[0] - issuetxid <> 69773ce91da4af37d358d660db9a9edde8885704c73e7d818be426612ec4da3c"); };
		if (!"5872-267-30569".equals(txOut.getAssets().get(0).getAssetref())) { System.err.println("testformatTxOut - assets[0] - assetref <> 5872-267-30569"); };
		if (txOut.getAssets().get(0).getQty() != 3.456789) { System.err.println("testformatTxOut - assets[0] - qty <> 3.456789"); };
		if (txOut.getAssets().get(0).getRaw() != 3) { System.err.println("testformatTxOut - assets[0] - raw <> 3"); };
		if (!txOut.getAssets().get(0).isIssue()) { System.err.println("testformatTxOut - assets[0] - issue <> true"); };

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of TxOutFormatterTest ---");

		testformatTxOut();

		System.out.println("--- End of TxOutFormatterTest ---");
	}

}
