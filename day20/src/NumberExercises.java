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
        exerciser.sumIntegers(StreamUtils.orderedNumberList(12, 3, 20));
        exerciser.sumDoubles(StreamUtils.randomDoubleList(25));
    }

    private void randomNumbers (int size) {
        StreamUtils.printHeader("Random list of 25 doubles...");
        List<Double> doubles = StreamUtils.randomDoubleList(size);
        doubles.stream().forEach(System.out::println);
    }

    private void sequentialNumbers (int start, int step, int limit) {
        StreamUtils.printHeader("Sequential number list");
        List<Integer> numbers = StreamUtils.orderedNumberList(start, step, limit);
        numbers.stream().forEach(System.out::println);
    }

    private void sumIntegers(List<Integer> numbers) {
        StreamUtils.printHeader("Sum list using parallel stream");
        System.out.println("Original list:");
        numbers.stream().forEach(System.out::println);
        System.out.print("\nSum sequential: ");
        System.out.println(numbers.stream().reduce(Integer::sum).orElse(-1));
        System.out.print("\nSum parallel: ");
        System.out.println(numbers.parallelStream().mapToInt(Integer::valueOf).sum());
    }

    private void sumDoubles(List<Double> numbers) {
        StreamUtils.printHeader("Sum doubles");
        System.out.println("Original list:");
        numbers.stream().forEach(System.out::println);
        System.out.print("\nSum parallel: ");
        System.out.println(numbers.parallelStream().reduce((d1, d2) -> d1 + d2).orElse(-1.00));
        System.out.print("\nSum sequential: ");
        System.out.println(numbers.stream().reduce((d1, d2) -> d1 + d2).orElse(-1.00));
        System.out.print("\nSum parallel: ");
        System.out.println(numbers.parallelStream().mapToDouble(Double::valueOf).sum());
    }
}
