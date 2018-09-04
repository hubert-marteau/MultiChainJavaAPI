/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command.builders;

import java.util.List;
import java.util.Map;

import multichain.command.MultichainException;
import multichain.command.tools.MultichainTestParameter;
import multichain.object.formatters.CustomParamFormatter;
import multichain.object.queryobjects.AssetParams;
import multichain.object.queryobjects.CustomParamString;

/**
 * @author Ub - H. MARTEAU
 * @version 4.13
 */
public class QueryBuilderIssue extends QueryBuilderCommon {

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
	protected Object executeGetAssetBalances() throws MultichainException {
		return execute(CommandEnum.GETASSETBALANCES);
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
	 * follow-on issues are allowed ,... } 3. "quantity" (numeric, required) The
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
	protected Object executeIssue(	String address,
									String assetName,
									float quantity,
									float unit,
									float amount,
									List<CustomParamString> customFields) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		MultichainTestParameter.isNotNullOrEmpty("assetName", assetName);
		MultichainTestParameter.valueIsPositive("quantity", quantity);
		MultichainTestParameter.valueIsPositive("unit", unit);
		MultichainTestParameter.valueIsNotNegative("float", amount);

		Map<String, String> customParams = CustomParamFormatter.formatCustomParamString(customFields);

		if (customParams == null || customParams.size() == 0) {
			return execute(CommandEnum.ISSUE, address, assetName, quantity, unit, amount);
		} else {
			return execute(CommandEnum.ISSUE, address, assetName, quantity, unit, amount, customParams);
		}
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
	 * follow-on issues are allowed ,... } 3. "quantity" (numeric, required) The
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
	protected Object executeIssue(	String address,
									AssetParams assets,
									float quantity,
									float unit,
									float amount,
									List<CustomParamString> customFields) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("address", address);

		if (assets == null) {
			throw new MultichainException("assets", "assets needed to be sent");
		}
		assets.isFilled();

		MultichainTestParameter.valueIsPositive("quantity", quantity);
		MultichainTestParameter.valueIsPositive("unit", unit);
		MultichainTestParameter.valueIsNotNegative("float", amount);

		Map<String, String> customParams = CustomParamFormatter.formatCustomParamString(customFields);

		if (customParams == null || customParams.size() == 0) {
			return execute(CommandEnum.ISSUE, address, assets, quantity, unit, amount);
		} else {
			return execute(CommandEnum.ISSUE, address, assets, quantity, unit, amount, customParams);
		}
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
	protected Object executeIssueFrom(	String fromAddress,
										String toAddress,
										String assetName,
										int quantity,
										float unit,
										float amount,
										List<CustomParamString> customFields) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("toAddress", toAddress);
		MultichainTestParameter.isNotNullOrEmpty("fromAddress", fromAddress);
		MultichainTestParameter.isNotNullOrEmpty("assetName", assetName);
		MultichainTestParameter.valueIsPositive("quantity", quantity);
		MultichainTestParameter.valueIsPositive("unit", unit);

		Map<String, String> customParams = CustomParamFormatter.formatCustomParamString(customFields);

		if (customParams == null || customParams.size() == 0) {
			return execute(CommandEnum.ISSUEFROM, fromAddress, toAddress, assetName, quantity, unit);
		} else {
			return execute(CommandEnum.ISSUEFROM, fromAddress, toAddress, assetName, quantity, unit, amount,
					customParams);
		}
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
	protected Object executeIssueFrom(	String fromAddress,
										String toAddress,
										AssetParams assets,
										float quantity,
										float unit,
										float amount,
										List<CustomParamString> customFields) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("toAddress", toAddress);
		MultichainTestParameter.isNotNullOrEmpty("fromAddress", fromAddress);

		if (assets == null) {
			throw new MultichainException("assets", "assets needed to be sent");
		}
		assets.isFilled();

		MultichainTestParameter.valueIsPositive("quantity", quantity);
		MultichainTestParameter.valueIsPositive("unit", unit);

		Map<String, String> customParams = CustomParamFormatter.formatCustomParamString(customFields);

		if (customParams == null || customParams.size() == 0) {
			return execute(CommandEnum.ISSUEFROM, fromAddress, toAddress, assets, quantity, unit);
		} else {
			return execute(CommandEnum.ISSUEFROM, fromAddress, toAddress, assets, quantity, unit, amount, customParams);
		}
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
	protected Object executeIssueMore(String address, String assetName, int quantity) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		MultichainTestParameter.isNotNullOrEmpty("assetName", assetName);
		MultichainTestParameter.valueIsPositive("quantity", quantity);
		return execute(CommandEnum.ISSUEMORE, address, assetName, quantity);
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
	protected Object executeIssueMoreFrom(	String fromAddress,
											String toAddress,
											String assetName,
											int quantity) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("toAddress", toAddress);
		MultichainTestParameter.isNotNullOrEmpty("fromAddress", fromAddress);
		MultichainTestParameter.isNotNullOrEmpty("assetName", assetName);
		MultichainTestParameter.valueIsPositive("quantity", quantity);
		return execute(CommandEnum.ISSUEMOREFROM, fromAddress, toAddress, assetName, quantity);
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
	protected Object executeListAssets(String asset, boolean verbose) throws MultichainException {
		if (asset != null && !"".equals(asset)) {
			return execute(CommandEnum.LISTASSETS, asset, verbose);
		} else {
			return execute(CommandEnum.LISTASSETS);
		}
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
	protected Object executeSendAssetFrom(	String fromAddress,
											String toAddress,
											String assetName,
											float quantity) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("fromAddress", fromAddress);
		MultichainTestParameter.isNotNullOrEmpty("toAddress", toAddress);
		MultichainTestParameter.isNotNullOrEmpty("assetName", assetName);
		MultichainTestParameter.valueIsPositive("quantity", quantity);
		return execute(CommandEnum.SENDASSETFROM, fromAddress, toAddress, assetName, quantity);
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
	protected Object executeSendAssetToAddress(	String address,
												String assetName,
												float quantity) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		MultichainTestParameter.isNotNullOrEmpty("assetName", assetName);
		MultichainTestParameter.valueIsPositive("quantity", quantity);
		return execute(CommandEnum.SENDASSETTOADDRESS, address, assetName, quantity);
	}

}
