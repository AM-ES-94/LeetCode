class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> minHeap = new PriorityQueue<>(Comparator.comparingDouble(a -> a[0]));
        for(int i=0; i<arr.length; i++){
            minHeap.add(new double[]{((double) arr[i] /arr[arr.length-1]), i, arr.length-1});
        }
        while(k>1){
            double[] curr = minHeap.remove();
            int numerator = (int) curr[1];
            int denominator = (int) curr[2]-1;
            if(denominator>numerator){
                minHeap.add(new double[]{(double) arr[numerator]/arr[denominator], numerator, denominator});
            }
            k--;
        }
        double[] result = minHeap.remove();
        return new int[]{ arr[(int)result[1]], arr[(int) result[2]]};   
    }
}