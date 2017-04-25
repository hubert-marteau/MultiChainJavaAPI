package multichain.object.formatters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import multichain.object.Stream;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Jagrut on 25-04-2017.
 *
 * To format the output from Multichain CLI to the Stream object
 */
public class StreamFormatter {

    /**
     * Format a single stream output into Stream Object
     * @param stringStream single stream output in String
     * @return {Stream} Object with populated fields
     */
    public final static Stream formatStream(String stringStream) {
        final Gson gson = new GsonBuilder().create();
        final Stream stream = gson.fromJson(stringStream, Stream.class);
        return stream;
    }

    /**
     * Format a list of streams from String format to List<Stream> format.
     * @param stringStreamList list of stream items in String
     * @return {List<Stream>} List of Stream Objects with populated fields for each
     */
    public final static List<Stream> formatStreamList(String stringStreamList) {
        final Gson gson = new GsonBuilder().create();
        Type typeList = new TypeToken<List<Stream>>(){}.getType();
        final List<Stream> streamList = gson.fromJson(stringStreamList, typeList);
        return streamList;
    }
}
