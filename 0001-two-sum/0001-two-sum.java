class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        Map <Integer, Integer> mpp = new HashMap<>();
        for (int i =0; i < nums.length; ++i){
            if (!mpp.containsKey(nums[i])) mpp.put(nums[i], i);
            if (mpp.containsKey(target - nums[i]) && mpp.get(target - nums[i]) != i) return new int[]{mpp.get(target - nums[i]), i};
            
        }
        return new int[0];
    }
}