import java.util.List;

class Solution_624 {
    public int maxDistance(List<List<Integer>> arrays) {


        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int maxDistance =0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);

            maxDistance = Math.max(maxDistance, Math.max(Math.abs(array.get(array.size()-1)-min),Math.abs(max-array.get(0))));

            min = Math.min(min,array.get(0));
            max = Math.max(max,array.get(array.size()-1));
        }

        return maxDistance;
    }
}
