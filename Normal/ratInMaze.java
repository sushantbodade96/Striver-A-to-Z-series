
import java.util.*;

public class ratInMaze {

    public static List<String> findPath(int[][] mat) {
        List<String> result = new ArrayList<>();
        int n = mat.length;

        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) {
            return result; // No path if start or end is blocked
        }

        boolean[][] visited = new boolean[n][n];
        backtrack(mat, n, 0, 0, "", visited, result);
        return result;
    }

    // Backtracking function
    private static void backtrack(int[][] mat, int n, int row, int col, String path, boolean[][] visited, List<String> result) {
        // Base case: reached destination
        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }

        // Directions: D, L, R, U
        int[] dRow = {1, 0, 0, -1};
        int[] dCol = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};

        for (int i = 0; i < 4; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if (isSafe(newRow, newCol, mat, visited, n)) {
                visited[row][col] = true;
                backtrack(mat, n, newRow, newCol, path + dir[i], visited, result);
                visited[row][col] = false; // backtrack
            }
        }
    }

    // Check if the next cell is valid to move
    private static boolean isSafe(int row, int col, int[][] mat, boolean[][] visited, int n) {
        return row >= 0 && col >= 0 && row < n && col < n && mat[row][col] == 1 && !visited[row][col];
    }

    // Sample usage
    public static void main(String[] args) {
        int[][] grid1 = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };
        System.out.println(findPath(grid1)); // Output: [DDRDRR, DRDDRR]

        int[][] grid2 = {
            {1, 0},
            {1, 0}
        };
        System.out.println(findPath(grid2)); // Output: []
    }
}

/*Rat in a Maze


0

100
Hard

Given a grid of dimensions n x n. A rat is placed at coordinates (0, 0) and wants to reach at coordinates (n-1, n-1).



Find all possible paths that rat can take to travel from (0, 0) to (n-1, n-1). The directions in which rat can move are 'U' (up) , 'D' (down) , 'L' (left) , 'R' (right).



The value 0 in grid denotes that the cell is blocked and rat cannot use that cell for travelling, whereas value 1 represents that rat can travel through the cell. If the cell (0, 0) has 0 value, then mouse cannot move to any other cell.



Note :

In a path no cell can be visited more than once.
If there is no possible path then return empty vector.

Examples:
Input : n = 4 , grid = [ [1, 0, 0, 0] , [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1] ]

Output : [ "DDRDRR" , "DRDDRR" ]

Explanation : The rat has two different path to reach (3, 3).

The first path is (0, 0) => (1, 0) => (2, 0) => (2, 1) => (3, 1) => (3, 2) => (3, 3).

The second path is (0,0) => (1,0) => (1,1) => (2,1) => (3,1) => (3,2) => (3,3).

Input : n = 2 , grid = [ [1, 0] , [1, 0] ]

Output : -1

Explanation : There is no path that rat can choose to travel from (0,0) to (1,1). */
