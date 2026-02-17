class Solution {

    public int countSubstrings(String s) {

        int count = 0;

        for(int i = 0; i < s.length(); i++) {

            // Odd length
            count += checkPalindrome(s, i, i);

            // Even length
            count += checkPalindrome(s, i, i + 1);
        }

        return count;
    }

    private int checkPalindrome(String s, int left, int right) {

        int tempCount = 0;

        while(left >= 0 && right < s.length() &&
              s.charAt(left) == s.charAt(right)) {

            tempCount++;
            left--;
            right++;
        }

        return tempCount;
    }
}
