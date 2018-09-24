package model;

import java.util.ArrayList;
import java.util.List;

//manages the jobs of a librarian
public class Library {
    private List<LibraryItem> itemList;
    public List<User> userList;
    private User currentUser;

    public Library(List<LibraryItem> itemList) {
        this.itemList = itemList;
        userList = new ArrayList<>();
        currentUser = null;
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

    public void addUser(User user){
        userList.add(user);
    }

    public boolean checkOutItem(User user, String title, ItemType itemType) {
        for (LibraryItem libraryItem : itemList) {
            if (itemType == libraryItem.getType()) {
                if (libraryItem.getName().equals(title)) {
                    itemList.remove(libraryItem);
                    user.addItem(libraryItem);
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

    public boolean returnItem(User user, String title, ItemType itemType) {
        LibraryItem libraryItem = user.findItem(title, itemType);
        if (libraryItem != null) {
            itemList.add(libraryItem);
            return true;
        }
        return false;
    }

    public void login(User user) {
        currentUser = user;
    }

    public User getCurrentUser(){
        return currentUser;
    }
}
