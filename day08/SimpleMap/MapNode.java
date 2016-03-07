package SimpleMap;

public class MapNode {
    private int key;
    private String content;
    private MapNode next;
    private MapNode prev;

    public MapNode (int key, String content) {
        this.key = key;
        this.content = content;
        this.next = null;
        this.prev = null;
    }

    public MapNode getNext () {
        return this.next;
    }

    public void setNext (MapNode next) {
        this.next = next;
    }

    public MapNode getPrev () {
        return this.prev;
    }

    public void setPrev (MapNode prev) {
        this.prev = prev;
    }

    public int getKey () {
        return this.key;
    }

    public String getContent () {
        return this.content;
    }

    public String toString () {
        return this.key + ": " + this.content;
    }
}
