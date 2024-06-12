class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i<nums1.length && j<nums2.length){
            if (nums1[i] == nums2[j]){
                set.add(nums1[i]);
                ++i;
                ++j;
            }
            else if(nums1[i] < nums2[j]) ++i;
            else ++j;
        }
        int[] ans = new int[set.size()];
        int k = 0;
        for (int x: set) ans[k++]=x;
        return ans;
    }
}