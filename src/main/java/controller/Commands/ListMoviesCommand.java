package controller.Commands;

import model.ItemType;
import model.Library;
import model.User;
import view.InputDriver;
import view.OutputDriver;

import java.util.List;

public class ListMoviesCommand implements Command {
    public void perform(Library library,User user, OutputDriver outputDriver, InputDriver inputDriver) {
        List<String> movieList = library.getItemDetails(ItemType.MOVIE);
        outputDriver.printHorizontalLine();
        outputDriver.printAsColumnsMovie("Name,Director,Release Year,Rating");
        outputDriver.printHorizontalLine();
        for (String movie : movieList) {
            outputDriver.printAsColumnsMovie(movie);
        }
    }
}
