/**
 * OldPhone
 * implementation of the Phone interface
 */
package Phones;
public abstract class OldPhone implements Phone {
    private String brand = null;

    /**
     * Initialises an OldPhone
     * @param  brand The brand of the phone
     */
    public OldPhone (String brand) {
        this.brand = brand;
    }

    /**
     * Retrieve the brand of this Phone
     */
    public String getBrand () {
        return this.brand;
    }

    /**
     * Calls a number
     * This implementation prints out the number on the screen.
     * @param number The number to call
     */
    public void call (String number) {
        System.out.println("Calling " + number + "...");
    }
}
