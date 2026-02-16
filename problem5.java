class Solution {

    // Main function that returns longest palindromic substring
    public String longestPalindrome(String s) {

        // If string is null or empty, return empty string
        if(s == null || s.length() < 1)
            return "";

        // These will store the starting and ending index
        // of the longest palindrome found so far
        int start = 0;
        int end = 0;

        // Loop through every character
        // We treat each character as a possible center
        for(int i = 0; i < s.length(); i++) {

            // Case 1: Odd length palindrome (center at one character)
            // Example: "aba"
            int len1 = expandFromCenter(s, i, i);

            // Case 2: Even length palindrome (center between two characters)
            // Example: "abba"
            int len2 = expandFromCenter(s, i, i + 1);

            // Take maximum length from both cases
            int maxLen = Math.max(len1, len2);

            // If this palindrome is longer than previous one
            if(maxLen > end - start) {

                // Calculate new start index
                start = i - (maxLen - 1) / 2;

                // Calculate new end index
                end = i + maxLen / 2;
            }
        }

        // Return the longest palindrome substring
        return s.substring(start, end + 1);
    }

    // Helper function to expand around center
    private int expandFromCenter(String s, int left, int right) {

        // Expand as long as:
        // 1. Left index does not go out of bounds
        // 2. Right index does not go out of bounds
        // 3. Characters at left and right are equal
        while(left >= 0 && right < s.length() &&
              s.charAt(left) == s.charAt(right)) {

            // Move left pointer one step backward
            left--;

            // Move right pointer one step forward
            right++;
        }

        // When loop stops, it means characters didn't match
        // So length = right - left - 1
        return right - left - 1;
    }
}
