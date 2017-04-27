package multichain.command.builders;

import multichain.command.MultichainException;
import multichain.command.tools.MultichainTestParameter;

/**
 * @author Jagrut Kosti on 21-04-2017.
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
        return execute(CommandEnum.CREATE, "stream", streamName, String.valueOf(openOrClose));
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
        return execute(CommandEnum.CREATEFROM, fromAddress, "stream", streamName, String.valueOf(openOrClose));
    }

    /**
     * List the detailed information for all streams or the information of streams passed in the parameters.
     * Params include (in exact order i.e. you cannot skip a param. But passing first 1 or 2 or 3 or none is allowed.
     * Pass default value instead of skipping):
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
        return execute(CommandEnum.LISTSTREAMS, separateIdentifierFromFormatParams(allParams));
    }

    /**
     * Publish the given data to the specified stream. This works if the node has only one wallet address associated
     * with it and assumes that it has the write permission
     *
     * @param streamName the name of the stream where you want to publish the data
     * @param key the key associated with the data
     * @param hexData the data to be embedded into the blockchain in hexadecimal string without spaces or tabs
     * @return  {transactionId} he transaction ID of the transaction made to make this change in the block chain
     * @throws MultichainException
     */
    protected static String executePublish(String streamName, String key, String hexData) throws MultichainException {
        MultichainTestParameter.isNotNullOrEmpty("streamName", streamName);
        MultichainTestParameter.isNotNullOrEmpty("key", key);
        MultichainTestParameter.isNotNullOrEmpty("hexData", hexData);
        return execute(CommandEnum.PUBLISH, streamName, key, hexData);
    }

    /**
     * Publish the given data to the specified stream. This requires the addresses that wants to publish the data in
     * the stream and assuming that address has the write permission to write in the specified stream.
     *
     * @param fromAddress the wallet address that should publish the data
     * @param streamName the name of the stream where you want to publish the data
     * @param key the key associated with the data
     * @param hexData the data to be embedded into the blockchain in hexadecimal string without spaces or tabs
     * @return  {transactionId} he transaction ID of the transaction made to make this change in the block chain
     * @throws MultichainException
     */
    protected static String executePublishFrom(String fromAddress, String streamName, String key, String hexData) throws MultichainException {
        MultichainTestParameter.isNotNullOrEmpty("fromAddress", fromAddress);
        MultichainTestParameter.isNotNullOrEmpty("streamName", streamName);
        MultichainTestParameter.isNotNullOrEmpty("key", key);
        MultichainTestParameter.isNotNullOrEmpty("hexData", hexData);
        return execute(CommandEnum.PUBLISHFROM, fromAddress, streamName, key, hexData);
    }

    /**
     * Subscribe to the specified asset or stream to read or write from these streams or assets
     *
     * @param assetOrStreamNames the names of assets or streams in single comma separated string
     * @param rescan (optional) to reindex all items or not
     * @throws MultichainException
     */
    protected static void executeSubscribe(String assetOrStreamNames, String... rescan) throws MultichainException {
        MultichainTestParameter.isNotNullOrEmpty("assetOrStreamNames", assetOrStreamNames);
        assetOrStreamNames = assetOrStreamNames.replaceAll(" ", "");
        assetOrStreamNames = formatStringArrayOS(assetOrStreamNames.split(","));
        if(rescan.length > 0)
            execute(CommandEnum.SUBSCRIBE, assetOrStreamNames, rescan[0]);
        else
            execute(CommandEnum.SUBSCRIBE, assetOrStreamNames, "true");
    }

    /**
     * Unsubscribe and stop tracking the specified assets or streams
     *
     * @param assetOrStreamNames the names of assets or streams in single comma separated string
     * @throws MultichainException
     */
    protected static void executeUnsubscribe(String assetOrStreamNames) throws MultichainException {
        MultichainTestParameter.isNotNullOrEmpty("assetOrStreamNames", assetOrStreamNames);
        assetOrStreamNames = assetOrStreamNames.replaceAll(" ", "");
        assetOrStreamNames = formatStringArrayOS(assetOrStreamNames.split(","));
        execute(CommandEnum.UNSUBSCRIBE, assetOrStreamNames);
    }

    /**
     * Returns the specific stream item of given stream, identified with given txid.
     *
     * @param streamName the name of the stream to search for
     * @param txId the transaction id of the item to retrieve
     * @param verbose (optional) If true, returns additional information about the item. Pass as string. Eg: "true"
     * @return {String} String in JSON format with all the data about the item
     * @throws MultichainException
     */
    protected static String executeGetStreamItem(String streamName, String txId, String... verbose)
            throws MultichainException{
        MultichainTestParameter.isNotNullOrEmpty("streamName", streamName);
        MultichainTestParameter.isNotNullOrEmpty("txId", txId);
        if(verbose.length > 0)
            return execute(CommandEnum.GETSTREAMITEM, streamName, txId, verbose[0]);
        else
            return execute(CommandEnum.GETSTREAMITEM, streamName, txId);
    }

    /**
     * Returns all items in the specified stream that has the given key value.
     *
     * @param streamName the name of the stream to search into
     * @param key the key of the item to retrieve
     * @param formatParams (optional) FormatParams in exact order; each represented as individual string (you cannot
     *                     skip any parameters. But passing first 1 or 2 or 3 or none is allowed. Pass default value
     *                     instead of skipping:
     *                     1) verbose: {true/false} -> pass boolean "true" or "false" as string (default: false)
     *                     2) count: {any integer} Limit number of entries -> pass an integer as string (default: 10)
     *                     3) start: {any integer} Start from a certain entry after skipping start entries
     *                                  -> pass integer as string(default: most recent)
     *                     4)local-ordering: {true/false} If true, order items based on when this local node has seen
     *                                      the item rather than chain ordering (default: false)
     * @return {String} String in JSON format with all items that has the given key
     * @throws MultichainException
     */
    protected static String executeListStreamKeyItems(String streamName, String key, String... formatParams)
            throws MultichainException {
        MultichainTestParameter.isNotNullOrEmpty("streamName", streamName);
        MultichainTestParameter.isNotNullOrEmpty("key", key);
        StringBuilder extraParams = new StringBuilder();
        for (String param : formatParams) {
            extraParams.append(param).append(" ");
        }
        return execute(CommandEnum.LISTSTREAMKEYITEMS, streamName, key, extraParams.toString());
    }

    /**
     * Returns all the keys that exists in the mentioned stream. Can also pass specific key to search for or list of
     * keys to search for.
     *
     * @param streamName the name of the stream to search into
     * @param allParams (optional) Keys + Format params in exact order; each represented as individual string (you cannot
     *                     skip any parameters. But passing first 1 or 2 or 3 or none is allowed. Pass default value
     *                     instead of skipping:
     *                     1) keys: {comma separated list of keys to search as single string} (default: *)
     *                     2) verbose: {true/false} -> pass boolean "true" or "false" as string (default: false)
     *                     3) count: {any integer} Limit number of entries -> pass an integer as string (default: 10)
     *                     4) start: {any integer} Start from a certain entry after skipping start entries
     *                                  -> pass integer as string(default: most recent)
     *                     5)local-ordering: {true/false} If true, order items based on when this local node has seen
     *                                      the item rather than chain ordering (default: false)
     * @return {String} String in JSON format with all keys found with their metadata
     * @throws MultichainException
     */
    protected static String executeListStreamKeys(String streamName, String... allParams) throws MultichainException {
        MultichainTestParameter.isNotNullOrEmpty("streamName", streamName);
        return execute(CommandEnum.LISTSTREAMKEYS, streamName, separateIdentifierFromFormatParams(allParams));
    }

    /**
     * Returns all the items present in the mentioned stream, including unconfirmed items.
     *
     * @param streamName the name of the stream to get items from
     * @param formatParams (optional) FormatParams in exact order; each represented as individual string (you cannot
     *                     skip any parameters. But passing first 1 or 2 or 3 or none is allowed. Pass default value
     *                     instead of skipping:
     *                     1) verbose: {true/false} -> pass boolean "true" or "false" as string (default: false)
     *                     2) count: {any integer} Limit number of entries -> pass an integer as string (default: 10)
     *                     3) start: {any integer} Start from a certain entry after skipping start entries
     *                                  -> pass integer as string(default: most recent)
     *                     4)local-ordering: {true/false} If true, order items based on when this local node has seen
     *                                      the item rather than chain ordering (default: false)
     * @return {String} String in JSON format with all the items present in the stream
     * @throws MultichainException
     */
    protected static String executeListStreamItems(String streamName, String... formatParams) throws MultichainException {
        MultichainTestParameter.isNotNullOrEmpty("streamName", streamName);
        StringBuilder extraParams = new StringBuilder();
        for(String param : formatParams) {
            extraParams.append(param).append(" ");
        }
        return execute(CommandEnum.LISTSTREAMITEMS, streamName, extraParams.toString());
    }

    /**
     * Returns all the items that were published in the specified stream by the specified publisher address.
     *
     * @param streamName the name of the stream to get the items of the publisher
     * @param address to get the items published by this address
     * @param formatParams (optional) FormatParams in exact order; each represented as individual string (you cannot
     *                     skip any parameters. But passing first 1 or 2 or 3 or none is allowed. Pass default value
     *                     instead of skipping:
     *                     1) verbose: {true/false} -> pass boolean "true" or "false" as string (default: false)
     *                     2) count: {any integer} Limit number of entries -> pass an integer as string (default: 10)
     *                     3) start: {any integer} Start from a certain entry after skipping start entries
     *                                  -> pass integer as string(default: most recent)
     *                     4)local-ordering: {true/false} If true, order items based on when this local node has seen
     *                                      the item rather than chain ordering (default: false)
     * @return {String} String in JSON format with all the items published by the specified publisher
     * @throws MultichainException
     */
    protected static String executeListStreamPublisherItems(String streamName, String address, String... formatParams)
            throws MultichainException {
        MultichainTestParameter.isNotNullOrEmpty("streamName", streamName);
        MultichainTestParameter.isNotNullOrEmpty("address", address);
        StringBuilder extraParams = new StringBuilder();
        for(String param : formatParams) {
            extraParams.append(param).append(" ");
        }
        return execute(CommandEnum.LISTSTREAMPUBLISHERITEMS, streamName, address, extraParams.toString());
    }

    /**
     * Returns all or specified publishers' metadata who published in this stream
     *
     * @param streamName the name of the stream to fetch all publishers from
     * @param allParams (optional) Addresses + Format params in exact order; each represented as individual string (you cannot
     *                     skip any parameters. But passing first 1 or 2 or 3 or none is allowed. Pass default value
     *                     instead of skipping:
     *                     1) addresses: {comma separated list of addresses to search as single string} (default: *)
     *                     2) verbose: {true/false} -> pass boolean "true" or "false" as string (default: false)
     *                     3) count: {any integer} Limit number of entries -> pass an integer as string (default: 10)
     *                     4) start: {any integer} Start from a certain entry after skipping start entries
     *                                  -> pass integer as string(default: most recent)
     *                     5)local-ordering: {true/false} If true, order items based on when this local node has seen
     *                                      the item rather than chain ordering (default: false)
     * @return {String} String in JSON format with metadata of all or specified publishers
     * @throws MultichainException
     */
    protected static String executeListStreamPublishers(String streamName, String... allParams)
            throws MultichainException {
        MultichainTestParameter.isNotNullOrEmpty("streamName", streamName);
        return execute(CommandEnum.LISTSTREAMPUBLISHERS, streamName,separateIdentifierFromFormatParams(allParams));
    }


    /**
     * Helper method. Separates the identifier values(and formats them as array of string based on OS)
     * from the formatting params.
     * @param allParams all params as separate strings for each option
     * @return {String} concatenated string with proper formatting and separation.
     */
    private static String separateIdentifierFromFormatParams(String... allParams) {
        String formatKeys = "";
        String formatParams = "";
        for(int i = 0; i < allParams.length; i++){
            if(i == 0) {
                allParams[i] = allParams[i].replaceAll(" ", "");
                String keyNames[] = allParams[i].split(",");
                formatKeys = formatStringArrayOS(keyNames);
            } else {
                formatParams += " " + allParams[i];
            }
        }
        return formatKeys + " " + formatParams;
    }
}
