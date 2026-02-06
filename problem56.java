import java.util.*;

public class MergeIntervalsSort {

    // Merge Sort function for intervals (sort by start time)
    static void mergesort(int[][] intervals, int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2;

        // Recursive calls
        mergesort(intervals, low, mid);
        mergesort(intervals, mid + 1, high);

        // Merge sorted parts
        merge(intervals, low, mid, high);
    }

    // Merge function for intervals
    static void merge(int[][] intervals, int low, int mid, int high) {
        ArrayList<int[]> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (intervals[left][0] <= intervals[right][0]) {
                temp.add(intervals[left]);
                left++;
            } else {
                temp.add(intervals[right]);
                right++;
            }
        }

        // Remaining left
        while (left <= mid) temp.add(intervals[left++]);
        // Remaining right
        while (right <= high) temp.add(intervals[right++]);

        // Copy temp back to original intervals array
        for (int i = low; i <= high; i++) {
            intervals[i] = temp.get(i - low);
        }
    }

    // Merge overlapping intervals after sorting
    static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Step 1: Sort intervals by start using our custom mergesort
        mergesort(intervals, 0, intervals.length - 1);

        // Step 2: Merge overlapping intervals
        ArrayList<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                merged.add(current);
                current = intervals[i];
            }
        }
        merged.add(current);

        return merged.toArray(new int[merged.size()][]);
    }

    // Print intervals
    static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.print(Arrays.toString(interval) + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println("Merged Intervals Example 1:");
        printIntervals(mergeIntervals(intervals1));

        int[][] intervals2 = {{1,4},{4,5}};
        System.out.println("Merged Intervals Example 2:");
        printIntervals(mergeIntervals(intervals2));

        int[][] intervals3 = {{4,7},{1,4}};
        System.out.println("Merged Intervals Example 3:");
        printIntervals(mergeIntervals(intervals3));
    }
}
