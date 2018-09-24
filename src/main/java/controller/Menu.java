package controller;

import controller.Commands.*;
import model.Library;
import model.User;
import view.InputDriver;
import view.OutputDriver;

import java.util.List;

public enum Menu {
    QUIT("0.Quit", new QuitCommand()),
    LIST_BOOKS("1.List Books", new ListBooksCommand()),
    CHECKOUT_BOOK("2.Checkout Book", new AuthenticatedCommand(new CheckoutBookCommand())),
    RETURN_BOOK("3.Return Book", new AuthenticatedCommand(new ReturnBookCommand())),
    LIST_MOVIES("4.List Movies", new ListMoviesCommand()),
    CHECKOUT_MOVIE("5.Checkout Movie", new AuthenticatedCommand(new CheckOutMoviesCommand())),
    RETURN_MOVIE("6.Return Movie", new AuthenticatedCommand(new ReturnMovieCommand()));

    private String string;
    private Command command;

    Menu(String string, Command command) {
        this.string = string;
        this.command = command;
    }

    public void perform(Library library, User user, OutputDriver output, InputDriver input) {
        this.command.perform(library,user, output, input);
    }

    public void displayMenu(OutputDriver output) {
        output.print(string);
    }
}
