package Phones;

import java.util.*;

/**
 * A Mobile implementation of a Phone
 * Using a PriorityQueue to implement a log of the last 10 called numbers
 */
public class MobilePhone extends OldPhone {

    static final int MAX_LOG = 10;
    private Queue<String> callLog;

    public MobilePhone (String brand) {
        super(brand);
        this.callLog = new LinkedList<>();
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
    public String playGame (String game) {
        return "Launching game: " + game;
    }

    /**
     * Calls a number and adds it to the call log
     * @param number The number to call
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
        for (String next : callLog) {
            System.out.println("Number called: " + next);
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

        if (this.getLogSize() >= this.MAX_LOG) {
            this.callLog.poll();
            this.callLog.add(number);
        } else {
            this.callLog.add(number);
        }

    }
}
