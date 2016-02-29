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

    private String message = "Transformed list %s %s: %s";

    @Before
    public void setUp () {
        String[] a = {"operand", "hydroplane", "transdialect", "and", "hajjes", "skein", "stational", "damn", "dam",
                "bear", "cat", "ox"};
        String[] b = {"restiveness", "jeopardy", "noon", "underquote", "huge", "tiny", "yam", "law", "subglobularity"};
        String[] c = {"cheesed", "unneedful", "undemonstrational", "amp", "zophar", "rad", "axe", "tui", "longueuil"};
        stringListA = Arrays.asList(a);
        stringListB = Arrays.asList(b);
        stringListC = Arrays.asList(c);
    }

    @Test
    public void replaceOWithZero () {
        List<String> resultA = StringUtils.transformedList(stringListA, s -> s.replace("o", "0"));
        System.out.printf(message, "a,", "by replacing o with zero", resultA);
    }

    @Test
    public void replaceIWithEye () {
        List<String> resultB = StringUtils.transformedList(stringListB, s -> s.replace("i", "EyE"));
        System.out.printf(message, "b,", "by replacing i with EyE", resultB);
    }

    @Test
    public void uppercased () {
        List<String> resultC = StringUtils.transformedList(stringListC, String::toUpperCase);
        System.out.printf(message, "c,", "made everything uppercase", resultC);
    }
}
