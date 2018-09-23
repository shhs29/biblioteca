package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import model.Book;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @DisplayName("should return a book called Gullivers Travels")
    @Test
    void shouldReturnBook() {
        Book book = new Book("Gullivers Travels","Jonathan Swift","2004");
        Book book1 = new Book("Gullivers Travels","Jonathan Swift","2004");
        Assertions.assertEquals(book1, book);
    }

    @DisplayName("should return a book called Gullivers Travels and a book called Tinkle")
    @Test
    void shouldReturnBook1() {
        Book book1 = new Book("Tinkle","Anant Pai","1996");
        Book book2 = new Book("Gullivers Travels","Jonathan Swift", "2004");
        assertAll(() -> Assertions.assertEquals(new Book("Tinkle","Anant Pai","1996"), book1),
                () -> Assertions.assertEquals(new Book("Gullivers Travels","Jonathan Swift","2004"), book2));
    }

    @DisplayName("should return the title, author and year of publishing")
    @Test
    void shouldReturnBookDetails() {
        Book book1 = new Book("Tinkle","Anant Pai","1996");
        Book book2 = new Book("Gullivers Travels","Jonathan Swift", "2004");
        assertAll(() -> Assertions.assertEquals("Tinkle,Anant Pai,1996", book1.toString()),
                () -> Assertions.assertEquals("Gullivers Travels,Jonathan Swift,2004", book2.toString()));
    }

}