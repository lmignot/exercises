public class EvenStringPrinter extends String {

    /**
     * Prints the even characters contained in a String
     */
    public void printEven () {
        int len = super.length();

        if (len > 0) {
            for (int i = 0; i < len; i++) {
                if (i % 2 == 0) {
                    System.out.println(super.charAt(i));
                }
            }
        }
    }

}
