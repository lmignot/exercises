/**
 * Day 17 exercise 4
 */
public class Collector {
    private String collected = "";

    public synchronized void addCompletedTask (int taskId) {
        if (this.collected.length() != 0) {
            this.collected += ", ";
        }
        this.collected += taskId;
    }

    public synchronized String getCompletedTasks () {
        String result = this.collected;
        this.collected = "";
        return result;
    }
}