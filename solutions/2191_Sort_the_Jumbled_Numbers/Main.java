import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution_2191 solution = new Solution_2191();

        // Test case
        int[] mapping = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums = {991, 338, 38};

        // Call the sortJumbled method
        int[] result = solution.sortJumbled(mapping, nums);

        // Print the result
        System.out.print("Sorted Jumbled Numbers: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}


class Solution_2191 {
    public int[] sortJumbled(int[] mapping, int[] nums) {

        ArrayList<Integer[]> arrayList= new ArrayList<>();

        for(int i=0;i<nums.length;i++){

            String number = Integer.toString(nums[i]);
            StringBuilder newNumber = new StringBuilder();

            for(int j=0;j<number.length();j++){
                newNumber.append(mapping[number.charAt(j) - '0']);
            }

            int newValue = Integer.parseInt(newNumber.toString());

            arrayList.add(new Integer[]{newValue,i});
        }


        arrayList.sort(Comparator.comparing(a -> a[0]));

        int[] answers = new int[nums.length];

        for(int i=0;i<arrayList.size();i++){
            answers[i] = nums[arrayList.get(i)[1]];
        }
        return answers;
    }

}