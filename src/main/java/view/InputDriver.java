package view;

import java.util.Scanner;

public class InputDriver {
    private Scanner scanner = new Scanner(System.in);

    public int takeInput() {
        return Integer.parseInt(scanner.nextLine());
    }

    public String getTitle() {
        return scanner.nextLine();
    }
}
