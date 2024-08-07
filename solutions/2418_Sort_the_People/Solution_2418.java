import java.util.*;

public class Solution_2418 {
    public String[] sortPeople(String[] names, int[] heights) {

        SortedMap<Integer, String>
                sotreemap = new TreeMap<>(
                Collections.reverseOrder());

        for(int i=0;i<names.length;i++){
            sotreemap.put(heights[i],names[i]);
        }

        return sotreemap.values().toArray(new String[0]);
    }
}