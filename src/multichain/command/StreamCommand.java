package multichain.command;

import multichain.command.builders.QueryBuilderStream;
import multichain.object.Stream;
import multichain.object.formatters.StreamFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jagrut on 24-04-2017.
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
}
