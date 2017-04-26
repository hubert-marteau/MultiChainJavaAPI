package multichain.object;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Jagrut Kosti on 24-04-2017.
 *
 * Contains the structure of stream related data exactly as the multichain output.
 * Excluded: synchronized: It is a Java keyword and clashes with multichain stream field)
 *           details: Need more information about its structure
 */
public class Stream {
    String name;
    String createtxid;
    String streamref;
    boolean open;
    boolean subscribed;
    int items;
    int confirmed;
    int keys;
    int publishers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatetxid() {
        return createtxid;
    }

    public void setCreatetxid(String createtxid) {
        this.createtxid = createtxid;
    }

    public String getStreamref() {
        return streamref;
    }

    public void setStreamref(String streamref) {
        this.streamref = streamref;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
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

    public int getKeys() {
        return keys;
    }

    public void setKeys(int keys) {
        this.keys = keys;
    }

    public int getPublishers() {
        return publishers;
    }

    public void setPublishers(int publishers) {
        this.publishers = publishers;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this, this.getClass());
    }
}
