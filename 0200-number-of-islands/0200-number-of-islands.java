class Solution {
    private static void breadthFirstSearch(int m, int n, int[][] traversal, char[][] grid){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{m, n});
        traversal[m][n] = 1;

        int r = grid.length;
        int c = grid[0]. length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()){
            int[] curr = q.peek();
            int row = curr[0];
            int col = curr[1];
            q.poll();

            for (int[] dir: directions){
                int nrow = row + dir[0];
                int ncol = col + dir[1];
                if(nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && grid[nrow][ncol] == '1' && traversal[nrow][ncol] == 0){
                    q.offer(new int[]{nrow, ncol});
                    traversal[nrow][ncol] = 1;
                }
            }
        }

        return;
    }

    private static void depthFirstSearch(int m, int n, int[][] traversal, char[][] grid){
        traversal[m][n] = 1;

        int r = grid.length;
        int c = grid[0]. length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir: directions){
            int nrow = m + dir[0];
            int ncol = n + dir[1];
            if(nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && grid[nrow][ncol] == '1' && traversal[nrow][ncol] == 0){
                traversal[nrow][ncol] = 1;
                depthFirstSearch(nrow, ncol, traversal, grid);
            }
        }

    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0]. length;
        
        int[][] traversal = new int[m][n];  

        int countIslands = 0;   
        
        for (int i = 0; i<m; ++i){
            for (int j = 0; j<n; ++j){
                if (grid[i][j] == '1' && traversal[i][j] !=1){
                    ++countIslands;
                    breadthFirstSearch(i, j, traversal, grid);
                    //depthFirstSearch(i, j, traversal, grid);
                }
            }
        }

        return countIslands;
    }
}