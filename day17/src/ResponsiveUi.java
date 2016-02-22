import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Day 17 exercise 4
 * @author Sergio - adapted by myself
 */
public class ResponsiveUi {

    private static final int MAX_TASKS = 9;

    public static void main (String[] args) {
        ResponsiveUi ui = new ResponsiveUi();
        Scanner sc = new Scanner(System.in);

        Collector collector = new Collector();

        boolean running = true;
        int taskId = 0;
        int tasksDidFinish = 0;

        while (running) {
            if (taskId <= MAX_TASKS) {
                int seconds = ui.getInput(sc);
                Runnable r = new Task(taskId, seconds * 1000, collector);
                Thread t = new Thread(r);
                t.start();
            }

            List<Integer> completedTasks = collector.getCompletedTasks();
            if (!completedTasks.isEmpty()) {
                tasksDidFinish += completedTasks.size();
                System.out.println("Completed tasks: " + completedTasks);
            }

            if (tasksDidFinish == MAX_TASKS + 1) {
                running = false;
            }

            taskId++;
        }

        sc.close();
    }

    private int getInput (Scanner sc) {
        int seconds = 0;
        boolean isNumber = false;
        while (!isNumber) {
            try {
                System.out.print("Enter the length of the task in seconds: ");
                seconds = sc.nextInt();
                isNumber = true;
            } catch (InputMismatchException e) {
                String input = sc.nextLine();
                System.out.println(input + " is not a valid number. Try again.");
            }
        }
        return seconds;
    }
}
