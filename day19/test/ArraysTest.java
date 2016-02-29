import org.junit.Test;

import java.util.Arrays;

/**
 * PiJ day 19 - exercise 1
 */
public class ArraysTest {

    @Test
    public void sortArrayByLength () {
        String[] arr = {"Beta", "Ypsilon", "Zulu", "Romeo", "Xray", "Alpha", "Gamma", "Delta"};

        System.out.println("Unsorted: " + Arrays.asList(arr));

        Arrays.sort(arr, (a, b) -> a.length() - b.length());

        System.out.println("Sorted by length: " + Arrays.asList(arr));
    }

    @Test
    public void sortArrayByReverseLength () {
        String[] arr = {"Beta", "Ypsilon", "Zulu", "Romeo", "Xray", "Alpha", "Gamma", "Delta"};

        System.out.println("Unsorted: " + Arrays.asList(arr));

        Arrays.sort(arr, (a, b) -> b.length() - a.length());

        System.out.println("Sorted by length reverse: " + Arrays.asList(arr));
    }

    @Test
    public void sortArrayByFirstCharacter () {
        String[] arr = {"Beta", "Ypsilon", "Zulu", "Romeo", "Xray", "Alpha", "Gamma", "Delta"};

        System.out.println("Unsorted: " + Arrays.asList(arr));

        Arrays.sort(arr, String::compareTo);

        System.out.println("Sorted by first character: " + Arrays.asList(arr));
    }

    @Test
    public void sortArrayByELambdaExpression () {
        String[] arr = {"Beta", "Ypsilon", "Zulu", "Romeo", "Xray", "Alpha", "Gamma", "Delta"};

        System.out.println("Unsorted: " + Arrays.asList(arr));

        Arrays.sort(arr, (a, b) -> {
            int result = 0;
            if (a.contains("e") && !b.contains("e")) {
                result = -1;
            } else if (b.contains("e") && !a.contains("e")) {
                result = 1;
            }
            return result;
        });

        System.out.println("Sorted by contains 'e': " + Arrays.asList(arr));
    }

    @Test
    public void sortArrayByEStaticLambda () {
        String[] arr = {"Beta", "Ypsilon", "Zulu", "Romeo", "Xray", "Alpha", "Gamma", "Delta"};

        System.out.println("Unsorted: " + Arrays.asList(arr));

        Arrays.sort(arr, (a, b) -> StringUtils.eChecker(a, b));

        System.out.println("Sorted by contains 'e': " + Arrays.asList(arr));
    }

    @Test
    public void sortArrayByEMethodReference () {
        String[] arr = {"Beta", "Ypsilon", "Zulu", "Romeo", "Xray", "Alpha", "Gamma", "Delta"};

        System.out.println("Unsorted: " + Arrays.asList(arr));

        Arrays.sort(arr, StringUtils::eChecker);

        System.out.println("Sorted by contains 'e': " + Arrays.asList(arr));
    }
}
