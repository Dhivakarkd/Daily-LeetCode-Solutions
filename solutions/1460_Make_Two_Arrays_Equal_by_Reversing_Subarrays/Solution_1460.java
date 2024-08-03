import java.util.HashMap;
import java.util.Map;

class Solution_1460 {

    public boolean canBeEqual(int[] target, int[] arr) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < target.length; i++) {
            frequencyMap.put(target[i], frequencyMap.getOrDefault(target[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {

            if (!frequencyMap.containsKey(arr[i])) {
                return false;
            }

            frequencyMap.put(arr[i], frequencyMap.get(arr[i]) - 1);

            if (frequencyMap.get(arr[i]) == 0) {
                frequencyMap.remove(arr[i]);
            }


        }

        if (frequencyMap.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
