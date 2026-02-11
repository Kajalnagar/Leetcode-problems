problemclass Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        int l = 0;   // left sum
        int r = 0;   // right sum
        int maxlen = 0;

        // sum of first k elements from left
        for (int i = 0; i < k; i++) {
            l = l + cardPoints[i];
        }

        maxlen = l;

        int rightIndex = n - 1;

        // shifting picks from left to right
        for (int i = k - 1; i >= 0; i--) {
            l = l - cardPoints[i];          // remove from left
            r = r + cardPoints[rightIndex]; // add from right
            rightIndex--;

            maxlen = Math.max(maxlen, l + r);
        }

        return maxlen;
    }
}
