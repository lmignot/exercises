package ResponsiveUi;

/**
 * Day 17 exercise 4
 */
public class Task implements Runnable {

    private int id;
    private int delay;
    private Collector collector;

    public Task(int id, int delay, Collector collector) {
        this.id = id;
        this.delay = delay;
        this.collector = collector;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.delay);
        } catch (InterruptedException ex) {
            //no-op
        }
        this.collector.addCompletedTask(this.id);
    }
}
