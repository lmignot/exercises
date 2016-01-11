/**
 * Person class created to practice writing unit tests
 */
public class Person {

    /**
     * Returns the initials for a given name
     * @param fullName The name to get the initials for
     * @return A String with the retrieved initials
     */
    public static String getInitials (String fullName) {
        String result = "";
        String[] words = fullName.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                String nextInitial = "" + words[i].charAt(0);
                result = result + nextInitial.toUpperCase();
            }
        }

        return result;
    }
}
