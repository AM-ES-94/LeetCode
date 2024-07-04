class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (l <= r){
            int mid = l + (r-l)/2;
            if (nums[l] <= nums[r]){
                ans = (nums[l]<=ans) ? nums[l] : ans;
                break;
            }
            else if (nums[l] <= nums[mid] ){
                ans = (nums[l]<=ans) ? nums[l] : ans;
                l = mid + 1; 
            }
            else {
                ans = (nums[mid]<=ans) ? nums[mid] : ans;
                r = mid - 1; 
            }
        }
        return ans;
    }
}