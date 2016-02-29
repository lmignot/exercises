import org.junit.Test;

/**
 * PiJ day 19 - exercise 3
 */
public class BetterStringTest {

    private final String a = "Green Lantern";
    private final String b = "Green Hornet";

    @Test
    public void betterByLength () {
        String result = StringUtils.betterString(a, b, (sA, sB) -> sA.length() > sB.length());
        System.out.println("Comparison by length of '" + a + "' and '" + b + "', '" + result + "' wins.");
    }

    @Test
    public void betterByFirst () {
        String result = StringUtils.betterString(a, b, (sA, sB) -> true);
        System.out.println("Comparison by which is first of '" + a + "' and '" + b + "', '" + result + "' wins" +
                ".");
    }
}
