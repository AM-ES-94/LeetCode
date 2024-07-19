class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < matrix.length; i++) {
            // Find the column of the minimum element in this row
            int minCol = findMinColumn(matrix, i);
            int candidate = matrix[i][minCol];
            
            // Check if this minimum is also the maximum in its column
            if (isMaxInColumn(matrix, candidate, minCol)) {
                result.add(candidate);
            }
        }
        
        return result;
    }
    
    private int findMinColumn(int[][] matrix, int row) {
        int minVal = matrix[row][0], minCol = 0;
        for (int j = 1; j < matrix[row].length; j++) {
            if (matrix[row][j] < minVal) {
                minVal = matrix[row][j];
                minCol = j;
            }
        }
        return minCol;
    }
    
    private boolean isMaxInColumn(int[][] matrix, int val, int col) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] > val) return false;
        }
        return true;
    }
}