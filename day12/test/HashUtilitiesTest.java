import org.junit.Test;

import java.util.Random;

import static HashUtilities.HashUtilities.shortHash;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * PiJ day 12 - exercise 2
 */

public class HashUtilitiesTest {

    @Test
    public void shortHashSimpleTest() {
        int numToTest = 5;

        assertEquals("shortHash should return a simple hash for a given number",
                Math.abs(numToTest % 1000), shortHash(numToTest));
    }

    @Test
    public void shortHashStressTest() {
        int oneMillion = 1000000;
        Random randomizer = new Random();

        for (int i = 0; i < oneMillion; i++) {
            int random = randomizer.nextInt(oneMillion);
            int expected = Math.abs(random % 1000);
            int actual = shortHash(random);

            assertEquals("shortHash should return expected hash for a given number", expected, actual);

            assertTrue("generated hash should be within 0 and 1000", actual >= 0 && actual <= 1000);
        }

    }
}
