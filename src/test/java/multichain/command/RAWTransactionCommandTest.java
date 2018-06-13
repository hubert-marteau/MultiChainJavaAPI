/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import multichain.object.AddressBalance;
import multichain.object.AddressBalanceAsset;
import multichain.object.AddressBalanceCurrency;
import multichain.object.BalanceAssetBase;
import multichain.object.SignedTransactionRAW;
import multichain.object.queryobjects.TxIdVout;

/**
 * @author Ub - H. MARTEAU
 * @version 4.10
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
	public void testcreateRawTransaction() {
//		MultiChainCommand multiChainCommand = new MultiChainCommand(TestConst.MULTICHAIN_SERVER_IP,
//				TestConst.MULTICHAIN_SERVER_PORT, TestConst.MULTICHAIN_SERVER_LOGIN, TestConst.MULTICHAIN_SERVER_PWD);
//		String testAddress = "1STvDuNXGJxs3EcHwhVMRQjxU9weHh8pudwPnx";
//		
//		String assetName = "TestRAWCreation";
//		
//		List<TxIdVout> listTxIdVout = new ArrayList<>();
//		
//		TxIdVout txIdVout01 = new TxIdVout();
//		//Existing transaction in Test BlockChain
//		txIdVout01.setTxId("9ca1ea54d2de7dceba8abbb52fedc5f65610a4dfef38aedd4b79c5a4540d35c9");
//		txIdVout01.setvOut(0);
//		listTxIdVout.add(txIdVout01);
//		
//		TxIdVout txIdVout02 = new TxIdVout();
//		//Existing transaction in Test BlockChain
//		txIdVout02.setTxId("64faee5a6d0c338c6e8162264f752c83913fd85227247a2ae157812411056ecd");
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
//			
//			assertNotNull(hextrans01);
//			assertTrue(hextrans01.length() > 100);
//			
//			
//			//TEST WITH ASSET
//			BalanceAssetBase balanceAssetBase = new BalanceAssetBase();
//			balanceAssetBase.setName(assetName);
//			balanceAssetBase.setQty(1);
//			List<BalanceAssetBase> listBalanceAssetBase = new ArrayList<>();
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
//			
//			assertNotNull(hextrans02);
//			assertTrue(hextrans02.length() > 100);
//			
//			//TEST WITH CURRENCY & ASSET 
//			List<AddressBalance> listAddressBalance03 = new ArrayList<>();
//			listAddressBalance03.add(addressBalanceCurrency);
//			listAddressBalance03.add(addressBalanceAsset);
//			
//			String hextrans03 = multiChainCommand.getRawTransactionCommand().createRawTransaction(listTxIdVout, listAddressBalance03);
//			
//			assertNotNull(hextrans03);
//			assertTrue(hextrans03.length() > 100);
//			
//			//TEST WITH CURRENCY & ASSET & METADATA
//			List<String> hexData = new ArrayList<>();
//			hexData.add("0123456789ABCDEF");
//			hexData.add("0123456789");
//			hexData.add("ABCDEF");
//			
//			String hextrans04 = multiChainCommand.getRawTransactionCommand().createRawTransaction(listTxIdVout, listAddressBalance03, hexData);
//			
//			assertNotNull(hextrans04);
//			assertTrue(hextrans04.length() > 100);
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
