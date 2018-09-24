package model;

public class User {
    private final String libraryNumber;
    private final String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public int verify(String userId, String password) {
        if (this.libraryNumber.equals(userId) && this.password.equals(password)) {
            return 1;
        }
        return 0;
    }
}
