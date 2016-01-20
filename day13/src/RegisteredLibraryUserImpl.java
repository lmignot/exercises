/**
 * @see RegisteredLibraryUser
 */
public class RegisteredLibraryUserImpl implements RegisteredLibraryUser {

    private String userName;
    private int userId;

    RegisteredLibraryUserImpl(String userName, int userId) {
        this.userName = userName;
        this.userId = userId;
    }

    @Override
    public int getUserId() {
        return this.userId;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }
}
