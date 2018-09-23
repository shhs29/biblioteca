package controller.Commands;

import model.ItemType;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class CheckoutBookCommand extends AuthenticatedCommand {
    @Override
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        if (userLogin()==1) {
            String string = inputDriver.getTitle();
            boolean isCheckedOut = library.checkOutItem(string, ItemType.BOOK);
            if (isCheckedOut) {
                outputDriver.print("Thank You! Enjoy the Book");
            } else {
                outputDriver.print("That book is not available");
            }
        } else {
            outputDriver.print("Please login first");
        }
    }
}
