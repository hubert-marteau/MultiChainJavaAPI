/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command.builders;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import multichain.command.MultichainException;
import multichain.object.MultiChainRPCAnswer;
import multichain.object.formatters.GsonFormatters;

/**
 * @author Ub - H. MARTEAU & Jagrut KOSTI
 * @version 4.8
 */
abstract class QueryBuilderCommon extends GsonFormatters {

	private CloseableHttpClient httpclient = null;
	private HttpPost httppost = null;

	protected enum CommandEnum {
								ADDMULTISIGADDRESS,
								ADDNODE,
								APPENDRAWCHANGE,
								APPENDRAWEXCHANGE,
								APPENDROWMETADA,
								CLEARMEMPOOL,
								COMBINEUNPSENT,
								CREATE,
								CREATEFROM,
								CREATEKEYPAIRS,
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
								GETSTREAMITEM,
								GETTOTALBALANCES,
								GETTRANSACTION,
								GETTXOUT,
								GETTXOUTDATA,
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
								LISTSTREAMITEMS,
								LISTSTREAMKEYITEMS,
								LISTSTREAMKEYS,
								LISTSTREAMPUBLISHERS,
								LISTSTREAMPUBLISHERITEMS,
								LISTSTREAMS,
								LISTUNSPENT,
								LISTWALLETTRANSACTIONS,
								LOCKUNSPENT,
                                LISTBLOCKS,
								PAUSE,
								PING,
								PREPARELOCKUNSPENT,
								PREPARELOCKUNSPENTFROM,
								PUBLISH,
								PUBLISHFROM,
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
								UNSUBSCRIBE,
								VALIDATEADDRESS,
								VERIFYMESSAGE,
								SENDWITHDATA,
								SENDWITHDATAFROM
	}

	protected void initialize(String ip, String port, String login, String password) {
		httppost = new HttpPost("http://" + ip + ":" + port);

		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(login, password);
		provider.setCredentials(AuthScope.ANY, credentials);

		httpclient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

	}

	/**
	 * 
	 * @param command
	 * @param parameters
	 * 
	 * @return
	 * 
	 * 		example :
	 *         MultichainQueryBuidlder.executeProcess(MultichainCommand
	 *         .SENDTOADDRESS,"1EyXuq2JVrj4E3CpM9iNGNSqBpZ2iTPdwGKgvf
	 *         {\"rdcoin\":0.01}"
	 * @throws MultichainException
	 */
	protected Object execute(CommandEnum command, Object... parameters) throws MultichainException {

		if (httpclient != null && httppost != null) {
			try {
				// Generate Mapping of calling arguments
				Map<String, Object> entityValues = prepareMap(command, parameters);
				// Generate the entity and initialize request
				StringEntity rpcEntity = prepareRpcEntity(entityValues);
				httppost.setEntity(rpcEntity);
				// Execute the request and get the answer
				return executeRequest();

			} catch (IOException e) {
				e.printStackTrace();
				throw new MultichainException(null, e.toString());
			}
		} else {
			throw new MultichainException("Initialization Problem",
					"MultiChainCommand not initialized, please specify ip, port, user and pwd !");

		}
	}

	protected StringEntity prepareRpcEntity(Map<String, Object> entityValues) throws UnsupportedEncodingException {
		return new StringEntity(formatJson(entityValues));
	}

	private Object executeRequest() throws IOException, ClientProtocolException, MultichainException {
		CloseableHttpResponse response = httpclient.execute(httppost);
//		int statusCode = response.getStatusLine().getStatusCode();
//		if (statusCode >= 400) {
//			EntityUtils.consume(response.getEntity());
//			throw new MultichainException("code :" + statusCode, "message : " + response.getStatusLine().getReasonPhrase());
//		}
		HttpEntity entity = response.getEntity();

		String rpcAnswer = EntityUtils.toString(entity);
		response.close();

		final Gson gson = new GsonBuilder().create();
		final MultiChainRPCAnswer multiChainRPCAnswer = gson.fromJson(rpcAnswer, MultiChainRPCAnswer.class);

		if (multiChainRPCAnswer != null && multiChainRPCAnswer.getError() == null) {
			return multiChainRPCAnswer.getResult();
		} else if (multiChainRPCAnswer != null && multiChainRPCAnswer.getError() != null) {
			throw new MultichainException("code :" + multiChainRPCAnswer.getError().get("code").toString(),
					"message : " + multiChainRPCAnswer.getError().get("message").toString());
		} else {
			throw new MultichainException(null, "General RPC Exceution Technical Error");
		}
	}

	private Map<String, Object> prepareMap(CommandEnum command, Object... parameters) {
		Map<String, Object> entityValues = new HashMap<String, Object>();
		entityValues.put("id", UUID.randomUUID().toString());
		entityValues.put("method", command.toString().toLowerCase());
		List<Object> paramList = new ArrayList<Object>(Arrays.asList(parameters));
		entityValues.put("params", paramList);
		return entityValues;
	}

	@SuppressWarnings("rawtypes")
	protected boolean verifyInstance(Object obj, Class TheClass) {
		return TheClass.isInstance(obj);
	}

	@SuppressWarnings("rawtypes")
	protected boolean verifyInstanceofList(List<Object> obj, Class TheClass) {
		boolean verify = true;

		// Verify only the first Element of the list
		if (obj.size() > 0) {
			Object objElt = obj.get(0);
			if (!LinkedTreeMap.class.isInstance(objElt)) {
				verify = TheClass.isInstance(objElt);
			}
		}

		return verify;
	}

}
