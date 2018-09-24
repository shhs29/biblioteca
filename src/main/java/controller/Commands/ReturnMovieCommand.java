package controller.Commands;

import model.ItemType;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class ReturnMovieCommand implements Command{
    @Override
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver){
        outputDriver.print("Enter the movie");
        String string = inputDriver.getTitle();
        boolean isReturned = library.returnItem(string, ItemType.MOVIE);
        if (isReturned) {
            outputDriver.print("Thank you for returning the movie");
        } else {
            outputDriver.print("That is not a valid movie to return");
        }
    }
}