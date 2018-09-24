package controller.Commands;

import model.ItemType;
import model.Library;
import model.User;
import view.InputDriver;
import view.OutputDriver;

import java.util.List;

public class CheckoutBookCommand implements Command {
    @Override
    public void perform(Library library,User user, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print("Enter the book");
        String string = inputDriver.getTitle();
        boolean isCheckedOut = library.checkOutItem(user,string, ItemType.BOOK);
        if (isCheckedOut) {
            outputDriver.print("Thank You! Enjoy the Book");
        } else {
            outputDriver.print("That book is not available");
        }

    }
}
