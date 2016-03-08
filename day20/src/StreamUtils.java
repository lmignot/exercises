import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Some utility classes for streams
 * PiJ day 20
 *
 * @author lmignot
 */
public final class StreamUtils {

    public static void printHeader(String header) {
        System.out.printf("%n%n::: %s :::%n%n", header);
    }

    public static List<Double> randomDoubleList (int size) {
        return new Random()
            .doubles()
            .limit(size)
            .distinct()
            .collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
    }

    public static List<Integer> orderedNumberList (int start, int step, int limit) {
        return IntStream
            .iterate(start, n -> n + step)
            .limit(limit)
            .collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
    }
}
