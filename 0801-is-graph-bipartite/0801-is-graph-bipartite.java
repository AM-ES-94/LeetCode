class Solution {

    /*private static boolean checkBipartiteBFS(int start, int[] traversal, List<List<Integer>> adjL){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        traversal[start] = -1;

        while(!q.isEmpty()){
            int node = q.poll();

            for (int it: adjL.get(node)){
                if (traversal[it] == 0){
                    q.add(it);
                    traversal[it] = -traversal[node];
                }
                else if (traversal[it] != 0 && traversal[it] == traversal[node]) return false;
            }
        }

        return true;
    }*/

    private static boolean checkBipartiteDFS(int start, int color, int[] traversal, List<List<Integer>> adjL){
        traversal[start] = color;
        for (int it: adjL.get(start)){
            if (traversal[it] == 0){
                if (checkBipartiteDFS(it, -color, traversal, adjL) == false) return false;
                }
            else if (traversal[it] != 0 && traversal[it] == color) return false;
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adjL = new ArrayList<>();

        for (int i = 0; i < graph.length; ++i){
            adjL.add(new ArrayList<>());
        }

        int[] traversal = new int[graph.length];

        int c = 0;
        for (int[] it: graph){
            for (int j = 0; j < it.length; ++j){
                adjL.get(c).add(it[j]);
                adjL.get(it[j]).add(c);
            }
            ++c;
        }

        for (int i = 0; i < traversal.length; ++i){
            if(traversal[i] == 0) {
                //if(checkBipartiteBFS(i, traversal, adjL) == false) return false;
                if(checkBipartiteDFS(i, 1, traversal, adjL) == false) return false;
            }
        }

        return true;
    }
}