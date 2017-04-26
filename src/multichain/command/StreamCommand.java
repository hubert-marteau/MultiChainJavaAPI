package multichain.command;

import multichain.command.builders.QueryBuilderStream;
import multichain.object.Stream;
import multichain.object.StreamItem;
import multichain.object.StreamKeyPublisherInfo;
import multichain.object.formatters.StreamFormatter;

import java.util.List;

/**
 * @author Jagrut Kosti on 24-04-2017.
 */
public class StreamCommand extends QueryBuilderStream {

    /**
     * Executed as: multichain-cli chainname create type stream open
     *
     * Arguments:
     * 1. type: required; default is always 'stream' and should always be mentioned explicitly (Beta 1.0, Version 1.0)
     * 2. stream: required; the name of the stream
     * 3. open: required; if true, anyone with global send permission can publish in this stream
     *
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
    public static String createStream(String streamName, boolean openOrClose) throws MultichainException {
        return executeCreate(streamName, openOrClose);
    }

    /**
     * Executed as: multichain-cli chainname createfrom from-address type stream open
     *
     * Arguments:
     * 1. from-address: required; the wallet address which should create this stream and has 'create' permission
     * 2. type: required; default is always 'stream' and should always be mentioned explicitly (Beta 1.0, Version 1.0)
     * 3. stream: required; the name of the stream
     * 4. open: required; if true, anyone with global send permission can publish in this stream
     *
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
    public static String createFromStream(String fromAddress, String streamName, boolean openOrClose)
            throws MultichainException {
        return executeCreateFrom(fromAddress, streamName, openOrClose);
    }

    /**
     * Executed as: multichain-cli chainname liststreams (streams=*) (verbose=false) (count=MAX) (start=-count)
     *
     * Arguments:
     * 1. streams: optional; the name of the stream or array of stream names, comma separated, for which info is needed
     * 2. verbose: optional; turn on or off verbose mode
     * 3. count: optional; the number of entries to be fetched
     * 4. start: optional; from which number of entry to start fetching
     *
     * List the detailed information for all streams or the information of streams passed in the parameters.
     * Params include (in exact order i.e. you cannot skip a param. But passing first 1 or 2 or 3 or none is allowed):
     * 1) streams = {comma separated names of the streams} -> "streamName1, streamName2" (default: all)
     * 2) verbose = {true/false} -> pass boolean "true" or "false" as string (default: false)
     * 3) count = {any integer} Limit number of entries -> pass an integer as string (default: all)
     * 4) start = {any integer} Start from a certain entry after skipping start entries -> pass integer as string
     *              (default: most recent)
     *
     * @param params (optional) Pass a list of params
     * @return {List<Stream>} output after formatting the returned string into list of stream objects
     * @throws MultichainException
     */
    public static List<Stream> listStreams(String... params) throws MultichainException {
        return StreamFormatter.formatStreamList(executeListStreams(params));
    }

    /**
     * Executed as: multichain-cli chainname publish stream key data-hex
     *
     * Arguments:
     * 1. stream: required; the name of the stream where you want to publish
     * 2. key: required; the key associated with the data in plain-text
     * 3. data-hex: required; the data to be submitted in hexadecimal string without spaces or tabs
     *
     * Publish the given data to the specified stream. This works if the node has only one wallet address associated
     * with it and assumes that it has the write permission
     *
     * @param streamName the name of the stream where you want to publish the data
     * @param key the key associated with the data
     * @param hexData the data to be embedded into the blockchain in hexadecimal string without spaces or tabs
     * @return  {transactionId} he transaction ID of the transaction made to make this change in the block chain
     * @throws MultichainException
     */
    public static String publishStream(String streamName, String key, String hexData) throws MultichainException {
        return executePublish(streamName, key, hexData);
    }

    /**
     * Executed as: multichain-cli chainname publishfrom from-address stream key data-hex
     *
     * Arguments:
     * 1. from-address: required; the wallet address which has the write permission to this stream
     * 2. stream: required; the name of the stream where you want to publish
     * 3. key: required; the key associated with the data in plain-text
     * 4. data-hex: required; the data to be submitted in hexadecimal string without spaces or tabs
     *
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
    public static String publishFromStream(String fromAddress, String streamName, String key, String hexData)
        throws MultichainException {
        return executePublishFrom(fromAddress, streamName, key, hexData);
    }

    /**
     * Executed as: multichain-cli chainname subscribe asset(s)|stream(s) (rescan=true)
     *
     * Arguments:
     * 1. asset(s)|stream(s): required; the names of assets or streams to subscribe to
     * 2. rescan: optional; to reindex all streams and assets or not. (default: true)
     *
     * Subscribe to the specified asset or stream to read or write from these streams or assets
     * @param assetOrStreamNames the names of assets or streams in single comma separated string
     * @param rescan (optional) to reindex all items or not
     * @throws MultichainException
     */
    public static void subscribeAssetsOrStreams(String assetOrStreamNames, String... rescan) throws MultichainException {
        executeSubscribe(assetOrStreamNames, rescan);
    }

    /**
     * Executed as: multichain-cli chainname unsubscribe asset(s)|stream(s)
     *
     * Arguments:
     * 1. asset(s)|stream(s): required; the names of asset or stream to unsubscribe to and stop tracking
     *
     * Unsubscribe and stop tracking the specified assets or streams
     *
     * @param assetOrStreamNames the names of assets or streams in single comma separated string
     * @throws MultichainException
     */
    public static void unsubscribeAssetsOrStreams(String assetOrStreamNames) throws MultichainException {
        executeUnsubscribe(assetOrStreamNames);
    }

    /**
     * Executed as: multichain-cli chainname getstreamitem stream txid (verbose=false)
     *
     * Arguments:
     * 1. stream: required; the name of the stream
     * 2. txid: required; the transaction id of the item whose data is to be retrieved
     * 3. verbose: optional; set to true for detailed information. (default: false)
     *
     * Returns the specific stream item of given stream, identified with given txid.
     *
     * @param streamName the name of the stream to search for
     * @param txId the transaction id of the item to retrieve
     * @param verbose (optional) If true, returns additional information about the item. Pass as string. Eg. "true"
     * @return {StreamItem} Object with all the data about the item
     * @throws MultichainException
     */
    public static StreamItem getStreamItem(String streamName, String txId, String... verbose) throws MultichainException {
        return StreamFormatter.formatStreamItem(executeGetStreamItem(streamName, txId, verbose));
    }

    /**
     * Executed as: multichain-cli chainname liststreamkeyitems stream key (verbose=false) (count=10) (start=-count) (local-ordering=false)
     *
     * Arguments:
     * 1. stream: required; the name of the stream
     * 2. key: required; the value of the key for fetching the items
     * 3. verbose: optional; set to true for detailed information. (default: false)
     * 4. count: optional; number of items to retrieve. (default: 10)
     * 5. start: optional; start from the nth item. (default: most recent)
     * 6. local-ordering: optional; true-> to order the items as seen by local node. false-> chain ordering. (default: false)
     *
     * Returns all items in the specified stream that has the given key value.
     *
     * @param streamName the name of the stream to search into
     * @param key the key of the item to retrieve
     * @param formatParams (optional) FormatParams in exact order; each represented as individual string (You cannot
     *                     skip any parameters. But passing first 1 or 2 or 3 or none is allowed. Pass default value
     *                     instead of skipping):
     *                     1) verbose: {true/false} -> pass boolean "true" or "false" as string (default: false)
     *                     2) count: {any integer} Limit number of entries -> pass an integer as string (default: 10)
     *                     3) start: {any integer} Start from a certain entry after skipping start entries
     *                                  -> pass integer as string(default: most recent)
     *                     4)local-ordering: {true/false} If true, order items based on when this local node has seen
     *                                      the item rather than chain ordering (default: false)
     * @return {List<StreamItem>} List of Object with all items that has the given key
     * @throws MultichainException
     */
    public static List<StreamItem> listStreamKeyItems(String streamName, String key, String... formatParams)
            throws MultichainException {
        return StreamFormatter.formatStreamItemList(executeListStreamKeyItems(streamName, key, formatParams));
    }

    /**
     * Executed as: multichain-cli chainname liststreamkeys stream (keys=*) (verbose=false) (count=MAX) (start=-count) (local-ordering=false)
     *
     * Arguments:
     * 1. stream: required; the name of the stream
     * 2. keys: optional; array of keys to search for and retrieve the metadata; otherwise metadata of all keys
     * 3. verbose: optional; set to true for detailed information. (default: false)
     * 4. count: optional; number of items to retrieve. (default: MAX)
     * 5. start: optional; start from the nth item. (default: most recent)
     * 6. local-ordering: optional; true-> to order the items as seen by local node. false-> chain ordering. (default: false)
     *
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
     * @return {List<StreamKeyPublisherInfo>} List of Object with all keys found with their metadata
     * @throws MultichainException
     */
    public static List<StreamKeyPublisherInfo> listStreamKeys(String streamName, String... allParams)
            throws MultichainException {
        return StreamFormatter.formatStreamKeyPublisherInfoList(executeListStreamKeys(streamName, allParams));
    }

    /**
     * Executed as: multichain-cli chainname liststreamitems stream (verbose=false) (count=10) (start=-count) (local-ordering=false)
     *
     * Arguments:
     * 1. stream: required; the name of the stream
     * 2. verbose: optional; set to true for detailed information. (default: false)
     * 3. count: optional; number of items to retrieve. (default: 10)
     * 4. start: optional; start from the nth item. (default: most recent)
     * 5. local-ordering: optional; true-> to order the items as seen by local node. false-> chain ordering. (default: false)
     *
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
     * @return {List<StreamItem>} List of Objects with all the items present in the stream
     * @throws MultichainException
     */
    public static List<StreamItem> listStreamItems(String streamName, String... formatParams) throws MultichainException {
        return StreamFormatter.formatStreamItemList(executeListStreamItems(streamName, formatParams));
    }

    /**
     * Executed as: multichain-cli chainname liststreampublisheritems stream address (verbose=false) (count=10) (start=-count) (local-ordering=false)
     *
     * Arguments:
     * 1. stream: required; the name of the stream
     * 2. address: required; the wallet address for fetching the items
     * 3. verbose: optional; set to true for detailed information. (default: false)
     * 4. count: optional; number of items to retrieve. (default: 10)
     * 5. start: optional; start from the nth item. (default: most recent)
     * 6. local-ordering: optional; true-> to order the items as seen by local node. false-> chain ordering. (default: false)
     *
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
     * @return {List<StreamItem>} List of Objects with all the items published by the specified publisher
     * @throws MultichainException
     */
    public static List<StreamItem> listStreamPublisherItems(String streamName, String address, String... formatParams)
            throws MultichainException {
        return StreamFormatter.formatStreamItemList(executeListStreamPublisherItems(streamName, address, formatParams));
    }

    /**
     * Executed as: multichain-cli chainname liststreampublishers stream (addresses=*) (verbose=false) (count=MAX) (start=-count) (local-ordering=false)
     *
     * Arguments:
     * 1. stream: required; the name of the stream
     * 2. addresses: optional; array of addresses to search for and retrieve the metadata; otherwise metadata of all addresses
     * 3. verbose: optional; set to true for detailed information. (default: false)
     * 4. count: optional; number of items to retrieve. (default: MAX)
     * 5. start: optional; start from the nth item. (default: most recent)
     * 6. local-ordering: optional; true-> to order the items as seen by local node. false-> chain ordering. (default: false)
     *
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
    public static List<StreamKeyPublisherInfo> listStreamPublishers(String streamName, String... allParams)
            throws MultichainException {
        return StreamFormatter.formatStreamKeyPublisherInfoList(executeListStreamPublishers(streamName, allParams));
    }
}
