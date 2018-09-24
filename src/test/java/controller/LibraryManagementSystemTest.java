package controller;

import controller.LibraryManagementSystem;
import model.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class LibraryManagementSystemTest {

    private List<LibraryItem> itemList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    private LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(itemList,userList);

    private OutputDriver outputMock = mock(OutputDriver.class);
    private InputDriver inputMock = mock(InputDriver.class);

    @DisplayName("should print the welcome message")
    @Test
    void testForWelcomeMessage() {
        libraryManagementSystem.showWelcomeMessage(outputMock);
        verify(outputMock).print("Welcome");
    }

    @DisplayName("should quit if option 0 is chosen")
    @Test
    void testForQuit() {
        when(inputMock.takeInput()).thenReturn(0);
        libraryManagementSystem.showMainMenu(outputMock, inputMock);
        //verify(outputMock).printMainMenu();
        verify(outputMock).print("0.Quit");
        verify(outputMock).print("1.List Books");
        verify(outputMock).print("2.Checkout Book");
        verify(outputMock).print("3.Return Book");
        verify(outputMock).print("4.List Movies");
        verify(outputMock).print("5.Checkout Movie");
        verify(outputMock).print("6.Return Movie");
        verify(outputMock).print("Quit");
    }

    @DisplayName("should print list of books if option 1 is chosen")
    @Test
    void testForListOfBooks() {
        when(inputMock.takeInput()).thenReturn(1).thenReturn(0);
        libraryManagementSystem.showMainMenu(outputMock, inputMock);
        //verify(outputMock, times(2)).printMainMenu();
        verify(outputMock, times(2)).print("0.Quit");
        verify(outputMock, times(2)).print("1.List Books");
        verify(outputMock, times(2)).print("2.Checkout Book");
        verify(outputMock, times(2)).print("3.Return Book");
        verify(outputMock, times(2)).print("4.List Movies");
        verify(outputMock, times(2)).print("5.Checkout Movie");
        verify(outputMock, times(2)).print("6.Return Movie");
        verify(outputMock, times(1)).print("Quit");
        verify(outputMock, times(1)).printAsColumns("Tinkle,Anant Pai,1996");
        verify(outputMock, times(1)).printAsColumns("Gullivers Travels,Jonathan Swift,2004");
    }

    @DisplayName("should print the Main Menu and print Select a valid option! for invalid option")
    @Test
    void testForInvalidOption1() {
        when(inputMock.takeInput()).thenReturn(7).thenReturn(0);
        libraryManagementSystem.showMainMenu(outputMock, inputMock);
        //verify(outputMock,times(2)).printMainMenu();
        verify(outputMock, times(2)).print("0.Quit");
        verify(outputMock, times(2)).print("1.List Books");
        verify(outputMock, times(2)).print("2.Checkout Book");
        verify(outputMock, times(2)).print("3.Return Book");
        verify(outputMock, times(2)).print("4.List Movies");
        verify(outputMock, times(2)).print("5.Checkout Movie");
        verify(outputMock, times(2)).print("6.Return Movie");
        verify(outputMock).print("Select a valid option!");
        verify(outputMock).print("Quit");
    }

    @DisplayName("should print the list of books and print Select a valid option! for invalid option")
    @Test
    void testForInvalidOption2() {
        when(inputMock.takeInput()).thenReturn(1).thenReturn(7).thenReturn(0);
        libraryManagementSystem.showMainMenu(outputMock, inputMock);
        //verify(outputMock,times(3)).printMainMenu();
        verify(outputMock, times(3)).print("0.Quit");
        verify(outputMock, times(3)).print("1.List Books");
        verify(outputMock, times(3)).print("2.Checkout Book");
        verify(outputMock, times(3)).print("3.Return Book");
        verify(outputMock, times(3)).print("4.List Movies");
        verify(outputMock, times(3)).print("5.Checkout Movie");
        verify(outputMock, times(3)).print("6.Return Movie");
        verify(outputMock, times(1)).print("Select a valid option!");
        verify(outputMock, times(1)).print("Quit");
        verify(outputMock, times(1)).printAsColumns("Tinkle,Anant Pai,1996");
        verify(outputMock, times(1)).printAsColumns("Gullivers Travels,Jonathan Swift,2004");
    }

    @DisplayName("should check-out a book if option 2 is chosen")
    @Test
    void testForCheckOutBook() {
        when(inputMock.takeInput()).thenReturn(2).thenReturn(1).thenReturn(0);
        when(inputMock.getTitle()).thenReturn("Chromosome 6");
        libraryManagementSystem.showMainMenu(outputMock, inputMock);
        //verify(outputMock,times(2)).printMainMenu();
        verify(outputMock, times(3)).print("0.Quit");
        verify(outputMock, times(3)).print("1.List Books");
        verify(outputMock, times(3)).print("2.Checkout Book");
        verify(outputMock, times(3)).print("3.Return Book");
        verify(outputMock, times(3)).print("4.List Movies");
        verify(outputMock, times(3)).print("5.Checkout Movie");
        verify(outputMock, times(3)).print("6.Return Movie");

        verify(outputMock).print("Quit");
        assertFalse(libraryManagementSystem.contains("Chromosome6", ItemType.BOOK));
    }

    @DisplayName("should not check-out a book if the book is not available")
    @Test
    void testForCheckOutBookNotAvailable() {
        when(inputMock.takeInput()).thenReturn(2).thenReturn(1).thenReturn(0);
        when(inputMock.getTitle()).thenReturn("The Fault In Our Stars");
        libraryManagementSystem.showMainMenu(outputMock, inputMock);
        //verify(outputMock,times(2)).printMainMenu();
        verify(outputMock, times(3)).print("0.Quit");
        verify(outputMock, times(3)).print("1.List Books");
        verify(outputMock, times(3)).print("2.Checkout Book");
        verify(outputMock, times(3)).print("3.Return Book");
        verify(outputMock, times(3)).print("4.List Movies");
        verify(outputMock, times(3)).print("5.Checkout Movie");
        verify(outputMock, times(3)).print("6.Return Movie");

        verify(outputMock).print("Quit");
        assertFalse(libraryManagementSystem.contains("The Fault In Our Stars", ItemType.BOOK));
    }

    @DisplayName("should return a book if option 3 is chosen")
    @Test
    void testForReturnBook() {
        when(inputMock.takeInput()).thenReturn(2).thenReturn(3).thenReturn(0);
        when(inputMock.getTitle()).thenReturn("Tinkle").thenReturn("Tinkle");
        libraryManagementSystem.showMainMenu(outputMock, inputMock);
        //verify(outputMock,times(2)).printMainMenu();
        verify(outputMock, times(3)).print("0.Quit");
        verify(outputMock, times(3)).print("1.List Books");
        verify(outputMock, times(3)).print("2.Checkout Book");
        verify(outputMock, times(3)).print("3.Return Book");
        verify(outputMock, times(3)).print("4.List Movies");
        verify(outputMock, times(3)).print("5.Checkout Movie");
        verify(outputMock, times(3)).print("6.Return Movie");

        verify(outputMock).print("Quit");
        assertTrue(libraryManagementSystem.contains("Tinkle", ItemType.BOOK));
    }

    @DisplayName("should print That is not a valid book to return if the book is not in this library")
    @Test
    void testForReturnBook1() {
        when(inputMock.takeInput()).thenReturn(3).thenReturn(0);
        when(inputMock.getTitle()).thenReturn("The Fault In Our Stars");
        libraryManagementSystem.showMainMenu(outputMock, inputMock);
        //verify(outputMock,times(2)).printMainMenu();
        verify(outputMock, times(2)).print("0.Quit");
        verify(outputMock, times(2)).print("1.List Books");
        verify(outputMock, times(2)).print("2.Checkout Book");
        verify(outputMock, times(2)).print("3.Return Book");
        verify(outputMock, times(2)).print("4.List Movies");
        verify(outputMock, times(2)).print("5.Checkout Movie");
        verify(outputMock, times(2)).print("6.Return Movie");
        verify(outputMock, times(1)).print("That is not a valid book to return");

        verify(outputMock).print("Quit");
        assertFalse(libraryManagementSystem.contains("The Fault In Our Stars", ItemType.BOOK));
    }

    @DisplayName("should print list of movies if option 4 is chosen")
    @Test
    void testForListOfMovies() {
        when(inputMock.takeInput()).thenReturn(4).thenReturn(0);
        libraryManagementSystem.showMainMenu(outputMock, inputMock);
        //verify(outputMock, times(2)).printMainMenu();
        verify(outputMock, times(2)).print("0.Quit");
        verify(outputMock, times(2)).print("1.List Books");
        verify(outputMock, times(2)).print("2.Checkout Book");
        verify(outputMock, times(2)).print("3.Return Book");
        verify(outputMock, times(2)).print("4.List Movies");
        verify(outputMock, times(2)).print("5.Checkout Movie");
        verify(outputMock, times(2)).print("6.Return Movie");
        verify(outputMock, times(1)).print("Quit");
        verify(outputMock, times(1)).printAsColumnsMovie("Name,Director,Release Year,Rating");
        verify(outputMock, times(1)).printAsColumnsMovie("Paper Towns,John Green,2017,Unrated");
        verify(outputMock, times(1)).printAsColumnsMovie("A Quiet Place,John Krasinski,2018,9");
    }

    @DisplayName("should check-out a movie if option 5 is chosen")
    @Test
    void testForCheckOutMovie() {
        when(inputMock.takeInput()).thenReturn(5).thenReturn(0);
        when(inputMock.getTitle()).thenReturn("A Quiet Place");
        libraryManagementSystem.showMainMenu(outputMock, inputMock);
        //verify(outputMock,times(2)).printMainMenu();
        verify(outputMock, times(2)).print("0.Quit");
        verify(outputMock, times(2)).print("1.List Books");
        verify(outputMock, times(2)).print("2.Checkout Book");
        verify(outputMock, times(2)).print("3.Return Book");
        verify(outputMock, times(2)).print("4.List Movies");
        verify(outputMock, times(2)).print("5.Checkout Movie");
        verify(outputMock, times(2)).print("6.Return Movie");

        verify(outputMock).print("Quit");

        assertFalse(libraryManagementSystem.contains("A Quiet Place", ItemType.MOVIE));
    }

    @DisplayName("should not check-out a movie if the movie is not available")
    @Test
    void testForCheckOutMovieNotAvailable() {
        when(inputMock.takeInput()).thenReturn(5).thenReturn(0);
        when(inputMock.getTitle()).thenReturn("Jurassic Park");
        libraryManagementSystem.showMainMenu(outputMock, inputMock);
        //verify(outputMock,times(2)).printMainMenu();
        verify(outputMock, times(2)).print("0.Quit");
        verify(outputMock, times(2)).print("1.List Books");
        verify(outputMock, times(2)).print("2.Checkout Book");
        verify(outputMock, times(2)).print("3.Return Book");
        verify(outputMock, times(2)).print("4.List Movies");
        verify(outputMock, times(2)).print("5.Checkout Movie");
        verify(outputMock, times(2)).print("6.Return Movie");

        verify(outputMock).print("Quit");

        assertFalse(libraryManagementSystem.contains("Jurassic Park", ItemType.MOVIE));

    }

    @DisplayName("should return a movie if option 6 is chosen")
    @Test
    void testForReturnMovie() {
        when(inputMock.takeInput()).thenReturn(5).thenReturn(6).thenReturn(0);
        when(inputMock.getTitle()).thenReturn("Paper Towns").thenReturn("Paper Towns");
        libraryManagementSystem.showMainMenu(outputMock, inputMock);
        //verify(outputMock,times(2)).printMainMenu();
        verify(outputMock, times(3)).print("0.Quit");
        verify(outputMock, times(3)).print("1.List Books");
        verify(outputMock, times(3)).print("2.Checkout Book");
        verify(outputMock, times(3)).print("3.Return Book");
        verify(outputMock, times(3)).print("4.List Movies");
        verify(outputMock, times(3)).print("5.Checkout Movie");
        verify(outputMock, times(3)).print("6.Return Movie");

        verify(outputMock).print("Quit");
        assertTrue(libraryManagementSystem.contains("Tinkle", ItemType.BOOK));
    }

    @DisplayName("should print That is not a valid movie to return if the movie is not in this library")
    @Test
    void testForReturnMovie1() {
        when(inputMock.takeInput()).thenReturn(6).thenReturn(0);
        when(inputMock.getTitle()).thenReturn("Jurassic Park");
        libraryManagementSystem.showMainMenu(outputMock, inputMock);
        //verify(outputMock,times(2)).printMainMenu();
        verify(outputMock, times(2)).print("0.Quit");
        verify(outputMock, times(2)).print("1.List Books");
        verify(outputMock, times(2)).print("2.Checkout Book");
        verify(outputMock, times(2)).print("3.Return Book");
        verify(outputMock, times(2)).print("4.List Movies");
        verify(outputMock, times(2)).print("5.Checkout Movie");
        verify(outputMock, times(2)).print("6.Return Movie");
        verify(outputMock, times(1)).print("That is not a valid movie to return");

        verify(outputMock).print("Quit");
        assertFalse(libraryManagementSystem.contains("Jurassic Park", ItemType.BOOK));
    }

}
