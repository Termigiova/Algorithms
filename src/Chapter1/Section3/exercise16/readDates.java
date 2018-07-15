package Chapter1.Section3.exercise16;

import edu.princeton.cs.introcs.StdOut;

import java.util.Scanner;

public class readDates {

    private Scanner scanner = new Scanner(System.in);
    private String[] date;

    private void readDate() {
        String input = readInput();
        date = input.split("/");
    }

    private String readInput() {
        try {
            return scanner.next();
        } catch (Exception e) {
            StdOut.print(e);
            return "";
        }
    }

    private void printDate() {
        StdOut.print(date[0] + "/");
        StdOut.print(date[1] + "/");
        StdOut.print(date[2]);
    }

    public static void main (String args[]) {

        readDates test = new readDates();
        test.readDate();
        test.printDate();

    }

}
