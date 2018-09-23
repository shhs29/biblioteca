package controller.Commands;

import model.ItemType;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

import java.util.List;

public class ListBooksCommand implements Command {
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver){
        List<String> bookList = library.getItemDetails(ItemType.BOOK);
        outputDriver.printHorizontalLine();
        outputDriver.printAsColumns("Title,Author,Year Of Publishing");
        outputDriver.printHorizontalLine();
        for (String book : bookList) {
            outputDriver.printAsColumns(book);
        }
    }
}
