package controller.Commands;

import model.ItemType;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class CheckOutMoviesCommand implements Command {
    @Override
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print("Enter the movie");
        String string = inputDriver.getTitle();
        boolean isCheckedOut = library.checkOutItem(string, ItemType.MOVIE);
        if (isCheckedOut) {
            outputDriver.print("Thank You! Enjoy the Movie");
        } else {
            outputDriver.print("That movie is not available");
        }
    }
}
