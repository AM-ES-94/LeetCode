class Solution {
    private static int checkPossibleBFSKahn(int[] inEdges, Queue<Integer> q, 
    int[] sortEdges, List<List<Integer>> adjL){
        for (int i = 0; i < inEdges.length; ++i){
            if (inEdges[i] == 0){
                q.offer(i);
            }
        }

        int index = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            sortEdges[index++] = node;

            for (int it : adjL.get(node)){
                inEdges[it]--;
                if (inEdges[it] == 0) q.offer(it);
            }
        }

        return index;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjL = new ArrayList<>();
        int[] inEdges = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int[] sortEdges = new int[numCourses];

        for (int i = 0; i < numCourses; ++i){
            adjL.add(new ArrayList<>());
        }

        for(int arr[] : prerequisites) {
            adjL.get(arr[1]).add(arr[0]);
            inEdges[arr[0]]++;
        }

        /*for (int i = 0; i < numCourses; ++i){
            for (int it : adjL.get(i)){
                inEdges[it]++;
            } 
        }*/

        int index = checkPossibleBFSKahn(inEdges, q, sortEdges, adjL);

        return index == numCourses ? sortEdges : new int[0];
    }
}