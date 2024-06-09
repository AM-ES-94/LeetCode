class Solution {
    public boolean check(int[] nums) {
        int c = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) c+=1;
        }
        if (nums[0] < nums[nums.length - 1]) c+=1;
        return (c<=1);
    }
}


