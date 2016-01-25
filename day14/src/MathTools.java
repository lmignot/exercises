import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Testing Recursion with Memoization
 */
public class MathTools {

    private static Map<Integer, Integer> memo = new ConcurrentHashMap<>();
    private static Map<Integer, Integer> hailstoneMemo = null;
    private static List<Integer> hailStoneSequence = null;

    public static Integer getFibonacciMemoized (Integer n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        } else {
            if (n.equals(1) || n.equals(2)) {
                memo.put(n, 1);
                return 1;
            } else {
                int result = getFibonacciMemoized(n - 1) + getFibonacciMemoized(n - 2);
                memo.put(n, result);
                return result;
            }
        }
    }

    public static Integer getFibonacci (Integer n) {
        if (n.equals(1) || n.equals(2)) {
            return 1;
        } else {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
    }

    public static List getHailstoneSequence (Integer n) {
        if (hailstoneMemo == null) {
            hailstoneMemo = new ConcurrentHashMap<>();
        }
        hailStoneSequence = new ArrayList<>();
        getNextHailstoneNumber(n);
        return hailStoneSequence;
    }

    public static Integer getNextHailstoneNumber(Integer n) {
        hailStoneSequence.add(n);
        if (hailstoneMemo.containsKey(n)) {
            return hailstoneMemo.get(n);
        }
        if (n == 1) {
            return n;
        } else {
            Integer r;
            if (n % 2 == 0) {
                r = getNextHailstoneNumber(n / 2);
                hailstoneMemo.put(n, r);
                return r;
            } else {
                r = getNextHailstoneNumber(3 * n + 1);
                hailstoneMemo.put(n, r);
                return r;
            }
        }
    }

    public static void main (String[] args) {
        Instant start;
        Instant end;

        System.out.println("Running non-memoized version...");
        start = Instant.now();
        Integer slow = getFibonacci(40);
        end = Instant.now();
        System.out.println("Fibonacci calculation on 40 is -> " + slow);
        System.out.println(Duration.between(start, end));

        System.out.println("Running memoized version...");
        start = Instant.now();
        Integer fast = getFibonacciMemoized(40);
        end = Instant.now();
        System.out.println("Fibonacci calculation on 40 is -> " + fast);
        System.out.println(Duration.between(start, end));

        System.out.println("Hailstone... starting from 99");
        List sequence = getHailstoneSequence(99);
        System.out.println(sequence);

        System.out.println("Hailstone... starting from 987");
        List sequence2 = getHailstoneSequence(987);
        System.out.println(sequence2);
    }
}
