class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int result = Integer.MIN_VALUE;
        int rIndex = 0;
        int lSum = 0, rSum = 0;
        
        for(int i = 0; i < k; ++i){
            lSum += cardPoints[i];
        }

        result = (lSum > result) ? lSum : result;

        if (k == cardPoints.length) return result;

        for(int i = k-1; i >= 0; --i){
            lSum -= cardPoints[i];
            rSum += cardPoints[cardPoints.length - 1 - rIndex];
            ++rIndex;

            result = ((lSum + rSum) > result) ? (lSum + rSum) : result;
        }

        return result;
    }
}