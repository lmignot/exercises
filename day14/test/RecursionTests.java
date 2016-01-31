import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testing various recursion exercises from day14
 */
public class RecursionTests {

    @Test
    public void binarySearchTestTenItems () {
        Integer numItems = 10;
        List<Integer> toSearch = new ArrayList<>(numItems);

        for(Integer i : toSearch) {
            toSearch.add(i, (int) Math.abs(numItems * Math.random()));
        }

        boolean found = SearchUtils.search(toSearch, 6, new ConcurrentHashMap<>());

        assertThat(found).isTrue();
    }

    @Test
    public void binarySearchTestOneHundredItems () {
        Integer numItems = 100;
        List<Integer> toSearch = new ArrayList<>(numItems);

        for(Integer i : toSearch) {
            toSearch.add(i, (int) Math.abs(numItems * Math.random()));
        }
    }

    @Test
    public void binarySearchTestOneThousandItems () {
        Integer numItems = 1000;
        List<Integer> toSearch = new ArrayList<>(numItems);

        for(Integer i : toSearch) {
            toSearch.add(i, (int) Math.abs(numItems * Math.random()));
        }
    }
}
