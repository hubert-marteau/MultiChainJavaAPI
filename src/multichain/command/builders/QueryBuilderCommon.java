/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command.builders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import multichain.command.MultichainException;
import multichain.object.formatters.GsonFormatters;

/**
 * @author Ub - H. MARTEAU
 * @version 2.1
 */
abstract class QueryBuilderCommon extends GsonFormatters {

	private String CHAIN = "";

	protected enum CommandEnum
	{
		ADDMULTISIGADDRESS,
		ADDNODE,
		APPENDRAWCHANGE,
		APPENDRAWEXCHANGE,
		APPENDROWMETADA,
		CLEARMEMPOOL,
		COMBINEUNPSENT,
		CREATE,
		CREATEMULTISIG,
		CREATERAWEXCHANGE,
		CREATERAWSENDFROM,
		CREATERAWTRANSACTION,
		DECODERAWEXCHANGE,
		DECODERAWTRANSACTION,
		DISABLERAWTRANSACTION,
		DUMPPRIVKEY,
		GETADDRESSBALANCES,
		GETADDRESSES,
		GETADDRESSTRANSACTION,
		GETASSETBALANCES,
		GETBESTBLOCKHASH,
		GETBLOCK,
		GETBLOCKCHAINPARAMS,
		GETBLOCKCOUNT,
		GETBLOCKHASH,
		GETINFO,
		GETMULTIBALANCES,
		GETNEWADDRESS,
		GETRAWCHANGEADDRESS,
		GETPEERINFO,
		GETRAWTRANSACTION,
		GETTOTALBALANCES,
		GETTRANSACTION,
		GETTXOUT,
		GETUNCONFIRMEDBALANCE,
		GETWALLETTRANSACTION,
		GRANT,
		GRANTFROM,
		GRANTWITHMETADATA,
		GRANTWITHMETADATAFROM,
		HELP,
		IMPORTADDRESS,
		IMPORTPRIVKEY,
		ISSUE,
		ISSUEFROM,
		ISSUEMORE,
		ISSUEMOREFROM,
		LISTADDRESSTRANSACTIONS,
		LISTASSETS,
		LISTLOCKUNPSENT,
		LISTPERMISSIONS,
		LISTSTREAMKEYITEMS,
		LISTUNSPENT,
		LISTWALLETTRANSACTIONS,
		LOCKUNSPENT,
		PAUSE,
		PING,
		PREPARELOCKUNSPENT,
		PREPARELOCKUNSPENTFROM,
		PUBLISH,
		RESUME,
		REVOKE,
		REVOKEFROM,
		SENDASSETFROM,
		SENDASSETTOADDRESS,
		SENDFROM,
		SENDFROMADDRESS,
		SENDRAWTRANSACTION,
		SENDTOADDRESS,
		SENDWITHMETADATA,
		SENDWITHMETADATAFROM,
		SETLASTBLOCK,
		SIGNMESSAGE,
		SIGNRAWTRANSACTION,
		STOP,
		SUBSCRIBE,
		VALIDATEADDRESS,
		VERIFYMESSAGE
	}

	private String removeHeader(String result) {
		String resultWithoutHeader = "";
		int size = 16 + CHAIN.length();
		int index = 0;
		index = result.indexOf("\"chain_name\":\"" + CHAIN + "\"");
		resultWithoutHeader = resultWithoutHeader.concat(result.substring(index + size));
		return resultWithoutHeader;
	}

	/**
	 * 
	 * @param command
	 * @param parameter
	 * 
	 * @return
	 * 
	 *         example :
	 *         MultichainQueryBuidlder.executeProcess(MultichainCommand
	 *         .SENDTOADDRESS,"1EyXuq2JVrj4E3CpM9iNGNSqBpZ2iTPdwGKgvf
	 *         {\"rdcoin\":0.01}"
	 * @throws MultichainException
	 */
	protected String execute(CommandEnum command, String... parameters) throws MultichainException {

		if (!CHAIN.equals("")) {
			Runtime rt = Runtime.getRuntime();
			Process pr;
			String result = "";
			String errorResult = "";
			String errorBody = "";
			boolean error = false;
			try {
				String commandToCall = "C:\\multichain\\multichain-cli.exe " + CHAIN + " "
						+ command.toString().toLowerCase();
				String params = "";
				if (parameters.length > 0) {
					for (String parameter : parameters) {
						params = params.concat(" " + parameter);
					}
				}
				commandToCall = commandToCall.concat(params);
				System.out.println(commandToCall);
				pr = rt.exec(commandToCall);

				BufferedReader stdInput = new BufferedReader(new InputStreamReader(pr.getInputStream()));

				BufferedReader stdError = new BufferedReader(new InputStreamReader(pr.getErrorStream()));

				// read the output from the command
				String s = null;
				while ((s = stdInput.readLine()) != null) {
					result = result.concat(s + "\n");
				}

				// read any errors from the attempted command
				while ((s = stdError.readLine()) != null) {
					errorResult = errorResult.concat(s + "\n");
				}
				errorBody = removeHeader(errorResult);

				if (errorBody != null && !"".equals(errorBody.replace("\n", ""))) {
					error = true;
					result = result.concat(errorBody + "\n");
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (error) {
				throw new MultichainException(null, result);
			} else {
				return result;
			}
		} else {
			return "ERROR, CHAIN NAME ARE EMPTY !";
		}

	}

	/**
	 * @return the cHAIN
	 */
	protected String getCHAIN() {
		return CHAIN;
	}

	/**
	 * @param cHAIN
	 *            the cHAIN to set
	 */
	protected void setCHAIN(String cHAIN) {
		CHAIN = cHAIN;
	}

}
