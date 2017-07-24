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

import multichain.command.builders.QueryBuilderAddress;
import multichain.object.Address;
import multichain.object.BalanceAsset;
import multichain.object.MultiBalance;
import multichain.object.formatters.AddressFormatter;
import multichain.object.formatters.BalanceFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0
 */
public class AddressCommand extends QueryBuilderAddress {

	public AddressCommand(String chainName) {
		setCHAIN(chainName);
	}

	/**
	 * addmultisigaddress nrequired ["key",...] ( "account" )
	 * 
	 * Add a nrequired-to-sign multisignature address to the wallet.
	 * Each key is a address or hex-encoded public key.
	 * If 'account' is specified, assign address to that account.
	 * 
	 * Arguments:
	 * 1. nrequired (numeric, required) The number of required signatures out of the n keys or addresses.
	 * 2. "keysobject" (string, required) A json array of addresses or hex-encoded public keys
	 * [
	 * "address" (string) address or hex-encoded public key
	 * ...,
	 * ]
	 * 3. "account" (string, optional) An account to assign the addresses to.
	 * 
	 * Result:
	 * "address" (string) A address associated with the keys.
	 * 
	 * 
	 * @param numberOfSigRequired
	 * @param publicKeys
	 * @return the P2SH address
	 * @throws MultichainException
	 */
	public final Address addMultiSigAddress(int numberOfSigRequired, String[] publicKeys) throws MultichainException {
		Address address = new Address();

		String stringAddress = executeAddMultiSigAddress(numberOfSigRequired, publicKeys);
		address = validateAddress(stringAddress);

		return address;
	}

	/**
	 * createmultisig nrequired ["key",...]
	 * 
	 * Creates a multi-signature address with n signature of m keys required.
	 * It returns a json object with the address and redeemScript.
	 * 
	 * Arguments:
	 * 1. nrequired (numeric, required) The number of required signatures out of the n keys or addresses.
	 * 2. "keys" (string, required) A json array of keys which are addresses or hex-encoded public keys
	 * [
	 * "key" (string) address or hex-encoded public key
	 * ,...
	 * ]
	 * 
	 * Result:
	 * {
	 * "address":"multisigaddress", (string) The value of the new multisig address.
	 * "redeemScript":"script" (string) The string value of the hex-encoded redemption script.
	 * }
	 * 
	 * 
	 * @param numberOfSigRequired
	 * @param publicKeys
	 * @return The P2SH address and corresponding redeem script.
	 * @throws MultichainException
	 */
	public Address createMultiSig(int numberOfSigRequired, String[] publicKeys) throws MultichainException {
		Address address = new Address();

		String stringAddress = executeCreateMultiSig(numberOfSigRequired, publicKeys);
		address = validateAddress(stringAddress);

		return address;
	}

	/**
	 * getaddresses ( verbose ) with verbose false
	 * 
	 * Returns the list of all addresses in the wallet.
	 * 
	 * Arguments:
	 * 1. "verbose" (boolean, optional, default=false) The account name.
	 * 
	 * Result:
	 * [ (json array of )
	 * "address" (string) an address
	 * or
	 * "address-datails" (object) address details if verbose=true
	 * ,...
	 * ]
	 * 
	 * @return Addresses of the Wallet
	 * @throws MultichainException
	 */
	public final List<String> getAddressesStringList() throws MultichainException {
		List<String> addresses = new ArrayList<String>();

		String stringAddresses = executeGetAddresses(false);
		addresses = AddressFormatter.formatAddressesStringList(stringAddresses);

		return addresses;
	}

	/**
	 * getaddresses
	 * 
	 * Returns the list of all addresses in the wallet.
	 * 
	 * Result:
	 * [ (json array of )
	 * "address" (string) an address
	 * ,...
	 * ]
	 * 
	 * @return Addresses of the Wallet
	 * @throws MultichainException
	 */
	public final List<String> getAddresses() throws MultichainException {
		return getAddressesStringList();
	}

	/**
	 * getaddresses ( verbose ) with verbose true
	 * 
	 * Returns the list of all addresses in the wallet.
	 * 
	 * Arguments:
	 * 1. "verbose" (boolean, optional, default=false) The account name.
	 * 
	 * Result:
	 * [ (json array of )
	 * "address" (string) an address
	 * or
	 * "address-datails" (object) address details if verbose=true
	 * ,...
	 * ]
	 * 
	 * @return Addresses of the Wallet
	 * @throws MultichainException
	 */
	public final List<Address> getAddressesList() throws MultichainException {
		List<Address> addresses = new ArrayList<Address>();

		String stringAddresses = executeGetAddresses(true);
		addresses = AddressFormatter.formatAddressesList(stringAddresses);

		return addresses;
	}

	/**
	 * Returns a list of balances of all addresses in this node’s wallet
	 * 
	 * getmultibalances ("address(es)" assets minconf includeLocked includeWatchonly)
	 * 
	 * Returns asset balances for specified address
	 * 
	 * Arguments:
	 * 1. "address(es)" (string, optional) Address(es) to return balance for, comma delimited. Default - all
	 * or
	 * 1. "address(es)" (array, optional) A json array of addresses to return balance for
	 * 2. "assets" (array, optional) A json array of asset identifiers to return balance for, default - all []
	 * 3. minconf (numeric, optional, default=1) Only include transactions confirmed at least this many times.
	 * 4. includeWatchonly (bool, optional, default=false) Include transactions to watchonly addresses (see
	 * 'importaddress')
	 * 5. includeLocked (bool, optional, default=false) Also take locked outputs into account
	 * Results are an Object of balance arrays with totals and details for each asset.
	 * 
	 * @return Balances
	 */
	public List<MultiBalance> getMultiBalances(String[] addresses) throws MultichainException {
		List<MultiBalance> listMultiBalance = new ArrayList<MultiBalance>();

		String stringMultiBalance = executeGetMultiBalances(addresses);
		listMultiBalance = BalanceFormatter.formatMultiBalances(stringMultiBalance);

		return listMultiBalance;
	}

	/**
	 * {@link #getMultiBalances(String[]) with only 1 address}
	 * 
	 * @param address
	 * @return
	 * @throws MultichainException
	 */
	public List<MultiBalance> getMultiBalances(String address) throws MultichainException {
		String[] addresses = { address };

		return getMultiBalances(addresses);
	}

	/**
	 * {@link #getMultiBalances(String) without address}
	 * 
	 * @return
	 * @throws MultichainException
	 */
	public List<MultiBalance> getMultiBalances() throws MultichainException {
		return getMultiBalances("");
	}

	/**
	 * 
	 * getaddressbalances "address" ( minconf includeLocked )
	 * 
	 * Returns asset balances for specified address
	 * 
	 * Arguments:
	 * 1. "address" (string, required) Address to return balance for.
	 * 2. minconf (numeric, optional, default=1) Only include transactions confirmed at least this many times.
	 * 3. includeLocked (bool, optional, default=false) Also take locked outputs into account
	 * Results are an array of Objects with totals and details for each asset.
	 * 
	 * @param address
	 * @return Balance of the address
	 * @throws MultichainException
	 */
	public List<BalanceAsset> getAddressBalances(String address) throws MultichainException {
		List<BalanceAsset> balance = new ArrayList<BalanceAsset>();

		String stringBalances = executeGetAddressBalances(address);
		balance = BalanceFormatter.formatBalanceAssets(stringBalances);

		return balance;
	}

	/**
	 * 
	 * getnewaddress ( "account" )
	 * 
	 * Returns a new address for receiving payments.
	 * If 'account' is specified (recommended), it is added to the address book
	 * so payments received with the address will be credited to 'account'.
	 * 
	 * Arguments:
	 * 1. "account" (string, optional) The account name for the address to be linked to. if not provided, the default
	 * account "" is used. It can also be set to the empty string "" to represent the default account. The account does
	 * not need to exist, it will be created if there is no account by the given name.
	 * 
	 * Result:
	 * "address" (string) The new address
	 * 
	 * @return Address created
	 * @throws MultichainException
	 */
	public final String getNewAddress() throws MultichainException {
		String stringAddress = executeGetNewAddress();
		return formatString(stringAddress);
	}

	/**
	 * 
	 * getnewaddress ( "account" )
	 * 
	 * Returns a new address for receiving payments.
	 * If 'account' is specified (recommended), it is added to the address book
	 * so payments received with the address will be credited to 'account'.
	 * 
	 * Arguments:
	 * 1. "account" (string, optional) The account name for the address to be linked to. if not provided, the default
	 * account "" is used. It can also be set to the empty string "" to represent the default account. The account does
	 * not need to exist, it will be created if there is no account by the given name.
	 * 
	 * Result:
	 * "address" (string) The new address
	 * 
	 * @return Address created
	 * @throws MultichainException
	 */
	public final Address getNewAddressFilled() throws MultichainException {
		Address address = new Address();

		String stringAddress = executeGetNewAddress();
		address = validateAddress(stringAddress);

		return address;
	}

	/**
	 * Adds address to the wallet, without an associated private key, to create
	 * a watch-only address. This is an address whose activity and balance can
	 * be retrieved , but whose funds cannot be spent by this node
	 * 
	 * importaddress "address" ( "label" rescan )
	 * 
	 * Adds an address or script (in hex) that can be watched as if it were in your wallet but cannot be used to spend.
	 * 
	 * Arguments:
	 * 1. "address" (string, required) The address
	 * 2. "label" (string, optional, default="") An optional label
	 * 3. rescan (boolean, optional, default=true) Rescan the wallet for transactions
	 * 
	 * Note: This call can take minutes to complete if rescan is true.
	 * 
	 * @param address
	 * @param label
	 * @param rescan
	 *            If rescan is true, the entire blockchain is checked for
	 *            transactions relating to all addresses in the wallet,
	 *            including the added one
	 * @throws MultichainException
	 */
	public void importAddress(String address, String label, boolean rescan) throws MultichainException {
		/* String systemMessage = */executeImportAddress(address, label, rescan);
	}

	/**
	 * Get information about an address
	 * 
	 * validateaddress "address"
	 * 
	 * Return information about the given address.
	 * 
	 * Arguments:
	 * 1. "address" (string, required) The address to validate
	 * 
	 * Result:
	 * {
	 * "isvalid" : true|false, (boolean) If the address is valid or not. If not, this is the only property returned.
	 * "address" : "address", (string) The address validated
	 * "ismine" : true|false, (boolean) If the address is yours or not
	 * "isscript" : true|false, (boolean) If the key is a script
	 * "pubkey" : "publickeyhex", (string) The hex value of the raw public key
	 * "iscompressed" : true|false, (boolean) If the address is compressed
	 * "account" : "account" (string) The account associated with the address, "" is the default account
	 * }
	 * 
	 * @param stringAddress
	 *            Address String in multichain
	 * @return Address with Information
	 * @throws MultichainException
	 */
	public final Address validateAddress(String stringAddress) throws MultichainException {
		Address address = new Address();

		String stringAddressInfo = executeValidateAddress(stringAddress);
		address = AddressFormatter.formatAddress(stringAddressInfo);

		return address;
	}

}
