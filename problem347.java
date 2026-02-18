class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[k];
        boolean[] used = new boolean[n];

        for (int x = 0; x < k; x++) {

            int max = 0;
            int index = -1;

            for (int i = 0; i < n; i++) {

                if (used[i]) continue;

                int count = 0;

                for (int j = 0; j < n; j++) {
                    if (nums[i] == nums[j]) {
                        count++;
                    }
                }

                if (count > max) {
                    max = count;
                    index = i;
                }
            }

            result[x] = nums[index];

            // Mark ALL occurrences as used
            for (int i = 0; i < n; i++) {
                if (nums[i] == nums[index]) {
                    used[i] = true;
                }
            }
        }

        return result;
    }
}
