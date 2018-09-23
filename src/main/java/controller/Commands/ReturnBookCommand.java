package controller.Commands;

import controller.Command;
import model.ItemType;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class ReturnBookCommand implements Command {
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver){
        String string = inputDriver.getTitle();
        boolean isReturned = library.returnItem(string, ItemType.BOOK);
        if (isReturned) {
            outputDriver.print("Thank you for returning the book");
        } else {
            outputDriver.print("That is not a valid book to return");
        }
    }
}
