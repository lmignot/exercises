import java.util.List;

/**
 * PiJ day 20 - Java Streams API
 * Various exercises involving numbers
 *
 * @author lmignot
 */
public class NumberExercises {

    public static void main(String... args) {
        NumberExercises exerciser = new NumberExercises();

        exerciser.randomNumbers(25);
        exerciser.sequentialNumbers(60, 5, 10);
    }

    private void randomNumbers (int size) {
        StreamUtils.printHeader("Random list of doubles...");
        List<Double> doubles = StreamUtils.randomDoubleList(size);
        doubles.stream().forEach(System.out::println);
    }

    private void sequentialNumbers (int start, int step, int limit) {
        StreamUtils.printHeader("Sequential number list");
        List<Integer> numbers = StreamUtils.orderedNumberList(start, step, limit);
        numbers.stream().forEach(System.out::println);
    }
}
