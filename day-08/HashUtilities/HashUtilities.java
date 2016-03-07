package HashUtilities;

public class HashUtilities {

    public static int shortHash (int num) {
        return Math.abs(num % 1000);
    }
}
