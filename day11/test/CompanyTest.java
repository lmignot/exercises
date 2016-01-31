/**
 * Testing Generics - PiJ day 11
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CompanyTest {

    @Test
    public void basicTest () {
        Company cp = new Company();

        cp.addEmployee("John Doe", "29288199X");
        cp.addEmployee("Zane Zoolander", "19874490C");
        cp.addEmployee("Jane Smith", "19874490Z");
        cp.addEmployee("Adam Elderson", "19874490F");
        cp.addEmployee("Peter Baker", "198744786Y");
        cp.prettyPrint();

        assertEquals("Company lists should have correct size", cp.getListSize(), 5);
    }
}
