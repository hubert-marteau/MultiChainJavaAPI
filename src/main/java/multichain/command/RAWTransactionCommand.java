/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

import java.util.List;
import java.util.Map;

import multichain.command.builders.QueryBuilderRAWTransaction;
import multichain.object.Address;
import multichain.object.AddressBalance;
import multichain.object.SignedTransactionRAW;
import multichain.object.TransactionRAW;
import multichain.object.formatters.RAWTransactionFormatter;
import multichain.object.queryobjects.RawParam;
import multichain.object.queryobjects.TxIdVout;

/**
 * @author Ub - H. MARTEAU
 * @version 4.15
 */
public class RAWTransactionCommand extends QueryBuilderRAWTransaction {

	public RAWTransactionCommand(String ip, String port, String login, String password, RuntimeParameters runtimeparameters) {
		initialize(ip, port, login, password, runtimeparameters);
	}

	/**
	 * appendrawchange "hexstring" address ( native-fee )
	 * 
	 * Appends change output to raw transaction, containing any remaining assets / native currency in the inputs that
	 * are not already sent to other outputs.
	 * 
	 * Arguments:
	 * 1. "hexstring" (string, required) The hex string of the raw transaction)
	 * 2. "address" (string, required) The address to send the change to.
	 * 3. "native-fee" (numeric, optional) Native currency value deducted from that amount so it becomes a transaction
	 * fee. Default - calculated automatically
	 * 
	 * Result:
	 * "transaction" (string) hex string of the transaction
	 * 
	 * Adds a change output to the raw transaction in hexstring given by a previous call to createrawtransaction
	 * 
	 * @param hexString
	 * @param address
	 * @return
	 * @throws MultichainException
	 */
	public String appendRawChange(String hexString, String address) throws MultichainException {
		String stringAppendRawChange = "";

		Object objectAppendRawChange = executeAppendRawChange(hexString, address);
		if (verifyInstance(objectAppendRawChange, String.class)) {
			stringAppendRawChange = (String) objectAppendRawChange;
		}

		return stringAppendRawChange;
	}

	public String appendRawChange(String hexString, Address address) throws MultichainException {
		if (address == null) {
			throw new MultichainException("address", "is null");
		}

		return appendRawChange(hexString, address.getAddress());
	}

	/**
	 * 
	 * appendrawmetadata tx-hex data-hex
	 * 
	 * Appends new OP_RETURN output to existing raw transaction
	 * Returns hex-encoded raw transaction.
	 * 
	 * Arguments:
	 * 1. "tx-hex" (string, required) The transaction hex string
	 * 2. "data-hex" (string, required) Data hex string
	 * or
	 * 2. "issue-details" (object, required) A json object with issue metadata
	 * {
	 * "name" : asset-name (string,optional) Asset name
	 * "multiple" : n (numeric,optional, default 1) Number of raw units in one displayed unit
	 * "open" : true|false (boolean, optional, default false) True if follow-on issues are allowed
	 * "details" : (object, optional) a json object with custom fields
	 * {
	 * "param-name": "param-value" (strings, required) The key is the parameter name, the value is parameter value
	 * ,...
	 * }
	 * or
	 * 2. "issuemore-details" (object, required) A json object with issuemore metadata
	 * {
	 * "details" : (object, optional) a json object with custom fields
	 * {
	 * "param-name": "param-value" (strings, required) The key is the parameter name, the value is parameter value
	 * ,...
	 * }
	 * }
	 * 
	 * Result:
	 * {
	 * "hex": "value", (string) The raw transaction with appended data output (hex-encoded string)
	 * }
	 * 
	 * Adds a metadata output (using an OP_RETURN) to the raw transaction in tx-hex given by a previous call to
	 * createrawtransaction
	 * 
	 * @param txHex
	 * @param dataHex
	 * @return
	 * @throws MultichainException
	 */
	public String appendRawMetaData(String txHex, String dataHex) throws MultichainException {
		String stringAppendRawMetaData = "";

		Object objectAppendRawMetaData = executeAppendRawMetaData(txHex, dataHex);
		if (verifyInstance(objectAppendRawMetaData, String.class)) {
			stringAppendRawMetaData = (String) objectAppendRawMetaData;
		}

		return stringAppendRawMetaData;
	}

	/**
	 * createrawsendfrom from-address {"address":amount,...} ( [data] action )
	 * 
	 * Create a transaction using the given sending address.
	 * 
	 * Arguments:
	 * 1. from-address (string, required) Address to send from.
	 * 2. "addresses" (string, required) a json object with addresses as keys and amounts as values
	 * {
	 * "address":
	 * x.xxx (numeric, required) The key is the address, the value is the native currency amount
	 * or
	 * { (object) A json object of assets to send
	 * "asset-identifier" : asset-quantity
	 * ,...
	 * }
	 * or
	 * { (object) A json object describing new asset issue
	 * "issue" :
	 * {
	 * "raw" : n (numeric, required) The asset total amount in raw units
	 * ,...
	 * }
	 * ,...
	 * }
	 * or
	 * { (object) A json object describing follow-on asset issue
	 * "issuemore" :
	 * {
	 * "asset" : "asset-identifier" (string, required) Asset identifier - one of the following: issue txid. asset
	 * reference, asset name.
	 * "raw" : n (numeric, required) The asset total amount in raw units
	 * ,...
	 * }
	 * ,...
	 * }
	 * or
	 * { (object) A json object describing permission change
	 * "permissions" :
	 * {
	 * "type" : "permission(s)" (string,required) Permission strings, comma delimited. Possible values:
	 * connect,send,receive,issue,mine,admin,activate,create
	 * "startblock" (numeric, optional) Block to apply permissions from (inclusive). Default - 0
	 * "endblock" (numeric, optional) Block to apply permissions to (exclusive). Default - 4294967295
	 * "timestamp" (numeric, optional) This helps resolve conflicts between permissions assigned by the same
	 * administrator. Default - current time
	 * ,...
	 * }
	 * ,...
	 * }
	 * ,...
	 * }
	 * 3. data (array, optional) Array of hexadecimal strings or data objects, see help appendrawdata for details.
	 * 4. action (string, optional, default "") Additional actions: "lock", "sign", "lock,sign", "sign,lock", "send".
	 * 
	 * Result:
	 * "transaction" (string) hex string of the transaction (if action= "" or "lock")
	 * or
	 * { (object) A json object (if action= "sign" or "lock,sign" or "sign,lock")
	 * "hex": "value", (string) The raw transaction with signature(s) (hex-encoded string)
	 * "complete": n (numeric) if transaction has a complete set of signature (0 if not)
	 * }
	 * or
	 * "hex" (string) The transaction hash in hex (if action= "send")
	 */
	public SignedTransactionRAW createRawSendFrom(String address, List<RawParam> rawParams, String[] data, String action)
			throws MultichainException {
		SignedTransactionRAW signedTransactionRAW = new SignedTransactionRAW();

		Object objectTransactionRAW = executeCreateRawSendFrom(address, rawParams, data, action);
		signedTransactionRAW = RAWTransactionFormatter.formatSignedTransactionRAW(objectTransactionRAW);

		return signedTransactionRAW;
	}
	
	/**
	 * to agree to call the method as in tutorial https://www.multichain.com/developers/raw-transactions/
	 * for example have a look in test : RAWTransactionCommandTest
	 * 
	 * @param address from-address 
	 * @param rawParams list of parameters
	 * @return txId
	 * @throws MultichainException
	 */
	public String createRawSendFromByMap(String address, List<Map<String, String>> rawParams)
			throws MultichainException {
		Object objectTransactionRAW = executeCreateRawSendFrom(address, rawParams);

		return objectTransactionRAW.toString();
	}	

	/**
	 * createrawsendfrom from-address {"address":amount,...} ( [data] action )
	 * 
	 * Create a transaction using the given sending address.
	 * 
	 * Arguments:
	 * 1. from-address (string, required) Address to send from.
	 * 2. "addresses" (string, required) a json object with addresses as keys and amounts as values
	 * {
	 * "address":
	 * x.xxx (numeric, required) The key is the address, the value is the native currency amount
	 * or
	 * { (object) A json object of assets to send
	 * "asset-identifier" : asset-quantity
	 * ,...
	 * }
	 * or
	 * { (object) A json object describing new asset issue
	 * "issue" :
	 * {
	 * "raw" : n (numeric, required) The asset total amount in raw units
	 * ,...
	 * }
	 * ,...
	 * }
	 * or
	 * { (object) A json object describing follow-on asset issue
	 * "issuemore" :
	 * {
	 * "asset" : "asset-identifier" (string, required) Asset identifier - one of the following: issue txid. asset
	 * reference, asset name.
	 * "raw" : n (numeric, required) The asset total amount in raw units
	 * ,...
	 * }
	 * ,...
	 * }
	 * or
	 * { (object) A json object describing permission change
	 * "permissions" :
	 * {
	 * "type" : "permission(s)" (string,required) Permission strings, comma delimited. Possible values:
	 * connect,send,receive,issue,mine,admin,activate,create
	 * "startblock" (numeric, optional) Block to apply permissions from (inclusive). Default - 0
	 * "endblock" (numeric, optional) Block to apply permissions to (exclusive). Default - 4294967295
	 * "timestamp" (numeric, optional) This helps resolve conflicts between permissions assigned by the same
	 * administrator. Default - current time
	 * ,...
	 * }
	 * ,...
	 * }
	 * ,...
	 * }
	 * 3. data (array, optional) Array of hexadecimal strings or data objects, see help appendrawdata for details.
	 * 4. action (string, optional, default "") Additional actions: "lock", "sign", "lock,sign", "sign,lock", "send".
	 * 
	 * Result:
	 * "transaction" (string) hex string of the transaction (if action= "" or "lock")
	 * or
	 * { (object) A json object (if action= "sign" or "lock,sign" or "sign,lock")
	 * "hex": "value", (string) The raw transaction with signature(s) (hex-encoded string)
	 * "complete": n (numeric) if transaction has a complete set of signature (0 if not)
	 * }
	 * or
	 * "hex" (string) The transaction hash in hex (if action= "send")
	 */
	public String createRawSendFrom(String address, List<RawParam> rawParams, String[] data) throws MultichainException {
		String transactionRAW = new String();

		Object objectTransactionRAW = executeCreateRawSendFrom(address, rawParams, data, null);
		if (verifyInstance(objectTransactionRAW, String.class)) {
			transactionRAW = (String) objectTransactionRAW;
		}

		return transactionRAW;
	}

	/**
	 * createrawsendfrom from-address {"address":amount,...} ( [data] action )
	 * 
	 * Create a transaction using the given sending address.
	 * 
	 * Arguments:
	 * 1. from-address (string, required) Address to send from.
	 * 2. "addresses" (string, required) a json object with addresses as keys and amounts as values
	 * {
	 * "address":
	 * x.xxx (numeric, required) The key is the address, the value is the native currency amount
	 * or
	 * { (object) A json object of assets to send
	 * "asset-identifier" : asset-quantity
	 * ,...
	 * }
	 * or
	 * { (object) A json object describing new asset issue
	 * "issue" :
	 * {
	 * "raw" : n (numeric, required) The asset total amount in raw units
	 * ,...
	 * }
	 * ,...
	 * }
	 * or
	 * { (object) A json object describing follow-on asset issue
	 * "issuemore" :
	 * {
	 * "asset" : "asset-identifier" (string, required) Asset identifier - one of the following: issue txid. asset
	 * reference, asset name.
	 * "raw" : n (numeric, required) The asset total amount in raw units
	 * ,...
	 * }
	 * ,...
	 * }
	 * or
	 * { (object) A json object describing permission change
	 * "permissions" :
	 * {
	 * "type" : "permission(s)" (string,required) Permission strings, comma delimited. Possible values:
	 * connect,send,receive,issue,mine,admin,activate,create
	 * "startblock" (numeric, optional) Block to apply permissions from (inclusive). Default - 0
	 * "endblock" (numeric, optional) Block to apply permissions to (exclusive). Default - 4294967295
	 * "timestamp" (numeric, optional) This helps resolve conflicts between permissions assigned by the same
	 * administrator. Default - current time
	 * ,...
	 * }
	 * ,...
	 * }
	 * ,...
	 * }
	 * 3. data (array, optional) Array of hexadecimal strings or data objects, see help appendrawdata for details.
	 * 4. action (string, optional, default "") Additional actions: "lock", "sign", "lock,sign", "sign,lock", "send".
	 * 
	 * Result:
	 * "transaction" (string) hex string of the transaction (if action= "" or "lock")
	 * or
	 * { (object) A json object (if action= "sign" or "lock,sign" or "sign,lock")
	 * "hex": "value", (string) The raw transaction with signature(s) (hex-encoded string)
	 * "complete": n (numeric) if transaction has a complete set of signature (0 if not)
	 * }
	 * or
	 * "hex" (string) The transaction hash in hex (if action= "send")
	 */
	public String createRawSendFrom(String address, List<RawParam> rawParams) throws MultichainException {
		return createRawSendFrom(address, rawParams, null);
	}

	/**
	 * Creates a transaction spending the specified inputs, sending to the given addresses
	 * 
	 * createrawtransaction [{"txid":"id","vout":n},...] {"address":amount,...}
	 * 
	 * Create a transaction spending the given inputs and sending to the given addresses.
	 * Returns hex-encoded raw transaction.
	 * Note that the transaction's inputs are not signed, and
	 * it is not stored in the wallet or transmitted to the network.
	 * 
	 * Create a transaction spending the given inputs.
	 *
	 * Arguments:
	 * 1. transactions                           (array, required) A json array of json objects
	 *      [
	 *        {
	 *          "txid":"id",                     (string, required) The transaction id
	 *          "vout":n                         (numeric, required) The output number
	 *          "scriptPubKey": "hex",           (string, optional) script key, used if cache=true or action=sign
	 *          "redeemScript": "hex"            (string, optional) redeem script, used if action=sign
	 *          "cache":true|false               (boolean, optional) If true - add cached script to tx, if omitted - add automatically if needed
	 *        }
	 *        ,...
	 *      ]
	 * 2. addresses                              (object, required) a json object with addresses as keys and amounts as values
	 *     {
	 *       "address": 
	 *         x.xxx                             (numeric, required) The key is the address, the value is the native currency amount
	 *           or 
	 *         {                                 (object) A json object of assets to send
	 *           "asset-identifier" : asset-quantity 
	 *           ,...
	 *         }
	 *           or 
	 *         {                                 (object) A json object describing new asset issue
	 *           "issue" : 
	 *             {
	 *               "raw" : n                   (numeric, required) The asset total amount in raw units 
	 *               ,...
	 *             }
	 *           ,...
	 *         }
	 *           or 
	 *         {                                 (object) A json object describing follow-on asset issue
	 *           "issuemore" : 
	 *             {
	 *               "asset" : "asset-identifier"(string, required) Asset identifier - one of the following: issue txid. asset reference, asset name.
	 *               "raw" : n                   (numeric, required) The asset total amount in raw units 
	 *               ,...
	 *             }
	 *           ,...
	 *         }
	 *           or 
	 *         {                                 (object) A json object describing permission change
	 *           "permissions" : 
	 *             {
	 *               "type" : "permission(s)"    (string,required) Permission strings, comma delimited. Possible values:
	 *                                                               connect,send,receive,issue,mine,admin,activate,create 
	 *               "startblock" : n            (numeric, optional) Block to apply permissions from (inclusive). Default - 0
	 *               "endblock"  : n             (numeric, optional) Block to apply permissions to (exclusive). Default - 4294967295
	 *               "timestamp" : n             (numeric, optional) This helps resolve conflicts between
	 *                                                                 permissions assigned by the same administrator. Default - current time
	 *               ,...
	 *             }
	 *           ,...
	 *         }
	 *       ,...
	 *     }
	 * 3. data                                   (array, optional) Array of hexadecimal strings or data objects, see help appendrawdata for details.
	 * 4."action"                                (string, optional, default "") Additional actions: "lock", "sign", "lock,sign", "sign,lock", "send". 
	 * 
	 * Result:
	 * "transaction"                             (string) hex string of the transaction (if action= "" or "lock")
	 *   or 
	 * {                                         (object) A json object (if action= "sign" or "lock,sign" or "sign,lock")
	 *   "hex": "value",                         (string) The raw transaction with signature(s) (hex-encoded string)
	 *   "complete": true|false                  (boolean) if transaction has a complete set of signature (0 if not)
	 * }
	 *   or 
	 * "hex"                                     (string) The transaction hash in hex (if action= "send")
	 * 
	 * @param txids
	 * @param vouts
	 * @param addresses
	 * @param amounts
	 * @return
	 * @throws MultichainException
	 */
	public String createRawTransaction(List<TxIdVout> inputs, List<AddressBalance> addessBalances, List<String> hexMetaData)
			throws MultichainException {
		String createTransactionRAW = new String();

		Object objectTransactionRAW = executeCreateRawTransaction(inputs, addessBalances, hexMetaData);
		if (verifyInstance(objectTransactionRAW, String.class)) {
			createTransactionRAW = (String) objectTransactionRAW;
		}

		return createTransactionRAW;
	}
	
	public String createRawTransaction(List<TxIdVout> inputs,  List<AddressBalance> addessBalances)
			throws MultichainException {
		return createRawTransaction(inputs, addessBalances, null);
	}

	/**
	 * 
	 * decoderawtransaction "hexstring"
	 * 
	 * Return a JSON object representing the serialized, hex-encoded transaction.
	 * 
	 * Arguments:
	 * 1. "hex" (string, required) The transaction hex string
	 * 
	 * Result:
	 * {
	 * "txid" : "id", (string) The transaction id
	 * "version" : n, (numeric) The version
	 * "locktime" : ttt, (numeric) The lock time
	 * "vin" : [ (array of json objects)
	 * {
	 * "txid": "id", (string) The transaction id
	 * "vout": n, (numeric) The output number
	 * "scriptSig": { (json object) The script
	 * "asm": "asm", (string) asm
	 * "hex": "hex" (string) hex
	 * },
	 * "sequence": n (numeric) The script sequence number
	 * }
	 * ,...
	 * ],
	 * "vout" : [ (array of json objects)
	 * {
	 * "value" : x.xxx, (numeric) The value in btc
	 * "n" : n, (numeric) index
	 * "scriptPubKey" : { (json object)
	 * "asm" : "asm", (string) the asm
	 * "hex" : "hex", (string) the hex
	 * "reqSigs" : n, (numeric) The required sigs
	 * "type" : "pubkeyhash", (string) The type, eg 'pubkeyhash'
	 * "addresses" : [ (json array of string)
	 * "12tvKAXCxZjSmdNbao16dKXC8tRWfcF5oc" (string) address
	 * ,...
	 * ]
	 * }
	 * }
	 * ,...
	 * ],
	 * }
	 * 
	 * @param hex
	 * @return
	 * @throws MultichainException
	 */
	public TransactionRAW decodeRawTransaction(String hex) throws MultichainException {
		TransactionRAW transactionRAW = new TransactionRAW();

		Object objectTransactionRAW = executeDecodeRawTransaction(hex);
		transactionRAW = RAWTransactionFormatter.formatTransactionRAW(objectTransactionRAW);

		return transactionRAW;
	}

	/**
	 * getrawchangeaddress
	 * 
	 * Returns a new address, for receiving change.
	 * This is for use with raw transactions, NOT normal use.
	 * 
	 * Result:
	 * "address" (string) The address
	 * 
	 * @return String address
	 * @throws MultichainException
	 */
	public String getRawChangeAddress() throws MultichainException {
		String rawChangeAddress = new String();

		Object objectRawChangeAddress = executeGetRawChangeAddress();
		if (verifyInstance(objectRawChangeAddress, String.class)) {
			rawChangeAddress = (String) objectRawChangeAddress;
		}

		return rawChangeAddress;
	}

	/**
	 * getrawtransaction "txid" ( verbose )
	 * 
	 * NOTE: By default this function only works sometimes. This is when the tx is in the mempool
	 * or there is an unspent output in the utxo for this transaction. To make it always work,
	 * you need to maintain a transaction index, using the -txindex command line option.
	 * 
	 * Return the raw transaction data.
	 * 
	 * If verbose=0, returns a string that is serialized, hex-encoded data for 'txid'.
	 * If verbose is non-zero, returns an Object with information about 'txid'.
	 * 
	 * Arguments:
	 * 1. "txid" (string, required) The transaction id
	 * 2. verbose (numeric, optional, default=0) If 0, return a string, other return a json object
	 * 
	 * Result (if verbose is not set or set to 0):
	 * "data" (string) The serialized, hex-encoded data for 'txid'
	 * 
	 * Result (if verbose > 0):
	 * {
	 * "hex" : "data", (string) The serialized, hex-encoded data for 'txid'
	 * "txid" : "id", (string) The transaction id (same as provided)
	 * "version" : n, (numeric) The version
	 * "locktime" : ttt, (numeric) The lock time
	 * "vin" : [ (array of json objects)
	 * {
	 * "txid": "id", (string) The transaction id
	 * "vout": n, (numeric)
	 * "scriptSig": { (json object) The script
	 * "asm": "asm", (string) asm
	 * "hex": "hex" (string) hex
	 * },
	 * "sequence": n (numeric) The script sequence number
	 * }
	 * ,...
	 * ],
	 * "vout" : [ (array of json objects)
	 * {
	 * "value" : x.xxx, (numeric) The value in btc
	 * "n" : n, (numeric) index
	 * "scriptPubKey" : { (json object)
	 * "asm" : "asm", (string) the asm
	 * "hex" : "hex", (string) the hex
	 * "reqSigs" : n, (numeric) The required sigs
	 * "type" : "pubkeyhash", (string) The type, eg 'pubkeyhash'
	 * "addresses" : [ (json array of string)
	 * "address" (string) address
	 * ,...
	 * ]
	 * }
	 * }
	 * ,...
	 * ],
	 * "blockhash" : "hash", (string) the block hash
	 * "confirmations" : n, (numeric) The confirmations
	 * "time" : ttt, (numeric) The transaction time in seconds since epoch (Jan 1 1970 GMT)
	 * "blocktime" : ttt (numeric) The block time in seconds since epoch (Jan 1 1970 GMT)
	 * }
	 * 
	 * @param txid
	 * @param verbose
	 *            (0 : false / 1 : true)
	 * @return
	 * @throws MultichainException
	 */
	public Object getRawTransaction(String txid, int verbose) throws MultichainException {
		Object objectTransactionRAW = executeGetRawTransaction(txid, verbose);
		if (verbose == 0) {
          return objectTransactionRAW;
		} else {
          TransactionRAW transactionRAW = RAWTransactionFormatter.formatTransactionRAW(objectTransactionRAW);
          return transactionRAW;
		}
		
	}

	/**
	 * {@link #getRawTransaction(String, int) in verbose mode}
	 * 
	 * @param txid
	 * @return
	 * @throws MultichainException
	 */
	public TransactionRAW getRAWTransactionWithDetail(String txid) throws MultichainException {
		return (TransactionRAW) getRawTransaction(txid, 1);
	}

	/**
	 * {@link #getRawTransaction(String, int) in non-verbose mode}
	 * 
	 * @param txid
	 * @return
	 * @throws MultichainException
	 */
	public String getRAWTransactionWithoutDetail(String txid) throws MultichainException {
		return (String) getRawTransaction(txid, 0);
	}

	/**
	 * 
	 * sendrawtransaction "hexstring" ( allowhighfees )
	 * 
	 * Submits raw transaction (serialized, hex-encoded) to local node and network.
	 * 
	 * Also see createrawtransaction and signrawtransaction calls.
	 * 
	 * Arguments:
	 * 1. "hexstring" (string, required) The hex string of the raw transaction)
	 * 2. allowhighfees (boolean, optional, default=false) Allow high fees
	 * 
	 * Result:
	 * "hex" (string) The transaction hash in hex
	 * 
	 * Validates the raw transaction in hexstring and transmits it to the network, returning the txid.
	 * 
	 * @param hexString
	 * @return
	 * @throws MultichainException
	 */
	public Object sendRawTransaction(String hexString) throws MultichainException {
		return executeSendRawTransaction(hexString);
	}

	/**
	 * 
	 * signrawtransaction "hexstring" ( [{"txid":"id","vout":n,"scriptPubKey":"hex","redeemScript":"hex"},...]
	 * ["privatekey1",...] sighashtype )
	 * 
	 * Sign inputs for raw transaction (serialized, hex-encoded).
	 * The second optional argument (may be null) is an array of previous transaction outputs that
	 * this transaction depends on but may not yet be in the block chain.
	 * The third optional argument (may be null) is an array of base58-encoded private
	 * keys that, if given, will be the only keys used to sign the transaction.
	 * 
	 * 
	 * Arguments:
	 * 1. "hexstring" (string, required) The transaction hex string
	 * 2. "prevtxs" (string, optional) An json array of previous dependent transaction outputs
	 * [ (json array of json objects, or 'null' if none provided)
	 * {
	 * "txid":"id", (string, required) The transaction id
	 * "vout":n, (numeric, required) The output number
	 * "scriptPubKey": "hex", (string, required) script key
	 * "redeemScript": "hex" (string, required for P2SH) redeem script
	 * }
	 * ,...
	 * ]
	 * 3. "privatekeys" (string, optional) A json array of base58-encoded private keys for signing
	 * [ (json array of strings, or 'null' if none provided)
	 * "privatekey" (string) private key in base58-encoding
	 * ,...
	 * ]
	 * 4. "sighashtype" (string, optional, default=ALL) The signature hash type. Must be one of
	 * "ALL"
	 * "NONE"
	 * "SINGLE"
	 * "ALL|ANYONECANPAY"
	 * "NONE|ANYONECANPAY"
	 * "SINGLE|ANYONECANPAY"
	 * 
	 * Result:
	 * {
	 * "hex": "value", (string) The raw transaction with signature(s) (hex-encoded string)
	 * "complete": n (numeric) if transaction has a complete set of signature (0 if not)
	 * }
	 * 
	 * Signs the raw transaction in hexstring, often provided by a previous call to createrawtransaction and
	 * (optionally) appendrawmetadata. * @param hexString
	 * 
	 * @return
	 * @throws MultichainException
	 */
	public SignedTransactionRAW signRawTransaction(String hexString) throws MultichainException {
		SignedTransactionRAW signedTransactionRAW = new SignedTransactionRAW();

		Object objectTransactionRAW = executeSignRawTransaction(hexString);
		signedTransactionRAW = RAWTransactionFormatter.formatSignedTransactionRAW(objectTransactionRAW);

		return signedTransactionRAW;
	}
}
