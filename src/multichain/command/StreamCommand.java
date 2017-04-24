package multichain.command;

import multichain.command.builders.QueryBuilderStream;

/**
 * Created by Jagrut on 24-04-2017.
 */
public class StreamCommand extends QueryBuilderStream {

    public static String createStream(String streamName, boolean openOrClose) throws MultichainException{
        return executeCreate(streamName, openOrClose);
    }
}
