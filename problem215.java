class Solution {
    public int findKthLargest(int[] nums, int k) {int target = nums.length - k; // index for kth largest
        return quickSelect(nums, 0, nums.length - 1, target);
    }

    int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high) return arr[low];

        int p = partition(arr, low, high);

        if (p == k) return arr[p];
        else if (p < k) return quickSelect(arr, p + 1, high, k);
        else return quickSelect(arr, low, p - 1, k);
    }

    int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low, j = high;

        while (i < j) {
            while (i < high && arr[i] <= pivot) i++;
            while (j > low && arr[j] > pivot) j--;
            if (i < j) swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
