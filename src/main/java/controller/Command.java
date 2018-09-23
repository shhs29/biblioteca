package controller;

import model.Library;
import view.InputDriver;
import view.OutputDriver;

public interface Command {
    void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver);
}
