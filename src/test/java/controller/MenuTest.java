package controller;

import model.Library;
import model.LibraryItem;
import model.Movie;
import model.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class MenuTest {
    private List<LibraryItem> itemList = new ArrayList<>();
    private OutputDriver output = new OutputDriver();
    private InputDriver input = new InputDriver();

    @DisplayName("should print the list of books if option 1 is chosen")
    @Test
    void testForListOfBooks() {
        OutputDriver outputMock = mock(OutputDriver.class);
        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        Menu.LIST_BOOKS.perform(library, outputMock, input);
        verify(outputMock).printAsColumns("Tinkle,Anant Pai,1996");
    }

    @DisplayName("should quit if option 0 is chosen")
    @Test
    void testForQuit() {
        OutputDriver outputMock = mock(OutputDriver.class);
        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        Menu.QUIT.perform(library, outputMock, input);
        verify(outputMock).print("Quit");
    }

    @DisplayName("should checkout a book if option 2 is chosen")
    @Test
    void testForCheckOutBook() {
        OutputDriver outputMock = mock(OutputDriver.class);
        InputDriver inputMock = mock(InputDriver.class);
        when(inputMock.getTitle()).thenReturn("Tinkle");
        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        Menu.CHECKOUT_BOOK.perform(library, outputMock, inputMock);
        verify(outputMock).print("Thank You! Enjoy the Book");
        verify(outputMock, times(0)).print("That book is not available");
    }

    @DisplayName("should not check-out if option 2 is chosen and book is not available")
    @Test
    void testForCheckOutBookNotAvailable() {
        OutputDriver outputMock = mock(OutputDriver.class);
        InputDriver inputMock = mock(InputDriver.class);
        when(inputMock.getTitle()).thenReturn("The Fault In Our Stars");
        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        Menu.CHECKOUT_BOOK.perform(library, outputMock, inputMock);
        verify(outputMock, times(0)).print("Thank You! Enjoy the Book");
        verify(outputMock).print("That book is not available");
    }

    @DisplayName("should return a book if option 3 is chosen")
    @Test
    void testForReturnBook() {
        OutputDriver outputMock = mock(OutputDriver.class);
        InputDriver inputMock = mock(InputDriver.class);
        when(inputMock.getTitle()).thenReturn("").thenReturn("The Fault In Our Stars");
        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        Menu.CHECKOUT_BOOK.perform(library, outputMock, inputMock);
        Menu.RETURN_BOOK.perform(library, outputMock, inputMock);
        verify(outputMock, times(0)).print("Thank you for returning the book");
        verify(outputMock).print("That is not a valid book to return");
    }

    @DisplayName("should not return a book if the book is not in this library")
    @Test
    void testForReturnBookUnsuccessful() {
        OutputDriver outputMock = mock(OutputDriver.class);
        InputDriver inputMock = mock(InputDriver.class);
        when(inputMock.getTitle()).thenReturn("").thenReturn("The Fault In Our Stars");
        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        Menu.CHECKOUT_BOOK.perform(library, outputMock, inputMock);
        Menu.RETURN_BOOK.perform(library, outputMock, inputMock);
        verify(outputMock, times(0)).print("Thank you for returning the book");
        verify(outputMock).print("That is not a valid book to return");
    }

    @DisplayName("should print the list of movies if option 4 is chosen")
    @Test
    void testForListOfMovies() {
        OutputDriver outputMock = mock(OutputDriver.class);

        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);

        Menu.LIST_MOVIES.perform(library, outputMock, input);
        verify(outputMock).printAsColumns("Paper Towns,John Green,2017,Unrated");
    }

    @DisplayName("should checkout a movie if option 5 is chosen")
    @Test
    void testForCheckOutMovie() {
        OutputDriver outputMock = mock(OutputDriver.class);
        InputDriver inputMock = mock(InputDriver.class);
        when(inputMock.getTitle()).thenReturn("Paper Towns");

        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);

        Menu.CHECKOUT_MOVIE.perform(library, outputMock, inputMock);
        verify(outputMock).print("Thank You! Enjoy the Movie");
        verify(outputMock, times(0)).print("That movie is not available");
    }

    @DisplayName("should not check-out if option 5 is chosen and bmovie is not available")
    @Test
    void testForCheckOutMovieNotAvailable() {
        OutputDriver outputMock = mock(OutputDriver.class);
        InputDriver inputMock = mock(InputDriver.class);
        when(inputMock.getTitle()).thenReturn("The Fault In Our Stars");

        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);

        Menu.CHECKOUT_MOVIE.perform(library, outputMock, inputMock);
        verify(outputMock, times(0)).print("Thank You! Enjoy the Movie");
        verify(outputMock).print("That movie is not available");
    }
}