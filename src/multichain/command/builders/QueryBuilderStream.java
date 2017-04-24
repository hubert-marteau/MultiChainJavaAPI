package multichain.command.builders;

import multichain.command.MultichainException;

/**
 * Created by Jagrut on 21-04-2017.
 */
public class QueryBuilderStream extends QueryBuilderCommon {

    protected static String executeCreate(String streamName, boolean openOrClose) throws MultichainException {
        String params = "stream";
        params += " " + streamName + " " + String.valueOf(openOrClose);
        return execute(CommandEnum.CREATE, params);
    }
}
