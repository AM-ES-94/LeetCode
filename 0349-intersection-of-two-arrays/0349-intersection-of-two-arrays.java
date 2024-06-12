class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i<nums1.length && j<nums2.length){
            if (nums1[i] == nums2[j] && (list.size() == 0 || list.get(list.size()-1)!=nums1[i])){
                list.add(nums1[i]);
                ++i;
                ++j;
            }
            else if(nums1[i] < nums2[j]) ++i;
            else ++j;
        }
        int[] ans = new int[list.size()];
        for (int k=0; k<list.size(); ++k){
            ans[k]=list.get(k);
        }
        return ans;
    }
}