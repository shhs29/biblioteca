import controller.LibraryManagementSystem;
import controller.ListBooksCommand;
import model.Book;
import model.Library;
import model.LibraryItem;
import model.Movie;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

//Bangalore Public model.Library App
public class BibliotecaApplication {
    public static void main(String[] args) {
        List<LibraryItem> libraryItemList = new ArrayList<>();
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(libraryItemList);
        OutputDriver output = new OutputDriver();
        InputDriver input = new InputDriver();
        libraryManagementSystem.showWelcomeMessage(output);
        libraryManagementSystem.showMainMenu(output, input);
    }
}
