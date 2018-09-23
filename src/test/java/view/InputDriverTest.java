package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import view.InputDriver;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class InputDriverTest {

    @Test
    void testMenuInput() {
        setSystemIn("2\n");

        InputDriver inputDriver = new InputDriver();
        assertEquals(2, inputDriver.takeInput());
    }

    private void setSystemIn(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }

    @Test
    void testGetTitle(){
        setSystemIn("The Hobbit");

        InputDriver inputDriver = new InputDriver();
        assertEquals("The Hobbit", inputDriver.getTitle());
    }

    @AfterEach
    void setup() {
        System.setIn(System.in);
    }
}