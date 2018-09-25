package controller;

import controller.Commands.*;
import model.Library;
import model.User;
import view.InputDriver;
import view.OutputDriver;

import java.util.List;

import static controller.MenuDisplay.*;

public enum Menu {
    QUIT("0.Quit", new QuitCommand(), DISPLAY),
    LIST_BOOKS("1.List Books", new ListBooksCommand(), DISPLAY),
    CHECKOUT_BOOK("2.Checkout Book", new AuthenticatedCommand(new CheckoutBookCommand()), DISPLAY),
    RETURN_BOOK("3.Return Book", new AuthenticatedCommand(new ReturnBookCommand()), DISPLAY),
    LIST_MOVIES("4.List Movies", new ListMoviesCommand(), DISPLAY),
    CHECKOUT_MOVIE("5.Checkout Movie", new AuthenticatedCommand(new CheckOutMoviesCommand()), DISPLAY),
    RETURN_MOVIE("6.Return Movie", new AuthenticatedCommand(new ReturnMovieCommand()), DISPLAY),
    LOG_OUT("7.Log Out", new AuthenticatedCommand(new LogOutCommand()), HIDE),
    USER_DETAILS("8.Print User Details", new AuthenticatedCommand(new UserDetailsCommand()), HIDE);

    private String string;
    private Command command;
    private MenuDisplay menuDisplay;

    Menu(String string, Command command, MenuDisplay menuDisplay) {
        this.string = string;
        this.command = command;
        this.menuDisplay = menuDisplay;
    }

    public void perform(Library library, User user, OutputDriver output, InputDriver input) {
        this.command.perform(library, user, output, input);
    }

    public void displayMenu(Library library, OutputDriver output) {
        if (menuDisplay == DISPLAY) {
            output.print(string);
        }
        if (library.getCurrentUser() != null && menuDisplay == HIDE) {
            output.print(string);
        }
    }
}

