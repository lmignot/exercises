package Phones;

/**
 * A SmartPhone is a smarter MobilePhone
 * It can browse the web and provide one's GPS coordinates
 */
public class SmartPhone extends MobilePhone {

    private boolean internetDial = false;

    public SmartPhone (String brand) {
        super(brand);
    }

    /**
     * Browses a web url
     * This implementation simply prints out a line to the screen
     * @param url The url to browse.
     */
    public String browseWeb (String url) {
        return "Launching browser and loading url: " + url;
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
    @Override
    public String playGame (String game) {
        return "Launching game: " + game;
    }

    public boolean didDialViaInternet () {
        return this.internetDial;
    }

    @Override
    public void call (String number) {
        if (number.substring(0,2).equals("00") ||
                (number.substring(0,1).equals("+") && !number.substring(1,3).equals("44"))) {
            System.out.println("Calling " + number + " through the internet to save money");
            this.internetDial = true;
            this.addToLog(number);
        } else {
            this.internetDial = false;
            super.call(number);
        }
    }

}
