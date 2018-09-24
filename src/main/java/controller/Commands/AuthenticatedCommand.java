package controller.Commands;

import model.Library;
import model.User;
import view.InputDriver;
import view.OutputDriver;

import java.util.List;

public class AuthenticatedCommand implements Command {
    private static boolean isLogged = false;
    private Command command;

    public AuthenticatedCommand(Command command) {
        this.command = command;
    }

    @Override
    public void perform(Library library, List<User> userList, OutputDriver outputDriver, InputDriver inputDriver) {
        String userId;
        String password;
        if (!isLogged) {
            outputDriver.print("Library Number:");
            userId = inputDriver.getUserDetails();
            outputDriver.print("Password:");
            password = inputDriver.getUserDetails();
            isLogged = validateUser(userId, password, userList);
            if (isLogged) {
                outputDriver.print("Login Successful");
                this.command.perform(library, userList, outputDriver, inputDriver);

            } else {
                outputDriver.print("Please login first");
            }
        } else {
            this.command.perform(library, userList, outputDriver, inputDriver);
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
