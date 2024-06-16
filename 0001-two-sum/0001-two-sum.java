class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        Map <Integer, Integer> mpp = new HashMap<>();
        int i = 0;
        while (i < nums.length){
            int rem = target - nums[i];
            if (mpp.containsKey(rem)) return new int[]{mpp.get(rem), i};
            mpp.put(nums[i], i);
            ++i;
        }
        return null;
    }
}