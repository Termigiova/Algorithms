package Chapter1.Section1.exercise30;

import java.util.ArrayList;
import java.util.List;

public class Exercise30 {

    private static int N = 10;

    private static List createCFactor() {

        // Declaring N-by-N array
        List tempList = new ArrayList();
        List cFactor = new ArrayList();

        for (int i = 1; i < N + 1; i++) {

            for (int j = 1; j <= i; j++)
                if (i % j == 0)
                    tempList.add(j);

            if (!tempList.isEmpty())
                cFactor.add(i - 1, new ArrayList<Integer>(tempList));

            tempList.clear();

        }

        // Filling with data

        return cFactor;

    }

    private static boolean commonFactor(List list1, List list2) {

        boolean commonFactor = false;

        for (int i = 0; i < list2.size(); i++) {

            for (int j = 0; j < list1.size(); j++) {

                if ((int)list2.get(i) != 1 && (int)list1.get(j) != 1)
                    if (list2.get(i) == list1.get(j))
                        commonFactor = true;

            }

        }


        return commonFactor;

    }

    private static void printArray(boolean a[][]) {

        System.out.printf("|     ");

        for (int i = 0; i < N; i++) {

            System.out.printf("|%5d", i);

        }

        System.out.printf("|\n");

        for (int i = 0; i < N; i++) {

            System.out.printf("|%5d", i);

            for (int j = 0; j < N; j++) {

                System.out.printf("|%5b", a[i][j]);

            }

            System.out.printf("|\n");

        }

    }

    public static void main (String args[]) {

        // Create an N-by-N list to consult common factor
        List cFactor = createCFactor();

        // Create an N-by-N boolean array
        boolean a[][] = new boolean[N][N];

        // It start in 2 because all numbers with 0 or 1 are not included in the "Relatively prime number" definition
        for (int i = 2; i < N; i++) {

            for (int j = 2; j < N; j++) {

                List list1 = (List) cFactor.get(i - 1);
                List list2 = (List) cFactor.get(j - 1);

                if (!commonFactor(list1, list2))
                    a[i][j] = true;

            }

        }

        printArray(a);

    }

}
