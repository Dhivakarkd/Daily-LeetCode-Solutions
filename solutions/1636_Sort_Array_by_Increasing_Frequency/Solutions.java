import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] frequencySort(int[] nums) {

        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for(int n: nums){
            frequencyMap.put(n,frequencyMap.getOrDefault(n,0)+1);
        }

        Integer[] integers = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            integers[i] = nums[i];
        }
        Arrays.sort(integers, (a,b) ->{
            if(frequencyMap.get(a).equals(frequencyMap.get(b))){
                return Integer.compare(b,a);
            }else{
                return Integer.compare(frequencyMap.get(a),frequencyMap.get(b));
            }
        });

        for(int i=0;i<nums.length;i++){
            nums[i] = integers[i];
        }

        return nums;
    }
}