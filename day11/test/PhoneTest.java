/**
 * Created by lmignot on 18/01/2016.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import Phones.*;

public class PhoneTest {

    private SmartPhone sp;
    private String brand = "Nokia";

    @Before
    public void beforeUp () {
        MobilePhone mp = new SmartPhone(brand);
        sp = (SmartPhone) mp;
        sp.call("+4407401970527");
        sp.call("+4408456785948");
        sp.call("01908222111");
        sp.call("01908260260");
        sp.call("+05559876092");
        sp.call("+496971033307");
        sp.call("+33645678392");
        sp.call("02089768594");
        sp.call("+61758490395");
        sp.call("02190765849");
    }

    @After
    public void afterUp () {
        sp = null;
    }

    @Test
    public void SmartPhoneTest () {
        assertEquals("Phone should have the correct brand", brand, sp.getBrand());
        assertFalse("Phone should not have dialed last number via internet", sp.didDialViaInternet());
        sp.call("+33145678930");
        assertTrue("Phone should have dialed last number via internet", sp.didDialViaInternet());
        assertEquals("Phone should browse correct url",
                sp.browseWeb("http://www.google.com"), "Launching browser and loading url: http://www.google.com");
        System.out.println(sp.findPosition());
        assertEquals("Phone should play the correct game",
                sp.playGame("Nibbles"), "Launching game: Nibbles");
        sp.printCallLog();
        sp.ringAlarm("Work wake up");

        castPhoneTest(new SmartPhone("Apple"));
        castPhoneTest(new MobilePhone("Samsung"));
    }

    public void castPhoneTest (Phone p) {
        SmartPhone test = (SmartPhone) p;
        System.out.println("");
        System.out.println("");
        test.call("01908675849");
        System.out.println(test.browseWeb("http://www.google.com"));
        System.out.println(test.didDialViaInternet());
        System.out.println(test.findPosition());
        System.out.println(test.playGame("Snake2"));
        test.printCallLog();
        test.ringAlarm("Goodnight");
    }
}
