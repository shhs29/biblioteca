package controller.Commands;

import model.Library;
import model.User;
import view.InputDriver;
import view.OutputDriver;

import java.util.List;

public class AuthenticatedCommand implements Command {
    private static int count = 0;
    private boolean isLogged = false;
    private Command command;

    public AuthenticatedCommand(Command command) {
        this.command = command;
    }

    @Override
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        String userId;
        String password;
        if (count == 0) {
            outputDriver.print("Library Number:");
            userId = inputDriver.getUserDetails();
            outputDriver.print("Password:");
            password = inputDriver.getUserDetails();
            isLogged = validateUser(userId, password, library.userList);
            if (isLogged) {
                this.command.perform(library, outputDriver, inputDriver);
                count++;
            } else {
                outputDriver.print("Please login first");
            }
        }
    }

    private boolean validateUser(String userId, String password, List<User> userList) {
        for (User userAccount : userList) {
            if (userAccount.verify(userId, password) == 1) {
                return true;
            }
        }
        return false;
    }
}
