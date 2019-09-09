/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

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
import multichain.object.MultiChainRPCAnswer;
import multichain.object.formatters.GsonFormatters;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.1
 */
abstract class QueryBuilderCommon extends GsonFormatters {

  private CloseableHttpClient httpclient = null;
  private HttpPost httppost = null;
  private RuntimeParameters queryParameters = null;


  protected QueryBuilderCommon() {
    super();
  }

  protected void initialize(String ip, String port, String login, String password,
      RuntimeParameters queryParameter) {
    httppost = new HttpPost("http://" + ip + ":" + port);

    CredentialsProvider provider = new BasicCredentialsProvider();
    UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(login, password);
    provider.setCredentials(AuthScope.ANY, credentials);
    queryParameters = queryParameter;

    httpclient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

  }

  /**
   * 
   * @param command
   * @param parameters
   * 
   * @return
   * 
   *         example : MultichainQueryBuidlder.executeProcess(MultichainCommand .SENDTOADDRESS,
   *         "1EyXuq2JVrj4E3CpM9iNGNSqBpZ2iTPdwGKgvf {\"rdcoin\":0.01}"
   * @throws MultichainException
   */
  protected Object execute(CommandElt command, Object... parameters) throws MultichainException {

    if (httpclient != null && httppost != null) {
      try {
        // Generate Mapping of calling arguments
        Map<String, Object> entityValues = prepareMap(this.queryParameters, command, parameters);
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


  protected StringEntity prepareRpcEntity(Map<String, Object> entityValues)
      throws UnsupportedEncodingException {
    return new StringEntity(formatJson(entityValues));
  }

  private Object executeRequest() throws IOException, ClientProtocolException, MultichainException {
    CloseableHttpResponse response = httpclient.execute(httppost);

    HttpEntity entity = response.getEntity();

    String rpcAnswer = EntityUtils.toString(entity);
    response.close();

    final Gson gson = new GsonBuilder().create();
    final MultiChainRPCAnswer multiChainRPCAnswer =
        gson.fromJson(rpcAnswer, MultiChainRPCAnswer.class);

    if (multiChainRPCAnswer != null && multiChainRPCAnswer.getError() == null) {
      return multiChainRPCAnswer.getResult();
    } else if (multiChainRPCAnswer != null && multiChainRPCAnswer.getError() != null) {
      throw new MultichainException(
          "code :" + multiChainRPCAnswer.getError().get("code").toString(),
          "message : " + multiChainRPCAnswer.getError().get("message").toString());
    } else {
      throw new MultichainException(null, "General RPC Exceution Technical Error");
    }
  }

  private Map<String, Object> prepareMap(RuntimeParameters queryparameter, CommandElt command,
      Object... parameters) {
    Map<String, Object> entityValues = new HashMap<String, Object>();
    entityValues.put("id", UUID.randomUUID().toString());
    if (queryparameter != null) {
      if (queryparameter.getDatadir() != null && !queryparameter.getDatadir().isEmpty()) {
        entityValues.put("datadir", queryparameter.getDatadir());
      }
      if (queryparameter.getRpcport() != null && !queryparameter.getRpcport().isEmpty()) {
        entityValues.put("rpcport", queryparameter.getRpcport());
      }
    }
    entityValues.put("method", command.getCommandline());
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
