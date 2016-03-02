package Counting;

/**
 * Day 17 exercise 2
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