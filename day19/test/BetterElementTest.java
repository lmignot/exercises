import org.junit.Test;

/**
 * PiJ day 19 - exercise 4
 */
public class BetterElementTest {

    private final String a = "Green Lantern";
    private final String b = "Green Hornet";

    private final Integer i1 = 456;
    private final Integer i2 = 34567;

    @Test
    public void isStringBetterByLength () {
        String result = ElementUtils.betterElement(a, b, (sA, sB) -> sA.length() > sB.length());
        System.out.println("Comparison by length of '" + a + "' and '" + b + "', '" + result + "' wins.");
    }

    @Test
    public void isStringBetterByFirst () {
        String result = ElementUtils.betterElement(a, b, (sA, sB) -> true);
        System.out.println("Comparison by first of '" + a + "' and '" + b + "', '" + result + "' wins.");
    }

    @Test
    public void isIntegerBetterByLength () {
        int result = ElementUtils.betterElement(i1, i2, (a, b) -> a > b);
        System.out.println("Comparison by value of '" + i1 + "' and '" + i2 + "', '" + result + "' wins.");
    }

    @Test
    public void isIntegerBetterByFirst () {
        int result = ElementUtils.betterElement(i1, i2, (a, b) -> true);
        System.out.println("Comparison by first of '" + i1 + "' and '" + i2 + "', '" + result + "' wins.");
    }
}
