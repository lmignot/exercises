
/**
 * A SmartPhone is a smarter MobilePhone
 * It can browse the web and provide one's GPS coordinates
 */
public class SmartPhone extends MobilePhone {

    public SmartPhone (String brand) {
        super(brand);
    }

    /**
     * Browses a web url
     * This implementation simply prints out a line to the screen
     * @param url The url to browse.
     */
    public void browseWeb (String url) {
        System.out.println("Launching browser and loading url: " + url);
    }

    /**
     * Locates the user's current position using the phones GPS
     * This implementation simply returns a string
     * @return String with the current coordinates
     */
    public String findPosition () {
        return new Coordinates(51.5254607, -0.1292638).toString();
    }

    /**
     * Launches the specified game
     * This implementation simply prints out a line to the screen
     * @param game the game to play
     */
    public void playGame (String game) {
        System.out.println("Launching game: " + game);
    }

    @Override
    public void call (String number) {
        if (number.substring(0,2).equals("00")) {
            System.out.println("Calling " + number + " through the internet to save money");
            this.addToLog(number);
        } else {
            super.call(number);
        }
    }

}
