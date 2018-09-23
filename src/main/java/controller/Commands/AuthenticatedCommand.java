package controller.Commands;

import model.Library;
import model.User;
import view.InputDriver;
import view.OutputDriver;

import java.util.List;

public class AuthenticatedCommand implements Command {
    private int count = 0;

    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {

    }

    public void userLogin(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        String userId;
        String password;
        if (count == 0) {
            outputDriver.print("Library Number:");
            userId = inputDriver.getUserDetails();
            outputDriver.print("Password:");
            password = inputDriver.getUserDetails();
            validateUser(userId,password,userList);
            count++;
        }
    }

    public int validateUser(String userId, String password, List<User> userList) {
        for (User userAccount : userList) {
            if (userAccount.verify(userId, password) == 1) {
                return 1;
            }
        }
        return 0;
    }
}
