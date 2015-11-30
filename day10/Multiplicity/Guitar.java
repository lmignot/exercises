/**
 * This is a Guitar, it is a WoodenObject that is a MusicalInstrument
 */
public class Guitar extends WoodenObject implements MusicalInstrument {

    private String brand;

    public Guitar (String brand) {
        super("Guitar");
        this.brand = brand;
    }

    /**
     * Retrieves the Guitar's brand
     */
    public String getBrand () {
        return this.brand;
    }

    /**
     * Plays the specified song
     * This implementation simply prints the song's name to screen
     * @param song The song to play
     */
    public void play (String song) {
        System.out.println("Playing song: " + song);
    }
}
