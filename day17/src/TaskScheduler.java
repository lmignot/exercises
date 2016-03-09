import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

/**
 * PiJ day 18 exercises
 */
public class TaskScheduler implements Executor {

    private final Queue<Runnable> tasks = new ArrayDeque<>();
    private final Executor executor;
    private Runnable activeTask;

    public TaskScheduler (Executor executor) throws NullPointerException {
        if (executor == null) {
            throw new NullPointerException("Scheduler requires an executor");
        }
        this.executor = executor;
    }

    @Override
    public synchronized void execute(final Runnable command) {
        tasks.offer(()-> {
           try {
               command.run();
           } finally {
               execNext();
           }
        });
        if (activeTask == null) {
            execNext();
        }
    }

    private void execNext () {
        activeTask = tasks.poll();
        if(activeTask != null) {
            executor.execute(activeTask);
        }
    }
}
