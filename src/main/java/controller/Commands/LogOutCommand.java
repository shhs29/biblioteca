package controller.Commands;

import model.Library;
import model.User;
import view.InputDriver;
import view.OutputDriver;

public class LogOutCommand implements Command {
    @Override
    public void perform(Library library, User user, OutputDriver outputDriver, InputDriver inputDriver){
        User user1 = null;
        library.setCurrentUser(user1);
        outputDriver.print("Successfully logged out");
    }
}
