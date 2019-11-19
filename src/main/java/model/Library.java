package model;

import java.util.ArrayList;
import java.util.List;

//manages the jobs of a librarian
public class Library {
    public List<User> userList;
    private List<LibraryItem> itemList;
    private User currentUser;

    public Library(List<LibraryItem> itemList) {
        this.itemList = itemList;
        userList = new ArrayList<>();
        currentUser = null;
        userList = new ArrayList<>();
        userList.add(new User("123-4567", "user@123"));
        userList.add(new User("678-1423", "user@456"));
    }

    public List<String> getItemDetails(ItemType itemType) {
        List<String> itemTitles = new ArrayList<>();
        for (LibraryItem libraryItem : itemList) {
            if (itemType == libraryItem.getType()) {
                itemTitles.add(libraryItem.toString());
            }
        }
        return itemTitles;
    }

    void addUser(User user) {
        userList.add(user);
    }

    public boolean checkOutItem(String title, ItemType itemType) {
        for (LibraryItem libraryItem : itemList) {
            if (itemType == libraryItem.getType()) {
                if (libraryItem.getName().toLowerCase().equals(title.toLowerCase())) {
                    itemList.remove(libraryItem);
                    currentUser.addItem(libraryItem);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean contains(String title, ItemType itemType) {
        for (LibraryItem libraryItem : itemList) {
            if (itemType == libraryItem.getType()) {
                if (libraryItem.getName().equals(title)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean returnItem(String title, ItemType itemType) {
        LibraryItem libraryItem = currentUser.findItem(title, itemType);
        if (libraryItem != null) {
            itemList.add(libraryItem);
            return true;
        }
        return false;
    }

    public boolean login(User user) {
        if (validateUser(user) == null) {
            return false;
        }
        currentUser = validateUser(user);
        return true;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    private User validateUser(User user) {
        for (User userAccount : userList) {
            if (userAccount.equals(user)) {
                return userAccount;
            }
        }
        return null;
    }
}
