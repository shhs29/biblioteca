package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private final String libraryNumber;
    private final String password;
    private final String name;
    private final String phoneNumber;
    private final String emailId;
    private List<LibraryItem> itemList;

    public User() {
        this.libraryNumber = null;
        this.password = null;
        this.itemList = new ArrayList<>();
        this.name = "User name";
        this.phoneNumber = "9854673425";
        this.emailId = "user@example.com";
    }

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.itemList = new ArrayList<>();
        this.name = "User name";
        this.phoneNumber = "9854673425";
        this.emailId = "user@example.com";
    }

    void addItem(LibraryItem libraryItem) {
        itemList.add(libraryItem);
    }

    public String getUserDetails() {
        return this.name + "," + this.emailId + "," + this.phoneNumber;
    }

    @Override
    public String toString() {
        return "itemList=" + itemList;
    }

    public LibraryItem findItem(String title, ItemType itemType) {
        for (LibraryItem libraryItem : itemList) {
            if (itemType == libraryItem.getType()) {
                if (libraryItem.getName().toLowerCase().equals(title.toLowerCase())) {
                    itemList.remove(libraryItem);
                    return libraryItem;
                }
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(libraryNumber, user.libraryNumber) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryNumber, password);
    }

    boolean isItemListEmpty() {
        return itemList.isEmpty();
    }
}
