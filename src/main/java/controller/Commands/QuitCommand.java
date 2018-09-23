package controller.Commands;

import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class QuitCommand implements Command {
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver){
        outputDriver.print("Quit");
    }
}
