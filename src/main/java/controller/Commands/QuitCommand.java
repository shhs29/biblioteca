package controller.Commands;

import controller.Command;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

import java.util.List;

public class QuitCommand implements Command {
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver){
        outputDriver.print("Quit");
    }
}
