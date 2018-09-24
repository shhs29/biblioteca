package controller.Commands;

import model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class UserDetailsCommandTest {
    private List<LibraryItem> itemList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    private OutputDriver output = new OutputDriver();
    private InputDriver input = new InputDriver();
    private User user = new User("123-4567","usre@123");
    private UserDetailsCommand userDetailsCommand = new UserDetailsCommand();

    @DisplayName("should return details of the user")
    @Test
    void testForUserDetails(){
        OutputDriver outputMock = mock(OutputDriver.class);
        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        library.setCurrentUser(user);
        userDetailsCommand.perform(library, user, outputMock, input);
        verify(outputMock).print("User name,user@example.com,9854673425");
    }
}