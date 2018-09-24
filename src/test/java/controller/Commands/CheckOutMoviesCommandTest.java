package controller.Commands;

import controller.Commands.CheckOutMoviesCommand;
import model.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CheckOutMoviesCommandTest {

    private List<LibraryItem> itemList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    private User user = new User("123-4567", "user@123");
    private OutputDriver output = new OutputDriver();
    private InputDriver input = new InputDriver();
    private CheckOutMoviesCommand checkoutMoviesCommand = new CheckOutMoviesCommand();

    @DisplayName("should checkout if option 4 is chosen")
    @Test
    void testForCheckOutMovie() {
        OutputDriver outputMock = mock(OutputDriver.class);
        InputDriver inputMock = mock(InputDriver.class);
        when(inputMock.getTitle()).thenReturn("Paper Towns");

        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        library.setCurrentUser(user);
        checkoutMoviesCommand.perform(library, user, outputMock, inputMock);
        verify(outputMock).print("Thank You! Enjoy the Movie");
        verify(outputMock, times(0)).print("That movie is not available");
    }

    @DisplayName("should not check-out if option 4 is chosen and movie is not available")
    @Test
    void testForCheckOutMovieNotAvailable() {
        OutputDriver outputMock = mock(OutputDriver.class);
        InputDriver inputMock = mock(InputDriver.class);
        when(inputMock.getTitle()).thenReturn("The Fault In Our Stars");

        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        library.setCurrentUser(user);
        checkoutMoviesCommand.perform(library, user, outputMock, inputMock);
        verify(outputMock, times(0)).print("Thank You! Enjoy the Movie");
        verify(outputMock).print("That movie is not available");
    }
}