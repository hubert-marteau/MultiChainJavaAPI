/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.test.object.formatters;

import multichain.object.TransactionRAW;
import multichain.object.formatters.RAWTransactionFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class RAWTransactionFormatterTest {

	/**
	 *
	 */
	public RAWTransactionFormatterTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testformatTransactionRAW() {
		String jsonTransactionRAW = "{"
				+ "\"txid\" : \"69773ce91da4af37d358d660db9a9edde8885704c73e7d818be426612ec4da3c\","
				+ "\"version\" : 1,"
				+ "\"locktime\" : 0,"
				+ "\"vin\" : ["
				+ "{"
				+ "\"txid\" : \"3697978f311078f917faf1bbd836fb2709b1a8830dcf24b23f5e8311705aa707\","
				+ "\"vout\" : 0,"
				+ "\"scriptSig\" : {"
				+ "\"asm\" : \"1asm2asm3asm4asm5asm6asm7asm8asm9asm 9asm8asm7asm6asm5asm4asm3asm2asm1asm\","
				+ "\"hex\" : \"verylonghex122333444455555666666777777788888888999999999azertyuiop\""
				+ "},"
				+ "\"sequence\" : 4294967295"
				+ "}"
				+ "],"
				+ "\"vout\" : ["
				+ "{"
				+ "\"value\" : 0.00000000,"
				+ "\"n\" : 0,"
				+ "\"scriptPubKey\" : {"
				+ "\"asm\" : \"OP_DUP OP_HASH160 999hex666 OP_EQUALVERIFY OP_CHECKSIG 777value111 OP_DROP\","
				+ "\"hex\" : \"verylonghex122333444455555666666777777788888888999999999azertyuiop\","
				+ "\"reqSigs\" : 1,"
				+ "\"type\" : \"pubkeyhash\","
				+ "\"addresses\" : ["
				+ "\"aBcDeFgH123IjKlMnOp456\""
				+ "]"
				+ "},"
				+ "\"assets\" : ["
				+ "{"
				+ "\"name\" : \"Asset3\","
				+ "\"issuetxid\" : \"69773ce91da4af37d358d660db9a9edde8885704c73e7d818be426612ec4da3c\","
				+ "\"assetref\" : \"5872-267-30569\","
				+ "\"qty\" : 3.00000000,"
				+ "\"raw\" : 3,"
				+ "\"type\" : \"issuefirst\""
				+ "}"
				+ "],"
				+ "\"permissions\" : ["
				+ "]"
				+ "},"
				+ "{"
				+ "\"value\" : 1.23456789,"
				+ "\"n\" : 1,"
				+ "\"scriptPubKey\" : {"
				+ "\"asm\" : \"OP_RETURN 777value111\","
				+ "\"hex\" : \"verylonghex122333444455555666666777777788888888999999999azertyuiop\","
				+ "\"type\" : \"nulldata\""
				+ "},"
				+ "\"assets\" : ["
				+ "],"
				+ "\"permissions\" : ["
				+ "]"
				+ "},"
				+ "{"
				+ "\"value\" : 0.00000000,"
				+ "\"n\" : 2,"
				+ "\"scriptPubKey\" : {"
				+ "\"asm\" : \"OP_DUP OP_HASH160 999hex666 OP_EQUALVERIFY OP_CHECKSIG\","
				+ "\"hex\" : \"verylonghex122333444455555666666777777788888888999999999azertyuiop\","
				+ "\"reqSigs\" : 1,"
				+ "\"type\" : \"pubkeyhash\","
				+ "\"addresses\" : ["
				+ "\"address2aBcDeFgH123IjKlMnOp456\""
				+ "]"
				+ "},"
				+ "\"assets\" : ["
				+ "],"
				+ "\"permissions\" : ["
				+ "]"
				+ "}"
				+ "],"
				+ "\"issue\" : {"
				+ "\"type\" : \"issuefirst\","
				+ "\"name\" : \"Asset3\","
				+ "\"multiple\" : 1,"
				+ "\"open\" : false,"
				+ "\"details\" : {"
				+ "}"
				+ "},"
				+ "\"data\" : ["
				+ "\"53504b610100000041737365743300\""
				+ "]"
				+ "}";
		TransactionRAW transactionRAW = RAWTransactionFormatter.formatTransactionRAW(jsonTransactionRAW);

		if (!"69773ce91da4af37d358d660db9a9edde8885704c73e7d818be426612ec4da3c".equals(transactionRAW.getTxid())) { System.err.println("testformatTransactionRAW - txid <> 69773ce91da4af37d358d660db9a9edde8885704c73e7d818be426612ec4da3c"); };
		if (transactionRAW.getVersion() != 1) { System.err.println("testformatTransactionRAW - version <> 1"); };
		if (transactionRAW.getLocktime() != 0) { System.err.println("testformatTransactionRAW - locktime <> 0"); };

		if (transactionRAW.getVin().size() != 1) { System.err.println("testformatTransactionRAW - vin list size <> 1"); };

		if (!"3697978f311078f917faf1bbd836fb2709b1a8830dcf24b23f5e8311705aa707".equals(transactionRAW.getVin().get(0).getTxid())) { System.err.println("testformatTransactionRAW - vin[0].txid <> 3697978f311078f917faf1bbd836fb2709b1a8830dcf24b23f5e8311705aa707"); };
		if (transactionRAW.getVin().get(0).getVout() != 0) { System.err.println("testformatTransactionRAW - vin[0].Vout <> 0"); };
		if (!"1asm2asm3asm4asm5asm6asm7asm8asm9asm 9asm8asm7asm6asm5asm4asm3asm2asm1asm".equals(transactionRAW.getVin().get(0).getScriptSig().getAsm())) { System.err.println("testformatTransactionRAW - vin[0].scriptSig.asm <> 1asm2asm3asm4asm5asm6asm7asm8asm9asm 9asm8asm7asm6asm5asm4asm3asm2asm1asm"); };
		if (!"verylonghex122333444455555666666777777788888888999999999azertyuiop".equals(transactionRAW.getVin().get(0).getScriptSig().getHex())) { System.err.println("testformatTransactionRAW - vin[0].scriptSig.hex <> verylonghex122333444455555666666777777788888888999999999azertyuiop"); };
		if (transactionRAW.getVin().get(0).getSequence() != 4294967295L) { System.err.println("testformatTransactionRAW - vin[0].sequence <> 4294967295"); };

		if (transactionRAW.getVout().size() != 3) { System.err.println("testformatTransactionRAW - vout list size <> 3"); };

		if (transactionRAW.getVout().get(0).getValue() != 0.0) { System.err.println("testformatTransactionRAW - vout[0].Value <> 0.0"); };
		if (transactionRAW.getVout().get(0).getN() != 0) { System.err.println("testformatTransactionRAW - vout[0].N <> 0"); };
		if (!"OP_DUP OP_HASH160 999hex666 OP_EQUALVERIFY OP_CHECKSIG 777value111 OP_DROP".equals(transactionRAW.getVout().get(0).getScriptPubKey().getAsm())) { System.err.println("testformatTransactionRAW - vout[0].scriptPubKey.asm <> OP_DUP OP_HASH160 999hex666 OP_EQUALVERIFY OP_CHECKSIG 777value111 OP_DROP"); };
		if (!"verylonghex122333444455555666666777777788888888999999999azertyuiop".equals(transactionRAW.getVout().get(0).getScriptPubKey().getHex())) { System.err.println("testformatTransactionRAW - vout[0].scriptPubKey.hex <> verylonghex122333444455555666666777777788888888999999999azertyuiop"); };
		if (transactionRAW.getVout().get(0).getScriptPubKey().getReqSigs() != 1) { System.err.println("testformatTransactionRAW - vout[0].scriptPubKey.reqSigs <> 1"); };
		if (!"pubkeyhash".equals(transactionRAW.getVout().get(0).getScriptPubKey().getType())) { System.err.println("testformatTransactionRAW - vout[0].scriptPubKey.type <> pubkeyhash"); };
		if (transactionRAW.getVout().get(0).getScriptPubKey().getAddresses().size() != 1) { System.err.println("testformatTransactionRAW - vout[0].scriptPubKey.addresses list size <> 1"); };
		if (!"aBcDeFgH123IjKlMnOp456".equals(transactionRAW.getVout().get(0).getScriptPubKey().getAddresses().get(0))) { System.err.println("testformatTransactionRAW - vout[0].scriptPubKey.addresses[0] <> aBcDeFgH123IjKlMnOp456"); };
		if (transactionRAW.getVout().get(0).getAssets().size() != 1) { System.err.println("testformatTransactionRAW - vout[0].assets list size <> 1"); };
		if (!"Asset3".equals(transactionRAW.getVout().get(0).getAssets().get(0).getName())) { System.err.println("testformatTransactionRAW - vout[0].assets[0].name <> Asset3"); };
		if (!"69773ce91da4af37d358d660db9a9edde8885704c73e7d818be426612ec4da3c".equals(transactionRAW.getVout().get(0).getAssets().get(0).getIssuetxid())) { System.err.println("testformatTransactionRAW - vout[0].assets[0].issuetxid <> 69773ce91da4af37d358d660db9a9edde8885704c73e7d818be426612ec4da3c"); };
		if (transactionRAW.getVout().get(0).getAssets().get(0).getQty() != 3.0) { System.err.println("testformatTransactionRAW - vout[0].assets[0].qty <> 3.0"); };
		if (transactionRAW.getVout().get(0).getAssets().get(0).getRaw() != 3) { System.err.println("testformatTransactionRAW - vout[0].assets[0].raw <> 3"); };
		if (!"issuefirst".equals(transactionRAW.getVout().get(0).getAssets().get(0).getType())) { System.err.println("testformatTransactionRAW - vout[0].assets[0].type <> issuefirst"); };
		if (transactionRAW.getVout().get(0).getPermissions().size() != 0) { System.err.println("testformatTransactionRAW - vout[0].permissions list size <> 0"); };

		if (transactionRAW.getVout().get(1).getValue() != 1.23456789) { System.err.println("testformatTransactionRAW - vout[1].Value <> 1.23456789"); };
		if (transactionRAW.getVout().get(1).getN() != 1) { System.err.println("testformatTransactionRAW - vout[1].N <> 1"); };
		if (!"OP_RETURN 777value111".equals(transactionRAW.getVout().get(1).getScriptPubKey().getAsm())) { System.err.println("testformatTransactionRAW - vout[1].scriptPubKey.asm <> OP_RETURN 777value111"); };
		if (!"verylonghex122333444455555666666777777788888888999999999azertyuiop".equals(transactionRAW.getVout().get(1).getScriptPubKey().getHex())) { System.err.println("testformatTransactionRAW - vout[1].scriptPubKey.hex <> verylonghex122333444455555666666777777788888888999999999azertyuiop"); };
		if (!"nulldata".equals(transactionRAW.getVout().get(1).getScriptPubKey().getType())) { System.err.println("testformatTransactionRAW - vout[1].scriptPubKey.type <> nulldata"); };
		if (transactionRAW.getVout().get(1).getAssets().size() != 0) { System.err.println("testformatTransactionRAW - vout[1].assets list size <> 0"); };
		if (transactionRAW.getVout().get(1).getPermissions().size() != 0) { System.err.println("testformatTransactionRAW - vout[1].permissions list size <> 0"); };

		if (transactionRAW.getVout().get(2).getValue() != 0.0) { System.err.println("testformatTransactionRAW - vout[2].Value <> 0.0"); };
		if (transactionRAW.getVout().get(2).getN() != 2) { System.err.println("testformatTransactionRAW - vout[2].N <> 2"); };
		if (!"OP_DUP OP_HASH160 999hex666 OP_EQUALVERIFY OP_CHECKSIG".equals(transactionRAW.getVout().get(2).getScriptPubKey().getAsm())) { System.err.println("testformatTransactionRAW - vout[2].scriptPubKey.asm <> OP_DUP OP_HASH160 999hex666 OP_EQUALVERIFY OP_CHECKSIG"); };
		if (!"verylonghex122333444455555666666777777788888888999999999azertyuiop".equals(transactionRAW.getVout().get(2).getScriptPubKey().getHex())) { System.err.println("testformatTransactionRAW - vout[2].scriptPubKey.hex <> verylonghex122333444455555666666777777788888888999999999azertyuiop"); };
		if (transactionRAW.getVout().get(2).getScriptPubKey().getReqSigs() != 1) { System.err.println("testformatTransactionRAW - vout[2].scriptPubKey.reqSigs <> 1"); };
		if (!"pubkeyhash".equals(transactionRAW.getVout().get(2).getScriptPubKey().getType())) { System.err.println("testformatTransactionRAW - vout[2].scriptPubKey.type <> pubkeyhash"); };
		if (transactionRAW.getVout().get(2).getScriptPubKey().getAddresses().size() != 1) { System.err.println("testformatTransactionRAW - vout[2].scriptPubKey.addresses list size <> 1"); };
		if (!"address2aBcDeFgH123IjKlMnOp456".equals(transactionRAW.getVout().get(2).getScriptPubKey().getAddresses().get(0))) { System.err.println("testformatTransactionRAW - vout[2].scriptPubKey.addresses[0] <> address2aBcDeFgH123IjKlMnOp456"); };
		if (transactionRAW.getVout().get(2).getAssets().size() != 0) { System.err.println("testformatTransactionRAW - vout[2].assets list size <> 0"); };
		if (transactionRAW.getVout().get(2).getPermissions().size() != 0) { System.err.println("testformatTransactionRAW - vout[2].permissions list size <> 0"); };

		if (transactionRAW.getData().size() != 1) { System.err.println("testformatTransactionRAW - data list size <> 1"); };
		if (!"53504b610100000041737365743300".equals(transactionRAW.getData().get(0))) { System.err.println("testformatTransactionRAW - data[0] <> 53504b610100000041737365743300"); };
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of RAWTransactionFormatterTest ---");

		testformatTransactionRAW();

		System.out.println("--- Start of RAWTransactionFormatterTest ---");
	}

}
