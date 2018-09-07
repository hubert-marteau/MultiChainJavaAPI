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

import multichain.command.builders.QueryBuilderIssue;
import multichain.object.BalanceAsset;
import multichain.object.formatters.BalanceFormatter;
import multichain.object.queryobjects.AssetParams;
import multichain.object.queryobjects.CustomParamString;

/**
 * @author Ub - H. MARTEAU
 * @version 4.15
 */
public class IssueCommand extends QueryBuilderIssue {

	public IssueCommand(String ip, String port, String login, String password, RuntimeParameters runtimeparameters) {
		initialize(ip, port, login, password, runtimeparameters);
	}

	/**
	 * getassetbalances ( "account" minconf includeWatchonly includeLocked)
	 * 
	 * If account is not specified, returns the server's total available asset
	 * balances. If account is specified, returns the balances in the account.
	 * Note that the account "" is not the same as leaving the parameter out.
	 * The server total may be different to the balance in the default ""
	 * account.
	 * 
	 * Arguments: 1. "account" (string, optional) The selected account, or "*"
	 * for entire wallet. It may be the default account using "". 2. minconf
	 * (numeric, optional, default=1) Only include transactions confirmed at
	 * least this many times. 3. includeWatchonly (bool, optional,
	 * default=false) Also include balance in watchonly addresses (see
	 * 'importaddress') 4. includeLocked (bool, optional, default=false) Also
	 * take locked outputs into account Results are an array of Objects with
	 * totals and details for each asset.
	 * 
	 * @return
	 * @throws MultichainException
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<BalanceAsset> getAssetBalances() throws MultichainException {
		List<BalanceAsset> listBalanceAsset = new ArrayList<BalanceAsset>();

		Object objectBalanceAsset = executeGetAssetBalances();
		if (verifyInstance(objectBalanceAsset, ArrayList.class)
				&& verifyInstanceofList((ArrayList<Object>) objectBalanceAsset, BalanceAsset.class)) {
			listBalanceAsset = BalanceFormatter.formatBalanceAssets((ArrayList<Object>) objectBalanceAsset);
		}

		return listBalanceAsset;
	}

	/**
	 * Creates a new asset on the blockchain, sending the initial qty units to
	 * address. If open is true then additional units can be issued in future by
	 * the same key which signed the original issuance, via the issuemore or
	 * issuemorefrom command.
	 * 
	 * issue "address" asset-name|asset-params quantity ( smallest-unit
	 * native-amount custom-fields )
	 * 
	 * Issue new asset
	 * 
	 * Arguments: 1. "address" (string, required) The address to send newly
	 * created asset to. 2. "asset-name" (string, required) Asset name, if not
	 * "" should be unique. or 2. "asset-params" (object, required) A json
	 * object of with asset params { "name" : "asset-name" (string, optional)
	 * Asset name "open" : true|false (boolean, optional, default false) True if
	 * follow-on issues are allowed,... } 3. "quantity" (numeric, required) The
	 * asset total amount in display units. eg. 1234.56 4. "smallest-unit"
	 * (numeric, optional, default=1) Number of raw units in one displayed unit,
	 * eg 0.01 for cents 5. "native-amount" (numeric, optional) native currency
	 * amount to send. eg 0.1, Default: minimum-per-output. 6 "custom-fields"
	 * (object, optional) a json object with custom fields { "param-name":
	 * "param-value" (strings, required) The key is the parameter name, the
	 * value is parameter value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param assetName
	 * @param open
	 * @param quantity
	 * @param unit
	 *            the smallest transactable unit is given by units, e.g. 0.01.
	 * @return
	 * @throws MultichainException
	 */
	public String issue(String address, String assetName, float quantity, float unit) throws MultichainException {
		return issue(address, assetName, quantity, unit, 0, null);
	}

	/**
	 * Creates a new asset on the blockchain, sending the initial qty units to
	 * address. If open is true then additional units can be issued in future by
	 * the same key which signed the original issuance, via the issuemore or
	 * issuemorefrom command.
	 * 
	 * issue "address" asset-name|asset-params quantity ( smallest-unit
	 * native-amount custom-fields )
	 * 
	 * Issue new asset
	 * 
	 * Arguments: 1. "address" (string, required) The address to send newly
	 * created asset to. 2. "asset-name" (string, required) Asset name, if not
	 * "" should be unique. or 2. "asset-params" (object, required) A json
	 * object of with asset params { "name" : "asset-name" (string, optional)
	 * Asset name "open" : true|false (boolean, optional, default false) True if
	 * follow-on issues are allowed,... } 3. "quantity" (numeric, required) The
	 * asset total amount in display units. eg. 1234.56 4. "smallest-unit"
	 * (numeric, optional, default=1) Number of raw units in one displayed unit,
	 * eg 0.01 for cents 5. "native-amount" (numeric, optional) native currency
	 * amount to send. eg 0.1, Default: minimum-per-output. 6 "custom-fields"
	 * (object, optional) a json object with custom fields { "param-name":
	 * "param-value" (strings, required) The key is the parameter name, the
	 * value is parameter value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param assetName
	 * @param open
	 * @param quantity
	 * @param unit
	 *            the smallest transactable unit is given by units, e.g. 0.01.
	 * @return
	 * @throws MultichainException
	 */
	public String issue(String address, AssetParams assets, float quantity, float unit) throws MultichainException {
		return issue(address, assets, quantity, unit, 0, null);
	}

	/**
	 * Creates a new asset on the blockchain, sending the initial qty units to
	 * address. If open is true then additional units can be issued in future by
	 * the same key which signed the original issuance, via the issuemore or
	 * issuemorefrom command.
	 * 
	 * issue "address" asset-name|asset-params quantity ( smallest-unit
	 * native-amount custom-fields )
	 * 
	 * Issue new asset
	 * 
	 * Arguments: 1. "address" (string, required) The address to send newly
	 * created asset to. 2. "asset-name" (string, required) Asset name, if not
	 * "" should be unique. or 2. "asset-params" (object, required) A json
	 * object of with asset params { "name" : "asset-name" (string, optional)
	 * Asset name "open" : true|false (boolean, optional, default false) True if
	 * follow-on issues are allowed,... } 3. "quantity" (numeric, required) The
	 * asset total amount in display units. eg. 1234.56 4. "smallest-unit"
	 * (numeric, optional, default=1) Number of raw units in one displayed unit,
	 * eg 0.01 for cents 5. "native-amount" (numeric, optional) native currency
	 * amount to send. eg 0.1, Default: minimum-per-output. 6 "custom-fields"
	 * (object, optional) a json object with custom fields { "param-name":
	 * "param-value" (strings, required) The key is the parameter name, the
	 * value is parameter value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param assetName
	 * @param open
	 * @param quantity
	 * @param unit
	 *            the smallest transactable unit is given by units, e.g. 0.01.
	 * @param amount
	 * @return
	 * @throws MultichainException
	 */
	public String issue(String address,
						String assetName,
						float quantity,
						float unit,
						float amount) throws MultichainException {
		return issue(address, assetName, quantity, unit, amount, null);
	}

	/**
	 * Creates a new asset on the blockchain, sending the initial qty units to
	 * address. If open is true then additional units can be issued in future by
	 * the same key which signed the original issuance, via the issuemore or
	 * issuemorefrom command.
	 * 
	 * issue "address" asset-name|asset-params quantity ( smallest-unit
	 * native-amount custom-fields )
	 * 
	 * Issue new asset
	 * 
	 * Arguments: 1. "address" (string, required) The address to send newly
	 * created asset to. 2. "asset-name" (string, required) Asset name, if not
	 * "" should be unique. or 2. "asset-params" (object, required) A json
	 * object of with asset params { "name" : "asset-name" (string, optional)
	 * Asset name "open" : true|false (boolean, optional, default false) True if
	 * follow-on issues are allowed,... } 3. "quantity" (numeric, required) The
	 * asset total amount in display units. eg. 1234.56 4. "smallest-unit"
	 * (numeric, optional, default=1) Number of raw units in one displayed unit,
	 * eg 0.01 for cents 5. "native-amount" (numeric, optional) native currency
	 * amount to send. eg 0.1, Default: minimum-per-output. 6 "custom-fields"
	 * (object, optional) a json object with custom fields { "param-name":
	 * "param-value" (strings, required) The key is the parameter name, the
	 * value is parameter value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param assetName
	 * @param open
	 * @param quantity
	 * @param unit
	 *            the smallest transactable unit is given by units, e.g. 0.01.
	 * @param amount
	 * @return
	 * @throws MultichainException
	 */
	public String issue(String address,
						AssetParams assets,
						float quantity,
						float unit,
						float amount) throws MultichainException {
		return issue(address, assets, quantity, unit, amount, null);
	}

	/**
	 * Creates a new asset on the blockchain, sending the initial qty units to
	 * address. If open is true then additional units can be issued in future by
	 * the same key which signed the original issuance, via the issuemore or
	 * issuemorefrom command.
	 * 
	 * issue "address" asset-name|asset-params quantity ( smallest-unit
	 * native-amount custom-fields )
	 * 
	 * Issue new asset
	 * 
	 * Arguments: 1. "address" (string, required) The address to send newly
	 * created asset to. 2. "asset-name" (string, required) Asset name, if not
	 * "" should be unique. or 2. "asset-params" (object, required) A json
	 * object of with asset params { "name" : "asset-name" (string, optional)
	 * Asset name "open" : true|false (boolean, optional, default false) True if
	 * follow-on issues are allowed,... } 3. "quantity" (numeric, required) The
	 * asset total amount in display units. eg. 1234.56 4. "smallest-unit"
	 * (numeric, optional, default=1) Number of raw units in one displayed unit,
	 * eg 0.01 for cents 5. "native-amount" (numeric, optional) native currency
	 * amount to send. eg 0.1, Default: minimum-per-output. 6 "custom-fields"
	 * (object, optional) a json object with custom fields { "param-name":
	 * "param-value" (strings, required) The key is the parameter name, the
	 * value is parameter value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param assetName
	 * @param open
	 * @param quantity
	 * @param unit
	 *            the smallest transactable unit is given by units, e.g. 0.01.
	 * @param amount
	 * @param customFields
	 * @return
	 * @throws MultichainException
	 */
	public String issue(String address,
						String assetName,
						float quantity,
						float unit,
						float amount,
						List<CustomParamString> customFields) throws MultichainException {
		String issue = "";

		Object objectIssue = executeIssue(address, assetName, quantity, unit, amount, customFields);
		if (verifyInstance(objectIssue, String.class)) {
			issue = (String) objectIssue;
		}

		return issue;

	}

	/**
	 * Creates a new asset on the blockchain, sending the initial qty units to
	 * address. If open is true then additional units can be issued in future by
	 * the same key which signed the original issuance, via the issuemore or
	 * issuemorefrom command.
	 * 
	 * issue "address" asset-name|asset-params quantity ( smallest-unit
	 * native-amount custom-fields )
	 * 
	 * Issue new asset
	 * 
	 * Arguments: 1. "address" (string, required) The address to send newly
	 * created asset to. 2. "asset-name" (string, required) Asset name, if not
	 * "" should be unique. or 2. "asset-params" (object, required) A json
	 * object of with asset params { "name" : "asset-name" (string, optional)
	 * Asset name "open" : true|false (boolean, optional, default false) True if
	 * follow-on issues are allowed,... } 3. "quantity" (numeric, required) The
	 * asset total amount in display units. eg. 1234.56 4. "smallest-unit"
	 * (numeric, optional, default=1) Number of raw units in one displayed unit,
	 * eg 0.01 for cents 5. "native-amount" (numeric, optional) native currency
	 * amount to send. eg 0.1, Default: minimum-per-output. 6 "custom-fields"
	 * (object, optional) a json object with custom fields { "param-name":
	 * "param-value" (strings, required) The key is the parameter name, the
	 * value is parameter value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param assetName
	 * @param open
	 * @param quantity
	 * @param unit
	 *            the smallest transactable unit is given by units, e.g. 0.01.
	 * @param amount
	 * @param customFields
	 * @return
	 * @throws MultichainException
	 */
	public String issue(String address,
						AssetParams assets,
						float quantity,
						float unit,
						float amount,
						List<CustomParamString> customFields) throws MultichainException {
		String issue = "";

		Object objectIssue = executeIssue(address, assets, quantity, unit, amount, customFields);
		if (verifyInstance(objectIssue, String.class)) {
			issue = (String) objectIssue;
		}

		return issue;
	}

	/**
	 * This works like issue, but with control over the from-address used to
	 * issue the asset. If there are multiple addresses with asset issuing
	 * permissions on one node, this allows control over which address is used.
	 * 
	 * issuefrom "from-address" "to-address" asset-name|asset-params quantity (
	 * smallest-unit native-amount custom-fields )
	 * 
	 * Issue asset using specific address
	 * 
	 * Arguments: 1. "from-address" (string, required) Address used for issuing.
	 * 2. "to-address" (string, required) The address to send newly created
	 * asset to. 3. "asset-name" (string, required) Asset name, if not "" should
	 * be unique. or 3. "asset-params" (object, required) A json object of with
	 * asset params { "name" : "asset-name" (string, optional) Asset name "open"
	 * : true|false (boolean, optional, default false) True if follow-on issues
	 * are allowed ,... } 4. "quantity" (numeric, required) The asset total
	 * amount in display units. eg. 1234.56 5. "smallest-unit" (numeric,
	 * optional, default=1) Number of raw units in one displayed unit, eg 0.01
	 * for cents 6. "native-amount" (numeric, optional) native currency amount
	 * to send. eg 0.1, Default: minimum-per-output. 7 "custom-fields" (object,
	 * optional) a json object with custom fields { "param-name": "param-value"
	 * (strings, required) The key is the parameter name, the value is parameter
	 * value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param toAddress
	 * @param assetName
	 * @param open
	 * @param quantity
	 * @param unit
	 *            the smallest transactable unit is given by units, e.g. 0.01.
	 * @return
	 * @throws MultichainException
	 */
	public String issueFrom(String fromAddress,
							String toAddress,
							String assetName,
							int quantity,
							float unit) throws MultichainException {
		return issueFrom(fromAddress, toAddress, assetName, quantity, unit, 0, null);
	}

	/**
	 * This works like issue, but with control over the from-address used to
	 * issue the asset. If there are multiple addresses with asset issuing
	 * permissions on one node, this allows control over which address is used.
	 * 
	 * issuefrom "from-address" "to-address" asset-name|asset-params quantity (
	 * smallest-unit native-amount custom-fields )
	 * 
	 * Issue asset using specific address
	 * 
	 * Arguments: 1. "from-address" (string, required) Address used for issuing.
	 * 2. "to-address" (string, required) The address to send newly created
	 * asset to. 3. "asset-name" (string, required) Asset name, if not "" should
	 * be unique. or 3. "asset-params" (object, required) A json object of with
	 * asset params { "name" : "asset-name" (string, optional) Asset name "open"
	 * : true|false (boolean, optional, default false) True if follow-on issues
	 * are allowed ,... } 4. "quantity" (numeric, required) The asset total
	 * amount in display units. eg. 1234.56 5. "smallest-unit" (numeric,
	 * optional, default=1) Number of raw units in one displayed unit, eg 0.01
	 * for cents 6. "native-amount" (numeric, optional) native currency amount
	 * to send. eg 0.1, Default: minimum-per-output. 7 "custom-fields" (object,
	 * optional) a json object with custom fields { "param-name": "param-value"
	 * (strings, required) The key is the parameter name, the value is parameter
	 * value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param toAddress
	 * @param assetName
	 * @param open
	 * @param quantity
	 * @param unit
	 *            the smallest transactable unit is given by units, e.g. 0.01.
	 * @param amount
	 * @param customFields
	 * @return
	 * @throws MultichainException
	 */
	public String issueFrom(String fromAddress,
							String toAddress,
							String assetName,
							int quantity,
							float unit,
							float amount,
							List<CustomParamString> customFields) throws MultichainException {
		String issueFrom = "";

		Object objectIssueFrom = executeIssueFrom(fromAddress, toAddress, assetName, quantity, unit, amount,
				customFields);
		if (verifyInstance(objectIssueFrom, String.class)) {
			issueFrom = (String) objectIssueFrom;
		}

		return issueFrom;
	}

	/**
	 * This works like issue, but with control over the from-address used to
	 * issue the asset. If there are multiple addresses with asset issuing
	 * permissions on one node, this allows control over which address is used.
	 * 
	 * issuefrom "from-address" "to-address" asset-name|asset-params quantity (
	 * smallest-unit native-amount custom-fields )
	 * 
	 * Issue asset using specific address
	 * 
	 * Arguments: 1. "from-address" (string, required) Address used for issuing.
	 * 2. "to-address" (string, required) The address to send newly created
	 * asset to. 3. "asset-name" (string, required) Asset name, if not "" should
	 * be unique. or 3. "asset-params" (object, required) A json object of with
	 * asset params { "name" : "asset-name" (string, optional) Asset name "open"
	 * : true|false (boolean, optional, default false) True if follow-on issues
	 * are allowed ,... } 4. "quantity" (numeric, required) The asset total
	 * amount in display units. eg. 1234.56 5. "smallest-unit" (numeric,
	 * optional, default=1) Number of raw units in one displayed unit, eg 0.01
	 * for cents 6. "native-amount" (numeric, optional) native currency amount
	 * to send. eg 0.1, Default: minimum-per-output. 7 "custom-fields" (object,
	 * optional) a json object with custom fields { "param-name": "param-value"
	 * (strings, required) The key is the parameter name, the value is parameter
	 * value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param toAddress
	 * @param assetName
	 * @param open
	 * @param quantity
	 * @param unit
	 *            the smallest transactable unit is given by units, e.g. 0.01.
	 * @return
	 * @throws MultichainException
	 */
	public String issueFrom(String fromAddress,
							String toAddress,
							AssetParams assets,
							float quantity,
							float unit) throws MultichainException {
		return issueFrom(fromAddress, toAddress, assets, quantity, unit, 0, null);
	}

	/**
	 * This works like issue, but with control over the from-address used to
	 * issue the asset. If there are multiple addresses with asset issuing
	 * permissions on one node, this allows control over which address is used.
	 * 
	 * issuefrom "from-address" "to-address" asset-name|asset-params quantity (
	 * smallest-unit native-amount custom-fields )
	 * 
	 * Issue asset using specific address
	 * 
	 * Arguments: 1. "from-address" (string, required) Address used for issuing.
	 * 2. "to-address" (string, required) The address to send newly created
	 * asset to. 3. "asset-name" (string, required) Asset name, if not "" should
	 * be unique. or 3. "asset-params" (object, required) A json object of with
	 * asset params { "name" : "asset-name" (string, optional) Asset name "open"
	 * : true|false (boolean, optional, default false) True if follow-on issues
	 * are allowed ,... } 4. "quantity" (numeric, required) The asset total
	 * amount in display units. eg. 1234.56 5. "smallest-unit" (numeric,
	 * optional, default=1) Number of raw units in one displayed unit, eg 0.01
	 * for cents 6. "native-amount" (numeric, optional) native currency amount
	 * to send. eg 0.1, Default: minimum-per-output. 7 "custom-fields" (object,
	 * optional) a json object with custom fields { "param-name": "param-value"
	 * (strings, required) The key is the parameter name, the value is parameter
	 * value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param toAddress
	 * @param assetName
	 * @param open
	 * @param quantity
	 * @param unit
	 *            the smallest transactable unit is given by units, e.g. 0.01.
	 * @param amount
	 * @param customFields
	 * @return
	 * @throws MultichainException
	 */
	public String issueFrom(String fromAddress,
							String toAddress,
							AssetParams assets,
							float quantity,
							float unit,
							float amount,
							List<CustomParamString> customFields) throws MultichainException {
		String issueFrom = "";

		Object objectIssueFrom = executeIssueFrom(fromAddress, toAddress, assets, quantity, unit, amount, customFields);
		if (verifyInstance(objectIssueFrom, String.class)) {
			issueFrom = (String) objectIssueFrom;
		}

		return issueFrom;
	}

	/**
	 * Issues qty additional units of asset, sending them to address. The asset
	 * can be specified using its name, ref or issuance txid
	 * 
	 * issuemore "address" asset-identifier quantity ( native-amount
	 * custom-fields )
	 * 
	 * Create more units for asset
	 * 
	 * Arguments: 1. "address" (string, required) The address to send newly
	 * created asset to. 2. "asset-identifier" (string, required) Asset
	 * identifier - one of the following: issue txid. asset reference, asset
	 * name. 3. "quantity" (numeric, required) The asset total amount in display
	 * units. eg. 1234.56 4. "native-amount" (numeric, optional) native currency
	 * amount to send. eg 0.1, Default: minimum-per-output. 5 "custom-fields"
	 * (object, optional) a json object with custom fields { "param-name":
	 * "param-value" (strings, required) The key is the parameter name, the
	 * value is parameter value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param assetName
	 * @param quantity
	 * @return
	 * @throws MultichainException
	 */
	public String issueMore(String address, String assetName, int quantity) throws MultichainException {
		String issueMore = "";

		Object objectIssueMore = executeIssueMore(address, assetName, quantity);
		if (verifyInstance(objectIssueMore, String.class)) {
			issueMore = (String) objectIssueMore;
		}

		return issueMore;
	}

	/**
	 * Issues qty additional units of asset, sending them to address. The asset
	 * can be specified using its name, ref or issuance txid
	 * 
	 * issuemorefrom "from-address" "to-address" asset-identifier quantity (
	 * native-amount custom-fields )
	 * 
	 * Create more units for asset from specific address
	 * 
	 * Arguments: 1. "from-address" (string, required) Address used for issuing.
	 * 2. "to-address" (string, required) The address to send newly created
	 * asset to. 3. "asset-identifier" (string, required) Asset identifier - one
	 * of the following: issue txid. asset reference, asset name. 4. "quantity"
	 * (numeric, required) The asset total amount in display units. eg. 1234.56
	 * 5. "native-amount" (numeric, optional) native currency amount to send. eg
	 * 0.1, Default: minimum-per-output. 6 "custom-fields" (object, optional) a
	 * json object with custom fields { "param-name": "param-value" (strings,
	 * required) The key is the parameter name, the value is parameter value
	 * ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param assetName
	 * @param quantity
	 * @return
	 * @throws MultichainException
	 */
	public String issueMoreFrom(String fromAddress,
								String toAddress,
								String assetName,
								int quantity) throws MultichainException {
		String issueMoreFrom = "";

		Object objectIssueMoreFrom = executeIssueMoreFrom(fromAddress, toAddress, assetName, quantity);
		if (verifyInstance(objectIssueMoreFrom, String.class)) {
			issueMoreFrom = (String) objectIssueMoreFrom;
		}

		return issueMoreFrom;
	}

	/**
	 * 
	 * listassets ("asset-identifier" verbose) 1. "asset-identifier" (string,
	 * optional) Asset identifier - one of the following: issue txid, asset
	 * reference, asset name. 2. verbose (boolean, optional, default=false) If
	 * true, returns list of all issue transactions, including follow-ons
	 * 
	 * Returns list of defined assets
	 * 
	 * @param asset
	 * @param verbose
	 * @return information about assets issued on the blockchain. Provide an
	 *         asset name, ref or issuance txid
	 * @throws MultichainException
	 */
	@SuppressWarnings("unchecked")
	public List<BalanceAsset> listAssets(String asset, boolean verbose) throws MultichainException {
		List<BalanceAsset> listBalanceAsset = new ArrayList<BalanceAsset>();

		Object objectBalances = executeListAssets(asset, verbose);
		if (verifyInstance(objectBalances, ArrayList.class)
				&& verifyInstanceofList((ArrayList<Object>) objectBalances, BalanceAsset.class)) {
			listBalanceAsset = BalanceFormatter.formatBalanceAssets((ArrayList<Object>) objectBalances);
		}

		return listBalanceAsset;
	}

	/**
	 * 
	 * listassets ("asset-identifier" verbose) 1. "asset-identifier" (string,
	 * optional) Asset identifier - one of the following: issue txid, asset
	 * reference, asset name. 2. verbose (boolean, optional, default=false) If
	 * true, returns list of all issue transactions, including follow-ons
	 * 
	 * Returns list of defined assets
	 * 
	 * @param asset
	 * @return information about assets issued on the blockchain. Provide an
	 *         asset name, ref or issuance txid
	 * @throws MultichainException
	 */
	public List<BalanceAsset> listAssets(String asset) throws MultichainException {
		return listAssets(asset, false);
	}

	/**
	 * Sends assets to address, returning the txid.
	 * 
	 * sendassetfrom "from-address" "to-address" asset-identifier asset-qty (
	 * native-amount "comment" "comment-to" )
	 * 
	 * Send an asset amount using specific address.
	 * 
	 * Arguments: 1. "from-address" (string, required) Address to send from. 2.
	 * "to-address" (string, required) The address to send to. 3.
	 * "asset-identifier" (string, required) Asset identifier - one of the
	 * following: issue txid. asset reference, asset name. 4. "asset-qty"
	 * (numeric, required) Asset quantity to send. eg 0.1 5. "native-amount"
	 * (numeric, optional) native currency amount to send. eg 0.1, Default:
	 * minimum-per-output. 6. "comment" (string, optional) A comment used to
	 * store what the transaction is for. This is not part of the transaction,
	 * just kept in your wallet. 7. "comment-to" (string, optional) A comment to
	 * store the name of the person or organization to which you're sending the
	 * transaction. This is not part of the transaction, just kept in your
	 * wallet.
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param fromAddress
	 * @param toAddress
	 * @param assetName
	 * @param quantity
	 * @return
	 * @throws MultichainException
	 */
	public String sendAssetFrom(String fromAddress,
								String toAddress,
								String assetName,
								float quantity) throws MultichainException {
		String sendAssetFrom = "";

		Object objectSendAssetFrom = executeSendAssetFrom(fromAddress, toAddress, assetName, quantity);
		if (verifyInstance(objectSendAssetFrom, String.class)) {
			sendAssetFrom = (String) objectSendAssetFrom;
		}

		return sendAssetFrom;

	}

	/**
	 * Sends assets to address, returning the txid.
	 * 
	 * sendassettoaddress "address" asset-identifier asset-qty ( native-amount
	 * "comment" "comment-to" )
	 * 
	 * Send asset amount to a given address. The amounts are real.
	 * 
	 * Arguments: 1. "address" (string, required) The address to send to. 2.
	 * "asset-identifier" (string, required) Asset identifier - one of the
	 * following: issue txid. asset reference, asset name. 3. "asset-qty"
	 * (numeric, required) Asset quantity to send. eg 0.1 4. "native-amount"
	 * (numeric, optional) native currency amount to send. eg 0.1, Default:
	 * minimum-per-output. 5. "comment" (string, optional) A comment used to
	 * store what the transaction is for. This is not part of the transaction,
	 * just kept in your wallet. 6. "comment-to" (string, optional) A comment to
	 * store the name of the person or organization to which you're sending the
	 * transaction. This is not part of the transaction, just kept in your
	 * wallet.
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param assetName
	 * @param quantity
	 * @return
	 * @throws MultichainException
	 */
	public String sendAssetToAddress(String address, String assetName, float quantity) throws MultichainException {
		String sendAssetToAddress = "";

		Object objectSendAssetToAddress = executeSendAssetToAddress(address, assetName, quantity);
		if (verifyInstance(objectSendAssetToAddress, String.class)) {
			sendAssetToAddress = (String) objectSendAssetToAddress;
		}

		return sendAssetToAddress;
	}

}
