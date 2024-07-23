class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int n : nums) {
            list.add(n);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Collections.sort(list, (a, b) ->
        (map.get(a) == map.get(b)) ? b-a : map.get(a)-map.get(b));
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}