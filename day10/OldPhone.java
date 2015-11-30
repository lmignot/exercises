/**
 * OldPhone
 * implementation of the Phone interface
 */
public abstract class OldPhone implements Phone {

    public void call (String number) {
        System.out.println("Calling " + number + "...");
    }
}
