/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command.builders;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.entity.StringEntity;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import multichain.command.MultichainException;
import multichain.command.tools.MultichainTestParameter;
import multichain.object.BalanceAssetGeneral;
import multichain.object.formatters.HexFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 4.13
 */
public class QueryBuilderWalletTransaction extends QueryBuilderCommon {
	/**
	 * 
	 * getaddresstransaction "address" "txid" ( verbose)
	 * 
	 * Get detailed information about in-wallet transaction <txid>
	 * 
	 * Arguments: 1. "address" (string, required) Address used for balance
	 * calculation. 2. "txid" (string, required) The transaction id 3. verbose
	 * (bool, optional, default=false) If true, returns detailed array of inputs
	 * and outputs and raw hex of transactions
	 * 
	 * Result: [ { "balance": {...}, (object) Changes in address balance. {
	 * "amount": x.xxx, (numeric) The amount in native currency. Negative value
	 * means amount was send by the wallet, positive - received "assets": {...},
	 * (object) Changes in asset amounts. } "myaddresses": [...], (array)
	 * Address passed as parameter "addresses": [...], (array) Array of
	 * counterparty addresses involved in transaction "permissions": [...],
	 * (array) Changes in permissions "issue": {...}, (object) Issue details
	 * "data" : "metadata", (array) Hexadecimal representation of metadata
	 * appended to the transaction "confirmations": n, (numeric) The number of
	 * confirmations for the transaction. Available for 'send' and 'receive'
	 * category of transactions. "blockhash": "hashvalue",(string) The block
	 * hash containing the transaction. Available for 'send' and 'receive'
	 * category of transactions. "blockindex": n, (numeric) The block index
	 * containing the transaction. Available for 'send' and 'receive' category
	 * of transactions. "txid": "transactionid", (string) The transaction id.
	 * Available for 'send' and 'receive' category of transactions. "time": xxx,
	 * (numeric) The transaction time in seconds since epoch (midnight Jan 1
	 * 1970 GMT). "timereceived": xxx, (numeric) The time received in seconds
	 * since epoch (midnight Jan 1 1970 GMT). Available for 'send' and 'receive'
	 * category of transactions. "comment": "...", (string) If a comment is
	 * associated with the transaction. "vin": [...], (array) If verbose=true.
	 * Array of input details "vout": [...], (array) If verbose=true. Array of
	 * output details "hex" : "data" (string) If verbose=true. Raw data for
	 * transaction } ]
	 * 
	 * Lists information about the 10 most recent transactions related to
	 * address in this node’s wallet, including how they affected that address’s
	 * balance.
	 * 
	 * @param address
	 * @return
	 * @throws MultichainException
	 */
	protected Object executeGetAddressTransaction(String address, String txid, boolean verbose) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		MultichainTestParameter.isNotNullOrEmpty("txid", txid);
		return execute(CommandEnum.GETADDRESSTRANSACTION, address, txid, verbose);
	}

	/**
	 * gettransaction "txid" ( includeWatchonly )
	 * 
	 * Get detailed information about in-wallet transaction <txid>
	 * 
	 * Arguments: 1. "txid" (string, required) The transaction id 2.
	 * "includeWatchonly" (bool, optional, default=false) Whether to include
	 * watchonly addresses in balance calculation and details[]
	 * 
	 * Result: { "amount" : x.xxx, (numeric) The transaction amount in native
	 * currency "confirmations" : n, (numeric) The number of confirmations
	 * "blockhash" : "hash", (string) The block hash "blockindex" : xx,
	 * (numeric) The block index "blocktime" : ttt, (numeric) The time in
	 * seconds since epoch (1 Jan 1970 GMT) "txid" : "transactionid", (string)
	 * The transaction id. "time" : ttt, (numeric) The transaction time in
	 * seconds since epoch (1 Jan 1970 GMT) "timereceived" : ttt, (numeric) The
	 * time received in seconds since epoch (1 Jan 1970 GMT) "details" : [ {
	 * "account" : "accountname", (string) The account name involved in the
	 * transaction, can be "" for the default account. "address" : "address",
	 * (string) The address involved in the transaction "category" :
	 * "send|receive", (string) The category, either 'send' or 'receive'
	 * "amount" : x.xxx (numeric) The amount in native currency "vout" : n,
	 * (numeric) the vout value } ,... ], "hex" : "data" (string) Raw data for
	 * transaction }
	 * 
	 * @param txid
	 * @param includeWatchonly
	 * @return
	 * @throws MultichainException
	 */
	protected Object executeGetTransaction(String txid, boolean includeWatchonly) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("txid", txid);
		return execute(CommandEnum.GETTRANSACTION, txid, includeWatchonly);
	}

	/**
	 * 
	 * gettxout "txid" n ( includemempool )
	 * 
	 * Returns details about an unspent transaction output.
	 * 
	 * Arguments: 1. "txid" (string, required) The transaction id 2. n (numeric,
	 * required) vout value 3. includemempool (boolean, optional) Whether to
	 * included the mem pool
	 * 
	 * Result: { "bestblock" : "hash", (string) the block hash "confirmations" :
	 * n, (numeric) The number of confirmations "value" : x.xxx, (numeric) The
	 * transaction value in btc "scriptPubKey" : { (json object) "asm" : "code",
	 * (string) "hex" : "hex", (string) "reqSigs" : n, (numeric) Number of
	 * required signatures "type" : "pubkeyhash", (string) The type, eg
	 * pubkeyhash "addresses" : [ (array of string) array of addresses "address"
	 * (string) address ,... ] }, "version" : n, (numeric) The version
	 * "coinbase" : true|false (boolean) Coinbase or not }
	 * 
	 * Returns details about an unspent transaction output vout of txid.
	 * 
	 * @param txid
	 * @param vout
	 * @return
	 * @throws MultichainException
	 */
	protected Object executeGetTxOut(String txid, int vout, boolean includemempool) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("txid", txid);
		MultichainTestParameter.valueIsNotNegative("vout", vout);
		return execute(CommandEnum.GETTXOUT, txid, vout, includemempool);
	}

	/**
	 * 
	 * getwallettransaction "txid" ( includeWatchonly verbose)
	 * 
	 * Get detailed information about in-wallet transaction <txid>
	 * 
	 * Arguments: 1. "txid" (string, required) The transaction id 2.
	 * "includeWatchonly" (bool, optional, default=false) Whether to include
	 * watchonly addresses in balance calculation and details[] 3. verbose
	 * (bool, optional, default=false) If true, returns detailed array of inputs
	 * and outputs and raw hex of transactions
	 * 
	 * Result: [ { "balance": {...}, (object) Changes in wallet balance. {
	 * "amount": x.xxx, (numeric) The amount in native currency. Negative value
	 * means amount was send by the wallet, positive - received "assets": {...},
	 * (object) Changes in asset amounts. } "myaddresses": [...], (array) Array
	 * of wallet addresses involved in transaction "addresses": [...], (array)
	 * Array of counterparty addresses involved in transaction "permissions":
	 * [...], (array) Changes in permissions "issue": {...}, (object) Issue
	 * details "data" : "metadata", (array) Hexadecimal representation of
	 * metadata appended to the transaction "confirmations": n, (numeric) The
	 * number of confirmations for the transaction. Available for 'send' and
	 * 'receive' category of transactions. "blockhash": "hashvalue",(string) The
	 * block hash containing the transaction. Available for 'send' and 'receive'
	 * category of transactions. "blockindex": n, (numeric) The block index
	 * containing the transaction. Available for 'send' and 'receive' category
	 * of transactions. "txid": "transactionid", (string) The transaction id.
	 * Available for 'send' and 'receive' category of transactions. "time": xxx,
	 * (numeric) The transaction time in seconds since epoch (midnight Jan 1
	 * 1970 GMT). "timereceived": xxx, (numeric) The time received in seconds
	 * since epoch (midnight Jan 1 1970 GMT). Available for 'send' and 'receive'
	 * category of transactions. "comment": "...", (string) If a comment is
	 * associated with the transaction. "vin": [...], (array) If verbose=true.
	 * Array of input details "vout": [...], (array) If verbose=true. Array of
	 * output details "hex" : "data" (string) If verbose=true. Raw data for
	 * transaction } ]
	 * 
	 * Provides information about transaction txid in this node’s wallet,
	 * including how it affected the node’s total balance.
	 * 
	 * @param txid
	 * @param includeWatchOnly
	 * @param verbose
	 * @return
	 * @throws MultichainException
	 */
	protected Object executeGetWalletTransaction(String txid, boolean includeWatchOnly, boolean verbose) throws MultichainException {
		return execute(CommandEnum.GETWALLETTRANSACTION, txid, includeWatchOnly, verbose);

	}

	/**
	 * 
	 * listaddresstransactions ( "address" count skip verbose)
	 * 
	 * Returns up to 'count' most recent transactions skipping the first 'from'
	 * transactions for account 'account'.
	 * 
	 * Arguments: 1. "address" (string, required) Address to list transactions
	 * for. 2. count (numeric, optional, default=10) The number of transactions
	 * to return 3. skip (numeric, optional, default=0) The number of
	 * transactions to skip 4. verbose (bool, optional, default=false) If true,
	 * returns detailed array of inputs and outputs and raw hex of transactions
	 * 
	 * Result: [ { "balance": {...}, (object) Changes in address balance. {
	 * "amount": x.xxx, (numeric) The amount in native currency. Negative value
	 * means amount was send by the wallet, positive - received "assets": {...},
	 * (object) Changes in asset amounts. } "myaddresses": [...], (array)
	 * Address passed as parameter. "addresses": [...], (array) Array of
	 * counterparty addresses involved in transaction "permissions": [...],
	 * (array) Changes in permissions "issue": {...}, (object) Issue details
	 * "data" : "metadata", (array) Hexadecimal representation of metadata
	 * appended to the transaction "confirmations": n, (numeric) The number of
	 * confirmations for the transaction. Available for 'send' and 'receive'
	 * category of transactions. "blockhash": "hashvalue",(string) The block
	 * hash containing the transaction. Available for 'send' and 'receive'
	 * category of transactions. "blockindex": n, (numeric) The block index
	 * containing the transaction. Available for 'send' and 'receive' category
	 * of transactions. "txid": "transactionid", (string) The transaction id.
	 * Available for 'send' and 'receive' category of transactions. "time": xxx,
	 * (numeric) The transaction time in seconds since epoch (midnight Jan 1
	 * 1970 GMT). "timereceived": xxx, (numeric) The time received in seconds
	 * since epoch (midnight Jan 1 1970 GMT). Available for 'send' and 'receive'
	 * category of transactions. "comment": "...", (string) If a comment is
	 * associated with the transaction. "vin": [...], (array) If verbose=true.
	 * Array of input details "vout": [...], (array) If verbose=true. Array of
	 * output details "hex" : "data" (string) If verbose=true. Raw data for
	 * transaction } ]
	 * 
	 * Lists information about the 10 most recent transactions related to
	 * address in this node’s wallet, including how they affected that address’s
	 * balance.
	 * 
	 * @param address
	 * @param count
	 * @param skip
	 * @param verbose
	 * @return
	 * @throws MultichainException
	 */
	protected Object executeListAddressTransactions(String address, long count, long skip, boolean verbose) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		MultichainTestParameter.valueIsPositive("count", count);
		MultichainTestParameter.valueIsNotNegative("skip", skip);
		return execute(CommandEnum.LISTADDRESSTRANSACTIONS, address, count, skip, verbose);
	}

	/**
	 * 
	 * listwallettransactions ( count skip includeWatchonly verbose)
	 * 
	 * Returns up to 'count' most recent transactions skipping the first 'from'
	 * transactions for account 'account'.
	 * 
	 * Arguments: 1. count (numeric, optional, default=10) The number of
	 * transactions to return 2. skip (numeric, optional, default=0) The number
	 * of transactions to skip 3. includeWatchonly (bool, optional,
	 * default=false) Include transactions to watchonly addresses (see
	 * 'importaddress') 4. verbose (bool, optional, default=false) If true,
	 * returns detailed array of inputs and outputs and raw hex of transactions
	 * 
	 * Result: [ { "balance": {...}, (object) Changes in wallet balance. {
	 * "amount": x.xxx, (numeric) The amount in native currency. Negative value
	 * means amount was send by the wallet, positive - received "assets": {...},
	 * (object) Changes in asset amounts. } "myaddresses": [...], (array) Array
	 * of wallet addresses involved in transaction "addresses": [...], (array)
	 * Array of counterparty addresses involved in transaction "permissions":
	 * [...], (array) Changes in permissions "issue": {...}, (object) Issue
	 * details "data" : "metadata", (array) Hexadecimal representation of
	 * metadata appended to the transaction "confirmations": n, (numeric) The
	 * number of confirmations for the transaction. Available for 'send' and
	 * 'receive' category of transactions. "blockhash": "hashvalue",(string) The
	 * block hash containing the transaction. Available for 'send' and 'receive'
	 * category of transactions. "blockindex": n, (numeric) The block index
	 * containing the transaction. Available for 'send' and 'receive' category
	 * of transactions. "txid": "transactionid", (string) The transaction id.
	 * Available for 'send' and 'receive' category of transactions. "time": xxx,
	 * (numeric) The transaction time in seconds since epoch (midnight Jan 1
	 * 1970 GMT). "timereceived": xxx, (numeric) The time received in seconds
	 * since epoch (midnight Jan 1 1970 GMT). Available for 'send' and 'receive'
	 * category of transactions. "comment": "...", (string) If a comment is
	 * associated with the transaction. "vin": [...], (array) If verbose=true.
	 * Array of input details "vout": [...], (array) If verbose=true. Array of
	 * output details "hex" : "data" (string) If verbose=true. Raw data for
	 * transaction } ]
	 * 
	 * Lists information about the 10 most recent transactions in this node’s
	 * wallet, including how they affected the node’s total balance.
	 * 
	 * @return
	 * @throws MultichainException
	 */
	protected Object executeListWalletTransaction(long count, long skip, boolean includeWatchonly, boolean verbose) throws MultichainException {
		MultichainTestParameter.valueIsPositive("count", count);
		MultichainTestParameter.valueIsNotNegative("skip", skip);
		return execute(CommandEnum.LISTWALLETTRANSACTIONS, count, skip, includeWatchonly, verbose);
	}

	/**
	 * 
	 * sendfromaddress "from-address" "to-address" amount|asset-quantities (
	 * "comment" "comment-to" )
	 * 
	 * Send an amount (or several asset amounts) using specific address.
	 * 
	 * Arguments: 1. "from-address" (string, required) Address to send from. 2.
	 * "to-address" (string, required) The address to send to. 3. "amount"
	 * (numeric, required) The amount in native currency to send. eg 0.1 or 3.
	 * "asset-quantities" (object, required) A json object of assets to send {
	 * "asset-identifier" : asset-quantity ,... } 4. "comment" (string,
	 * optional) A comment used to store what the transaction is for. This is
	 * not part of the transaction, just kept in your wallet. 5. "comment-to"
	 * (string, optional) A comment to store the name of the person or
	 * organization to which you're sending the transaction. This is not part of
	 * the transaction, just kept in your wallet.
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * Sends assets to address, returning the txid.
	 * 
	 * @param fromAddress
	 * @param toAddress
	 * @param assets
	 * @return transactionId
	 * @throws MultichainException
	 */
	protected Object executeSendFromAddress(String fromAddress, String toAddress, List<BalanceAssetGeneral> assets) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("fromAddress", fromAddress);
		MultichainTestParameter.isNotNullOrEmpty("toAddress", toAddress);
		if (assets == null || assets.isEmpty()) {
			throw new MultichainException("assets", "assets needed to be sent");
		}

		Map<String, Double> mapAssets = new HashMap<String, Double>();
		for (BalanceAssetGeneral asset : assets) {
			asset.isFilled();
			mapAssets.put(asset.getName(), new Double(asset.getQty()));
		}

		return execute(CommandEnum.SENDFROMADDRESS, fromAddress, toAddress, mapAssets);
	}

	/**
	 * 
	 * sendfromaddress "from-address" "to-address" amount|asset-quantities (
	 * "comment" "comment-to" )
	 * 
	 * Send an amount (or several asset amounts) using specific address.
	 * 
	 * Arguments: 1. "from-address" (string, required) Address to send from. 2.
	 * "to-address" (string, required) The address to send to. 3. "amount"
	 * (numeric, required) The amount in native currency to send. eg 0.1 or 3.
	 * "asset-quantities" (object, required) A json object of assets to send {
	 * "asset-identifier" : asset-quantity ,... } 4. "comment" (string,
	 * optional) A comment used to store what the transaction is for. This is
	 * not part of the transaction, just kept in your wallet. 5. "comment-to"
	 * (string, optional) A comment to store the name of the person or
	 * organization to which you're sending the transaction. This is not part of
	 * the transaction, just kept in your wallet.
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * Sends assets to address, returning the txid.
	 * 
	 * @param fromAddress
	 * @param toAddress
	 * @param amount
	 * @return transactionId
	 * @throws MultichainException
	 */
	protected Object executeSendFromAddress(String fromAddress, String toAddress, double amount) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("fromAddress", fromAddress);
		MultichainTestParameter.isNotNullOrEmpty("toAddress", toAddress);
		MultichainTestParameter.valueIsNotNegative("amount", amount);

		return execute(CommandEnum.SENDFROMADDRESS, fromAddress, toAddress, amount);
	}

	/**
	 * 
	 * sendtoaddress "address" amount|asset-quantities ( "comment" "comment-to"
	 * )
	 * 
	 * Send an amount (or several asset amounts) to a given address. The amount
	 * is a real and is rounded to the nearest 0.00000001
	 * 
	 * Arguments: 1. "address" (string, required) The address to send to. 2.
	 * "amount" (numeric, required) The amount in native currency to send. eg
	 * 0.1 or 2. "asset-quantities" (object, required) A json object of assets
	 * to send { "asset-identifier" : asset-quantity ,... } 3. "comment"
	 * (string, optional) A comment used to store what the transaction is for.
	 * This is not part of the transaction, just kept in your wallet. 4.
	 * "comment-to" (string, optional) A comment to store the name of the person
	 * or organization to which you're sending the transaction. This is not part
	 * of the transaction, just kept in your wallet.
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * Sends one or more assets to address, returning the txid.
	 * 
	 * @param address
	 * @param assets
	 * @return
	 * @throws MultichainException
	 */
	protected Object executeSendToAddress(String address, List<BalanceAssetGeneral> assets) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		if (assets == null || assets.isEmpty()) {
			throw new MultichainException("assets", "assets needed to be sent");
		}
		Map<String, Double> mapAssets = new HashMap<String, Double>();
		for (BalanceAssetGeneral asset : assets) {
			asset.isFilled();
			mapAssets.put(asset.getName(), new Double(asset.getQty()));
		}

		return execute(CommandEnum.SENDTOADDRESS, address, mapAssets);
	}

	/**
	 * 
	 * sendtoaddress "address" amount|asset-quantities ( "comment" "comment-to"
	 * )
	 * 
	 * Send an amount (or several asset amounts) to a given address. The amount
	 * is a real and is rounded to the nearest 0.00000001
	 * 
	 * Arguments: 1. "address" (string, required) The address to send to. 2.
	 * "amount" (numeric, required) The amount in native currency to send. eg
	 * 0.1 or 2. "asset-quantities" (object, required) A json object of assets
	 * to send { "asset-identifier" : asset-quantity ,... } 3. "comment"
	 * (string, optional) A comment used to store what the transaction is for.
	 * This is not part of the transaction, just kept in your wallet. 4.
	 * "comment-to" (string, optional) A comment to store the name of the person
	 * or organization to which you're sending the transaction. This is not part
	 * of the transaction, just kept in your wallet.
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * Sends one or more assets to address, returning the txid.
	 * 
	 * @param address
	 * @param amount
	 * @return
	 * @throws MultichainException
	 */
	protected Object executeSendToAddress(String address, double amount) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		MultichainTestParameter.valueIsNotNegative("amount", amount);

		return execute(CommandEnum.SENDTOADDRESS, address, amount);
	}

	/**
	 * This works like sendtoaddress, but includes the data-hex hexadecimal
	 * metadata in an additional OP_RETURN transaction output.
	 * 
	 * sendwithmetadata "address" amount|asset-quantities data-hex
	 * 
	 * Send an amount (or several asset amounts) to a given address with
	 * appended metadata.
	 * 
	 * Arguments: 1. "address" (string, required) The address to send to. 2.
	 * "amount" (numeric, required) The amount in native currency to send. eg
	 * 0.1 or 2. "asset-quantities" (object, required) A json object of assets
	 * to send [ "asset-identifier" : asset-quantity ,... ] 3. "data-hex"
	 * (string, required) Data hex string
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param assets
	 * @param hexMetaData
	 * @return
	 * @throws MultichainException
	 */
	protected Object executeSendWithMetaData(String address, List<BalanceAssetGeneral> assets, String hexMetaData) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		MultichainTestParameter.isNotNullOrEmpty("hexMetaData", hexMetaData);
		if (assets == null || assets.isEmpty()) {
			throw new MultichainException("assets", "assets needed to be sent");
		}
		Map<String, Double> mapAssets = new HashMap<String, Double>();
		for (BalanceAssetGeneral asset : assets) {
			asset.isFilled();
			mapAssets.put(asset.getName(), new Double(asset.getQty()));
		}

		return execute(CommandEnum.SENDWITHMETADATA, address, mapAssets, hexMetaData);
	}

	/**
	 * This works like sendtoaddress, but includes the data-hex hexadecimal
	 * metadata in an additional OP_RETURN transaction output.
	 * 
	 * sendwithmetadata "address" amount|asset-quantities data-hex
	 * 
	 * Send an amount (or several asset amounts) to a given address with
	 * appended metadata.
	 * 
	 * Arguments: 1. "address" (string, required) The address to send to. 2.
	 * "amount" (numeric, required) The amount in native currency to send. eg
	 * 0.1 or 2. "asset-quantities" (object, required) A json object of assets
	 * to send [ "asset-identifier" : asset-quantity ,... ] 3. "data-hex"
	 * (string, required) Data hex string
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param amount
	 * @param hexMetaData
	 * @return
	 * @throws MultichainException
	 */
	protected Object executeSendWithMetaData(String address, double amount, String hexMetaData) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		MultichainTestParameter.isNotNullOrEmpty("hexMetaData", hexMetaData);
		MultichainTestParameter.valueIsNotNegative("amount", amount);

		return execute(CommandEnum.SENDWITHMETADATA, address, amount, hexMetaData);
	}

	/**
	 * This works like sendtoaddress, but with control over the from-address
	 * whose funds are used, and with the data-hex hexadecimal metadata added in
	 * an additional OP_RETURN transaction output. Any change from the
	 * transaction is sent back to from-address.
	 * 
	 * sendwithmetadatafrom "from-address" "to-address" amount|asset-quantities
	 * data-hex
	 * 
	 * Send an amount (or several asset amounts) using specific address.
	 * 
	 * Arguments: 1. "from-address" (string, required) Address to send from. 2.
	 * "to-address" (string, required) The address to send to. 3. "amount"
	 * (numeric, required) The amount in native currency to send. eg 0.1 or 3.
	 * "asset-quantities" (object, required) A json object of assets to send [
	 * "asset-identifier" : asset-quantity ,... ] 4. "data-hex" (string,
	 * required) Data hex string
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param assets
	 * @param hexMetaData
	 * @return
	 * @throws MultichainException
	 */
	protected Object executeSendWithMetaDataFrom(String fromAddress, String toAddress, List<BalanceAssetGeneral> assets, String hexMetaData) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("fromAddress", fromAddress);
		MultichainTestParameter.isNotNullOrEmpty("toAddress", toAddress);
		MultichainTestParameter.isNotNullOrEmpty("hexMetaData", hexMetaData);

		if (assets == null || assets.isEmpty()) {
			throw new MultichainException("assets", "assets needed to be sent");
		}
		Map<String, Double> mapAssets = new HashMap<String, Double>();
		for (BalanceAssetGeneral asset : assets) {
			asset.isFilled();
			mapAssets.put(asset.getName(), new Double(asset.getQty()));
		}

		return execute(CommandEnum.SENDWITHMETADATAFROM, fromAddress, toAddress, mapAssets, hexMetaData);
	}

	/**
	 * This works like sendtoaddress, but with control over the from-address
	 * whose funds are used, and with the data-hex hexadecimal metadata added in
	 * an additional OP_RETURN transaction output. Any change from the
	 * transaction is sent back to from-address.
	 * 
	 * sendwithmetadatafrom "from-address" "to-address" amount|asset-quantities
	 * data-hex
	 * 
	 * Send an amount (or several asset amounts) using specific address.
	 * 
	 * Arguments: 1. "from-address" (string, required) Address to send from. 2.
	 * "to-address" (string, required) The address to send to. 3. "amount"
	 * (numeric, required) The amount in native currency to send. eg 0.1 or 3.
	 * "asset-quantities" (object, required) A json object of assets to send [
	 * "asset-identifier" : asset-quantity ,... ] 4. "data-hex" (string,
	 * required) Data hex string
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param amount
	 * @param hexMetaData
	 * @return
	 * @throws MultichainException
	 */
	protected Object executeSendWithMetaDataFrom(String fromAddress, String toAddress, double amount, String hexMetaData) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("fromAddress", fromAddress);
		MultichainTestParameter.isNotNullOrEmpty("toAddress", toAddress);
		MultichainTestParameter.isNotNullOrEmpty("hexMetaData", hexMetaData);
		MultichainTestParameter.valueIsNotNegative("amount", amount);

		return execute(CommandEnum.SENDWITHMETADATAFROM, fromAddress, toAddress, amount, hexMetaData);
	}

	protected Object executeSendWithDataFrom(String fromAddress, String toAddress, String assetName, Integer assetValue, String metadata) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("fromAddress", fromAddress);
		MultichainTestParameter.isNotNullOrEmpty("toAddress", toAddress);
		MultichainTestParameter.isNotNullOrEmpty("metadata", metadata);
		MultichainTestParameter.isNotNull("asset", assetName);
		MultichainTestParameter.valueIsNotNegative("assetValue", assetValue);

		SimpleEntry<String, Integer> simpleEntry = new SimpleEntry<String, Integer>(assetName, assetValue);
		return execute(CommandEnum.SENDWITHDATAFROM, fromAddress, toAddress, simpleEntry, HexFormatter.toHex(metadata));
	}

	@Override
	protected StringEntity prepareRpcEntity(Map<String, Object> entityValues) throws UnsupportedEncodingException {
		final GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(SimpleEntry.class, new SimpleEntryAdapter());
		return new StringEntity(formatJsonWithCustomBuilder(entityValues, builder));
	}

	public static class SimpleEntryAdapter implements JsonSerializer<SimpleEntry> {

		@Override
		public JsonElement serialize(SimpleEntry src, Type typeOfSrc, JsonSerializationContext context) {

			JsonObject obj = new JsonObject();
			obj.addProperty(src.getKey().toString(), (Integer) src.getValue());

			return obj;
		}
	}

}
