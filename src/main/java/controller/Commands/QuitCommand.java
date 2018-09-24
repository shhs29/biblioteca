package controller.Commands;

import model.Library;
import model.User;
import view.InputDriver;
import view.OutputDriver;

import java.util.List;

public class QuitCommand implements Command {
    public void perform(Library library, List<User> userList, OutputDriver outputDriver, InputDriver inputDriver){
        outputDriver.print("Quit");
    }
}
