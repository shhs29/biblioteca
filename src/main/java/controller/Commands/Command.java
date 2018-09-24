package controller.Commands;

import model.Library;
import model.User;
import view.InputDriver;
import view.OutputDriver;

import java.util.List;

public interface Command {
    void perform(Library library, List<User> userList, OutputDriver outputDriver, InputDriver inputDriver);
}
