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

import multichain.command.builders.QueryBuilderStream;
import multichain.object.StreamKeyItem;
import multichain.object.formatters.StreamFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 1.1
 */
public class StreamCommand extends QueryBuilderStream {

	public StreamCommand(String ip, String port, String login, String password) {
		initialize(ip, port, login, password);
	}

	/**
	 * create stream "stream-name" open ( custom-fields )
	 * 
	 * Creates stream
	 * 
	 * 
	 * Arguments: 1. entity-type (string, required) The only possible value:
	 * stream 2. "stream-name" (string, required) Stream name, if not "" should
	 * be unique. 3. open (boolean, required) Allow anyone to publish in this
	 * stream 4 custom-fields (object, optional) a json object with custom
	 * fields { "param-name": "param-value" (strings, required) The key is the
	 * parameter name, the value is parameter value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param streamName
	 * @param open
	 * @return TxId
	 * @throws MultichainException
	 */
	public String create(String streamName, boolean open) throws MultichainException {
		String stringCreate = "";

		Object objectCreate = executeCreate(streamName, open);
		if (verifyInstance(objectCreate, String.class)) {
			stringCreate = (String) objectCreate;
		}

		return stringCreate;
	}

	/**
	 * create stream "stream-name" open ( custom-fields )
	 * 
	 * Creates stream
	 * 
	 * 
	 * Arguments: 1. entity-type (string, required) The only possible value:
	 * stream 2. "stream-name" (string, required) Stream name, if not "" should
	 * be unique. 3. open (boolean, required) Allow anyone to publish in this
	 * stream 4 custom-fields (object, optional) a json object with custom
	 * fields { "param-name": "param-value" (strings, required) The key is the
	 * parameter name, the value is parameter value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param streamName
	 * @param open
	 *            = false
	 * @return TxId
	 * @throws MultichainException
	 */
	public String create(String streamName) throws MultichainException {
		return create(streamName, false);
	}

	/**
	 * liststreamkeyitems "stream-identifier" "key" ( verbose count start
	 * local-ordering )
	 * 
	 * Returns stream items for specific key.
	 * 
	 * Arguments: 1. "stream-identifier"(string, required) Stream identifier -
	 * one of the following: stream txid, stream reference, stream name. 2.
	 * "key" (string, required) Stream key 3. verbose (boolean, optional,
	 * default=false) If true, returns information about item transaction 4.
	 * count (number, optional, default=10) The number of items to display 5.
	 * start (number, optional, default=-count - last) Start from specific item,
	 * 0 based, if negative - from the end 6. local-ordering (boolean, optional,
	 * default=false) If true, items appear in the order they were processed by
	 * the wallet, if false - in the order they appear in blockchain
	 * 
	 * Result: "stream-items" (array) List of stream items for specific key.
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 * @param count
	 * @param start
	 * @return
	 * @throws MultichainException
	 */
	@SuppressWarnings("unchecked")
	public List<StreamKeyItem> listStreamKeyItems(String streamName, String key, boolean verbose, int count, int start)
			throws MultichainException {
		List<StreamKeyItem> streamKeyItems = new ArrayList<StreamKeyItem>();

		Object objectStreamKeyItems = executeListStreamKeyItems(streamName, key, verbose, count, start);
		if (verifyInstance(objectStreamKeyItems, ArrayList.class)
				&& verifyInstanceofList((ArrayList<Object>) objectStreamKeyItems, StreamKeyItem.class)) {
			streamKeyItems = StreamFormatter.formatStreamKeyItems((ArrayList<Object>) objectStreamKeyItems);
		}

		return streamKeyItems;
	}

	/**
	 * liststreamkeyitems "stream-identifier" "key" ( verbose count start
	 * local-ordering )
	 * 
	 * Returns stream items for specific key.
	 * 
	 * Arguments: 1. "stream-identifier"(string, required) Stream identifier -
	 * one of the following: stream txid, stream reference, stream name. 2.
	 * "key" (string, required) Stream key 3. verbose (boolean, optional,
	 * default=false) If true, returns information about item transaction 4.
	 * count (number, optional, default=10) The number of items to display 5.
	 * start (number, optional, default=-count - last) Start from specific item,
	 * 0 based, if negative - from the end 6. local-ordering (boolean, optional,
	 * default=false) If true, items appear in the order they were processed by
	 * the wallet, if false - in the order they appear in blockchain
	 * 
	 * Result: "stream-items" (array) List of stream items for specific key.
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 * @param count
	 *            * @return
	 * @throws MultichainException
	 */
	@SuppressWarnings("unchecked")
	public List<StreamKeyItem> listStreamKeyItems(String streamName, String key, boolean verbose, int count)
			throws MultichainException {
		List<StreamKeyItem> streamKeyItems = new ArrayList<StreamKeyItem>();

		Object objectStreamKeyItems = executeListStreamKeyItems(streamName, key, verbose, count);
		if (verifyInstance(objectStreamKeyItems, ArrayList.class)
				&& verifyInstanceofList((ArrayList<Object>) objectStreamKeyItems, StreamKeyItem.class)) {
			streamKeyItems = StreamFormatter.formatStreamKeyItems((ArrayList<Object>) objectStreamKeyItems);
		}

		return streamKeyItems;
	}

	/**
	 * liststreamkeyitems "stream-identifier" "key" ( verbose count start
	 * local-ordering )
	 * 
	 * Returns stream items for specific key.
	 * 
	 * Arguments: 1. "stream-identifier"(string, required) Stream identifier -
	 * one of the following: stream txid, stream reference, stream name. 2.
	 * "key" (string, required) Stream key 3. verbose (boolean, optional,
	 * default=false) If true, returns information about item transaction 4.
	 * count (number, optional, default=10) The number of items to display 5.
	 * start (number, optional, default=-count - last) Start from specific item,
	 * 0 based, if negative - from the end 6. local-ordering (boolean, optional,
	 * default=false) If true, items appear in the order they were processed by
	 * the wallet, if false - in the order they appear in blockchain
	 * 
	 * Result: "stream-items" (array) List of stream items for specific key.
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 * @param count
	 *            = 10 * @return
	 * @throws MultichainException
	 */
	public List<StreamKeyItem> listStreamKeyItems(String streamName, String key, boolean verbose)
			throws MultichainException {
		return listStreamKeyItems(streamName, key, verbose, 10);
	}

	/**
	 * liststreamkeyitems "stream-identifier" "key" ( verbose count start
	 * local-ordering )
	 * 
	 * Returns stream items for specific key.
	 * 
	 * Arguments: 1. "stream-identifier"(string, required) Stream identifier -
	 * one of the following: stream txid, stream reference, stream name. 2.
	 * "key" (string, required) Stream key 3. verbose (boolean, optional,
	 * default=false) If true, returns information about item transaction 4.
	 * count (number, optional, default=10) The number of items to display 5.
	 * start (number, optional, default=-count - last) Start from specific item,
	 * 0 based, if negative - from the end 6. local-ordering (boolean, optional,
	 * default=false) If true, items appear in the order they were processed by
	 * the wallet, if false - in the order they appear in blockchain
	 * 
	 * Result: "stream-items" (array) List of stream items for specific key.
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 *            = false
	 * @param count
	 *            = 10 * @return
	 * @throws MultichainException
	 */
	public List<StreamKeyItem> listStreamKeyItems(String streamName, String key) throws MultichainException {
		return listStreamKeyItems(streamName, key, false, 10);
	}

	/**
	 * publish "stream-identifier" "key" data-hex
	 * 
	 * Publishes stream item
	 * 
	 * 
	 * Arguments: 1. "stream-identifier" (string, required) Stream identifier -
	 * one of the following: stream txid, stream reference, stream name. 2.
	 * "key" (string, required) Item key 3. data-hex (string, required) Item
	 * data hex string
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param streamName
	 * @param key
	 * @param dataHex
	 *            : data in hexadecimal in string format
	 * @return
	 * @throws MultichainException
	 */
	public String publish(String streamName, String key, String dataHex) throws MultichainException {
		String stringPublish = "";

		Object objectPublish = executePublish(streamName, key, dataHex);
		if (verifyInstance(objectPublish, String.class)) {
			stringPublish = (String) objectPublish;
		}

		return stringPublish;
	}

	/**
	 * subscribe entity-identifier(s) ( rescan )
	 * 
	 * Subscribes to the stream.
	 * 
	 * Arguments: 1. "stream-identifier" (string, required) Stream identifier -
	 * one of the following: stream txid, stream reference, stream name. or 1.
	 * "asset-identifier" (string, required) Asset identifier - one of the
	 * following: asset txid, asset reference, asset name. or 1.
	 * entity-identifier(s) (array, optional) A json array of stream or asset
	 * identifiers 2. rescan (boolean, optional, default=true) Rescan the wallet
	 * for transactions
	 * 
	 * Note: This call can take minutes to complete if rescan is true.
	 * 
	 * @param streamName
	 * @throws MultichainException
	 */
	public void subscribe(String streamName) throws MultichainException {
		executeSubscribe(streamName);
	}

}
