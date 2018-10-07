package random;

import Players.treePlayer;

import java.util.ArrayList;

public class ListUtil {

    public static ArrayList<treePlayer> chooseRandomly(ArrayList<treePlayer> sourceList, int itemsToSelect, SingletonRandom random) {
        int sourceSize = sourceList.size();

        int[] selections = new int[itemsToSelect];

        ArrayList<treePlayer> resultArray = new ArrayList<treePlayer>();

        for (int count = 0; count < itemsToSelect; count++) {

            int selection = random.nextInt(sourceSize - count);
            for (int scanIdx = count - 1; scanIdx >= 0; scanIdx--) {
                if (selection >= selections[scanIdx]) {
                    selection++;
                }
            }
            if(resultArray.contains(sourceList.get(selection)))
                count--;
            else resultArray.add(sourceList.get(selection));
        }
        return resultArray;
    }
}
