/**
 * Created by lmignot on 18/01/2016.
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CompanyTest {

    @Test
    public void basicTest () {
        Company cp = new Company();

        cp.addEmployee("John Doe", "29288199X");
        cp.addEmployee("Jane Smith", "19874490C");
        cp.prettyPrint();

        assertEquals("Company lists should have correct size", cp.getListSize(), 2);
    }
}
