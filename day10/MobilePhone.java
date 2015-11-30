import java.util.*;

/**
 * A Mobile implementation of a Phone
 * Using a PriorityQueue to implement a log of the last 10 called numbers
 */
public class MobilePhone extends OldPhone {

    public static final int callLogMemorySize = 10;
    private Queue<String> callLog;

    public MobilePhone (String brand) {
        super(brand);
        this.callLog = new PriorityQueue<String>();
    }

    /**
     * Rings an alarm
     * This implementation simply prints out a line to the screen
     * @param message The alarm to ring
     */
    public void ringAlarm (String message) {
        System.out.println("Ringing alarm: " + message);
    }

    /**
     * Launches the specified game
     * This implementation simply prints out a line to the screen
     * @param game the game to play
     */
    private void playGame (String game) {
        System.out.println("Launching game: " + game);
    }

    /**
     * Calls a number and adds it to the call log
     * @param number The number to call
     * @param callSuper Whether to call the super implementation or not
     */
    @Override
    public void call (String number) {
        super.call(number);
        this.addToLog(number);
    }

    /**
     * Prints out the logged calls to screen
     */
    public void printCallLog () {
        Iterator iterator = this.callLog.iterator();
        while(iterator.hasNext()){
            System.out.println("Number called: " + (String) iterator.next());
        }
    }

    /**
     * Returns the size of the call log
     */
    public int getLogSize () {
        return this.callLog.size();
    }

    /**
     * Adds a number dialed to the call log
     * @param number The number to store
     */
    public void addToLog (String number) {

        if (this.callLog.size() >= this.callLogMemorySize) {
            this.callLog.poll();
        } else {
            this.callLog.add(number);
        }

    }
}
