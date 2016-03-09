import java.util.concurrent.Executor;

/**
 * PiJ day 18 exercise 3.1
 */
public class ScheduledTask implements Executor {
    @Override
    public void execute(Runnable command) {
        Thread t = new Thread(command);
        t.start();
    }
}
