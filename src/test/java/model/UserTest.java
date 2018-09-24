package model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user = new User("123-4567", "user@123");
    private User user1 = new User("123-4567", "user@123");

    @DisplayName("should verify a user and return true if user is found")
    @Test
    void testForUserValidation() {
       assertTrue(user.equals(user1));
    }

    @DisplayName("should add an item to the user's item list")
    @Test
    void testForAddItem() {
        LibraryItem libraryItem = new Book("Tinkle", "Anant Pai", "1996");
        user.addItem(libraryItem);
        assertEquals(user.toString(),"itemList=[Tinkle,Anant Pai,1996]");
    }

    @DisplayName("should remove an item from the user's item list if it is available")
    @Test
    void testForRemoveItem(){
        user.addItem(new Book("Tinkle","Anant Pai","1996"));
        LibraryItem result =new Book("Tinkle","Anant Pai","1996");
        assertEquals(user.findItem("Tinkle",ItemType.BOOK),result);
    }

    @DisplayName("should not remove an item from the user's item list if it is not available")
    @Test
    void testForRemoveItemUnsuccessful(){
        user.addItem(new Book("Tinkle","Anant Pai","1996"));
        assertNull(user.findItem("Gullivers Travels",ItemType.BOOK));
    }

    @DisplayName("should return false if item list is not empty")
    @Test
    void testForItemList(){
        user.addItem(new Book("Tinkle","Anant Pai","1996"));
        assertFalse(user.isItemListEmpty());
    }

    @DisplayName("should return true if item list is empty")
    @Test
    void testForItemList1(){
       assertTrue(user.isItemListEmpty());
    }
}