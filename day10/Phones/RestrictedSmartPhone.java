/**
 * A boring SmartPhone with restricted access
 * Useful for keeping children from wasting too many
 * hours playing games
 */
public class RestrictedSmartPhone extends SmartPhone {

    public RestrictedSmartPhone (String brand) {
        super(brand);
    }

    /**
     * Plays a game...
     * Overrides super method making access private
     * @param game the game to play
     */
    // can't do this
    // @Override
    // private void playGame (String game) {
    //     System.out.println("Launching game: " + game);
    // }

}
