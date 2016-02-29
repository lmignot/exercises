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

}
