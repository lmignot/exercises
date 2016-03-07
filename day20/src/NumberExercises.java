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
    }

    private void randomNumbers (int size) {
        StreamUtils.printHeader("Random list of doubles...");
        List<Double> doubles = StreamUtils.randomDoubleList(size);
        doubles.stream().forEach(System.out::println);
    }
}
