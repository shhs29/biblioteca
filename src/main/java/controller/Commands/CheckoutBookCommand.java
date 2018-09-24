package controller.Commands;

import model.ItemType;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class CheckoutBookCommand implements Command {
    @Override
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print("Enter the book");
        String string = inputDriver.getTitle();
        boolean isCheckedOut = library.checkOutItem(string, ItemType.BOOK);
        if (isCheckedOut) {
            outputDriver.print("Thank You! Enjoy the Book");
        } else {
            outputDriver.print("That book is not available");
        }

    }
}
