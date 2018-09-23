package controller.Commands;

import controller.Commands.CheckoutBookCommand;
import model.Book;
import model.Library;
import model.LibraryItem;
import model.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CheckoutBookCommandTest {
    private List<LibraryItem> itemList = new ArrayList<>();
    private OutputDriver output = new OutputDriver();
    private InputDriver input = new InputDriver();
    private CheckoutBookCommand checkoutBookCommand = new CheckoutBookCommand();

    @DisplayName("should checkout if option 2 is chosen")
    @Test
    void testForCheckOutBook() {
        OutputDriver outputMock = mock(OutputDriver.class);
        InputDriver inputMock = mock(InputDriver.class);
        when(inputMock.getTitle()).thenReturn("Tinkle");
        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        checkoutBookCommand.perform(library, outputMock, inputMock);
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
        checkoutBookCommand.perform(library, outputMock, inputMock);
        verify(outputMock, times(0)).print("Thank You! Enjoy the Book");
        verify(outputMock).print("That book is not available");
    }

}