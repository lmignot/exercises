/**
 * Created by lmignot on 14/01/2016.
 */
public class Comparator {
    public static int getMax(int n, int m) {
        return (n > m) ? n : m;
    }

    public static double getMax(double d1, double d2) {
        return (d1 > d2) ? d1 : d2;
    }

    public static String getMax(String number1, String number2) {
        int n1 = Integer.parseInt(number1);
        int n2 = Integer.parseInt(number2);

        return String.valueOf((n1 > n2) ? n1 : n2);
    }
}
