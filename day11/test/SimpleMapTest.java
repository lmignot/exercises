import DataStructures.SimpleMap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * PiJ day 11 - exercise 6.1 tests
 */
public class SimpleMapTest {

    private static final int ONE_THOUSAND = 1000;

    @Test
    public void testSimpleMapPutAndGet () {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("Peter Parker", 1);
        map.put("Wade Wilson", 2);
        map.put("Peter Quill", 1);

        assertEquals(map.size(), 3);

        int pp = map.get("Peter Parker");
        int ww = map.get("Wade Wilson");
        int pq = map.get("Peter Quill");

        assertEquals(pp, 1);
        assertEquals(ww, 2);
        assertEquals(pq, 1);
    }

    @Test
    public void testSimpleMapRemove () {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Peter Parker");
        map.put(2, "Wade Wilson");
        map.put(3, "Peter Quill");
        map.put(5, "Wade Wilson");
        map.put(4, "Peter Quill");
        map.put(7, "Peter Parker");

        assertEquals(map.size(), 6);

        assertTrue(map.remove(5));
        assertTrue(map.remove(4));

        assertEquals(map.size(), 4);

        map.put(5, "Wade Wilson");
        map.put(4, "Peter Quill");

        assertEquals(map.size(), 6);
    }

    @Test
    public void testReplaceByPut () {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Peter Parker");
        map.put(1, "Wade Wilson");
        map.put(1, "Peter Quill");

        String p = map.get(1);

        assertEquals(map.size(), 1);
        assertEquals(p, "Peter Quill");
    }

    @Test
    public void testMaxItems () {
        SimpleMap<String, Integer> map = new SimpleMap<>();

        for (int i = 0; i < ONE_THOUSAND; i++) {
            map.put(String.valueOf(i), i);
        }

        assertEquals(map.size(), 1000);

        map.put("1001", 1001);

        assertEquals(map.size(), 1000);
    }
}
