/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command.builders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import multichain.command.MultichainException;
import multichain.command.tools.MultichainTestParameter;

/**
 * @author Ub - H. MARTEAU
 * @version 4.15
 */
public class QueryBuilderAddress extends QueryBuilderCommon {

	/**
	 * Creates public/private key pairs. These key pairs are not stored in the
	 * wallet.
	 * 
	 * Arguments: 1. count (number, optional, default=1) Number of pairs to
	 * create.
	 * 
	 * Result: [ (json array of ) { "address" : "address", (string)
	 * Pay-to-pubkeyhash address "pubkey" : "pubkey", (string) Public key
	 * (hexadecimal) "privkey" : "privatekey", (string) Private key,
	 * base58-encoded as required for signrawtransaction } ]
	 * 
	 * @param numberOfPairs
	 * @return
	 * @throws MultichainException
	 */
	protected Object executeCreateKeyPairs(int numberOfPairs) throws MultichainException {
		MultichainTestParameter.valueIsPositive("number of pairs", numberOfPairs);
		return execute(CommandEnum.CREATEKEYPAIRS, numberOfPairs);
	}

	/**
	 * addmultisigaddress nrequired ["key",...] ( "account" )
	 * 
	 * Add a nrequired-to-sign multisignature address to the wallet. Each key is
	 * a address or hex-encoded public key. If 'account' is specified, assign
	 * address to that account.
	 * 
	 * Arguments: 1. nrequired (numeric, required) The number of required
	 * signatures out of the n keys or addresses. 2. "keysobject" (string,
	 * required) A json array of addresses or hex-encoded public keys [
	 * "address" (string) address or hex-encoded public key ..., ] 3. "account"
	 * (string, optional) An account to assign the addresses to.
	 * 
	 * Result: "address" (string) A address associated with the keys.
	 * 
	 * 
	 * @param numberOfSigRequired
	 * @param publicKeys
	 * @return the P2SH address
	 * @throws MultichainException
	 */
	protected Object executeAddMultiSigAddress(int numberOfSigRequired, String[] publicKeys) throws MultichainException {
		MultichainTestParameter.valueIsPositive("number of signature required", numberOfSigRequired);
		MultichainTestParameter.isNotNullOrEmpty("publicKeys", publicKeys);
		MultichainTestParameter.arrayNotContainNullOrEmptyValues("publicKeys", publicKeys);
		if (publicKeys.length >= numberOfSigRequired) {
			List<String> publicKeysList = new ArrayList<>(Arrays.asList(publicKeys));
			return execute(CommandEnum.ADDMULTISIGADDRESS, numberOfSigRequired, publicKeysList);
		} else {
			throw new MultichainException("number of signature", "is greater than the size of public keys");
		}
	}

	/**
	 * createmultisig nrequired ["key",...]
	 * 
	 * Creates a multi-signature address with n signature of m keys required. It
	 * returns a json object with the address and redeemScript.
	 * 
	 * Arguments: 1. nrequired (numeric, required) The number of required
	 * signatures out of the n keys or addresses. 2. "keys" (string, required) A
	 * json array of keys which are addresses or hex-encoded public keys [ "key"
	 * (string) address or hex-encoded public key ,... ]
	 * 
	 * Result: { "address":"multisigaddress", (string) The value of the new
	 * multisig address. "redeemScript":"script" (string) The string value of
	 * the hex-encoded redemption script. }
	 * 
	 * 
	 * @param numberOfSigRequired
	 * @param publicKeys
	 * @return The P2SH address and corresponding redeem script.
	 * @throws MultichainException
	 */
	protected Object executeCreateMultiSig(int numberOfSigRequired, String[] publicKeys) throws MultichainException {

		MultichainTestParameter.valueIsPositive("number of signature required", numberOfSigRequired);
		MultichainTestParameter.isNotNullOrEmpty("public Keys", publicKeys);
		MultichainTestParameter.arrayNotContainNullOrEmptyValues("public Keys", publicKeys);
		if (publicKeys.length >= numberOfSigRequired) {
			List<String> publicKeysList = new ArrayList<>(Arrays.asList(publicKeys));
			return execute(CommandEnum.CREATEMULTISIG, numberOfSigRequired, publicKeysList);
		} else {
			throw new MultichainException("number of signature", "is greater than the size of public keys");
		}
	}

	/**
	 * 
	 * getaddressbalances "address" ( minconf includeLocked )
	 * 
	 * Returns asset balances for specified address
	 * 
	 * Arguments: 1. "address" (string, required) Address to return balance for.
	 * 2. minconf (numeric, optional, default=1) Only include transactions
	 * confirmed at least this many times. 3. includeLocked (bool, optional,
	 * default=false) Also take locked outputs into account Results are an array
	 * of Objects with totals and details for each asset.
	 * 
	 * @param address
	 * @return a list of all the asset balances for address in this node’s
	 *         wallet
	 * @throws MultichainException
	 */
	protected Object executeGetAddressBalances(String address) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		return execute(CommandEnum.GETADDRESSBALANCES, address);
	}

	/**
	 * getaddresses ( verbose )
	 * 
	 * Returns the list of all addresses in the wallet.
	 * 
	 * Arguments: 1. "verbose" (boolean, optional, default=false) The account
	 * name.
	 * 
	 * Result: [ (json array of ) "address" (string) an address or
	 * "address-datails" (object) address details if verbose=true ,... ]
	 * 
	 * @param verbose
	 *            t verbose to true to get more information about each address,
	 *            formatted like the output of the validateaddress command.
	 * @return a list of addresses in this node’s wallet
	 * @throws MultichainException
	 */
	protected Object executeGetAddresses(boolean verbose) throws MultichainException {
		return execute(CommandEnum.GETADDRESSES, verbose);
	}

	/**
	 * Returns a list of balances of all addresses in this node’s wallet
	 * 
	 * getmultibalances ("address(es)" assets minconf includeLocked
	 * includeWatchonly)
	 * 
	 * Returns asset balances for specified address
	 * 
	 * Arguments: 1. "address(es)" (string, optional) Address(es) to return
	 * balance for, comma delimited. Default - all or 1. "address(es)" (array,
	 * optional) A json array of addresses to return balance for 2. "assets"
	 * (array, optional) A json array of asset identifiers to return balance
	 * for, default - all [] 3. minconf (numeric, optional, default=1) Only
	 * include transactions confirmed at least this many times. 4.
	 * includeWatchonly (bool, optional, default=false) Include transactions to
	 * watchonly addresses (see 'importaddress') 5. includeLocked (bool,
	 * optional, default=false) Also take locked outputs into account Results
	 * are an Object of balance arrays with totals and details for each asset.
	 * 
	 * @return Balances
	 */
	protected Object executeGetMultiBalances(String[] addresses, String[] assets) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("addresses", addresses);
		MultichainTestParameter.arrayNotContainNullOrEmptyValues("addresses", addresses);
		MultichainTestParameter.isNotNullOrEmpty("assets", assets);
		MultichainTestParameter.arrayNotContainNullOrEmptyValues("assets", assets);

		List<String> addressesList = new ArrayList<>(Arrays.asList(addresses));
		return execute(CommandEnum.GETMULTIBALANCES, addressesList, formatJson(assets));
	}

	/**
	 * Returns a list of balances of all addresses in this node’s wallet
	 * 
	 * getmultibalances ("address(es)" assets minconf includeLocked
	 * includeWatchonly)
	 * 
	 * Returns asset balances for specified address
	 * 
	 * Arguments: 1. "address(es)" (string, optional) Address(es) to return
	 * balance for, comma delimited. Default - all or 1. "address(es)" (array,
	 * optional) A json array of addresses to return balance for 2. "assets"
	 * (array, optional) A json array of asset identifiers to return balance
	 * for, default - all [] 3. minconf (numeric, optional, default=1) Only
	 * include transactions confirmed at least this many times. 4.
	 * includeWatchonly (bool, optional, default=false) Include transactions to
	 * watchonly addresses (see 'importaddress') 5. includeLocked (bool,
	 * optional, default=false) Also take locked outputs into account Results
	 * are an Object of balance arrays with totals and details for each asset.
	 * 
	 * @return Balances
	 */
	protected Object executeGetMultiBalances(String[] addresses) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("addresses", addresses);
		MultichainTestParameter.arrayNotContainNullOrEmptyValues("addresses", addresses);

		List<String> addressesList = new ArrayList<>(Arrays.asList(addresses));
		return execute(CommandEnum.GETMULTIBALANCES, addressesList);
	}

	protected Object executeGetMultiBalances(String address) throws MultichainException {
		return execute(CommandEnum.GETMULTIBALANCES, address);
	}

	protected Object executeGetMultiBalances() throws MultichainException {
		return execute(CommandEnum.GETMULTIBALANCES);
	}

	/**
	 * getnewaddress ( "account" )
	 * 
	 * Returns a new address for receiving payments. If 'account' is specified
	 * (recommended), it is added to the address book so payments received with
	 * the address will be credited to 'account'.
	 * 
	 * Arguments: 1. "account" (string, optional) The account name for the
	 * address to be linked to. if not provided, the default account "" is used.
	 * It can also be set to the empty string "" to represent the default
	 * account. The account does not need to exist, it will be created if there
	 * is no account by the given name.
	 * 
	 * Result: "address" (string) The new address
	 * 
	 * @return a new address whose private key is added to the wallet.
	 * @throws MultichainException
	 */
	protected Object executeGetNewAddress() throws MultichainException {
		return execute(CommandEnum.GETNEWADDRESS);
	}
	protected Object executeGetNewAddress(String label) throws MultichainException {
		return execute(CommandEnum.GETNEWADDRESS, label);
	}
	/**
	 * Adds address to the wallet, without an associated private key, to create
	 * a watch-only address. This is an address whose activity and balance can
	 * be retrieved , but whose funds cannot be spent by this node
	 * 
	 * importaddress "address" ( "label" rescan )
	 * 
	 * Adds an address or script (in hex) that can be watched as if it were in
	 * your wallet but cannot be used to spend.
	 * 
	 * Arguments: 1. "address" (string, required) The address 2. "label"
	 * (string, optional, default="") An optional label 3. rescan (boolean,
	 * optional, default=true) Rescan the wallet for transactions
	 * 
	 * Note: This call can take minutes to complete if rescan is true.
	 * 
	 * @param address
	 * @param label
	 * @param rescan
	 *            If rescan is true, the entire blockchain is checked for
	 *            transactions relating to all addresses in the wallet,
	 *            including the added one
	 * @return null if successful.
	 * @throws MultichainException
	 */
	protected Object executeImportAddress(String address, String label, boolean rescan) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		return execute(CommandEnum.IMPORTADDRESS, address, label, rescan);
	}
	
	
	/**
	 * setaccount "address" "account"
	 * 
	 * Sets the account associated with the given address.
	 * 
	 * Arguments:
	 * 1. "address"                        (string, required) The address to be associated with an account.
	 * 2. "account"                        (string, required) The account to assign the address to.
	 * 
	 * @param address
	 * @param label
	 * @return
	 * @throws MultichainException
	 */
	protected Object executeSetAccount(String address, String label) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		MultichainTestParameter.isNotNullOrEmpty("label", label);
		return execute(CommandEnum.SETACCOUNT, address, label);
		
	}

	/**
	 * Returns information about address including a check for its validity.
	 * 
	 * * validateaddress "address"
	 * 
	 * Return information about the given address.
	 * 
	 * Arguments: 1. "address" (string, required) The address to validate
	 * 
	 * Result: { "isvalid" : true|false, (boolean) If the address is valid or
	 * not. If not, this is the only property returned. "address" : "address",
	 * (string) The address validated "ismine" : true|false, (boolean) If the
	 * address is yours or not "isscript" : true|false, (boolean) If the key is
	 * a script "pubkey" : "publickeyhex", (string) The hex value of the raw
	 * public key "iscompressed" : true|false, (boolean) If the address is
	 * compressed "account" : "account" (string) The account associated with the
	 * address, "" is the default account }
	 * 
	 * 
	 * @param address
	 * @return information on address
	 * @throws MultichainException
	 */
	protected Object executeValidateAddress(String address) throws MultichainException, MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		return execute(CommandEnum.VALIDATEADDRESS, address);
	}

}
