class Solution {
    private static void breadthFirstSearch(int n, boolean[] traversal, List<List<Integer>> adjL){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        traversal[n] = true;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int it: adjL.get(node)){
                if(!traversal[it]){
                    traversal[it] = true;
                    q.offer(it);
                }
            }
        }
        return;
    }

    private static void depthFirstSearch(int node, boolean[] traversal, List<List<Integer>> adjL){
        traversal[node] = true;

        for (int it : adjL.get(node)){
            if (!traversal[it]) depthFirstSearch(it, traversal, adjL);
        }

        return;
    }

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjL = new ArrayList<>();
        boolean[] traversal = new boolean[isConnected.length + 1];

        for (int i = 0; i <= isConnected.length; ++i){
            adjL.add(new ArrayList<Integer>());
        }

        for (int i = 0; i<isConnected.length; ++i){
            for (int j = 0; j<isConnected.length; ++j){
                if (isConnected[i][j] == 1 && i != j) {
                    adjL.get(i+1).add(j+1);
                    adjL.get(j+1).add(i+1);
                }
            }
        }

        int citiesCount = 0;

        for (int i = 1; i<=isConnected.length; ++i){
            if (!traversal[i]){
                ++citiesCount;
                //depthFirstSearch(i, traversal, adjL);
                breadthFirstSearch(i, traversal, adjL); 
            }
        }

        return citiesCount;
    }
}