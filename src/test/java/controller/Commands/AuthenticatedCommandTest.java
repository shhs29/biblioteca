package controller.Commands;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AuthenticatedCommandTest {

    @DisplayName("should validate a user")
    @Test
    @Disabled
    void testForUserLogin(){
        InputDriver inputDriver = mock(InputDriver.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        when(inputDriver.getUserDetails()).thenReturn("123-4567").thenReturn("user@123");
        verify(outputDriver).print("Library Number:");
        verify(outputDriver).print("Password:");
    }

}