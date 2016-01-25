/**
 * Test class
 */
public class McCarthy {

    private int numberOfLoops = 0;

    public int mcCarthy91(int n) {
        this.numberOfLoops++;
        System.out.println(n);
        if (n > 100) {
            return n - 10;
        } else {
            return mcCarthy91(mcCarthy91(n + 11));
        }
    }

    public int getLoops () {
        return this.numberOfLoops;
    }

    public void reset () {
        this.numberOfLoops = 0;
    }
}
