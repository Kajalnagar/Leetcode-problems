import java.util.Arrays;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);                 // sort array
        return nums[nums.length - k];      // kth largest
    }
}
