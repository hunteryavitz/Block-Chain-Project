import java.security.NoSuchAlgorithmException;

public class Block {

    private int index;
    private String previous_hash;
    private long timestamp;
    private String data;
    private String hash;

    public Block(int index, String previous_hash, long timestamp, String data, String hash) {
        this.index = index;
        this.previous_hash = previous_hash;
        this.timestamp = timestamp;
        this.data = data;
        this.hash = hash;
    }

    public int getIndex() {
        return index;
    }

    public String getPrevious_hash() {
        return previous_hash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getData() {
        return data;
    }

    public String getHash() {
        return hash;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setPrevious_hash(String previous_hash) {
        this.previous_hash = previous_hash;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
