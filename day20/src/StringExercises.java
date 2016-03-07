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
        exerciser.excitingWords(words);
        exerciser.replacedWords(words);
        exerciser.uppercasedWords(words);
        exerciser.shortWords(words);
        exerciser.wordsWithB(words);
        exerciser.evenLengthWords(words);
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

    private void excitingWords(List<String> list) {
        printHeader("Exciting Words");
        list.stream().map(s -> s + "!").forEach(System.out::println);
    }

    private void replacedWords(List<String> list) {
        printHeader("Replaced Words");
        list.stream().map(s -> s.replace("i", "eye")).forEach(System.out::println);
    }

    private void uppercasedWords(List<String> list) {
        printHeader("Uppercase Words");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    private void shortWords(List<String> list) {
        printHeader("Short Words");
        list.stream().filter(s -> s.length() < 4).forEach(System.out::println);
    }

    private void wordsWithB(List<String> list) {
        printHeader("Words with b");
        list.stream().filter(s -> s.contains("b")).forEach(System.out::println);
    }

    private void evenLengthWords(List<String> list) {
        printHeader("Even length Words");
        list.stream().filter(s -> s.length() %2 == 0).forEach(System.out::println);
    }

}
