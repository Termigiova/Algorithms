// Remove duplicates. Modify the test client in BinarySearch to remove any du-plicate keys in the whitelist after the sort.

package Chapter1.Section1.Exercise28;

import java.util.ArrayList;
import java.util.List;

public class Exercise28 {

    public static List removeDuplicates (List list) {

        List newList = new ArrayList();
        boolean add = true;
        int listIndex = 0;

        for (int i = 0; i < list.size(); i++) {

            for (int j = 0; j < newList.size(); j++) {

                if ((int)list.get(i) == (int)newList.get(j))
                    add = false;

            }

            if (add) {

                newList.add(listIndex, list.get(i));
                listIndex++;

            }

            add = true;

        }

        return newList;

    }

}
