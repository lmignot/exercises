import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * PiJ day 19 - exercise 5
 */
public class MatchesTest {

    private List<String> stringListA;
    private List<String> stringListB;
    private List<String> stringListC;

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
    public void matchesLengthLtFour () {
        List<String> shortWordsA = StringUtils.allMatches(stringListA, s -> s.length() < 4);
        List<String> shortWordsAb = ElementUtils.allMatches(stringListA, s -> s.length() < 4);
        System.out.println("Words less than 4 characters in list a: " + shortWordsA);
        System.out.println("Using generic version: " + shortWordsAb);
        List<String> shortWordsB = StringUtils.allMatches(stringListB, s -> s.length() < 4);
        List<String> shortWordsBb = ElementUtils.allMatches(stringListB, s -> s.length() < 4);
        System.out.println("Words less than 4 characters in list b: " + shortWordsB);
        System.out.println("Using generic version: " + shortWordsBb);
        List<String> shortWordsC = StringUtils.allMatches(stringListC, s -> s.length() < 4);
        List<String> shortWordsCb = ElementUtils.allMatches(stringListC, s -> s.length() < 4);
        System.out.println("Words less than 4 characters in list c: " + shortWordsC);
        System.out.println("Using generic version: " + shortWordsCb);
    }

    @Test
    public void containsN () {
        List<String> containsA = StringUtils.allMatches(stringListA, s -> s.contains("n"));
        List<String> containsAb = ElementUtils.allMatches(stringListA, s -> s.contains("n"));
        System.out.println("List A, words containing 'n': " + containsA);
        System.out.println("Using generic version: " + containsAb);
        List<String> containsB = StringUtils.allMatches(stringListB, s -> s.contains("n"));
        List<String> containsBb = ElementUtils.allMatches(stringListA, s -> s.contains("n"));
        System.out.println("List B, words containing 'n': " + containsB);
        System.out.println("Using generic version: " + containsBb);
        List<String> containsC = StringUtils.allMatches(stringListC, s -> s.contains("n"));
        List<String> containsCb = ElementUtils.allMatches(stringListC, s -> s.contains("n"));
        System.out.println("List C, words containing 'n': " + containsC);
        System.out.println("Using generic version: " + containsCb);
    }

    @Test
    public void evenLength () {
        List<String> evenA = StringUtils.allMatches(stringListA, s -> s.length() %2 == 0);
        List<String> evenAb = ElementUtils.allMatches(stringListA, s -> s.length() %2 == 0);
        System.out.println("List A, even length words: " + evenA);
        System.out.println("Using generic version: " + evenAb);
        List<String> evenB = StringUtils.allMatches(stringListB, s -> s.length() %2 == 0);
        List<String> evenBb = ElementUtils.allMatches(stringListB, s -> s.length() %2 == 0);
        System.out.println("List B, even length words: " + evenB);
        System.out.println("Using generic version: " + evenBb);
        List<String> evenC = StringUtils.allMatches(stringListC, s -> s.length() %2 == 0);
        List<String> evenCb = ElementUtils.allMatches(stringListC, s -> s.length() %2 == 0);
        System.out.println("List C, even length words:" + evenC);
        System.out.println("Using generic version: " + evenCb);
    }

}
