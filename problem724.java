class Solution {
    public int pivotIndex(int[] nums) {

        int totalSum = 0;
        int leftSum = 0;

        // Step 1: calculate total sum
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        // Step 2: find pivot index
        for (int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;   // pivot index
            }

            leftSum += nums[i];
        }

        return -1;  // no pivot found
    }
}
