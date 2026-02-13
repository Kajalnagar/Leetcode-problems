class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] freq = new int[26];   // To store frequency of A-Z
        int left = 0;               // Left pointer of window
        int maxOccurrence = 0;      // Highest frequency in current window
        int ans = 0;                // Store maximum length

        for (int right = 0; right < s.length(); right++) {

            // Increase frequency of current character
            freq[s.charAt(right) - 'A']++;

            // Update maxOccurrence (most frequent character count)
            maxOccurrence = Math.max(maxOccurrence,  freq[s.charAt(right) - 'A']);

            // If replacements needed > k, shrink window
            while ((right - left + 1) - maxOccurrence > k) {
                freq[s.charAt(left) - 'A']--;  // Remove left character
                left++;                        // Move left pointer
            }

            // Update answer with current valid window size
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
