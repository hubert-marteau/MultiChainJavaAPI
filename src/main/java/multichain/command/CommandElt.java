/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

import java.util.HashMap;
import multichain.object.AddedNodeInfo;
import multichain.object.Address;
import multichain.object.AddressReceived;
import multichain.object.AssetInfo;
import multichain.object.AssetTransaction;
import multichain.object.BalanceAsset;
import multichain.object.BalanceAssetGeneral;
import multichain.object.Block;
import multichain.object.BlockTemplate;
import multichain.object.BlockchainInfo;
import multichain.object.ChainTip;
import multichain.object.ChunkqueueInfo;
import multichain.object.ChunkqueueTotal;
import multichain.object.KeyPairs;
import multichain.object.LastBlockInfo;
import multichain.object.MemPoolInfo;
import multichain.object.MiningInfo;
import multichain.object.MultiBalance;
import multichain.object.MultisigAddress;
import multichain.object.NetTotals;
import multichain.object.NetworkInfo;
import multichain.object.PeerInfo;
import multichain.object.Permission;
import multichain.object.Publisher;
import multichain.object.RawMemPoolTransaction;
import multichain.object.RuntimeParams;
import multichain.object.Script;
import multichain.object.SignedTransactionRAW;
import multichain.object.SinceBlock;
import multichain.object.Stream;
import multichain.object.StreamKey;
import multichain.object.StreamKeyItem;
import multichain.object.Transaction;
import multichain.object.TransactionCurrency;
import multichain.object.TransactionRAW;
import multichain.object.TransactionWallet;
import multichain.object.TxIdVout;
import multichain.object.TxOut;
import multichain.object.TxOutInfo;
import multichain.object.Unspent;
import multichain.object.WalletInfo;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.1
 */
public enum CommandElt {
  ADDMULTISIGADDRESS("addmultisigaddress", null, new Class<?>[] {String.class}),
  ADDNODE("addnode", null, null),
  APPENDBINARYCACHE("appendbinarycache", null, new Class<?>[] {Long.class}),
  APPENDRAWCHANGE("appendrawchange", null, new Class<?>[] {String.class}),
  APPENDRAWDATA("appendrawdata", null, new Class<?>[] {String.class}),
  APPENDRAWEXCHANGE("appendrawexchange", null, new Class<?>[] {SignedTransactionRAW.class}),
  APPENDRAWTRANSACTION("appendrawtransaction", null,
      new Class<?>[] {String.class, SignedTransactionRAW.class}),
  APPROVEFROM("approvefrom", null, new Class<?>[] {String.class}),
  BACKUPWALLET("backupwallet", null, null),
  CLEARMEMPOOL("clearmempool", null, null),
  COMBINEUNSPENT("combineunspent", null, new Class<?>[] {String.class}, true),
  COMPLETERAWEXCHANGE("completerawexchange", null, new Class<?>[] {String.class}),
  CREATE("create", null, new Class<?>[] {String.class}),
  CREATEBINARYCACHE("createbinarycache", null, new Class<?>[] {String.class}),
  CREATEFROM("createfrom", null, new Class<?>[] {String.class}),
  CREATEKEYPAIRS("createkeypairs", null, new Class<?>[] {KeyPairs.class}, true),
  CREATEMULTISIG("createmultisig", null, new Class<?>[] {MultisigAddress.class}),
  CREATERAWEXCHANGE("createrawexchange", null, new Class<?>[] {String.class}),
  CREATERAWSENDFROM("createrawsendfrom", null,
      new Class<?>[] {String.class, SignedTransactionRAW.class}),
  CREATERAWTRANSACTION("createrawtransaction", null,
      new Class<?>[] {String.class, SignedTransactionRAW.class}),
  DECODERAWEXCHANGE("decoderawexchange"),
  DECODERAWTRANSACTION("decoderawtransaction", null, new Class<?>[] {TransactionRAW.class}),
  DECODESCRIPT("decodescript", null, new Class<?>[] {Script.class}),
  DELETEBINARYCACHE("deletebinarycache", null, null),
  DISABLERAWTRANSACTION("disablerawtransaction", null, new Class<?>[] {String.class}),
  DUMPPRIVKEY("dumpprivkey", null, new Class<?>[] {String.class}),
  DUMPWALLET("dumpwallet", null, null),
  ENCRYPTWALLET("encryptwallet", null, null),
  ESTIMATEFEE("estimatefee", null, new Class<?>[] {Long.class}),
  ESTIMATEPRIORITY("estimatepriority", null, new Class<?>[] {Long.class}),
  GETACCOUNT("getaccount", null, new Class<?>[] {String.class}),
  GETACCOUNTADDRESS("getaccountaddress", null, new Class<?>[] {String.class}),
  GETADDEDNODEINFO("getaddednodeinfo", null, new Class<?>[] {AddedNodeInfo.class}, true),
  GETADDRESSBALANCES("getaddressbalances", null, new Class<?>[] {BalanceAssetGeneral.class}, true),
  GETADDRESSES("getaddresses", null, new Class<?>[] {String.class, Address.class}, true),
  GETADDRESSESBYACCOUNT("getaddressesbyaccount", null, new Class<?>[] {String.class}, true),
  GETADDRESSTRANSACTION("getaddresstransaction", null, new Class<?>[] {TransactionWallet.class}),
  GETASSETBALANCES("getassetbalances", null, new Class<?>[] {BalanceAsset.class}, true),
  GETASSETINFO("getassetinfo", null, new Class<?>[] {AssetInfo.class}),
  GETASSETTRANSACTION("getassettransaction", null, new Class<?>[] {TransactionWallet.class}),
  GETBALANCE("getbalance", null, new Class<?>[] {Double.class}),
  GETBESTBLOCKHASH("getbestblockhash", null, new Class<?>[] {String.class}),
  GETBLOCK("getblock", null, new Class<?>[] {Block.class}),
  GETBLOCKCHAININFO("getblockchaininfo", null, new Class<?>[] {BlockchainInfo.class}),
  GETBLOCKCHAINPARAMS("getblockchainparams", null,
      new Class<?>[] {(new HashMap<String, String>()).getClass()}),
  GETBLOCKCOUNT("getblockcount", null, new Class<?>[] {Long.class}),
  GETBLOCKHASH("getblockhash", null, new Class<?>[] {String.class}),
  GETBLOCKTEMPLATE("getblocktemplate", null, new Class<?>[] {BlockTemplate.class}),
  GETCHAINTIPS("getchaintips", null, new Class<?>[] {ChainTip.class}, true),
  GETCHUNKQUEUEINFO("getchunkqueueinfo", null, new Class<?>[] {ChunkqueueInfo.class}),
  GETCHUNKQUEUETOTALS("getchunkqueuetotals", null, new Class<?>[] {ChunkqueueTotal.class}),
  GETCONNECTIONCOUNT("getconnectioncount", null, new Class<?>[] {Long.class}),
  GETDIFFICULTY("getdifficulty", null, new Class<?>[] {Double.class}),
  GETFILTERCODE("getfiltercode", null, new Class<?>[] {String.class}),
  GETGENERATE("getgenerate", null, new Class<?>[] {Boolean.class}),
  GETHASHESPERSEC("gethashespersec", null, new Class<?>[] {Long.class}),
  GETINFO("getinfo", null, new Class<?>[] {(new HashMap<String, Object>()).getClass()}),
  GETLASTBLOCKINFO("getlastblockinfo", null, new Class<?>[] {LastBlockInfo.class}),
  GETMEMPOOLINFO("getmempoolinfo", null, new Class<?>[] {MemPoolInfo.class}),
  GETMININGINFO("getmininginfo", null, new Class<?>[] {MiningInfo.class}),
  GETMULTIBALANCES("getmultibalances", null, new Class<?>[] {MultiBalance.class}),
  GETNETTOTALS("getnettotals", null, new Class<?>[] {NetTotals.class}),
  GETNETWORKHASHPS("getnetworkhashps", null, new Class<?>[] {Long.class}),
  GETNETWORKINFO("getnetworkinfo", null, new Class<?>[] {NetworkInfo.class}),
  GETNEWADDRESS("getnewaddress", null, new Class<?>[] {String.class}),
  GETPEERINFO("getpeerinfo", null, new Class<?>[]{PeerInfo.class}, true),
  GETRAWCHANGEADDRESS("getrawchangeaddress", null, new Class<?>[] {String.class}),
  GETRAWMEMPOOL("getrawmempool", null,
      new Class<?>[] {String.class, (new HashMap<String, RawMemPoolTransaction>()).getClass()},
      true),
  GETRAWTRANSACTION("getrawtransaction", null, new Class<?>[] {String.class, TransactionRAW.class}),
  GETRECEIVEDBYACCOUNT("getreceivedbyaccount", null, new Class<?>[] {Double.class}),
  GETRECEIVEDBYADDRESS("getreceivedbyaddress", null, new Class<?>[] {Double.class}),
  GETRUNTIMEPARAMS("getruntimeparams", null, new Class<?>[] {RuntimeParams.class}),
  GETSTREAMINFO("getstreaminfo", null, new Class<?>[] {Stream.class}),
  GETSTREAMITEM("getstreamitem", null, new Class<?>[] {StreamKeyItem.class}),
  GETSTREAMKEYSUMMARY("getstreamkeysummary"),
  GETSTREAMPUBLISHERSUMMARY("getstreampublishersummary"),
  GETTOTALBALANCES("gettotalbalances", null, new Class<?>[] {BalanceAssetGeneral.class}, true),
  GETTRANSACTION("gettransaction", null, new Class<?>[] {Transaction.class}),
  GETTXOUT("gettxout", null, new Class<?>[] {TxOut.class}),
  GETTXOUTDATA("gettxoutdata", null, new Class<?>[] {String.class}),
  GETTXOUTSETINFO("gettxoutsetinfo", null, new Class<?>[] {TxOutInfo.class}),
  GETUNCONFIRMEDBALANCE("getunconfirmedbalance", null, new Class<?>[] {Double.class}),
  GETWALLETINFO("getwalletinfo", null, new Class<?>[] {WalletInfo.class}),
  GETWALLETTRANSACTION("getwallettransaction", null, new Class<?>[] {TransactionWallet.class}),
  GRANT("grant", null, new Class<?>[] {String.class}),
  GRANTFROM("grantfrom", null, new Class<?>[] {String.class}),
  GRANTWITHDATA("grantwithdata", null, new Class<?>[] {String.class}),
  GRANTWITHDATAFROM("grantwithdatafrom", null, new Class<?>[] {String.class}),
  HELP("help", null, new Class<?>[] {String.class}, false),
  IMPORTADDRESS("importaddress", null, null),
  IMPORTPRIVKEY("importprivkey", null, null),
  IMPORTWALLET("importwallet", null, null),
  ISSUE("issue", null, new Class<?>[] {String.class}),
  ISSUEFROM("issuefrom", null, new Class<?>[] {String.class}),
  ISSUEMORE("issuemore", null, new Class<?>[] {String.class}),
  ISSUEMOREFROM("issuemorefrom", null, new Class<?>[] {String.class}),
  KEYPOOLREFILL("keypoolrefill", null, null),
  LISTACCOUNTS("listaccounts", null, new Class<?>[] {Double.class}, true),
  LISTADDRESSES("listaddresses", null, new Class<?>[] {Address.class}, true),
  LISTADDRESSGROUPINGS("listaddressgroupings"),
  LISTADDRESSTRANSACTIONS("listaddresstransactions", null, new Class<?>[] {TransactionWallet.class},
      true),
  LISTASSETS("listassets", null, new Class<?>[] {BalanceAsset.class}, true),
  LISTASSETTRANSACTIONS("listassettransactions", null, new Class<?>[] {AssetTransaction.class},
      true),
  LISTBLOCKS("listblocks", null, new Class<?>[] {Block.class}, true),
  LISTLOCKUNSPENT("listlockunspent", null, new Class<?>[] {TxIdVout.class}, true),
  LISTPERMISSIONS("listpermissions", null, new Class<?>[] {Permission.class}, true),
  LISTRECEIVEDBYACCOUNT("listreceivedbyaccount", null, new Class<?>[] {AddressReceived.class},
      true),
  LISTRECEIVEDBYADDRESS("listreceivedbyaddress", null, new Class<?>[] {AddressReceived.class},
      true),
  LISTSINCEBLOCK("listsinceblock", null, new Class<?>[] {SinceBlock.class}),
  LISTSTREAMBLOCKITEMS("liststreamblockitems", null, new Class<?>[] {StreamKeyItem.class}, true),
  LISTSTREAMFILTERS("liststreamfilters"),
  LISTSTREAMITEMS("liststreamitems", null, new Class<?>[] {StreamKeyItem.class}, true),
  LISTSTREAMKEYITEMS("liststreamkeyitems", null, new Class<?>[] {StreamKeyItem.class}, true),
  LISTSTREAMKEYS("liststreamkeys", null, new Class<?>[] {StreamKey.class}, true),
  LISTSTREAMPUBLISHERITEMS("liststreampublisheritems", null, new Class<?>[] {StreamKeyItem.class},
      true),
  LISTSTREAMPUBLISHERS("liststreampublishers", null, new Class<?>[] {Publisher.class}, true),
  LISTSTREAMQUERYITEMS("liststreamqueryitems"),
  LISTSTREAMS("liststreams", null, new Class<?>[] {Stream.class}, true),
  LISTSTREAMTXITEMS("liststreamtxitems", null, new Class<?>[] {StreamKeyItem.class}, true),
  LISTTRANSACTIONS("listtransactions", null, new Class<?>[] {TransactionCurrency.class}, true),
  LISTTXFILTERS("listtxfilters"),
  LISTUNSPENT("listunspent", null, new Class<?>[] {Unspent.class}, true),
  LISTUPGRADES("listupgrades", null, null, true),
  LISTWALLETTRANSACTIONS("listwallettransactions", null, new Class<?>[] {TransactionWallet.class},
      true),
  LOCKUNSPENT("lockunspent", null, new Class<?>[] {Boolean.class}),
  MOVE("move", null, new Class<?>[] {Boolean.class}),
  PAUSE("pause", null, null),
  PING("ping", null, null),
  PREPARELOCKUNSPENT("preparelockunspent", null, new Class<?>[] {TxIdVout.class}),
  PREPARELOCKUNSPENTFROM("preparelockunspentfrom", null, new Class<?>[] {TxIdVout.class}),
  PRIORITISETRANSACTION("prioritisetransaction", null, new Class<?>[] {Boolean.class}),
  PUBLISH("publish", null, new Class<?>[] {String.class}),
  PUBLISHFROM("publishfrom", null, new Class<?>[] {String.class}),
  PUBLISHMULTI("publishmulti", null, new Class<?>[] {String.class}),
  PUBLISHMULTIFROM("publishmultifrom", null, new Class<?>[] {String.class}),
  RESENDWALLETTRANSACTIONS("resendwallettransactions"),
  RESUME("resume", null, null),
  REVOKE("revoke", null, new Class<?>[] {String.class}),
  REVOKEFROM("revokefrom", null, new Class<?>[] {String.class}),
  RUNSTREAMFILTER("runstreamfilter"),
  RUNTXFILTER("runtxfilter"),
  SEND("send", null, new Class<?>[] {String.class}),
  SENDASSET("sendasset", null, new Class<?>[] {String.class}),
  SENDASSETFROM("sendassetfrom", null, new Class<?>[] {String.class}),
  SENDFROM("sendfrom", null, new Class<?>[] {String.class}),
  SENDFROMACCOUNT("sendfromaccount", null, new Class<?>[] {String.class}),
  SENDMANY("sendmany", null, new Class<?>[] {String.class}),
  SENDRAWTRANSACTION("sendrawtransaction", null, new Class<?>[] {String.class}),
  SENDWITHDATA("sendwithdata", null, new Class<?>[] {String.class}),
  SENDWITHDATAFROM("sendwithdatafrom", null, new Class<?>[] {String.class}),
  SETACCOUNT("setaccount"),
  SETGENERATE("setgenerate"),
  SETLASTBLOCK("setlastblock", null, new Class<?>[] {String.class}),
  SETRUNTIMEPARAM("setruntimeparam"),
  SETTXFEE("settxfee", null, new Class<?>[] {Boolean.class}),
  SIGNMESSAGE("signmessage", null, new Class<?>[] {String.class}),
  SIGNRAWTRANSACTION("signrawtransaction", null, new Class<?>[] {SignedTransactionRAW.class}),
  STOP("stop"),
  SUBMITBLOCK("submitblock"),
  SUBSCRIBE("subscribe"),
  TESTSTREAMFILTER("teststreamfilter"),
  TESTTXFILTER("testtxfilter"),
  UNSUBSCRIBE("unsubscribe"),
  VALIDATEADDRESS("validateaddress", null, new Class<?>[] {Address.class}),
  VERIFYCHAIN("verifychain", null, new Class<?>[] {Boolean.class}),
  VERIFYMESSAGE("verifymessage", null, new Class<?>[] {Boolean.class}),
  VERIFYPERMISSION("verifypermission", null, new Class<?>[] {Boolean.class}),
  WALLETLOCK("walletlock"),
  WALLETPASSPHRASE("walletpassphrase"),
  WALLETPASSPHRASECHANGE("walletpassphrasechange");

  String commandline;
  Object commandParameters; // Will be defined in 6.02
  Class<?>[] returnedClass;
  boolean resultByList = false;

  private CommandElt(String commandline) {
    this.commandline = commandline;
  }

  private CommandElt(String commandline, Object commandParameters) {
    this.commandline = commandline;
    this.commandParameters = commandParameters;
  }

  private CommandElt(String commandline, Object commandParameters, Class<?>[] returnedClass) {
    this.commandline = commandline;
    this.commandParameters = commandParameters;
    this.returnedClass = returnedClass;
  }

  private CommandElt(String commandline, Object commandParameters, Class<?>[] returnedClass,
      boolean resultByList) {
    this.commandline = commandline;
    this.commandParameters = commandParameters;
    this.returnedClass = returnedClass;
    this.resultByList = resultByList;
  }

  /**
   * @return the commandline
   */
  public String getCommandline() {
    return commandline;
  }

  /**
   * @return the returnClass
   */
  public Class<?>[] getReturnedClass() {
    return returnedClass;
  }

  /**
   * @return the commandArguments
   */
  public Object getCommandParameters() {
    return commandParameters;
  }

  /**
   * @return the resultByList
   */
  public boolean isResultByList() {
    return resultByList;
  }

}
