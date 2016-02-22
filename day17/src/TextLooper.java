/**
 * Day 18 exercise 2
 */
public class TextLooper implements Runnable {
    public static final int COUNT = 10;
    private final String name;

    public TextLooper(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            System.out.println("Loop:" + name + ", iteration:" + i + ".");
        }
    }
}
