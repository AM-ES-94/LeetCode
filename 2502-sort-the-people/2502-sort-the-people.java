class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        } 

        Arrays.sort(heights);

        String[] result = new String[heights.length];
        int index = heights.length - 1;

        for (int it : heights){
            result[index--] = map.get(it);
        }

        return result;
    }
}