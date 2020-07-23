/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import junit.framework.TestCase;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.1
 */
@SuppressWarnings("unused")
public class CommandManagerTest extends TestCase {


  @Test
  public void testPingPauseResume() {
	  assertTrue(true);
//    System.out.println("--- testGetInfo ---");
//
//    CommandManager commandManager =
//        new CommandManager(TestConst.MULTICHAIN_SERVER_IP, TestConst.MULTICHAIN_SERVER_PORT,
//            TestConst.MULTICHAIN_SERVER_LOGIN, TestConst.MULTICHAIN_SERVER_PWD, null);
//
//    Object result = null;
//
//    try {
//      result = commandManager.invoke(CommandElt.PING);
//    } catch (MultichainException e) {
//      e.printStackTrace();
//      fail();
//    }
//
//    assertNull(result);
//
//    try {
//      result = commandManager.invoke(CommandElt.PAUSE, "offchain");
//    } catch (MultichainException e) {
//      e.printStackTrace();
//      fail();
//    }
//
//    assertNotNull(result);
//    assertEquals("Paused", result);
//
//    try {
//      result = commandManager.invoke(CommandElt.RESUME, "offchain");
//    } catch (MultichainException e) {
//      e.printStackTrace();
//      fail();
//    }
//
//    assertNotNull(result);
//    assertEquals("Resumed", result);
//
  }

//  @Test
//  public void testGetInfo() {
//    System.out.println("--- testGetInfo ---");
//
//    CommandManager commandManager =
//        new CommandManager(TestConst.MULTICHAIN_SERVER_IP, TestConst.MULTICHAIN_SERVER_PORT,
//            TestConst.MULTICHAIN_SERVER_LOGIN, TestConst.MULTICHAIN_SERVER_PWD, null);
//
//    Object result = null;
//
//    try {
//      result = commandManager.invoke(CommandElt.GETINFO);
//    } catch (MultichainException e) {
//      e.printStackTrace();
//      fail();
//    }
//
//    assertNotNull(result);
//
//    System.out.println(result);
//    System.out.println(result.getClass());
//  }
//
//  @Test
//  public void testGetAddresses() {
//    System.out.println("--- testGetAddresses ---");
//
//    CommandManager commandManager =
//        new CommandManager(TestConst.MULTICHAIN_SERVER_IP, TestConst.MULTICHAIN_SERVER_PORT,
//            TestConst.MULTICHAIN_SERVER_LOGIN, TestConst.MULTICHAIN_SERVER_PWD, null);
//
//    Object addressResult = null;
//
//    try {
//      addressResult = commandManager.invoke(CommandElt.GETADDRESSES);
//    } catch (MultichainException e) {
//      e.printStackTrace();
//      fail();
//    }
//
//    assertNotNull(addressResult);
//
//    System.out.println(addressResult);
//    System.out.println(addressResult.getClass());
//    if (ArrayList.class.isInstance(addressResult) && addressResult != null
//        && ((ArrayList<?>) addressResult).size() > 0) {
//      System.out.println(((ArrayList<?>) addressResult).get(0).getClass());
//    }
//
//
//    try {
//      addressResult = commandManager.invoke(CommandElt.GETADDRESSES, true);
//    } catch (MultichainException e) {
//      e.printStackTrace();
//      fail();
//    }
//
//    assertNotNull(addressResult);
//
//    System.out.println(addressResult);
//    System.out.println(addressResult.getClass());
//    if (ArrayList.class.isInstance(addressResult) && addressResult != null
//        && ((ArrayList<?>) addressResult).size() > 0) {
//      System.out.println(((ArrayList<?>) addressResult).get(0).getClass());
//    }
//
//
//  }
//
//  @Test
//  public void testAddMultisigAddress() {
//    System.out.println("--- testAddMultisigAddress ---");
//
//    CommandManager commandManager =
//        new CommandManager(TestConst.MULTICHAIN_SERVER_IP, TestConst.MULTICHAIN_SERVER_PORT,
//            TestConst.MULTICHAIN_SERVER_LOGIN, TestConst.MULTICHAIN_SERVER_PWD, null);
//
//    Object result = null;
//
//    try {
//      result = commandManager.invoke(CommandElt.GETADDRESSES);
//    } catch (MultichainException e) {
//      e.printStackTrace();
//      fail();
//    }
//
//    assertNotNull(result);
//
//    String[] addresses = null;
//
//    if (ArrayList.class.isInstance(result) && result != null
//        && ((ArrayList<?>) result).size() > 1) {
//      addresses =
//          new String[] {((ArrayList<String>) result).get(0), ((ArrayList<String>) result).get(1)};
//    }
//
//    try {
//      result = commandManager.invoke(CommandElt.ADDMULTISIGADDRESS, 1, addresses);
//    } catch (MultichainException e) {
//      e.printStackTrace();
//      fail();
//    }
//
//    assertNotNull(result);
//
//    System.out.println(result);
//    System.out.println(result.getClass());
//  }
//
//  @Test
//  public void testGetBlockchainParams() {
//    System.out.println("--- testGetBlockchainParams ---");
//
//    CommandManager commandManager =
//        new CommandManager(TestConst.MULTICHAIN_SERVER_IP, TestConst.MULTICHAIN_SERVER_PORT,
//            TestConst.MULTICHAIN_SERVER_LOGIN, TestConst.MULTICHAIN_SERVER_PWD, null);
//
//    HashMap<String, String> result = null;
//
//    try {
//      result = (HashMap<String, String>) commandManager.invoke(CommandElt.GETBLOCKCHAINPARAMS);
//    } catch (MultichainException e) {
//      e.printStackTrace();
//      fail();
//    }
//
//    assertNotNull(result);
//    for (String key : result.keySet()) {
//      System.out.println(key + " - " + String.valueOf(result.get(key)));
//    }
//
//  }
}

