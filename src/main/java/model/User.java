package model;

public class User {
    private final String libraryNumber;
    private final String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    int verify(String userId, String password) {
        if (this.libraryNumber == userId && this.password == password) {
            return 1;
        }
        return 0;
    }
}
