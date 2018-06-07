package Chapter1.Section1.exercise23;

import Chapter1.Section1.exercise22.Exercise22;
import Chapter1.Section1.Exercise28.Exercise28;
import Chapter1.Section1.exercise29.Exercise29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercise23 {

    private static Exercise22 BinarySearch;
    private static Exercise28 RemoveDuplicates;
    private static Exercise29 equalKeys;
    private static int depth = 0;


    private static int[] sort (int a[]) {

        int aux;
        boolean swapped = true;

        while(swapped) {

            swapped = false;

            for (int i = 1; i < a.length; i++) {

                if (a[i - 1] > a[i]) {

                    aux = a[i - 1];
                    a[i - 1] = a[i];
                    a[i] = aux;

                    swapped = true;

                }

            }

        }

        return a;

    }

    private static void printNumbers(int a[], int index, char param) {

        System.out.print("| Index | Value |\n");


        if (param == '-') {

            if (index >= 0)
                System.out.printf("|%7d|%7d|\n", a[index], index);
            else
                System.out.print("Not found in the array\n");

        }
        else if (param == '+') {

            if (index < 0)
                for (int i = 0; i < a.length; i++)
                    System.out.printf("|%7d|%7d|\n", a[i], i);

            else {

                for (int i = 0; i < a.length; i++) {

                    if (a[i] == a[index])
                        continue;

                    System.out.printf("|%7d|%7d|\n", a[i], i);

                }

            }

        }

    }

    private static void printNumbers(List list, int index, char param) {

        System.out.print("| Index | Value |\n");


        if (param == '-') {

            if (index >= 0)
                System.out.printf("|%7s|%7d|\n", index, list.get(index));
            else
                System.out.print("Not found in the array\n");

        }
        else if (param == '+') {

            if (index < 0)
                for (int i = 0; i < list.size(); i++)
                    System.out.printf("|%7s|%7d|\n", i, list.get(i));

            else {

                for (int i = 0; i < list.size(); i++) {

                    if (list.get(i) == list.get(index))
                        continue;

                    System.out.printf("|%7s|%7d|\n", i, list.get(i));

                }

            }

        }

    }

    public static void whitelist(List list) {

        // Sort the array
//        a = sort(a);
        Collections.sort(list);

        // Remove duplicates
        list = RemoveDuplicates.removeDuplicates(list);

        // Read input from console
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.print("Enter a value to search in the array: ");
        int key = reader.nextInt();

        System.out.print("Enter the second parameter '+' or '-': ");
        char param = reader.next().charAt(0);

        // Call binary search function and return index of the result
//        int index = BinarySearch.rank(key, a);
        int index = BinarySearch.rank(key, list);

        if (param == '-') {

            System.out.print("Printing numbers that are in the whitelist\n");
//            printNumbers(a, index, param);
            printNumbers(list, index, param);

        } else if (param == '+') {

            System.out.print("Printing numbers that are not in the whitelist\n");
//            printNumbers(a, index, param);
            printNumbers(list, index, param);

        }

        // Exercise 1.1.29
        equalKeys.start(key, list);

    }

    private static List fillList(List list) {

        int listSize = 10;

        for (int i = 0; i < listSize; i++) {

//            a[i] = a.length - i;
            list.add(i, listSize - i);

        }

        return list;

    }


    public static void main (String args[]) {


        // Initialize the list and insert values
//        int a[] = new int[100];
        List list = new ArrayList();

        fillList(list);
        fillList(list);

        whitelist(list);

    }

}
