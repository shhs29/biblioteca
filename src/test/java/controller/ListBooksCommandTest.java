package controller;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ListBooksCommandTest {
    private List<LibraryItem> itemList = new ArrayList<>();
    private OutputDriver output = new OutputDriver();
    private InputDriver input = new InputDriver();
    private ListBooksCommand listBooksCommand = new ListBooksCommand();

    @DisplayName("should print the list of books if option 1 is chosen")
    @Test
    void testForListOfBooks() {
        OutputDriver outputMock = mock(OutputDriver.class);
        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        Library library = new Library(itemList);
        listBooksCommand.perform(library, outputMock, input);
        verify(outputMock).printAsColumns("Tinkle,Anant Pai,1996");
    }

}