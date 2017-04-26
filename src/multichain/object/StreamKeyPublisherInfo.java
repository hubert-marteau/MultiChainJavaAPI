package multichain.object;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Jagrut Kosti on 26-04-2017.
 *
 * Structure for each stream key and publisher data. Can use this class for key metadata or publisher meta data.
 */
public class StreamKeyPublisherInfo {
    String publisher;
    String key;
    int items;
    int confirmed;
    StreamItem first;
    StreamItem last;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public StreamItem getFirst() {
        return first;
    }

    public void setFirst(StreamItem first) {
        this.first = first;
    }

    public StreamItem getLast() {
        return last;
    }

    public void setLast(StreamItem last) {
        this.last = last;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this, this.getClass());
    }
}
