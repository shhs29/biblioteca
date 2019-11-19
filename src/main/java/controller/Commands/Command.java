package controller.Commands;

import model.Library;
import model.User;
import view.InputDriver;
import view.OutputDriver;

public interface Command {
    void perform(Library library, User user, OutputDriver outputDriver, InputDriver inputDriver);
}
