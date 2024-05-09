class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
      for(int num: happiness){
        maxHeap.add(num);
        }
        long decay = 0;
        long ans = 0;
        while(k>0){
            long toAdd = maxHeap.remove()-decay;
            ans += toAdd>0? toAdd : 0;
            decay++;
            k--;
        }
        return ans;  
    }
}