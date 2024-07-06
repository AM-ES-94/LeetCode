class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int m = matrix.length;
        
        for (int i=0; i<m; ++i){
            if (matrix[i][0] <= target && target <= matrix[i][n-1]){
                if (binarySearch(matrix[i], target) == 1) return true;
            }
            else continue;
        }
        return false;
    }

    private int binarySearch(int[] arr, int target){
        int l = 0, r = arr.length - 1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if (arr[mid] == target) return 1;
            else if (arr[mid] < target) l = mid + 1;
            else r = mid - 1;

        }
        return -1;
    }
}