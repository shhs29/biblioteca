package controller;

import model.ItemType;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class CheckoutBookCommand implements Command {
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver){
        String string = inputDriver.getTitle();
        boolean isCheckedOut = library.checkOutItem(string, ItemType.BOOK);
        if (isCheckedOut) {
            outputDriver.print("Thank You! Enjoy the Book");
        } else {
            outputDriver.print("That book is not available");
        }
    }
}
