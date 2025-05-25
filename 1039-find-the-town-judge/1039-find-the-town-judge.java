/*class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1) return 1;
        List<List<Integer>> adjL = new ArrayList<>();
        
        for (int i = 0; i <= n; ++i) {
            adjL.add(new ArrayList<>());
        }
        
        for (int i = 0; i < trust.length; ++i) {
            adjL.get(trust[i][0]).add(trust[i][1]);
        }

        for(int i = 1; i <= n; ++i) {
            boolean flag = false;
            if(adjL.get(i).size()==0) {
                for(int j = 1; j < adjL.size(); ++j) {
                   if(i==j) continue;
                   flag = adjL.get(j).contains(i);
                   if(flag == false) break;
                }
                if(flag == true)
                   return i;
           }
              
        }
        return -1;
    }
}*/

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];

        for (int[] t : trust) {
            outdegree[t[0]]++;
            indegree[t[1]]++;
        }

        for (int i = 1; i <= n; ++i) {
            if (indegree[i] == n - 1 && outdegree[i] == 0)
                return i;
        }

        return -1;
    }
}
