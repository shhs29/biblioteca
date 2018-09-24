package controller;

import model.*;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;


//controller
public class LibraryManagementSystem {
    private Library library;

    public LibraryManagementSystem(List<LibraryItem> itemList) {
        addDummyBooks(itemList);
        addDummyMovies(itemList);
        library = new Library(itemList);
    }

    private void addDummyMovies(List<LibraryItem> itemList) {
        itemList.add(new Movie("The Fault In Our Stars", "John Green", "2016", 8));
        itemList.add(new Movie("Paper Towns", "John Green", "2017", 0));
        itemList.add(new Movie("A Quiet Place", "John Krasinski", "2018", 9));
    }

    public void showMainMenu(OutputDriver output, InputDriver input) {
        int option;
        User user;
        do {
            user = library.getCurrentUser();
            Menu[] menu = Menu.values();
            for (Menu menuOption : menu) {
                menuOption.displayMenu(output);
            }
            option = input.takeInput();
            if (option < menu.length) {
                menu[option].perform(library,user, output, input);
            } else {
                output.print("Select a valid option!");
            }
            output.printHorizontalLine();
        } while (option != 0);
    }

    private void addDummyBooks(List<LibraryItem> itemList) {
        itemList.add(new Book("Tinkle", "Anant Pai", "1996"));
        itemList.add(new Book("Gullivers Travels", "Jonathan Swift", "2004"));
        itemList.add(new Book("Chromosome 6", "Robin Cook", "2001"));
    }


    public void showWelcomeMessage(OutputDriver output) {
        output.print("Welcome");
        output.printHorizontalLine();
    }


    public boolean contains(String title, ItemType itemType) {
        return library.contains(title, itemType);
    }
}
