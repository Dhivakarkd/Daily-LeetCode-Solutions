import java.util.HashMap;
import java.util.Map;

class Solution_2053 {

    public String kthDistinct(String[] arr, int k) {

        Map<String,Integer> distinctMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {

            distinctMap.m

                distinctMap.put(arr[i],distinctMap.getOrDefault(arr[i],0)+1);

        }

        for (int i = 0; i < arr.length; i++) {

            if(distinctMap.get(arr[i]) == 1){
                k--;
            }

            if(k==0){
                return arr[i];
            }
        }

        return "";
    }
}
