package controller;

import model.ItemType;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class ReturnMovieCommand implements Command{
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver){
        String string = inputDriver.getTitle();
        boolean isReturned = library.returnItem(string, ItemType.MOVIE);
        if (isReturned) {
            outputDriver.print("Thank you for returning the movie");
        } else {
            outputDriver.print("That is not a valid movie to return");
        }
    }
}
