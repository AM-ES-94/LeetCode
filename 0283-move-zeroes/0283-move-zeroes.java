class Solution {
    public void moveZeroes(int[] nums) {
        int i=-1;
        int j;
        for (j=0; j<nums.length; ++j){
            if (nums[j] == 0) {
                i=j;
                break;
            }
        }
        if (i==-1) return;
        for (j=i+1; j<nums.length; ++j){
            if (nums[j]!=0){
                swap(nums, i++, j);
            }
        }
    }

    private static void swap(int[] arr, int x, int y){
        arr[x] = arr[x] + arr[y];
        arr[y] = arr[x] - arr[y];
        arr[x] = arr[x] - arr[y];
    }
}