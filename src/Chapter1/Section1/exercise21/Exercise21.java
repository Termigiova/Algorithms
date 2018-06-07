// Write a program that reads in lines from standard input with each line containing a name and two integers
// and then uses printf() to print a table with a column of the names, the integers, and the result of dividing the first by the second, accurate to three decimal places.
// You could use a program like this to tabulate batting averages for baseball players or grades for students.


// Read i'th line
// Separate from the string the name, and two following integers. Save them in variables
// Separator -> String[] splited = str.split("\\s+");
// Print the results


package Chapter1.Section1.exercise21;

import java.util.Scanner;

public class Exercise21 {

    public static class Lines {

        private String name;
        private int firstNumber;
        private int secondNumber;

    }


    public static void main (String args[]) {

        System.out.println("This program will ask for user input five times");

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        Lines line[] = new Lines[5];

        // Initialize 'line' values
        for (int i = 0; i < line.length; i++) {

            line[i] =  new Lines();

        }


        for (int i = 0; i < line.length; i++) {

            System.out.print("Enter a name and two integers separated by a space: ");
            String inputLine[] = reader.nextLine().split("\\s+"); // Create string array and separate it by spaces

            line[i].name = inputLine[0];
            line[i].firstNumber = Integer.parseInt(inputLine[1]);
            line[i].secondNumber = Integer.parseInt(inputLine[2]);


        }

        reader.close();

        // Print the resulting table
        System.out.printf("|       Name       | First integer | Second Integer |   Result   | \n");

        // Print line
        for (int i = 0; i < line.length; i++) {

            System.out.printf("|%18s|", line[i].name);
            System.out.printf("%15d|", line[i].firstNumber);
            System.out.printf("%16d|", line[i].secondNumber);
            System.out.printf("%12.3f|", ((double) line[i].firstNumber / (double) line[i].secondNumber));

            System.out.println();

        }


    }


}
