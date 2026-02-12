import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if (n < m) return result;

        // Step 1: sort pattern
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        String sortedP = new String(pArr);

        // Step 2: sliding window substrings
        for (int i = 0; i <= n - m; i++) {

            String sub = s.substring(i, i + m);  // window substring

            char[] subArr = sub.toCharArray();
            Arrays.sort(subArr);                 // sort window
            String sortedSub = new String(subArr);

            // Step 3: compare
            if (sortedSub.equals(sortedP)) {
                result.add(i);
            }
        }

        return result;
    }
}
