package model;

import model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private List<LibraryItem> itemList = new ArrayList<>();
    private User user = new User("123-4567", "user@123");


    @DisplayName("should return the details of the book")
    @Test
    void testForBookDetails() {

        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);

        List<String> result = new ArrayList<>();
        result.add("Tinkle,Anant Pai,1996");

        Assertions.assertEquals(library.getItemDetails(ItemType.BOOK), result);
    }

    @DisplayName("should return details of all the books")
    @Test
    void testForBookDetails1() {

        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);

        List<String> result = new ArrayList<>();
        result.add("Tinkle,Anant Pai,1996");
        result.add("Chromosome 6,Robin Cook,2001");

        Assertions.assertEquals(library.getItemDetails(ItemType.BOOK), result);
    }

    @DisplayName("should check-out a book and remove it from the list of books")
    @Test
    void testForCheckOutBook() {

        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        library.addUser(new User("123-4567", "user@123"));
        boolean isCheckedOut = library.checkOutItem(user, "Tinkle", ItemType.BOOK);
        assertFalse(library.contains("Tinkle",ItemType.BOOK));
        assertTrue(isCheckedOut);
    }

    @DisplayName("should return false if a book is not available to check-out")
    @Test
    void testForCheckOutWhenBookNotAvailable() {

        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        library.addUser(new User("123-4567", "user@123"));
        boolean isCheckedOut = library.checkOutItem(user, "Gullivers Travels", ItemType.BOOK);

        assertFalse(isCheckedOut);
    }

    @DisplayName("should return true if return book is successful")
    @Test
    void testForReturnBook() {

        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        library.addUser(new User("123-4567", "user@123"));
        boolean isCheckedOut = library.checkOutItem(user, "Tinkle", ItemType.BOOK);
        boolean isReturned = library.returnItem(user, "Tinkle", ItemType.BOOK);
        assertTrue(library.contains("Tinkle",ItemType.BOOK));
        assertTrue(isReturned);
    }

    @DisplayName("should return false if return book is not successful")
    @Test
    void testForReturnBookUnsuccessful() {

        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        library.addUser(new User("123-4567", "user@123"));
        boolean isReturned = library.returnItem(user, "The Fault In Our Stars", ItemType.BOOK);

        assertFalse(isReturned);
    }

    @DisplayName("should return details of all the movies")
    @Test
    void testForMovieDetails() {
        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        itemList.add(new Movie("A Quiet Place", "John Krasinski", "2018", 9));
        Library library = new Library(itemList);
        List<String> result = new ArrayList<>();
        result.add("Paper Towns,John Green,2017,Unrated");
        result.add("A Quiet Place,John Krasinski,2018,9");

        assertEquals(library.getItemDetails(ItemType.MOVIE), result);
    }


    @DisplayName("should return true if return movie is successful")
    @Test
    void testForReturnMovie() {
        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        library.addUser(new User("123-4567", "user@123"));
        boolean isCheckedOut = library.checkOutItem(user, "Paper Towns", ItemType.MOVIE);
        boolean isReturned = library.returnItem(user, "Paper Towns", ItemType.MOVIE);
        assertTrue(library.contains("Paper Towns",ItemType.MOVIE));
        assertTrue(isReturned);
    }

    @DisplayName("should return false if return movie is not successful")
    @Test
    void testForReturnMovieUnsuccessful() {
        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        library.addUser(new User("123-4567", "user@123"));
        boolean isReturned = library.returnItem(user, "The Fault In Our Stars", ItemType.MOVIE);

        assertFalse(isReturned);
    }

    @DisplayName("should check-out a movie and remove it from the list of movies")
    @Test
    void testForCheckOutMovie() {
        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);

        library.addUser(new User("123-4567", "user@123"));
        boolean isCheckedOut = library.checkOutItem(user, "Paper Towns", ItemType.MOVIE);
        assertFalse(library.contains("Paper Towns",ItemType.MOVIE));
        assertTrue(isCheckedOut);
    }

    @DisplayName("should return false if a movie is not available to check-out")
    @Test
    public void testForCheckOutWhenMovieNotAvailable() {
        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        library.addUser(new User("123-4567", "user@123"));

        boolean isCheckedOut = library.checkOutItem(user, "Jurassic Park", ItemType.MOVIE);

        assertFalse(isCheckedOut);
    }
}