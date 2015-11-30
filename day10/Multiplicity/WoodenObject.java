/**
 * A wooden object that can burn
 */
public abstract class WoodenObject {

    private String brand;
    private String type;

    /**
     * Initialises a plain WoodenObject
     */
    public WoodenObject () {
        this.type = "plain";
    }

    /**
     * Initialises a WoodenObject specifying the type
     * @param  type [description]
     */
    public WoodenObject (String type) {
        this.type = type;
    }

    /**
     * Retrieves the type of object
     */
    public String getType () {
        return this.type;
    }

    /**
     * Wood burns...
     */
    public void burn () {
        System.out.println("The object is now burning!");
    }
}
