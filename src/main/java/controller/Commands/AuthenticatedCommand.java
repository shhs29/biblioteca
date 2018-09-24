package controller.Commands;

import model.Library;
import model.User;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

public class AuthenticatedCommand implements Command {
    private static boolean isLogged = false;
    private Command command;
    private List<User> userList;

    public AuthenticatedCommand(Command command) {
        this.command = command;
        userList = new ArrayList<>();
        userList.add(new User("123-4567","user@123"));
        userList.add(new User("678-1423","user@456"));
    }

    @Override
    public void perform(Library library, User user,OutputDriver outputDriver, InputDriver inputDriver) {
        String userId;
        String password;
        if (!isLogged) {
            outputDriver.print("Library Number:");
            userId = inputDriver.getUserDetails();
            outputDriver.print("Password:");
            password = inputDriver.getUserDetails();
            user = new User(userId,password);
            library.login(user);
            isLogged = validateUser(user, userList);
            System.out.println(isLogged);
            if (isLogged) {
                outputDriver.print("Login Successful");
                library.addUser(user);
            } else {
                outputDriver.print("Please login first");
            }
        }
        if(isLogged){
            this.command.perform(library, user, outputDriver, inputDriver);
        }
    }

    private boolean validateUser(User user, List<User> userList) {
        for (User userAccount : userList) {
            if (userAccount.equals(user)) {
                return true;
            }
        }
        return false;
    }
}
