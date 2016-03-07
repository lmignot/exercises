import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * PiJ day 19 - exercise 7
 */
public class TransformTest {

    private List<String> stringListA;
    private List<String> stringListB;
    private List<String> stringListC;

    private List<Integer> intListA;

    private String message = "Transformed list %s %s: %s%n";

    @Before
    public void setUp () {
        String[] a = {"operand", "hydroplane", "transdialect", "and", "hajjes", "skein", "stational", "damn", "dam",
                "bear", "cat", "ox"};
        String[] b = {"restiveness", "jeopardy", "noon", "underquote", "huge", "tiny", "yam", "law", "subglobularity"};
        String[] c = {"cheesed", "unneedful", "undemonstrational", "amp", "zophar", "rad", "axe", "tui", "longueuil"};

        Integer[] d = {0, 452, 22, 55, 9876, 2342, 12, 45, 67};

        stringListA = Arrays.asList(a);
        stringListB = Arrays.asList(b);
        stringListC = Arrays.asList(c);
        intListA = Arrays.asList(d);
    }

    @Test
    public void replaceOWithZero () {
        List<String> resultA = StringUtils.transformList(stringListA, s -> s.replace("o", "0"));
        System.out.printf(message, "a,", "by replacing o with zero", resultA);
    }

    @Test
    public void replaceIWithEye () {
        List<String> resultB = ElementUtils.transformList(stringListB, s -> s.replace("i", "EyE"));
        System.out.printf(message, "b,", "by replacing i with EyE", resultB);
    }

    @Test
    public void uppercased () {
        List<String> resultC = StringUtils.transformList(stringListC, String::toUpperCase);
        System.out.printf(message, "c,", "made everything uppercase", resultC);
    }

    @Test
    public void addedTwo () {
        System.out.println("Before transformation: " + Arrays.asList(intListA));
        List<Integer> result = ElementUtils.transformList(intListA, i -> i + 2);
        System.out.printf(message, "numbers,", "added 2", result);
    }

    @Test
    public void divideByTwo () {
        System.out.println("Before transformation: " + Arrays.asList(intListA));
        List<Integer> result = ElementUtils.transformList(intListA, i -> i / 2);
        System.out.printf(message, "numbers,", "divided by 2", result);
    }

    @Test
    public void addedFifty () {
        System.out.println("Before transformation: " + Arrays.asList(intListA));
        List<Integer> result = ElementUtils.transformList(intListA, i -> i + 50);
        System.out.printf(message, "numbers,", "added 50", result);
    }

    @Test
    public void numbersToStrings () {
        System.out.println("Before transformation: " + Arrays.asList(intListA));
        List<String> result = ElementUtils.transformList(intListA, String::valueOf);
        System.out.printf(message, "numbers,", "they're strings now, but it's hard to tell", result);
    }
}
