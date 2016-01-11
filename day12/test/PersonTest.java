import org.junit.*;
import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testsNormalName () {
        String name = "Laurent Jonathan Mignot";
        String initials = "LJM";

        assertEquals("getInitials should return the correct initials", initials, Person.getInitials(name));
    }

    @Test
    public void testsNamesWithExtraSpaces () {
        String[] names = {
                "Laurent Mignot",
                "John Doe",
                "Jack  Daniels",
                "Jane Anne  Smith",
                "Clark  Kent",
                "Rupert  Darcy  Sr"};
        String[] initials = {"LM", "JD", "JD", "JAS", "CK", "RDS"};

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            String initial = initials[i];

            assertEquals("getInitials should return the correct initials", initial, Person.getInitials(name));
        }
    }

    @Test
    public void testsSpacesAroundName () {
        String name = " Laurent Jonathan Mignot ";
        String initials = "LJM";

        assertEquals("getInitials should return the correct initials", initials, Person.getInitials(name));
    }

    @Test
    public void testsSpacesAroundAndInsideName () {
        String name = " Laurent Jonathan  Mignot ";
        String initials = "LJM";

        assertEquals("getInitials should return the correct initials", initials, Person.getInitials(name));
    }
}
