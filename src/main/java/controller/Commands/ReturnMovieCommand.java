package controller.Commands;

import model.ItemType;
import model.Library;
import model.User;
import view.InputDriver;
import view.OutputDriver;

import java.util.List;

public class ReturnMovieCommand implements Command{
    @Override
    public void perform(Library library,User user, OutputDriver outputDriver, InputDriver inputDriver){
        outputDriver.print("Enter the movie");
        String string = inputDriver.getTitle();
        boolean isReturned = library.returnItem(user,string, ItemType.MOVIE);
        if (isReturned) {
            outputDriver.print("Thank you for returning the movie");
        } else {
            outputDriver.print("That is not a valid movie to return");
        }
    }
}
