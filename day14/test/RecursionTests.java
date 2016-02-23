import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testing various recursion exercises from day14
 */
public class RecursionTests {

    private static final int TEN = 10;
    private static final int FIFTY = 50;
    private static final int ONE_HUNDRED = 100;
    private static final int ONE_THOUSAND = 1000;

    private SearchUtils su = new SearchUtils();

    @Test
    public void mergeSortTestTenItems () {
        List<Integer> toMerge = new ArrayList<>(TEN);

        toMerge.add(3);
        toMerge.add(9);
        toMerge.add(4);
        toMerge.add(8);
        toMerge.add(2);
        toMerge.add(1);
        toMerge.add(0);
        toMerge.add(5);
        toMerge.add(6);
        toMerge.add(7);

        List<Integer> sorted = su.mergeSort(toMerge);

        System.out.println(sorted);
    }

    @Test
    public void mergeSortTestOneThousandItems () {
        List<Integer> toMerge = new ArrayList<>(ONE_THOUSAND);

        for(int i = 0; i < ONE_THOUSAND; i++) {
            toMerge.add(i, (int) Math.abs(ONE_THOUSAND * Math.random()));
        }

        List<Integer> sorted = su.mergeSort(toMerge);

        System.out.println(sorted);
    }

    @Test
    public void binarySearchTestTenItems () {
        List<Integer> toSearch = new ArrayList<>(TEN);

        toSearch.add(3);
        toSearch.add(4);
        toSearch.add(5);
        toSearch.add(6);
        toSearch.add(11);
        toSearch.add(22);
        toSearch.add(27);
        toSearch.add(32);
        toSearch.add(98);
        toSearch.add(234);

        assertThat(su.binarySearch(toSearch, 6)).isTrue();
        assertThat(su.binarySearch(toSearch, 231)).isFalse();
        assertThat(su.binarySearch(toSearch, 22)).isTrue();
        assertThat(su.binarySearch(toSearch, 190)).isFalse();
        assertThat(su.binarySearch(toSearch, 234)).isTrue();
        assertThat(su.binarySearch(toSearch, 1)).isFalse();
    }

    @Test
    public void binarySearchTestOneHundredItems () {
        List<Integer> toSearch = new ArrayList<>(ONE_HUNDRED);

        for(int i = 0; i < ONE_HUNDRED; i++) {
            toSearch.add(i, i);
        }

        assertThat(su.binarySearch(toSearch, 97)).isTrue();
        assertThat(su.binarySearch(toSearch, 32)).isTrue();
        assertThat(su.binarySearch(toSearch, 27)).isTrue();
        assertThat(su.binarySearch(toSearch, 2)).isTrue();
        assertThat(su.binarySearch(toSearch, 121)).isFalse();
        assertThat(su.binarySearch(toSearch, 198)).isFalse();
    }

    @Test
    public void binarySearchTestOneThousandItems () {
        List<Integer> toSearch = new ArrayList<>(ONE_THOUSAND);

        for(int i = 0; i < ONE_THOUSAND; i++) {
            toSearch.add(i, i);
        }

        assertThat(su.binarySearch(toSearch, 970)).isTrue();
        assertThat(su.binarySearch(toSearch, 322)).isTrue();
        assertThat(su.binarySearch(toSearch, 275)).isTrue();
        assertThat(su.binarySearch(toSearch, 189)).isTrue();
        assertThat(su.binarySearch(toSearch, 1210)).isFalse();
        assertThat(su.binarySearch(toSearch, 1980)).isFalse();
    }
}
