import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution_703 {

    List<Integer> integerList ;
    int k = 0;

    public KthLargest(int k, int[] nums) {

        integerList = new ArrayList<>(nums.length);
        k=k;

        for(int num : nums){
            integerList.add(num);
        }

        Collections.sort(integerList);
    }

    public int add(int val) {

        int index = findIndex(val);

        integerList.add(index,val);

        return integerList.get(integerList.size() - k);

    }

    public int findIndex(int value){
        int left =0;
        int right = integerList.size() -1;

        while(left <=right) {
            int middle = (left+right) / 2;

            int middleElement = integerList.get(middle);

            if(middleElement == value) return middle;
            if(middleElement > value){
                right = middle-1;
            }else{
                left = middle+1;
            }
        }

        return left;


    }
}
