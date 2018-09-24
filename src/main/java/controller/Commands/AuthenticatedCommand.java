package controller.Commands;

import model.Library;
import model.User;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

public class AuthenticatedCommand implements Command {
    private Command command;

    public AuthenticatedCommand(Command command) {
        this.command = command;
    }

    @Override
    public void perform(Library library, User user, OutputDriver outputDriver, InputDriver inputDriver) {
        String userId;
        String password;
        if (library.getCurrentUser() == null) {
            outputDriver.print("Library Number:");
            userId = inputDriver.getUserDetails();
            outputDriver.print("Password:");
            password = inputDriver.getUserDetails();
            user = new User(userId, password);
            if (library.login(user)) {
                outputDriver.print("Login Successful");
                this.command.perform(library, user, outputDriver, inputDriver);
            } else {
                outputDriver.print("Please login first");
            }
        }
        else {
            this.command.perform(library,user,outputDriver,inputDriver);
        }
    }
}
