package controller.Commands;

import model.ItemType;
import model.Library;
import model.User;
import view.InputDriver;
import view.OutputDriver;

public class UserDetailsCommand implements Command{
    @Override
    public void perform(Library library, User user, OutputDriver outputDriver, InputDriver inputDriver) {
       user = library.getCurrentUser();
       outputDriver.print(user.getUserDetails());

    }
}
