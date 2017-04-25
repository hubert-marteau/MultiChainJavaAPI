package multichain.command.builders;

import multichain.command.MultichainException;
import multichain.command.tools.MultichainTestParameter;

/**
 * Created by Jagrut on 21-04-2017.
 */
public class QueryBuilderStream extends QueryBuilderCommon {

    /**
     * Create a new stream, assuming that the node from which this command is executed has only one wallet address
     * and that address has the 'create' permission.
     *
     * @param streamName the name of the new stream, without spaces. If there are any whitespace characters, they will
     *                   be removed.
     * @param openOrClose true: allow anyone with send permission to write into this stream.
     *                    false: an address needs to have send permission to write into this stream.
     * @return {transactionID} the transaction ID of the transaction made to make this change in the block chain
     * @throws MultichainException
     */
    protected static String executeCreate(String streamName, boolean openOrClose) throws MultichainException {
        MultichainTestParameter.isNotNullOrEmpty("streamName", streamName);
        streamName = streamName.replaceAll("\\s", "");
        String params = "stream " + streamName + " " + String.valueOf(openOrClose);
        return execute(CommandEnum.CREATE, params);
    }

    /**
     * Create a new stream with the command executed from the specified wallet address, in case there are multiple
     * addresses and assuming that the address has 'create' permission. If it does not have the permission, use 'grant'.
     *
     * @param fromAddress the wallet address that has the permission to create a stream
     * @param streamName the name of the new stream, without spaces. If there are any whitespace characters, they will
     *                   be removed.
     * @param openOrClose true: allow anyone with send permission to write into this stream.
     *                    false: an address needs to have send permission to write into this stream.
     * @return {transactionID} the transaction ID of the transaction made to make this change in the block chain
     * @throws MultichainException
     */
    protected static String executeCreateFrom(String fromAddress, String streamName, boolean openOrClose)
            throws MultichainException {
        MultichainTestParameter.isNotNullOrEmpty("streamName", streamName);
        MultichainTestParameter.isNotNullOrEmpty("fromAddress", fromAddress);
        streamName = streamName.replaceAll("\\s", "");
        String params = fromAddress + " stream " + streamName + " " + String.valueOf(openOrClose);;
        return execute(CommandEnum.CREATEFROM, params);
    }

    /**
     * List the detailed information for all streams or the information of streams passed in the parameters.
     * Params include (in exact order i.e. you cannot skip a param. But passing first 1 or 2 or 3 or none is allowed):
     * 1) streams = {comma separated names of the streams} -> "streamName1, streamName2" (default: all)
     * 2) verbose = {true/false} -> pass boolean "true" or "false" as string (default: false)
     * 3) count = {any integer} Limit number of entries -> pass an integer as string (default: all)
     * 4) start = {any integer} Start from a certain entry after skipping start entries -> pass integer as string
     *              (default: most recent)
     *
     * @param allParams (optional) Pass a list of params
     * @return {String} output as a String JSON format
     * @throws MultichainException
     */
    protected static String executeListStreams(String... allParams) throws MultichainException {
        String params = "";
        for(int i = 0; i < allParams.length; i++){
            if(i == 0) {
                allParams[i] = allParams[i].replaceAll(" ", "");
                String streamNames[] = allParams[i].split(",");
                String OS = System.getProperty("os.name").toLowerCase();
                if(OS.contains("win")) {
                    String streamNamesParam = "[";
                    for(int j = 0; j < streamNames.length; j++) {
                        streamNamesParam += (j != streamNames.length - 1) ?  ("\"\"\"" + streamNames[j] + "\"\"\",") :
                                ("\"\"\"" + streamNames[j] + "\"\"\"");
                    }
                    streamNamesParam += "]";
                    params += streamNamesParam;
                } else {
                    String streamNamesParam = "'[";
                    for(int j = 0; j < streamNames.length; j++) {
                        streamNamesParam += (j != streamNames.length - 1) ?  ("\"" + streamNames[j] + "\",") :
                                ("\"" + streamNames[j] + "\"");
                    }
                    streamNamesParam += "]'";
                    params += streamNamesParam;
                }
            } else {
                params += " " + allParams[i];
            }
        }
        return execute(CommandEnum.LISTSTREAMS, params);
    }
}
