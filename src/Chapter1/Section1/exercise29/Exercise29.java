package Chapter1.Section1.exercise29;

import java.util.List;

public class Exercise29 {

    public static int rank(int key, List list) {

        int smallerE = 0;

        for (int i = 0; i < list.size(); i++)
            if ((int)list.get(i) < key)
                smallerE++;

        return smallerE;

    }

    public static int count(int key, List list) {

        int numberKeys = 0;

        for (int i = 0; i < list.size(); i++)
            if (key == (int)list.get(i))
                numberKeys++;

        return numberKeys;

    }

    public static void start(int key, List list) {

        int rank = rank(key,list);
        int count = count(key, list);

        if (rank != 0 || count != 0 ) {

            System.out.print("Values in the array that are equal and lower to the key\n");
            for (int i = 0; i < rank + count; i++) {
                System.out.print(list.get(i) + "\n");
            }

        } else {

            System.out.printf("There were no values lower than the key: %d", key);

        }

    }

}
