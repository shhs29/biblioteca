package controller.Commands;

import model.Library;
import model.User;
import view.InputDriver;
import view.OutputDriver;

public class QuitCommand implements Command {
    public void perform(Library library, User user, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print("Quit");
    }
}
