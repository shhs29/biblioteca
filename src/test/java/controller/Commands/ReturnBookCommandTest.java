package controller.Commands;

import controller.Commands.CheckoutBookCommand;
import controller.Commands.ReturnBookCommand;
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

class ReturnBookCommandTest {
    private List<LibraryItem> itemList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    private OutputDriver output = new OutputDriver();
    private InputDriver input = new InputDriver();
    private User user = new User();
    private ReturnBookCommand returnBookCommand = new ReturnBookCommand();
    private CheckoutBookCommand checkoutBookCommand = new CheckoutBookCommand();

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
        checkoutBookCommand.perform(library,user, outputMock, inputMock);
        returnBookCommand.perform(library,user, outputMock, inputMock);
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
        checkoutBookCommand.perform(library,user, outputMock, inputMock);
        returnBookCommand.perform(library,user, outputMock, inputMock);
        verify(outputMock, times(0)).print("Thank you for returning the book");
        verify(outputMock).print("That is not a valid book to return");
    }
}