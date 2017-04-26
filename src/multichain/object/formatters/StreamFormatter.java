package multichain.object.formatters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import multichain.object.Stream;
import multichain.object.StreamItem;
import multichain.object.StreamKeyPublisherInfo;

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
     * @param stringStreamList list of stream in String
     * @return {List<Stream>} List of Stream Objects with populated fields for each
     */
    public final static List<Stream> formatStreamList(String stringStreamList) {
        final Gson gson = new GsonBuilder().create();
        Type typeList = new TypeToken<List<Stream>>(){}.getType();
        final List<Stream> streamList = gson.fromJson(stringStreamList, typeList);
        return streamList;
    }

    /**
     * Format a single stream item output into Streamitem Object. Stream item refers to each item in the stream.
     * @param stringStreamItem single stream item output in String
     * @return {StreamItem} Object with populated fields
     */
    public final static StreamItem formatStreamItem(String stringStreamItem) {
        final Gson gson = new GsonBuilder().create();
        final StreamItem streamItem = gson.fromJson(stringStreamItem, StreamItem.class);
        return streamItem;
    }

    /**
     * Format a list of stream items from String format to List<StreamItem> format.
     * Stream item refers to each item in the stream.
     * @param stringStreamItemList list of stream items in String
     * @return {List<StreamItem>} List of StreamItem Objects with populated fields for each
     */
    public final static List<StreamItem> formatStreamItemList(String stringStreamItemList) {
        final Gson gson = new GsonBuilder().create();
        Type typeList = new TypeToken<List<StreamItem>>(){}.getType();
        final List<StreamItem> streamItemList = gson.fromJson(stringStreamItemList, typeList);
        return streamItemList;
    }

    /**
     * Formats single string output of key or publisher metadata into StreamKeyPublisherInfo object.
     * @param stringStreamKeyPublisherInfo output string of multichain key and publisher metadata command
     * @return {StreamKeyPublisherInfo} Object with populated fields
     */
    public final static StreamKeyPublisherInfo formatStreamKeyPublisherInfo(String stringStreamKeyPublisherInfo) {
        final Gson gson = new GsonBuilder().create();
        final StreamKeyPublisherInfo streamKeyPublisherInfo = gson.fromJson(stringStreamKeyPublisherInfo, StreamKeyPublisherInfo.class);
        return streamKeyPublisherInfo;
    }

    /**
     * Format list of key or publisher metadata output from string to StreamKeyPublisherInfo object.
     * @param stringStreamKeyPublisherInfoList output string of multichain key and publisher metadata command
     * @return {List<StreamKeyPublisherInfo>} List of this object
     */
    public final static List<StreamKeyPublisherInfo> formatStreamKeyPublisherInfoList(String stringStreamKeyPublisherInfoList) {
        final Gson gson = new GsonBuilder().create();
        Type typeList = new TypeToken<List<StreamKeyPublisherInfo>>(){}.getType();
        final List<StreamKeyPublisherInfo> streamKeyPublisherInfoList = gson.fromJson(stringStreamKeyPublisherInfoList, typeList);
        return streamKeyPublisherInfoList;
    }
}
