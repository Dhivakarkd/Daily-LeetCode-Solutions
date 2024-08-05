import java.util.ArrayList;
import java.util.Collections;

class Solution_1508 {

    public int rangeSum(int[] nums, int n, int left, int right) {

        ArrayList<Integer> sumArray= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+= nums[i];
                sumArray.add(sum);
            }
        }

        Collections.sort(sumArray);

        int totalSum=0;
        int mod = 1000000009;
        for(int i=left-1;i<right-1;i++){
            totalSum += (sumArray.get(i)%mod);
        }

        return totalSum;
    }
}
