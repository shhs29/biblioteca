package controller.Commands;

import controller.Command;
import model.ItemType;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

import java.util.List;

public class ListMoviesCommand implements Command {
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        List<String> movieList = library.getItemDetails(ItemType.MOVIE);
        outputDriver.printHorizontalLine();
        outputDriver.printAsColumnsMovie("Name,Director,Release Year,Rating");
        outputDriver.printHorizontalLine();
        for (String movie : movieList) {
            outputDriver.printAsColumnsMovie(movie);
        }
    }
}
