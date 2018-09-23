package model;

import java.util.ArrayList;
import java.util.List;

//manages the jobs of a librarian
public class Library {
    private List<LibraryItem> itemList;
    private List<LibraryItem> checkedOutList;

    public Library(List<LibraryItem> itemList) {
        this.itemList = itemList;
        checkedOutList = new ArrayList<>();
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

    public boolean checkOutItem(String title, ItemType itemType) {
        for (LibraryItem libraryItem : itemList) {
            if (itemType == libraryItem.getType()) {
                if (libraryItem.getName().equals(title)) {
                    itemList.remove(libraryItem);
                    checkedOutList.add(libraryItem);
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
        for (LibraryItem libraryItem : checkedOutList) {
            if (itemType == libraryItem.getType()) {
                if (libraryItem.getName().equals(title)) {
                    checkedOutList.remove(libraryItem);
                    itemList.add(libraryItem);
                    return true;
                }
            }
        }
        return false;
    }

}
