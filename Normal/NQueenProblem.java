
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenProblem {

    private static void solveNQueens(int n, List<List<String>> output, char[][] nQueens, int row,
            int[] leftCol, int[] upperDiagonal, int[] lowerDiagonal) {

        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] rowArray : nQueens) {
                solution.add(new String(rowArray));
            }
            output.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (leftCol[col] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
                nQueens[row][col] = 'Q';
                leftCol[col] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;

                solveNQueens(n, output, nQueens, row + 1, leftCol, upperDiagonal, lowerDiagonal);

                nQueens[row][col] = '.';
                leftCol[col] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();
        char[][] nQueens = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.');
        }

        int[] leftCol = new int[n];              // Should be 'columns'
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];

        solveNQueens(n, output, nQueens, 0, leftCol, upperDiagonal, lowerDiagonal);

        return output;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}/*51. N-Queens
Solved
Hard
Topics
premium lock icon
Companies
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9 */
