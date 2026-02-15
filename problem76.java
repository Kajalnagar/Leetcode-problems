class Solution {
    public String minWindow(String s, String t) {

        // If s is smaller than t → impossible
        if (s.length() < t.length()) {
            return "";
        }

        int[] freq = new int[128];   // ASCII frequency array

        // Store frequency of characters in t
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0;
        int count = 0;   // how many characters matched
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        // Sliding window
        for (int right = 0; right < s.length(); right++) {

            // If character is required
            if (freq[s.charAt(right)] > 0) {
                count++;
            }

            // Decrease frequency (even if not required)
            freq[s.charAt(right)]--;

            // When all characters matched
            while (count == t.length()) {

                // Update minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Shrink window from left
                freq[s.charAt(left)]++;

                // If we removed a required character
                if (freq[s.charAt(left)] > 0) {
                    count--;
                }

                left++;
            }
        }

        // Return result
        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}
