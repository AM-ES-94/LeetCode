class Solution {
    private static void safeNodes(Queue<Integer> q, int[] inEdgesRev, 
    List<List<Integer>> adjLRev, List<Integer> safeNodes){
        for (int i = 0; i < inEdgesRev.length; ++i) if (inEdgesRev[i] == 0) q.offer(i);

        while(!q.isEmpty()){
            int node = q.poll();
            safeNodes.add(node);

            for (int it : adjLRev.get(node)){
                inEdgesRev[it]--;
                if(inEdgesRev[it] == 0) q.offer(it);
            }
        }

        return;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new ArrayList<>();
        List<List<Integer>> adjLRev = new ArrayList<>();
        int[] inEdgesRev = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; ++i){
            adjLRev.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; ++i){
            for (int j = 0; j < graph[i].length; ++j){
                adjLRev.get(graph[i][j]).add(i);
                inEdgesRev[i]++;
            }
        }

        safeNodes(q, inEdgesRev, adjLRev, safeNodes);

        Collections.sort(safeNodes);

        return safeNodes;
    }
}