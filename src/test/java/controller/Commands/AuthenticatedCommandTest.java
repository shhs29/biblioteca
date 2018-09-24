package controller.Commands;

import model.Library;
import model.LibraryItem;
import model.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthenticatedCommandTest {
    private List<LibraryItem> itemList = new ArrayList<>();
    private User user = new User();

    @DisplayName("should validate a user")
    @Test
    void testForUserLogin() {
        AuthenticatedCommand authenticatedCommand = new AuthenticatedCommand(new CheckoutBookCommand());
        Library library = new Library(itemList);
        InputDriver inputDriver = mock(InputDriver.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        when(inputDriver.getUserDetails()).thenReturn("123-4567").thenReturn("user@123");
        authenticatedCommand.perform(library,user, outputDriver, inputDriver);
        verify(outputDriver).print("Library Number:");
        verify(outputDriver).print("Password:");
        verify(outputDriver, times(1)).print("Login Successful");
        verify(outputDriver, times(0)).print("Please login first");
    }

    @DisplayName("should validate a user")
    @Test
    void testForUserLogin1() {
        AuthenticatedCommand authenticatedCommand = new AuthenticatedCommand(new CheckoutBookCommand());
        Library library = new Library(itemList);
        InputDriver inputDriver = mock(InputDriver.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        when(inputDriver.getUserDetails()).thenReturn("678-1423").thenReturn("user@456");
        authenticatedCommand.perform(library,user, outputDriver, inputDriver);
        verify(outputDriver).print("Library Number:");
        verify(outputDriver).print("Password:");
        verify(outputDriver, times(1)).print("Login Successful");
        verify(outputDriver, times(0)).print("Please login first");
    }

    @DisplayName("should not validate a user if the credentials are not valid")
    @Test
    void testForUserLoginUnsuccessful() {
        AuthenticatedCommand authenticatedCommand = new AuthenticatedCommand(new CheckoutBookCommand());
        Library library = new Library(itemList);
        InputDriver inputDriver = mock(InputDriver.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        when(inputDriver.getUserDetails()).thenReturn("123-4674").thenReturn("user@134");
        authenticatedCommand.perform(library,user, outputDriver, inputDriver);
        verify(outputDriver).print("Library Number:");
        verify(outputDriver).print("Password:");
        verify(outputDriver, times(0)).print("Login Successful");
        verify(outputDriver, times(1)).print("Please login first");
    }

}