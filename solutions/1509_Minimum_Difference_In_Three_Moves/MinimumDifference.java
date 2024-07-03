import java.util.Arrays;

public class MinimumDifference {
    public static int minDifference(int[] nums) {
        if(nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = nums[nums.length - 1] - nums[0];
        for(int i = 0; i <= 3; i++) {
            ans = Math.min(ans, nums[nums.length - (3 - i) - 1] - nums[i]);
        }
        return ans;  }

    public static void main(String[] args) {
        int[] nums1 = {5, 3, 2, 4};
        System.out.println(minDifference(nums1)); // Output: 0

        int[] nums2 = {1, 5, 0, 10, 14};
        System.out.println(minDifference(nums2)); // Output: 1

        int[] nums3 = {3, 100, 20};
        System.out.println(minDifference(nums3)); // Output: 0
    }
}
