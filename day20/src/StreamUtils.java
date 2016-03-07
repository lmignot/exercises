import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        List<Integer> list = new ArrayList<>();
        int l = 0;
        for (int i = start; l <= limit; l++) {
            list.add(i);
            i += step;
        }
        return list;
    }
}
