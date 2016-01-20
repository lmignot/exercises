/**
 * Mock class for testing Library interface
 */
public class LibraryMock implements Library {

    @Override
    public String getLibrary() {
        return "My Library";
    }

    @Override
    public int getId(String userName) {
        return 99;
    }

    @Override
    public int getMaxBooksPerUser() {
        return 9;
    }
}
