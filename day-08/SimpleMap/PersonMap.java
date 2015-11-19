/**
 * Implementation of SimpleMap interface
 * Using IntegerList to store the entries
 * in the map
 */
public class PersonMap implements SimpleMap {

    private IntegerList map;

    public PersonMap () {
        this.map = new IntegerList();
    }

    public void put (int key, String name) {
        this.map.add(new MapNode(key, name));
    }

    public String get (int key) {
        MapNode node = this.map.find(key);

        if (node != null) { return node.getContent(); }

        return null;
    }

    public void remove (int key) {
        MapNode node = this.map.find(key);

        if (node != null) {
            this.map.delete(node);
        }
    }

    public boolean isEmpty () {
        return (this.map.getSize() == 0);
    }

    public void prettyPrint () {
        this.map.prettyPrint();
    }

}
