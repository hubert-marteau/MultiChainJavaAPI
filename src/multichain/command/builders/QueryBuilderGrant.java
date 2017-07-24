/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command.builders;

import multichain.command.MultichainException;
import multichain.command.tools.MultichainTestParameter;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0
 */
public class QueryBuilderGrant extends QueryBuilderCommon {

	protected static byte CONNECT = (byte) 0b0000001;
	protected static byte SEND = (byte) 0b0000010;
	protected static byte RECEIVE = (byte) 0b0000100;
	protected static byte ISSUE = (byte) 0b0001000;
	protected static byte MINE = (byte) 0b0010000;
	protected static byte ACTIVATE = (byte) 0b0100000;
	protected static byte ADMIN = (byte) 0b1000000;

	protected static int WALLET = CONNECT | SEND | RECEIVE;
	protected static int WALLET_ISSUE = WALLET | ISSUE;

	private static String CONNECT_STR = "connect";
	private static String SEND_STR = "send";
	private static String RECEIVE_STR = "receive";
	private static String ISSUE_STR = "issue";
	private static String MINE_STR = "mine";
	private static String ACTIVATE_STR = "activate";
	private static String ADMIN_STR = "admin";

	private static String formatPermissionsList(int permissions) {
		String permissionsFormated = "";

		if ((permissions & CONNECT) > 0) {
			permissionsFormated = permissionsFormated.concat(CONNECT_STR);
		}
		if ((permissions & SEND) > 0) {
			if (permissionsFormated.length() > 0) {
				permissionsFormated = permissionsFormated.concat(",");
			}
			permissionsFormated = permissionsFormated.concat(SEND_STR);
		}
		if ((permissions & RECEIVE) > 0) {
			if (permissionsFormated.length() > 0) {
				permissionsFormated = permissionsFormated.concat(",");
			}
			permissionsFormated = permissionsFormated.concat(RECEIVE_STR);
		}
		if ((permissions & ISSUE) > 0) {
			if (permissionsFormated.length() > 0) {
				permissionsFormated = permissionsFormated.concat(",");
			}
			permissionsFormated = permissionsFormated.concat(ISSUE_STR);
		}
		if ((permissions & MINE) > 0) {
			if (permissionsFormated.length() > 0) {
				permissionsFormated = permissionsFormated.concat(",");
			}
			permissionsFormated = permissionsFormated.concat(MINE_STR);
		}
		if ((permissions & ACTIVATE) > 0) {
			if (permissionsFormated.length() > 0) {
				permissionsFormated = permissionsFormated.concat(",");
			}
			permissionsFormated = permissionsFormated.concat(ACTIVATE_STR);
		}
		if ((permissions & ADMIN) > 0) {
			if (permissionsFormated.length() > 0) {
				permissionsFormated = permissionsFormated.concat(",");
			}
			permissionsFormated = permissionsFormated.concat(ADMIN_STR);
		}
		return permissionsFormated;
	}

	/**
	 * Grants permissions to addresses
	 * 
	 * grant "address(es)" "permission(s)" ( native-amount "comment" "comment-to" startblock endblock )
	 * 
	 * Grant permission(s) to a given address.
	 * 
	 * Arguments:
	 * 1. "address(es)" (string, required) The multichain addresses to send to (comma delimited)
	 * 2. "permission(s)" (string, required) Permission strings, comma delimited. Possible values:
	 * connect,send,receive,issue,mine,admin,activate
	 * 3. "native-amount" (numeric, optional) native currency amount to send. eg 0.1. Default - 0.0
	 * 4. "startblock" (numeric, optional) Block to apply permissions from (inclusive). Default - 0
	 * 5. "endblock" (numeric, optional) Block to apply permissions to (exclusive). Default - 4294967295
	 * If -1 is specified default value is used.
	 * 6. "comment" (string, optional) A comment used to store what the transaction is for.
	 * This is not part of the transaction, just kept in your wallet.
	 * 7. "comment-to" (string, optional) A comment to store the name of the person or organization
	 * to which you're sending the transaction. This is not part of the
	 * transaction, just kept in your wallet.
	 * 
	 * Result:
	 * "transactionid" (string) The transaction id.
	 * 
	 * 
	 * @param address
	 * @param permissions
	 *            This permissions will be grant to all addresses who are send
	 *            in parameter
	 * @return the txid of the transaction granting the permissions
	 * @throws MultichainException
	 */
	protected String executeGrant(String address, int permissions) throws MultichainException {
		String permissionsFormated = formatPermissionsList(permissions);

		MultichainTestParameter.isNotNullOrEmpty("address", address);
		MultichainTestParameter.isNotNullOrEmpty("permissionsFormated", permissionsFormated);

		return execute(CommandEnum.GRANT, formatJson(address), formatJson(permissionsFormated));
	}

	/**
	 * Grants permissions to addresses From an address
	 * 
	 * grantfrom "from-address" "to-address(es)" "permission(s)" ( native-amount "comment" "comment-to" startblock
	 * endblock )
	 * 
	 * Grant permission using specific address.
	 * 
	 * Arguments:
	 * 1. "from-address" (string, required) Address used for grant.
	 * 2. "to-address(es)" (string, required) The multichain addresses to grant permissions to
	 * 3. "permission(s)" (string, required) Permission strings, comma delimited. Possible values:
	 * connect,send,receive,issue,mine,admin,activate
	 * 4. "native-amount" (numeric, optional) native currency amount to send. eg 0.1. Default - 0.0
	 * 5. "startblock" (numeric, optional) Block to apply permissions from (inclusive). Default - 0
	 * 6. "endblock" (numeric, optional) Block to apply permissions to (exclusive). Default - 4294967295
	 * If -1 is specified default value is used.
	 * 7. "comment" (string, optional) A comment used to store what the transaction is for.
	 * This is not part of the transaction, just kept in your wallet.
	 * 8. "comment-to" (string, optional) A comment to store the name of the person or organization
	 * to which you're sending the transaction. This is not part of the
	 * transaction, just kept in your wallet.
	 * 
	 * Result:
	 * "transactionid" (string) The transaction id.
	 * 
	 * 
	 * @param addressFrom
	 *            address origin
	 * @param address
	 *            address destination
	 * @param permissions
	 *            This permissions will be grant to all addresses who are send
	 *            in parameter
	 * @return the txid of the transaction granting the permissions
	 * @throws MultichainException
	 */
	protected String executeGrantFrom(String addressFrom, String address, int permissions) throws MultichainException {
		String permissionsFormated = formatPermissionsList(permissions);

		MultichainTestParameter.isNotNullOrEmpty("addressFrom", addressFrom);
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		MultichainTestParameter.isNotNullOrEmpty("permissionsFormated", permissionsFormated);

		return execute(CommandEnum.GRANTFROM, formatJson(addressFrom), formatJson(address),
				formatJson(permissionsFormated));
	}

	/**
	 * 
	 * listpermissions ("permission(s)" "address" verbose)
	 * 
	 * Returns list of addresses having one of the specified permissions
	 * 
	 * Arguments:
	 * 1. "permission(s)" (string, optional) Permission strings, comma delimited. Possible values:
	 * connect,send,receive,issue,mine,admin,activate. Default: all.
	 * 2. "address" (string, optional) The addresses to retrieve permissions for. "" or "*" for all addresses
	 * 3. verbose (boolean, optional, default=false) If true, returns list of pending grants
	 * 
	 * @param permissions
	 * @param address
	 *            to get permissions
	 * @param verbose
	 * @return a list of all permissions currently granted to addresses.
	 * @throws MultichainException
	 */
	protected String executeListPermissions(int permissions, String address, boolean verbose)
			throws MultichainException {
		String permissionsFormated = formatPermissionsList(permissions);

		String listPermissions = "";

		if (permissionsFormated == null || "".equals(permissionsFormated)) {
			listPermissions = execute(CommandEnum.LISTPERMISSIONS, "all");
		} else if (address == null || "".equals(address)) {
			listPermissions = execute(CommandEnum.LISTPERMISSIONS, "all", formatJson(permissionsFormated));
		} else {
			listPermissions = execute(CommandEnum.LISTPERMISSIONS, "all", formatJson(permissionsFormated),
					formatJson(address), formatJson(verbose));
		}

		return listPermissions;
	}

	/**
	 * Revoke permissions to addresses
	 * 
	 * revoke "address(es)" "permission(s)" ( native-amount "comment" "comment-to" )
	 * 
	 * Revoke permission from a given address. The amount is a real
	 * 
	 * Arguments:
	 * 1. "address(es)" (string, required) The addresses(es) to revoke permissions from
	 * 2. "permission(s)" (string, required) Permission strings, comma delimited. Possible values:
	 * connect,send,receive,issue,mine,admin
	 * 3. "native-amount" (numeric, optional) native currency amount to send. eg 0.1. Default - 0
	 * 4. "comment" (string, optional) A comment used to store what the transaction is for.
	 * This is not part of the transaction, just kept in your wallet.
	 * 5. "comment-to" (string, optional) A comment to store the name of the person or organization
	 * to which you're sending the transaction. This is not part of the
	 * transaction, just kept in your wallet.
	 * 
	 * Result:
	 * "transactionid" (string) The transaction id.
	 * 
	 * @param address
	 * @param permissions
	 *            This permissions will be grant to all addresses who are send
	 *            in parameter
	 * @return the txid of the transaction revoking the permissions
	 * @throws MultichainException
	 */
	protected String executeRevoke(String address, int permissions) throws MultichainException {
		String permissionsFormated = formatPermissionsList(permissions);

		MultichainTestParameter.isNotNullOrEmpty("address", address);
		MultichainTestParameter.isNotNullOrEmpty("permissionsFormated", permissionsFormated);

		return execute(CommandEnum.REVOKE, formatJson(address), formatJson(permissionsFormated));
	}

	/**
	 * Revoke permissions to addresses From an address
	 * 
	 * revokefrom "from-address" "to-address(es)" "permission(s)" ( native-amount "comment" "comment-to" )
	 * 
	 * Revoke permissions using specific address.
	 * 
	 * Arguments:
	 * 1. "from-address" (string, required) Addresses used for revoke.
	 * 2. "to-address(es)" (string, required) The addresses(es) to revoke permissions from. Comma delimited
	 * 3. "permission(s)" (string, required) Permission strings, comma delimited. Possible values:
	 * connect,send,receive,issue,mine,admin
	 * 4. "native-amount" (numeric, optional) native currency amount to send. eg 0.1. Default - 0
	 * 5. "comment" (string, optional) A comment used to store what the transaction is for.
	 * This is not part of the transaction, just kept in your wallet.
	 * 6. "comment-to" (string, optional) A comment to store the name of the person or organization
	 * to which you're sending the transaction. This is not part of the
	 * transaction, just kept in your wallet.
	 * 
	 * Result:
	 * "transactionid" (string) The transaction id.
	 * 
	 * 
	 * @param addressFrom
	 *            address origin
	 * @param address
	 *            address destination
	 * @param permissions
	 *            This permissions will be grant to all addresses who are send
	 *            in parameter
	 * @return the txid of the transaction revoking the permissions
	 * @throws MultichainException
	 */
	protected String executeRevokeFrom(String addressFrom, String address, int permissions) throws MultichainException {
		String permissionsFormated = formatPermissionsList(permissions);

		MultichainTestParameter.isNotNullOrEmpty("addressFrom", addressFrom);
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		MultichainTestParameter.isNotNullOrEmpty("permissionsFormated", permissionsFormated);

		return execute(CommandEnum.REVOKE, formatJson(addressFrom), formatJson(address),
				formatJson(permissionsFormated));
	}
}
