import java.util.ArrayList;
import java.util.List;

/**
 * Day 17 exercise 4
 */
public class Collector {
    private List<Integer> collected = null;

    public Collector () {
        collected = new ArrayList<>();
    }

    public synchronized void addCompletedTask (int taskId) {
        collected.add(taskId);
    }

    public List<Integer> getCompletedTasks () {
        if (collected.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> result = collected;
        collected = new ArrayList<>();
        return result;
    }
}