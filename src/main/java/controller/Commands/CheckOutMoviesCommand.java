package controller.Commands;

import controller.Command;
import model.ItemType;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class CheckOutMoviesCommand implements Command {
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver){
        String string = inputDriver.getTitle();
        boolean isCheckedOut = library.checkOutItem(string, ItemType.MOVIE);
        if (isCheckedOut) {
            outputDriver.print("Thank You! Enjoy the Movie");
        } else {
            outputDriver.print("That movie is not available");
        }
    }
}
