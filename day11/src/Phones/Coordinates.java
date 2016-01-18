/**
 * Simple class to store a set of coordinates
 */
package Phones;

public class Coordinates {

    private double latitude;
    private double longitude;

    public Coordinates (double lat, double lng) {
        this.latitude = lat;
        this.longitude = lng;
    }

    /**
     * Allows to print out the coordinates
     * @return the coordinates as a string
     */
    public String toString () {
        String result = "Latitude: " + this.latitude;
        result += "\nLongitude: " + this.longitude;

        return result;
    }
}
