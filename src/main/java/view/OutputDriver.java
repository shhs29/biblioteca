package view;

public class OutputDriver implements Output {
    @Override
    public void print(Object string) {
        System.out.println(string);
    }

    public void printAsColumns(String string) {
        String delims = ",";
        String[] parsedString = string.split(delims);
        String newString = String.format("%-30s%-30s%-30s\n", parsedString[0], parsedString[1], parsedString[2]);
        print(newString);
    }

    public void printHorizontalLine() {
        for (int i = 0; i < 50; i++) {
            System.out.print("--");
        }
        System.out.println(" ");
    }

    public void printAsColumnsMovie(String movie) {
        String delims = ",";
        String[] parsedString = movie.split(delims);
        String newString = String.format("%-30s%-30s%-30s%-30s\n", parsedString[0], parsedString[1], parsedString[2], parsedString[3]);
        print(newString);
    }
}
