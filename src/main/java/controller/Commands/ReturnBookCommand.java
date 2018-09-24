package controller.Commands;

import model.ItemType;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class ReturnBookCommand implements Command{
    @Override
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver){
        outputDriver.print("Enter the book");
        String string = inputDriver.getTitle();
        boolean isReturned = library.returnItem(string, ItemType.BOOK);
        if (isReturned) {
            outputDriver.print("Thank you for returning the book");
        } else {
            outputDriver.print("That is not a valid book to return");
        }
    }
}
