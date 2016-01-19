/**
 * Implementation of Library User
 * @see LibraryUser
 */
public class LibraryUserImpl implements LibraryUser {

    private final String fullName;
    private int libraryId;

    LibraryUserImpl(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @see LibraryUser#getFullName()
     */
    @Override
    public String getFullName() {
        return this.fullName;
    }

    /**
     * @see LibraryUser#getLibraryId()
     */
    @Override
    public int getLibraryId() {
        return this.libraryId;
    }
}
