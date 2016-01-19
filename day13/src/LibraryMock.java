/**
 * Mock class for testing Library interface
 */
public class LibraryMock implements Library {

    /**
     * @see Library#getLibrary()
     */
    @Override
    public String getLibrary() {
        return "My Library";
    }

    /**
     * @see Library#getId(String)
     */
    @Override
    public int getId(String userName) {
        return 99;
    }
}
