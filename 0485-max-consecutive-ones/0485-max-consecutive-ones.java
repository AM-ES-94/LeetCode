class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c=0;
        int max=0;
        for (int i=0; i<nums.length; ++i){
            if (nums[i]==1) max=(++c > max)? c:max;
            else c=0;
        }
        return max;
    }
}