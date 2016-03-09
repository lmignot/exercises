import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * PiJ day 12 - exercise 4.2
 */
public class QueueTestD12 {

    private static final int ONE_THOUSAND = 1000;

    @Test
    public void QueueEmUp () {
        Queue q = new Queue();
        q.insert(1);
        q.insert(4);
        q.insert(5);
        q.insert(7);

        assertEquals(q.size(), 4);
    }

    @Test
    public void TestAddRetrieveEtc () {
        Queue q = new Queue();
        q.insert(1);
        q.insert(4);
        q.insert(5);
        q.insert(7);

        assertEquals(q.size(), 4);

        assertEquals(q.retrieve(), 1);
        assertEquals(q.retrieve(), 4);
        assertEquals(q.retrieve(), 5);

        q.insert(1);
        q.insert(8);
        q.insert(7);
        q.insert(3);

        assertEquals(q.size(), 5);
    }

    @Test
    public void TestManyAddsAndRetrieves () {
        Queue q = new Queue();
        for (int i = 0; i < ONE_THOUSAND; i++) {
            q.insert(i);
        }

        assertEquals(q.size(), ONE_THOUSAND);

        int compare = 0;
        for (int i = ONE_THOUSAND; i > 0;  i--) {
            assertEquals(q.retrieve(), compare);
            compare++;
        }
    }
}
