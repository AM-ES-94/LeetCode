/*class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j=1; j<nums.length; ++j){
            if (nums[j]!=nums[i]) swap(nums, ++i, j);
        }
        return (i+1);
    }

    private void swap(int[] nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j=1; j<nums.length; ++j){
            if (nums[j]!=nums[i]){
                ++i;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;  
            }
        }
        return (i+1);
    }
}