package controller.Commands;

import model.Library;
import model.User;
import view.InputDriver;
import view.OutputDriver;

public class LogOutCommand implements Command {
    @Override
    public void perform(Library library, User user, OutputDriver outputDriver, InputDriver inputDriver){
        library.setCurrentUser();
        outputDriver.print("Successfully logged out");
    }
}
