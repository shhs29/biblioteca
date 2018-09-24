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
private List<User> userList = new ArrayList<>();

    @DisplayName("should validate a user")
    @Test
    void testForUserLogin(){
        userList.add(new User("123-4567","user@123"));
        AuthenticatedCommand authenticatedCommand = new AuthenticatedCommand(new CheckoutBookCommand());
        Library library = new Library(itemList,userList);
        InputDriver inputDriver = mock(InputDriver.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        when(inputDriver.getUserDetails()).thenReturn("123-4567").thenReturn("user@123");
        authenticatedCommand.perform(library,outputDriver,inputDriver);
        verify(outputDriver).print("Library Number:");
        verify(outputDriver).print("Password:");
        verify(outputDriver,times(1)).print("Login Successful");
        verify(outputDriver,times(0)).print("Please login first");
    }

    @DisplayName("should not validate a user if the credentials are not valid")
    @Test
    void testForUserLoginUnsuccessful(){
        userList.add(new User("123-4567","user@123"));
        AuthenticatedCommand authenticatedCommand = new AuthenticatedCommand(new CheckoutBookCommand());
        Library library = new Library(itemList,userList);
        InputDriver inputDriver = mock(InputDriver.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        when(inputDriver.getUserDetails()).thenReturn("123-4674").thenReturn("user@134");
        authenticatedCommand.perform(library,outputDriver,inputDriver);
        verify(outputDriver).print("Library Number:");
        verify(outputDriver).print("Password:");
        verify(outputDriver,times(0)).print("Login Successful");
        verify(outputDriver,times(1)).print("Please login first");
    }

}