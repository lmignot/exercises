/**
 * PiJ day 19 - exercise 2
 */
public class StringUtilsImpl {

    static StringUtils eChecker = (String a, String b) -> {
        if (a.contains("e")) {
            return -1;
        } else if (b.contains("e")) {
            return 1;
        } else {
            return 0;
        }
    };
}
