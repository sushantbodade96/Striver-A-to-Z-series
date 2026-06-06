
public class rowWithMaxOnes {

    public static int LB(int nums[], int target) {
        int n = nums.length;
        int right = n - 1;
        int left = 0;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (nums[mid] >= target) {
                n = mid;
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }
        return n;
    }

    public static int rowWithMax1s(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int maxOne = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int ones = m - LB(mat[i], 1);
            if (ones > maxOne) {
                maxOne = ones;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int nums[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println("the row with ones is : " + rowWithMax1s(nums));
    }
}
/*Find row with maximum 1's
100
Easy
Hint
Given a non-empty grid mat consisting of only 0s and 1s, where all the rows are sorted in ascending order, find the index of the row with the maximum number of ones.

If two rows have the same number of ones, consider the one with a smaller index. If no 1 exists in the matrix, return -1.


Examples:
Input : mat = [ [1, 1, 1], [0, 0, 1], [0, 0, 0] ]

Output: 0

Explanation: The row with the maximum number of ones is 0 (0 - indexed).

Input: mat = [ [0, 0], [0, 0] ]

Output: -1

Explanation: The matrix does not contain any 1. So, -1 is the answer.

 */
