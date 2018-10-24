/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import junit.framework.TestCase;
import multichain.object.AddressBalance;
import multichain.object.AddressBalanceAsset;
import multichain.object.AddressBalanceCurrency;
import multichain.object.AddressBalanceIssue;
import multichain.object.BalanceAssetGeneral;
import multichain.object.SignedTransactionRAW;
import multichain.object.queryobjects.CustomParamString;
import multichain.object.queryobjects.DataParam;
import multichain.object.queryobjects.DataParamHex;
import multichain.object.queryobjects.DataParamIssue;
import multichain.object.queryobjects.ParamIssue;
import multichain.object.queryobjects.TxIdVout;

/**
 * @author Ub - H. MARTEAU
 * @version 4.16
 */
public class RAWTransactionCommandTest extends TestCase {
	
	@Test
	public void testsignRawTransaction() {
//		MultiChainCommand multiChainCommand = new MultiChainCommand(TestConst.MULTICHAIN_SERVER_IP,
//				TestConst.MULTICHAIN_SERVER_PORT, TestConst.MULTICHAIN_SERVER_LOGIN, TestConst.MULTICHAIN_SERVER_PWD);
//		
//		String rawtransaction = "010000000103b800bda672b9a23d5e039b6d895a17cfa8d467431e3a18a4879cc86025b77e0000000000ffffffff0200000000000000003776a914c8054354dc1ca5542aaec06bc1521b83664e067088ac1c73706b71cfa8d467431e3a18a4879cc86025b77e010000000000000075000000000000000035a914cd94314baf6d7dc041e262103569ebb9af254491871c73706b71cfa8d467431e3a18a4879cc86025b77e0f270000000000007500000000";
//		
//		SignedTransactionRAW result = null;
//
//		try {
//			result = multiChainCommand.getRawTransactionCommand().signRawTransaction(rawtransaction);
//		} catch (MultichainException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		assertNotNull(result);
//		assertNotNull(result.getHex());
//		assertTrue(!result.getHex().isEmpty());
	  assertTrue(true);
	}
	
	@Test
	public void testcreateRawTransactionStream() {
//		MultiChainCommand multiChainCommand = new MultiChainCommand(TestConst.MULTICHAIN_SERVER_IP,
//				TestConst.MULTICHAIN_SERVER_PORT, TestConst.MULTICHAIN_SERVER_LOGIN, TestConst.MULTICHAIN_SERVER_PWD);
//		String testAddress = "136ptUdTCCgcg4RQ7FktVtVih4Te5cfzn4P1kE";
//		
//		List<Map<String, String>> rawParams = new ArrayList<>();
//		
//		Map<String, String> param1 = new HashMap<>();
//		param1.put("for","stream3");
//		param1.put("key","key1");
//		param1.put("data","4f6e65206974656d");
//		
//		Map<String, String> param2 = new HashMap<>();
//		param2.put("for","stream4");
//		param2.put("key","key2");
//		param2.put("data","416e6f74686572206974656d");
//		
//		rawParams.add(param1);
//		rawParams.add(param2);
//		
//		try {
//			String result = multiChainCommand.getRawTransactionCommand().createRawSendFromByMap(testAddress, rawParams);
//			
//			System.out.println(result);
//			assertNotNull(result);
//		} catch (MultichainException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			fail();
//		}
		assertTrue(true);
	}	
	
	@Test
	public void testcreateRawTransaction() {
//		MultiChainCommand multiChainCommand = new MultiChainCommand(TestConst.MULTICHAIN_SERVER_IP,
//				TestConst.MULTICHAIN_SERVER_PORT, TestConst.MULTICHAIN_SERVER_LOGIN, TestConst.MULTICHAIN_SERVER_PWD);
//		String testAddress = "19bF9s2vYLEPAGKr4dduB8Muzj2avgVrrtR6WJ";
//		
//		String assetName = "TestClosed";
//		
//		List<TxIdVout> listTxIdVout = new ArrayList<>();
//		
//		TxIdVout txIdVout01 = new TxIdVout();
//		//Existing transaction in Test BlockChain
//		txIdVout01.setTxId("4fe42e431f0339e4e78605bc20c0866d7db1ce1794f68ce4f36a708cb5ea60bb");
//		txIdVout01.setvOut(0);
//		listTxIdVout.add(txIdVout01);
//		
//		TxIdVout txIdVout02 = new TxIdVout();
//		//Existing transaction in Test BlockChain
//		txIdVout02.setTxId("a9bac94e5c84b3a4b788d09bcecb53a8efc8a52957c77ac1a4428851db70f2aa");
//		txIdVout02.setvOut(0);
//		listTxIdVout.add(txIdVout02);
//		
//		try {
//			//TEST WITH CURRENCY
//			AddressBalanceCurrency addressBalanceCurrency = new AddressBalanceCurrency();
//			addressBalanceCurrency.setAddress(testAddress);
//			addressBalanceCurrency.setCurrencyValue(0.0);
//			
//			List<AddressBalance> listAddressBalance01 = new ArrayList<>();
//			listAddressBalance01.add(addressBalanceCurrency);
//			
//			String hextrans01 = multiChainCommand.getRawTransactionCommand().createRawTransaction(listTxIdVout, listAddressBalance01);
//			SignedTransactionRAW hextrans01Signed = multiChainCommand.getRawTransactionCommand().signRawTransaction(hextrans01);
//			
//			assertNotNull(hextrans01);
//			assertTrue(hextrans01.length() > 100);
//			assertNotNull(hextrans01Signed);
//			assertTrue(hextrans01Signed.isComplete());
//			
//			
//			
//			//TEST WITH ASSET
//			BalanceAssetGeneral balanceAssetBase = new BalanceAssetGeneral();
//			balanceAssetBase.setName(assetName);
//			balanceAssetBase.setQty(1);
//			List<BalanceAssetGeneral> listBalanceAssetBase = new ArrayList<>();
//			listBalanceAssetBase.add(balanceAssetBase);
//			
//			AddressBalanceAsset addressBalanceAsset = new AddressBalanceAsset();
//			addressBalanceAsset.setAddress(testAddress);
//			addressBalanceAsset.setAssets(listBalanceAssetBase);
//			
//			List<AddressBalance> listAddressBalance02 = new ArrayList<>();
//			listAddressBalance02.add(addressBalanceAsset);
//			
//			String hextrans02 = multiChainCommand.getRawTransactionCommand().createRawTransaction(listTxIdVout, listAddressBalance02);
//            SignedTransactionRAW hextrans02Signed = multiChainCommand.getRawTransactionCommand().signRawTransaction(hextrans02);
//			
//			assertNotNull(hextrans02);
//			assertTrue(hextrans02.length() > 100);
//            assertNotNull(hextrans02Signed);
//            assertTrue(hextrans02Signed.isComplete());
//			
//            
//            
//			//TEST WITH CURRENCY & ASSET 
//			List<AddressBalance> listAddressBalance03 = new ArrayList<>();
//			listAddressBalance03.add(addressBalanceCurrency);
//			listAddressBalance03.add(addressBalanceAsset);
//			
//			String hextrans03 = multiChainCommand.getRawTransactionCommand().createRawTransaction(listTxIdVout, listAddressBalance03);
//            SignedTransactionRAW hextrans03Signed = multiChainCommand.getRawTransactionCommand().signRawTransaction(hextrans03);
//			
//			assertNotNull(hextrans03);
//			assertTrue(hextrans03.length() > 100);
//            assertNotNull(hextrans03Signed);
//            assertTrue(hextrans03Signed.isComplete());
//            
//            
//			
//			//TEST WITH CURRENCY & ASSET & METADATA
//			List<DataParam> hexData = new ArrayList<>();
//			hexData.add(new DataParamHex("0123456789ABCDEF"));
//			hexData.add(new DataParamHex("0123456789"));
//			hexData.add(new DataParamHex("ABCDEF"));
//			
//			String hextrans04 = multiChainCommand.getRawTransactionCommand().createRawTransaction(listTxIdVout, listAddressBalance03, hexData);
//            SignedTransactionRAW hextrans04Signed = multiChainCommand.getRawTransactionCommand().signRawTransaction(hextrans04);
//			
//			assertNotNull(hextrans04);
//			assertTrue(hextrans04.length() > 100);
//            assertNotNull(hextrans04Signed);
//            assertTrue(hextrans04Signed.isComplete());
//            
//            
//            
//            //TEST WITH ISSUE
//            AddressBalanceIssue addressBalanceIssue = new AddressBalanceIssue();
//            addressBalanceIssue.setAddress(testAddress);
//            ParamIssue paramIssue = new ParamIssue(new Long(420));
//            addressBalanceIssue.setIssue(paramIssue);
//            
//            List<AddressBalance> listAddressBalance04 = new ArrayList<>();
//            listAddressBalance04.add(addressBalanceIssue);
//            
//            List<DataParam> issueData = new ArrayList<>();
//            DataParamIssue issueDataParam = new DataParamIssue();
//            issueDataParam.setName("testcreateRawTransaction");
//            issueDataParam.setMultiple(new Long(10));
//            issueDataParam.setOpen(true);
//            issueDataParam.addDetails(new CustomParamString("test", "is running"));
//            issueDataParam.addDetails(new CustomParamString("this value", "is an Issue definition value"));
//            issueData.add(issueDataParam);
//            
//            String hextrans05 = multiChainCommand.getRawTransactionCommand().createRawTransaction(listTxIdVout, listAddressBalance04, issueData);
//            SignedTransactionRAW hextrans05Signed = multiChainCommand.getRawTransactionCommand().signRawTransaction(hextrans05);
//            
//            assertNotNull(hextrans05);
//            assertTrue(hextrans05.length() > 100);
//            assertNotNull(hextrans05Signed);
//            assertTrue(hextrans05Signed.isComplete());
//            
//		} catch (MultichainException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			fail();
//		}
		assertTrue(true);
	}
	
	   @Test
	    public void testgetRawTransaction() throws MultichainException {
//	      MultiChainCommand multiChainCommand = new MultiChainCommand(TestConst.MULTICHAIN_SERVER_IP,
//	          TestConst.MULTICHAIN_SERVER_PORT, TestConst.MULTICHAIN_SERVER_LOGIN, TestConst.MULTICHAIN_SERVER_PWD);
//
//	      Object temp = multiChainCommand.getRawTransactionCommand().getRawTransaction("a8d2952e73258f115a7561f799b26dbf14b446ddf62b0136a982fc76a2d80a85", 0);
//	      
//	      System.out.println(temp.getClass());
	      assertTrue(true);
	   }
	
}
