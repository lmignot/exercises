import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Day 17 exercise 4
 * @author Sergio - adapted by myself
 */
public class ResponsiveUi {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        int taskId = 0;
        Collector collector = new Collector();
        while (running) {
            taskId++;
            int secs = 0;

            boolean isNumber = false;

            while (!isNumber) {
                try {
                    System.out.print("Enter the length of the task in seconds: ");
                    secs = sc.nextInt();
                    isNumber = true;
                } catch (InputMismatchException e) {
                    String input = sc.nextLine();
                    System.out.println(input + " is not a valid number. Try again.");
                }
            }

            Runnable r = new Task(taskId, secs * 1000, collector);
            Thread t = new Thread(r);
            t.start();

            String completedTasks = collector.getCompletedTasks();
            if (completedTasks.length() != 0) {
                System.out.println("Completed tasks: " + completedTasks);
            }

            if (taskId == 10) {
                running = false;
            }
        }

        sc.close();
    }

    private static class Collector {
        private String collected = "";

        private synchronized void addCompletedTask(int taskId) {
            if (this.collected.length() != 0) {
                this.collected += ", ";
            }
            this.collected += taskId;
        }

        private synchronized String getCompletedTasks() {
            String result = this.collected;
            this.collected = "";
            return result;
        }
    }

    private static class Task implements Runnable {

        private int id;
        private int delay;
        private Collector collector;

        Task(int id, int delay, Collector collector) {
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
}
