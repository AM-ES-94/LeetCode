class Solution {

    public boolean canBeEqual(int[] target, int[] arr) {
        // Frequency count for arr
        Map<Integer, Integer> arrFreq = new HashMap<>();
        for (int num : arr) {
            arrFreq.put(num, arrFreq.getOrDefault(num, 0) + 1);
        }

        for (int num : target) {
            // If num does not appear in target, then arrays are not equal
            if (!arrFreq.containsKey(num)) return false;

            // Decrement the frequency count for num and
            // remove key if the count goes to 0
            arrFreq.put(num, arrFreq.get(num) - 1);
            if (arrFreq.get(num) == 0) {
                arrFreq.remove(num);
            }
        }
        return arrFreq.size() == 0;
    }
}