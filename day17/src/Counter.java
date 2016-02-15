/**
 * Created by lmignot on 15/02/2016.
 */
public class Counter {
    private int n = 0;
    public synchronized void increase() {
        n++;
    }
    public int getCount() {
        return n;
    }
}