class Solution_2134 {

    public int minSwaps(int[] nums) {

        int l = nums.length;

        int totalCount=0;
        for (int i = 0; i < l; i++) {
            totalCount += nums[i];
        }

        int oneCount = nums[0];
        int minSwap = Integer.MAX_VALUE;
        int end=0;
        for (int i = 0; i < l; ++i) {

            if(i!=0){
                oneCount -= nums[l-1];
            }

            while(end - i +1 < totalCount){
                end++;
                oneCount += nums[end%l];
            }

            minSwap = Math.min(minSwap,totalCount-oneCount);
        }

        return minSwap;
    }
}
