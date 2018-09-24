package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private final String libraryNumber;
    private final String password;
    private List<LibraryItem> itemList;

    public User() {
        this.libraryNumber = null;
        this.password = null;
        this.itemList = new ArrayList<>();
    }

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.itemList = new ArrayList<>();
    }

    void addItem(LibraryItem libraryItem) {
        itemList.add(libraryItem);
    }

    @Override
    public String toString() {
        return "itemList=" + itemList;
    }

    public LibraryItem findItem(String title, ItemType itemType) {
        for (LibraryItem libraryItem : itemList) {
            if (itemType == libraryItem.getType()) {
                if (libraryItem.getName().equals(title)) {
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
