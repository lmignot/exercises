import java.util.Arrays;
import java.util.List;

/**
 * PiJ day 20 - Java Streams API
 *
 * @author lmignot
 */
public class StringExercises {


    public static void main(String... args) {
        StringExercises exerciser = new StringExercises();

        List<String> words = Arrays.asList("act", "alpha", "boo", "bravo", "charlie", "doe", "delta", "echo",
                "foxtrot", "fox", "golf", "how", "hotel", "india", "juliet", "kilo", "lima", "mike", "november",
                "oscar", "papa", "quebec", "romeo", "sierra", "sam", "tango", "tar", "uniform", "whisky", "xray",
                "yankee",
                "zulu");

        exerciser.printOnSeparateLinesWithDoubleSpacePrefix(words);
        exerciser.printOnSeparateLines(words);
    }

    private void printHeader(String header) {
        System.out.printf("%n%n::: %s :::%n%n", header);
    }

    private void printOnSeparateLinesWithDoubleSpacePrefix (List<String> list) {
        printHeader("Words on separate Lines with 2-space prefix");
        list.stream().map(s -> "  " + s).forEach(System.out::println);
    }

    private void printOnSeparateLines (List<String> list) {
        printHeader("Words on separate Lines");
        list.stream().forEach(System.out::println);
    }

}
