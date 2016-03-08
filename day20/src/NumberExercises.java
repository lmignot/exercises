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
        exerciser.sumNumbersReduce(StreamUtils.orderedNumberList(12, 3, 20));
        exerciser.sumNumbersReduceMethodRef(StreamUtils.orderedNumberList(12, 3, 20));
        exerciser.sumNumbersInParallel(StreamUtils.orderedNumberList(12, 3, 20));
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

    private void sumNumbersReduce(List<Integer> numbers) {
        StreamUtils.printHeader("Sum list using reduce");
        System.out.println("Original list:");
        numbers.stream().forEach(System.out::println);
        System.out.print("\nSum: ");
        System.out.println(numbers.stream().reduce(0, (a,b) -> a+b));
    }

    private void sumNumbersReduceMethodRef(List<Integer> numbers) {
        StreamUtils.printHeader("Sum list using reduce with method reference");
        System.out.println("Original list:");
        numbers.stream().forEach(System.out::println);
        System.out.print("\nSum: ");
        System.out.println(numbers.stream().reduce(Integer::sum).orElse(-1));
    }

    private void sumNumbersInParallel(List<Integer> numbers) {
        StreamUtils.printHeader("Sum list using parallel stream");
        System.out.println("Original list:");
        numbers.stream().forEach(System.out::println);
        System.out.print("\nSum: ");
        System.out.println(numbers.parallelStream().mapToInt(Integer::valueOf).sum());
    }
}
