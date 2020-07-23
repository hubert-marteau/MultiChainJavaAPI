/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import multichain.command.CommandElt;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.1
 */
public class GenericOutputFormatterTest {

  @SuppressWarnings("unchecked")
@Test
  public void testFormatBlock() {
    String blockJsonValue =
        "{\"hash\": \"00cd11ab4a7146236595c29f52a874521845cb2a417da4e938266e1a3a1f3bb2\","
            + "\"miner\": \"13SKg7Qw7UxPWvjDMkskyvKU7HfM9mz1KHi43E\"," + "\"confirmations\": 235,"
            + "\"size\": 241," + "\"height\": 0," + "\"version\": 1,"
            + "\"merkleroot\": \"428c3d6b97720175dba80c893ec97407522f564af5665ecff0684cd8d74eae6e\","
            + "\"tx\": [" + "  \"428c3d6b97720175dba80c893ec97407522f564af5665ecff0684cd8d74eae6e\""
            + "]," + "\"time\": 1543504235," + "\"nonce\": 97," + "\"bits\": \"2000ffff\","
            + "\"difficulty\": 5.96046447753906E-8,"
            + "\"chainwork\": \"0000000000000000000000000000000000000000000000000000000000000100\","
            + "\"nextblockhash\": \"0074f303c0b50dcf4a0f8e48840c14af9dd5666f5f953b154b9d7d2549ea02f9\""
            + "}";

    Class<?>[] returnedTypes = CommandElt.GETBLOCK.getReturnedClass();
    LinkedTreeMap<String, Object> linkedTreeMapValue =
        new Gson().fromJson(blockJsonValue, LinkedTreeMap.class);

    Object returnedValue = GenericOutputFormatter.format(linkedTreeMapValue, returnedTypes);

    System.out.println(returnedValue);
    System.out.println(returnedValue.getClass());

    Assert.assertNotNull(returnedValue);

  }

@SuppressWarnings("rawtypes")
@Test
  public void testFormatAddressesSimple() {
    String addresseJsonValue01 = "\"11ADDRESSE01ADDRESSE01ADDRESSE01111111\"";
    String addresseJsonValue02 = "\"22ADDRESSE02ADDRESSE02ADDRESSE02222222\"";
    String addresseJsonValue03 = "\"33ADDRESSE03ADDRESSE03ADDRESSE03333333\"";
    String addresseJsonValue04 = "\"44ADDRESSE04ADDRESSE04ADDRESSE04444444\"";

    Class<?>[] returnedTypes = CommandElt.GETADDRESSES.getReturnedClass();
    String linkedTreeMapValue1 = new Gson().fromJson(addresseJsonValue01, String.class);
    String linkedTreeMapValue2 = new Gson().fromJson(addresseJsonValue02, String.class);
    String linkedTreeMapValue3 = new Gson().fromJson(addresseJsonValue03, String.class);
    String linkedTreeMapValue4 = new Gson().fromJson(addresseJsonValue04, String.class);

    List<String> listLinkedTreeMap = new ArrayList<>();
    listLinkedTreeMap.add(linkedTreeMapValue1);
    listLinkedTreeMap.add(linkedTreeMapValue2);
    listLinkedTreeMap.add(linkedTreeMapValue3);
    listLinkedTreeMap.add(linkedTreeMapValue4);

    Object returnedValue = GenericOutputFormatter.formatList(listLinkedTreeMap, returnedTypes);

    System.out.println(returnedValue);
    System.out.println(returnedValue.getClass());
    if (ArrayList.class.isInstance(returnedValue) && returnedValue != null
        && ((ArrayList) returnedValue).size() > 0) {
      System.out.println(((ArrayList) returnedValue).get(0).getClass());
    }

    Assert.assertNotNull(returnedValue);

  }


  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Test
  public void testFormatAddressesVerbose() {
    String addresseJsonValue01 =
        "{\"address\": \"11ADDRESSE01ADDRESSE01ADDRESSE01111111\",\"ismine\": true,"
            + "\"iswatchonly\": false,\"isscript\": false,"
            + "\"pubkey\": \"000011ADDRESSE01ADDRESSE01ADDRESSE01111111ADRESSE01ADDRESSE0111111\","
            + "\"iscompressed\": true,\"account\": \"adresse01\"}";
    String addresseJsonValue02 =
        "{\"address\": \"22ADDRESSE02ADDRESSE02ADDRESSE02222222\",\"ismine\": true,"
            + "\"iswatchonly\": false,\"isscript\": false,"
            + "\"pubkey\": \"000022ADDRESSE02ADDRESSE02ADDRESSE02222222ADRESSE02ADDRESSE0222222\","
            + "\"iscompressed\": true,\"account\": \"adresse02\"}";
    String addresseJsonValue03 =
        "{\"address\": \"33ADDRESSE03ADDRESSE03ADDRESSE03333333\",\"ismine\": true,"
            + "\"iswatchonly\": false,\"isscript\": false,"
            + "\"pubkey\": \"000033ADDRESSE03ADDRESSE03ADDRESSE03333333ADRESSE03ADDRESSE0333333\","
            + "\"iscompressed\": true,\"account\": \"adresse03\"}";
    String addresseJsonValue04 =
        "{\"address\": \"44ADDRESSE04ADDRESSE04ADDRESSE04444444\",\"ismine\": true,"
            + "\"iswatchonly\": false,\"isscript\": false,"
            + "\"pubkey\": \"000044ADDRESSE04ADDRESSE04ADDRESSE04444444ADRESSE04ADDRESSE0444444\","
            + "\"iscompressed\": true,\"account\": \"adresse04\"}";

    Class<?>[] returnedTypes = CommandElt.GETADDRESSES.getReturnedClass();
    LinkedTreeMap<String, Object> linkedTreeMapValue1 =
        new Gson().fromJson(addresseJsonValue01, LinkedTreeMap.class);
    LinkedTreeMap<String, Object> linkedTreeMapValue2 =
        new Gson().fromJson(addresseJsonValue02, LinkedTreeMap.class);
    LinkedTreeMap<String, Object> linkedTreeMapValue3 =
        new Gson().fromJson(addresseJsonValue03, LinkedTreeMap.class);
    LinkedTreeMap<String, Object> linkedTreeMapValue4 =
        new Gson().fromJson(addresseJsonValue04, LinkedTreeMap.class);

    List<LinkedTreeMap<String, Object>> listLinkedTreeMap = new ArrayList<>();
    listLinkedTreeMap.add(linkedTreeMapValue1);
    listLinkedTreeMap.add(linkedTreeMapValue2);
    listLinkedTreeMap.add(linkedTreeMapValue3);
    listLinkedTreeMap.add(linkedTreeMapValue4);

    Object returnedValue = GenericOutputFormatter.formatList(listLinkedTreeMap, returnedTypes);

    System.out.println(returnedValue);
    System.out.println(returnedValue.getClass());
    if (ArrayList.class.isInstance(returnedValue) && returnedValue != null
        && ((ArrayList) returnedValue).size() > 0) {
      System.out.println(((ArrayList) returnedValue).get(0).getClass());
    }

    Assert.assertNotNull(returnedValue);

  }



}
