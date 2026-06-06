
public class bsInMatrixSearch {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;
        int n = matrix.length;
        int left = 0;
        int right = n * m - 1;
        int mid;
        while (left <= right) {
            mid = (right + left) / 2;
            int k = matrix[mid / m][mid % m];
            if (k == target) {
                return true;
            } else if (k < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int nums[][] = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println("The target is present : " + searchMatrix(nums, 3));
    }
}
/*74. Search a 2D Matrix
Medium
Topics
premium lock icon
Companies
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104 */
